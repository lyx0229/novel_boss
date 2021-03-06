package com.novel.web.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separater {
	/**
	 * 生成小说文件夹
	 * 
	 * @param novel
	 * @return 成功生成返回文件夹名，已存在返回null
	 */
	private static String genarateFolder(File novel) {
		if (!novel.isFile() || !novel.getAbsolutePath().endsWith(".txt")) {
			return null;
		}
		String novelName = novel.getAbsolutePath();
		String folderName = novelName.substring(0, novelName.indexOf(".txt"));
		File folder = new File(folderName);
		if (!folder.exists()) {
			folder.mkdirs();
			return folderName;
		}
		return null;
	}

	/**
	 * 输出html文件
	 * 
	 * @param bodyContent
	 * @param currentFileName
	 * @param currentPageIndex
	 * @throws Exception
	 */
	private static void generateChapterHtmlFile(int currentPageIndex, String content, List<String> chapterList,
			String folderName ,int i) throws Exception {
		String pageContent = content;
//		chapterList.get(currentPageIndex)
		currentPageIndex=currentPageIndex+1;
		String filePath = folderName + "\\" + currentPageIndex + ".txt";
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
		out.print(pageContent);
		out.flush();
		out.close();
	}

	/**
	 * 获取章节列表
	 * 
	 * @param novel
	 * @throws Exception
	 */
	private static List<String> getChapterList(File novel) throws Exception {
		List<String> chapterList = new ArrayList<String>();
		FileInputStream fileInputStream = new FileInputStream(novel);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, getCharsetOfNovel(novel));
		BufferedReader novelbr = new BufferedReader(inputStreamReader);
		int currentIndex = 1;
		String line = novelbr.readLine();
		while (line != null) {
			line = line.replaceAll("\\s*", "");
			/*
			 * if (line.indexOf("第") == 0 && line.indexOf("节") != -1) {
			 * chapterList.add("第" + currentIndex + "章" +
			 * line.substring(line.indexOf("节") + 1)); currentIndex++; } else
			 */
			if ((line.indexOf("章") == 0 && line.indexOf("节") == 1 && appearNumber(line, "章") > 1)
					|| (line.indexOf("章") == 0 && line.indexOf("节") == 1 && line.indexOf("第") != -1)) {
				System.out.println(line);
				// chapterList.add("第" + currentIndex + "章" +
				// line.substring(line.indexOf("章") + 1));
				chapterList.add(line.substring(line.indexOf("录") + 1));
				currentIndex++;
			}
			line = novelbr.readLine();
		}
		System.out.println(chapterList);
		novelbr.close();
		fileInputStream.close();
		return chapterList;
	}

	/**
	 * 判断TXT文件编码方式
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private static String getCharsetOfNovel(File novel) throws IOException {
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(novel));
		byte[] head = new byte[3];
		bin.read(head, 0, head.length);
		String encoding = "gb2312";
		if (head[0] == -1 && head[1] == -2)
			encoding = "UTF-16";
		if (head[0] == -2 && head[1] == -1)
			encoding = "Unicode";
		if (head[0] == -17 && head[1] == -69 && head[2] == -65)
			encoding = "UTF-8";
		return encoding;
	}

	public static void generate(File novel,int i) throws Exception {
		String folderName = genarateFolderNum(novel, i);
		if (folderName == null) {
			return;
		}
		List<String> chapterList = getChapterList(novel);
		// generateChapterMenuHtmlFile(folderName, chapterList);
		FileInputStream fileInputStream = new FileInputStream(novel);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, getCharsetOfNovel(novel));
		BufferedReader novelbr = new BufferedReader(inputStreamReader);
		int currentPageIndex = -1;
		StringBuilder content = new StringBuilder();
		String line = novelbr.readLine();
		while (line != null) {
			if ((line.indexOf("章") == 0 && line.indexOf("节") == 1 && appearNumber(line, "章") > 1)
					|| (line.indexOf("章") == 0 && line.indexOf("节") == 1 && line.indexOf("第") != -1)) {
				if (currentPageIndex > -1) {
					generateChapterHtmlFile(currentPageIndex, content.toString(), chapterList, folderName,i);
					content.delete(0, content.length());
				}
				currentPageIndex++;
			} else if (currentPageIndex > -1) {
				content.append(line + "<br><br>");
			}
			line = novelbr.readLine();
		}
		novelbr.close();
		fileInputStream.close();
	}
	/**
	 * 生成小说文件夹
	 * 
	 * @param novel
	 * @return 成功生成返回文件夹名，已存在返回null
	 */
	private static String genarateFolderNum(File novel, int i) {
		if (!novel.isFile() || !novel.getAbsolutePath().endsWith(".txt")) {
			return null;
		}
		String path="D:\\book\\"+i;
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdirs();
			return path;
		}
		return null;
	}
	/**
	 *  * 获取指定字符串出现的次数  *  * @param srcText 源字符串  * @param findText 要查找的字符串
	 *  * @return  
	 */
	public static int appearNumber(String srcText, String findText) {
		int count = 0;
		Pattern p = Pattern.compile(findText);
		Matcher m = p.matcher(srcText);
		while (m.find()) {
			count++;
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		File folder = new File("D:\\books");
		// File folder=new File("D:/book/杀神叶欢.TXT");
		File[] files = folder.listFiles();
		for (int i = 0; i < files.length; i++) {
			Separater.generate(files[i],i+1);
		}
	}

}