package com.novel.web.admin.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.novel.web.admin.entity.JSONResponse;
import com.novel.web.admin.entity.Novel;
import com.novel.web.admin.entity.NovelDetail;
/**
 * 文件上传
 */
import com.novel.web.admin.service.NovelCmsService;
import com.novel.web.common.utils.Util;
@RestController
@RequestMapping("/upload")
public class FileController {
	Logger logger = LoggerFactory.getLogger(FileController.class); 
	@Autowired
	NovelCmsService novelCmsService;

	 //文件上传相关代码
    @RequestMapping(value = "/upload_file", method = {RequestMethod.POST,RequestMethod.GET})
    public JSONResponse upload(@RequestParam MultipartFile file,HttpServletRequest request) {
        if (file.isEmpty()) {
        	return	JSONResponse.error("文件为空");
        }
       
        int novel_id=Util.toInt(request.getParameter("novel_id"));
        String chapter_name=request.getParameter("chapter_name");
        int free_state=Util.toInt(request.getParameter("free_state"));
        int id=Util.toInt(request.getParameter("id"));
        
        if (novel_id==0) {
        	return	JSONResponse.error("小说id为空");
        }
        NovelDetail detail=novelCmsService.findNovelDetailById(id);
        Novel novel=novelCmsService.findNovelById(novel_id);
        novel.setNovel_new_chapter(chapter_name);
        novel.setNovel_update_time(new Date());
        if(detail==null){
        	detail=new NovelDetail();
        	detail.setChapter_name(chapter_name);
        	detail.setFree_state(free_state);
        	detail.setNovel_id(novel_id);
        	detail.setUpdate_time(new Date());
        }else{
        	detail.setChapter_name(chapter_name);
        	detail.setFree_state(free_state);
        	detail.setUpdate_time(new Date());
        }
        logger.info("novel_id：" + novel_id);
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = "D://books//"+novel_id+"//";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            detail.setChapter_url(dest.getPath());
            novel.setNovel_page_url(dest.getPath());
//            novelCmsService.updateNovelAndNovelDetail(detail,novel);
            return JSONResponse.success("上传成功");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSONResponse.error("上传失败");
    }
    @RequestMapping(value ="/download_file", method = RequestMethod.POST)
    public String downloadFile(HttpServletRequest request, HttpServletResponse response){
        String fileName = "FileUploadTests.java";
        if (fileName != null) {
            //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
            String realPath = request.getServletContext().getRealPath(
                    "//WEB-INF//");
            File file = new File(realPath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" +  fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
    //多文件上传
    @RequestMapping(value = "/batch_upload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();

                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => "
                            + e.getMessage();
                }
            } else {
                return "You failed to upload " + i
                        + " because the file was empty.";
            }
        }
        return "上传成功";
    }
}
