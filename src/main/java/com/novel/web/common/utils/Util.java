package com.novel.web.common.utils;

import java.io.File;
import java.io.FileOutputStream;

public class Util {

	public static int toInt(String strNum) {
		if (strNum == null || "".equals(strNum)) {
			return 0;
		}
		Integer integer = new Integer(strNum);
		return integer.parseInt(strNum);
	}
	
	public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception { 
        File targetFile = new File(filePath);  
        if(!targetFile.exists()){    
            targetFile.mkdirs();    
        }       
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
