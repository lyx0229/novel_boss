package com.novel.web.boss.controller;

import java.util.Date;
import java.util.List;
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
import com.novel.web.boss.common.tools.PageableTools;
import com.novel.web.boss.common.tools.SortDto;
import com.novel.web.boss.entity.PermissionPO;
import com.novel.web.boss.entity.UserPO;
import com.novel.web.boss.service.PermissionService;
import com.novel.web.boss.service.UserService;
/**
 * 资源管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	PermissionService perService;
	@Autowired
	UserService userService;

	
	/**
	 * 进入资源页面
	 * 
	 * @return
	 */
	@RequestMapping("/perinfo")
	public ModelAndView getPerInfo() {
		ModelAndView model = new ModelAndView("html/user/permissioninfo");
		return model;
	}

	/**
	 * 资源查询.
	 * 
	 * @return
	 */
	@RequestMapping("perlist")
	public Map<String, Object> perList(HttpServletRequest request) {
		Map<String, Object> map = new HashedMap();
		String param1 = request.getParameter("pageSize");
		String param2 = request.getParameter("currentPage");
		String perName = request.getParameter("searchPerName");
		String perCode = request.getParameter("searchPerCode");
		int pageSize = Integer.valueOf(param1);
		int currentPage = Integer.valueOf(param2);
		PermissionPO PermissionPO = new PermissionPO();
		PermissionPO.setPerName(perName);
		PermissionPO.setPerCode(perCode);
		Page<PermissionPO> datas = perService.findPerByCondition(PermissionPO,
				PageableTools.basicPage(currentPage, pageSize, new SortDto("id")));
		map.put("perlist", datas);// 菜单
		return map;
	}

	/**
	 * 资源添加;
	 * 
	 * @return
	 */
	@RequestMapping("/perAdd")
	public Map<String, Object> perAdd(HttpServletRequest request) {
		Map<String, Object> map = new HashedMap();
		Subject currentUser = SecurityUtils.getSubject();
		Object phone = currentUser.getPrincipal();
		UserPO user = userService.findByPhone(phone.toString());
		String param = request.getParameter("perPO");
		JSONObject jsonObject = JSONObject.parseObject(param);
		PermissionPO PermissionPO = (PermissionPO) JSONObject.toJavaObject(jsonObject, PermissionPO.class);

		PermissionPO PermissionPO1 = perService.findPermissionPOByCode(PermissionPO.getPerCode());
		if (PermissionPO1 != null) {
			map.put("msg", "该资源编码已经添加完成，不可重复添加");
			return map;
		}

		PermissionPO.setDataStatus(1);
		PermissionPO.setCreateUserid(user.getId());
		PermissionPO.setUpdateUserid(user.getId());
		PermissionPO = perService.saveOrUpdate(PermissionPO);
		map.put("msg", "添加成功");
		return map;
	}
	
	
	/**
	 * 进入编辑资源页面
	 * 
	 * @return
	 */
	@RequestMapping("/editPer")
	public Map<String, Object> getEditperInfo(HttpServletRequest request) {
		String param1 = request.getParameter("perid");
		Map<String, Object> map = new HashedMap();
		PermissionPO PermissionPO  = perService.findOne(Integer.valueOf(param1));
		map.put("PermissionPO", PermissionPO);
		return map;
	}
	
	/**
	 * 资源编辑;
	 * 
	 * @return
	 */
	@RequestMapping("/updatePerEdit")
	public Map<String, Object> updateperEdit(HttpServletRequest request) {
		Map<String, Object> map = new HashedMap();
		Subject currentUser = SecurityUtils.getSubject();
		Object phone = currentUser.getPrincipal();
		UserPO user = userService.findByPhone(phone.toString());
		
		String param = request.getParameter("perPO");
		JSONObject jsonObject = JSONObject.parseObject(param);
		PermissionPO PermissionPO = (PermissionPO) JSONObject.toJavaObject(jsonObject, PermissionPO.class);
		
		PermissionPO.setUpdateUserid(user.getId());
		PermissionPO.setUpdateTime(new Date());
		PermissionPO=perService.saveOrUpdate(PermissionPO);
		map.put("PermissionPO", PermissionPO);
		map.put("msg", "修改成功");
		return map;
	}

	/**
	 * 资源删除;
	 * 
	 * @return
	 */
	@RequestMapping("/perDel")
	public Map<String, Object> perDel(HttpServletRequest request) {
		Map<String, Object> map = new HashedMap();
		String perid = request.getParameter("perid");
		perService.deleteById(Integer.valueOf(perid));
		map.put("msg", "删除成功");
		return map;
	}
	
	/**
	 * 获取下拉列表
	 * 
	 * @return
	 */
	@RequestMapping("/perOpinionList")
	public Map<String, Object> perOpinionList(HttpServletRequest request) {
		Map<String, Object> map = new HashedMap();
		List<PermissionPO> perOpinionList  = perService.perOpinionList();
		map.put("perOpinionList", perOpinionList);
		return map;
	}

}
