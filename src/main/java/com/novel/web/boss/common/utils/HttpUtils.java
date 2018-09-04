package com.novel.web.boss.common.utils;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {

	public static final Logger logger = LoggerFactory
			.getLogger(HttpUtils.class);

	public static void httpPost(String url, List<BasicNameValuePair> formparams)
			throws Exception {
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost(url);
		try {
			if (null != formparams) {
				UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(
						formparams, "UTF-8");
				httppost.setEntity(uefEntity);
			}
			System.out.println("executing request " + httppost.getURI());
			CloseableHttpResponse response = httpclient.execute(httppost);
			String respData = null;
			try {
				HttpEntity entity = response.getEntity();
			} finally {
				response.close();
			}
		} finally {
			// 关闭连接,释放资源
			httpclient.close();
		}
	}

	/**
	 * http post请求传参的方法 返回实体
	 */
	public static CloseableHttpResponse httpPostWithPAaram(String url,
			List<BasicNameValuePair> formparams) throws Exception {
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		// 创建httppost
		HttpPost httppost = new HttpPost(url);
		try {
			if (null != formparams) {
				UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(
						formparams, "UTF-8");
				httppost.setEntity(uefEntity);
			}
			response = httpclient.execute(httppost);
			return response;
		} catch (Exception e) {
			logger.error("remote post exception");
		}
		return response;
	}
}
