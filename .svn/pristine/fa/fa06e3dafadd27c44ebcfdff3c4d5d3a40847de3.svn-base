package com.novel.web.boss.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.novel.web.boss.common.tools.Md5Tools;
import com.novel.web.boss.common.tools.PageableTools;
import com.novel.web.boss.common.tools.SortDto;
import com.novel.web.boss.entity.UserPO;
import com.novel.web.boss.service.UserService;

/**
 * 用户管理
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {
	@Autowired
	UserService userService;

	/**
	 * 进入用户页面
	 * 
	 * @return
	 */
	@RequestMapping("/userinfo")
	public ModelAndView getUserInfo() {
		ModelAndView model = new ModelAndView("html/user/userinfo");
		return model;
	}

	/**
	 * 用户查询.
	 * 
	 * @return
	 */
	@RequestMapping("userList")
	public Map<String, Object> userInfo(HttpServletRequest request) {
		Map<String, Object> map=new HashMap<String, Object>();
		String param1 = request.getParameter("pageSize");
		String param2 = request.getParameter("currentPage");
		String phoneName = request.getParameter("searchPhoneName");
		String userName = request.getParameter("searchUserName");
		int pageSize = Integer.valueOf(param1);
		int currentPage = Integer.valueOf(param2);
		UserPO userPO = new UserPO();
		userPO.setPhoneNum(phoneName);
		userPO.setUserName(userName);
		Page<UserPO> datas = userService.findUserByPhone(userPO,
				PageableTools.basicPage(currentPage, pageSize, new SortDto("id")));
		map.put("userlist", datas);// 菜单
		return map;
	}

	/**
	 * 用户添加;
	 * 
	 * @return
	 */
	@RequestMapping("/userAdd")
	public Map<String, Object> userInfoAdd(HttpServletRequest request) {
		Map<String, Object> map=new HashMap<String, Object>();
		Subject currentUser = SecurityUtils.getSubject();
		Object phone = currentUser.getPrincipal();
		UserPO user = userService.findByPhone(phone.toString());
		String param = request.getParameter("userPO");
 		String ids = request.getParameter("ids");
		JSONObject jsonObject = JSONObject.parseObject(param);
		UserPO userPO = (UserPO) JSONObject.toJavaObject(jsonObject, UserPO.class);
		
		UserPO user1 = userService.findByPhone(userPO.getPhoneNum());
		if(user1!=null){
			map.put("msg", "该用户已经添加完成，不可重复添加");
			return map;
		}
		
		try {
			String host = InetAddress.getLocalHost().getHostAddress();
			userPO.setPassWord(Md5Tools.passMd5(userPO.getPassWord()));// MD5加密
			userPO.setDataStatus(1);
			userPO.setCreateUserid(user.getId());
			userPO.setUpdateUserid(user.getId());
			userPO.setUserIp(host);
			userPO=userService.saveOrUpdate(userPO,ids);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		map.put("msg", "添加成功");
		return map;
	}

	/**
	 * 进入编辑用户页面
	 * 
	 * @return
	 */
	@RequestMapping("/editUser")
	public Map<String, Object> getEditUserInfo(HttpServletRequest request) {
		String param1 = request.getParameter("userid");
		Map<String, Object> map=new HashMap<String, Object>();
		UserPO user = userService.findOne(Integer.valueOf(param1));
		map.put("userPO", user);
		return map;
	}
	
	
	/**
	 * 用户编辑;
	 * 
	 * @return
	 */
	@RequestMapping("/updateUserEdit")
	public Map<String, Object> updateUserEdit(HttpServletRequest request) {
		Map<String, Object> map=new HashMap<String, Object>();
		Subject currentUser = SecurityUtils.getSubject();
		Object phone = currentUser.getPrincipal();
		UserPO user = userService.findByPhone(phone.toString());
		String param = request.getParameter("userPO");
		String ids = request.getParameter("ids");
		JSONObject jsonObject = JSONObject.parseObject(param);
		
		UserPO userPO = (UserPO) JSONObject.toJavaObject(jsonObject, UserPO.class);
		UserPO userPO1=userService.findOne(userPO.getId());
		userPO.setRoleList(userPO1.getRoleList());
		userPO.setRoleRelationList(userPO1.getRoleRelationList());
		userPO.setUpdateUserid(user.getId());
		userPO.setUpdateTime(new Date());
		userPO=userService.updateUserInfo(userPO,ids);
		map.put("userPO", userPO);
		map.put("msg", "修改成功");
		return map;
	}

	
	/**
	 * 用户删除;
	 * 
	 * @return
	 */
	@RequestMapping("/userDel")
	public Map<String, Object> userDel(HttpServletRequest request) {
		Map<String, Object> map=new HashMap<String, Object>();
		String userid = request.getParameter("userid");
		userService.deleteById(Integer.valueOf(userid));
		map.put("msg", "删除成功");
		return map;
	}
	
	/**
	 * 修改密码
	 * 
	 * @return
	 */
	@RequestMapping("/updatePassWord")
	public Map<String, Object> updatePassWord(HttpServletRequest request) {
		Map<String, Object> map=new HashMap<String, Object>();
		Subject currentUser = SecurityUtils.getSubject();
		Object phone = currentUser.getPrincipal();
		UserPO user = userService.findByPhone(phone.toString());
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		UserPO userPO = userService.findOne(Integer.valueOf(userid));
		
		userPO.setPassWord(Md5Tools.passMd5(password));// MD5加密
		userPO.setUpdateUserid(user.getId());
		userPO.setUpdateTime(new Date());
		userPO=userService.updateUserPOById(userPO);
		map.put("msg", "修改成功");
		return map;
	}

}