package com.novel.web.boss.common.tools;

import org.apache.shiro.crypto.hash.SimpleHash;

import com.novel.web.boss.common.constants.Constant;

public class Md5Tools {
	
    public static String passMd5 (String password){
    	String algorithmName = "md5";
		int hashIterations = 1;
		SimpleHash hash = new SimpleHash(algorithmName, password+Constant.md5_key, null, hashIterations);
		String encodedPassword = hash.toHex();
		return encodedPassword;
    }
}
