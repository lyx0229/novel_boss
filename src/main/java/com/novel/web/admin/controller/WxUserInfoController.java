package com.novel.web.admin.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.novel.web.admin.entity.WeixinUserInfo;
import com.novel.web.admin.service.WxUserService;
import com.novel.web.boss.common.tools.PageableTools;
import com.novel.web.boss.common.tools.SortDto;
import com.novel.web.common.utils.Util;
/**
 * 会员管理
 * @author Administrator
 *
 */

@RestController
@RequestMapping("/wx_user")
public class WxUserInfoController {
	Logger logger = LoggerFactory.getLogger(WxUserInfoController.class); 
	@Autowired
	WxUserService userService;
	 /**
		 * 进入页面
		 * 
		 * @return
		 */
		@RequestMapping("/wx_user_main")
		public ModelAndView wx_user_main() {
			ModelAndView model = new ModelAndView("html/wx/wx_user_list");
			return model;
		}
		
		/**
		 * 小说列表查询
		 * 
		 * @return
		 * @throws UnsupportedEncodingException 
		 */
		@RequestMapping(value = "/wx_user_list", method = RequestMethod.POST)
		public JSONObject wx_user_list(HttpServletRequest request) throws UnsupportedEncodingException {
			JSONObject json =new JSONObject();
			String param1 = request.getParameter("pageSize");
			String param2 = request.getParameter("currentPage");
			String open_id = request.getParameter("searchName");
			int scheme_id = Util.toInt(request.getParameter("searchScheme"));
			String channel = request.getParameter("searchChannel");
			int vip_status = Util.toInt(request.getParameter("searchVipStatus"));
			int sex = Util.toInt(request.getParameter("searchSex"));
			int pageSize = Integer.valueOf(param1);
			int currentPage = Integer.valueOf(param2);
			WeixinUserInfo po = new WeixinUserInfo();
			po.setOpen_id(open_id);
			po.setScheme_id(scheme_id);
			po.setChannel(channel);
			po.setVip_status(vip_status);
			po.setSex(sex);
			Page<WeixinUserInfo> datas = userService.findUserByCondition(po,
					PageableTools.basicPage(currentPage, pageSize, new SortDto("id")));
			json.put("wx_user_list", datas);// 
			logger.info(json.toJSONString());
			return json;
		}
}
