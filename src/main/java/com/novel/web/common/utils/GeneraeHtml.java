package com.novel.web.common.utils;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class GeneraeHtml {


    private ArrayList<String> fileNames;
   
    public  GeneraeHtml()
    {
        fileNames=new ArrayList<String>();
    }
    public void generateHtmlByFile(File file)throws Exception
    {
            generate(file);
//            generateContent();
       
    }
   
    //Create all chapters's html file
    private void generate(File file)throws Exception
    {
        boolean isFirstTitle=true;
        Scanner sca=new Scanner(file);
        String currentContent="";
        String currentLineStr="";
        String currentPageFileName="";
        String nextPageFileName="";
        int currentPageIndex=-1;
       
        sca.useDelimiter("/n");
       
        while(sca.hasNext())
        {
            currentLineStr=sca.next();
            if(currentLineStr.indexOf("章 ")!=-1)
            {
               
                if(!isFirstTitle)
                {
                    System.out.println("Current output title:"+currentPageFileName);
                    nextPageFileName=(currentPageIndex+1)+currentLineStr.trim()+".html";
                    fileNames.add(nextPageFileName);
                   
                    writeContent(currentContent,currentPageFileName,currentPageIndex);
                   
                    currentPageFileName=nextPageFileName;
                    currentContent="";
                }else
                {
                    currentPageFileName=(currentPageIndex+1)+currentLineStr.trim()+".html";
                    fileNames.add(currentPageFileName);
                    isFirstTitle=false;
                }
                currentPageIndex++;
               
            }
            currentContent+=currentLineStr+"</br>";
        }
        sca.close();
    }
   
    //It will write the current chapter into a html file
    private void writeContent(String bodyContent,String currentFileName,int currentPageIndex)throws Exception
    {
         int previousPageIndex=0;
         int nextPageIndex=currentPageIndex+1;
         if(currentPageIndex!=0)
         {
             previousPageIndex=currentPageIndex-1;
         }
         String pageContent="<html>/n<head>/n"
                             +"<meta http-equiv='content-type' content='text/html;charset=utf-8'>/n"
                             +"</head>/n<body bgcolor='#e6f3ff'>/n"
                             +bodyContent
                             +"</br>"
                             +"<table align='center'>"
//                             +"<tr>"
//                             +"<td><a href='./"+fileNames.get(previousPageIndex)+"'>上一页</a></td>"
//                             +"<td><a href='./contents.html'>目录</a></td>"
//                             +"<td><a href='./"+fileNames.get(nextPageIndex)+"'>下一页</a></td>"
//                             +"</tr>"
                             +"</table>"
                             +"</body>/n</html>";
         String filePath="杀神叶欢/"+currentFileName;
         PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
         out.print(pageContent);
         out.flush();
         out.close();
    }
   
    //Create a html file contain chapter's reference.
    /*private void generateContent()throws Exception
    {
        String pageContent="<html>/n<head>/n"
                            +"<meta http-equiv='content-type' content='text/html;charset=utf-8'>/n"
                            +"</head>/n<body bgcolor='#e6f3ff'>/n"
                            +"<table align='center' width='80%' border=1>"
                            +"<tr align='center'>";
        for(int i=0;i<fileNames.size();i++)
        {
            String item=fileNames.get(i);
            pageContent+="<td width=33% color='green'><a href='./"+item+"'>"+item+"</a></td>";
             if((i+1)%3==0)
            {
                pageContent+="</tr>/n<tr align='center'>";
            }
        }
         pageContent+="</table>/n</body>/n</html>";
         PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("杀神叶欢/contents.html")));
         out.print(pageContent);
         out.flush();
         out.close();
                           
    }*/
   
    public static void main(String[] args) {
        GeneraeHtml generaeHtml=new GeneraeHtml();
        try
        {
//           File file=new File("D:/book/杀神叶欢.TXT");
           File file= new File("D:\\book\\杀神叶欢.TXT");
           generaeHtml.generateHtmlByFile(file);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}