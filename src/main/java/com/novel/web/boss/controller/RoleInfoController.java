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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.novel.web.boss.common.tools.PageableTools;
import com.novel.web.boss.common.tools.SortDto;
import com.novel.web.boss.entity.PerRoleRelationPO;
import com.novel.web.boss.entity.PermissionPO;
import com.novel.web.boss.entity.RolePO;
import com.novel.web.boss.entity.UserPO;
import com.novel.web.boss.service.PerRoleRelationService;
import com.novel.web.boss.service.PermissionService;
import com.novel.web.boss.service.RoleService;
import com.novel.web.boss.service.UserService;

/**
 * 角色管理
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/role")
public class RoleInfoController {
	@Autowired
	RoleService roleService;
	@Autowired
	UserService userService;
	@Autowired
	PermissionService perService;
	@Autowired
	PerRoleRelationService perRoleRelationService;

	/**
	 * 进入角色页面
	 * 
	 * @return
	 */
	@RequestMapping("/roleinfo")
	public ModelAndView getRoleInfo() {
		ModelAndView model = new ModelAndView("html/user/roleinfo");
		return model;
	}

	/**
	 * 角色查询.
	 * 
	 * @return
	 */
	@RequestMapping("rolelist")
	public Map<String, Object> roleList(HttpServletRequest request) {
		Map<String, Object> map = new HashedMap();
		String param1 = request.getParameter("pageSize");
		String param2 = request.getParameter("currentPage");
		String roleName = request.getParameter("searchRoleName");
		String roleCode = request.getParameter("searchRoleCode");
		int pageSize = Integer.valueOf(param1);
		int currentPage = Integer.valueOf(param2);
		RolePO rolePO = new RolePO();
		rolePO.setRoleName(roleName);
		rolePO.setRoleCode(roleCode);
		Page<RolePO> datas = roleService.findRoleByCondition(rolePO,
				PageableTools.basicPage(currentPage, pageSize, new SortDto("id")));
		map.put("rolelist", datas);// 菜单
		return map;
	}

	/**
	 * 角色添加;
	 * 
	 * @return
	 */
	@RequestMapping("/roleAdd")
	public Map<String, Object> roleAdd(HttpServletRequest request) {
		Map<String, Object> map = new HashedMap();
		Subject currentUser = SecurityUtils.getSubject();
		Object phone = currentUser.getPrincipal();
		UserPO user = userService.findByPhone(phone.toString());
		String param = request.getParameter("rolePO");
		String ids = request.getParameter("ids");
		JSONObject jsonObject = JSONObject.parseObject(param);
		RolePO rolePO = (RolePO) JSONObject.toJavaObject(jsonObject, RolePO.class);

		RolePO rolePO1 = roleService.findRoleByCode(rolePO.getRoleCode());
		if (rolePO1 != null) {
			map.put("msg", "该角色编码已经添加完成，不可重复添加");
			return map;
		}

		rolePO.setDataStatus(1);
		rolePO.setCreateUserid(user.getId());
		rolePO.setUpdateUserid(user.getId());
		rolePO = roleService.saveOrUpdateInfo(rolePO,ids);
		map.put("msg", "添加成功");
		return map;
	}
	
	
	/**
	 * 进入编辑角色页面
	 * 
	 * @return
	 */
	@RequestMapping("/editRole")
	public Map<String, Object> getEditRoleInfo(HttpServletRequest request) {
		String param1 = request.getParameter("roleid");
		Map<String, Object> map = new HashedMap();
		RolePO rolePO  = roleService.findOne(Integer.valueOf(param1));
		rolePO.setPerList(null);
		List<PermissionPO> perOpinionList  = perService.perOpinionList();
		
		List<PerRoleRelationPO> perRoleRelationList  = perRoleRelationService.findPerRoleRelationByRoleId(Integer.valueOf(param1));
		
		JSONArray jsonArray=new JSONArray();
		Integer [] idlist=new Integer[perRoleRelationList.size()];
		for(int i=0;i<perOpinionList.size();i++){
			JSONObject json=new JSONObject();
			json.put("id", perOpinionList.get(i).getId());
			json.put("pId", perOpinionList.get(i).getPerUpperId()==null ? "0" : perOpinionList.get(i).getPerUpperId() );
			json.put("name", perOpinionList.get(i).getPerName());
			if(perOpinionList.get(i).getPerUpperId()==null){
				json.put("open", true);
			}
			if (perRoleRelationList != null && perRoleRelationList.size() > 0) {
				for (int  j=0;j< perRoleRelationList.size();j++) {
                 if(perRoleRelationList.get(j).getPerId().equals(perOpinionList.get(i).getId())){
                	 json.put("checked", true);
            }
                 idlist[j]=perRoleRelationList.get(j).getPerId();
				}
			}
			jsonArray.add(json);
		}
		map.put("idlist", idlist);
		map.put("json", jsonArray);
		map.put("rolePO", rolePO);
		return map;
	}
	
	/**
	 * 角色编辑;
	 * 
	 * @return
	 */
	@RequestMapping("/updateRoleEdit")
	public Map<String, Object> updateRoleEdit(HttpServletRequest request) {
		Map<String, Object> map = new HashedMap();
		Subject currentUser = SecurityUtils.getSubject();
		Object phone = currentUser.getPrincipal();
		UserPO user = userService.findByPhone(phone.toString());
		
		String param = request.getParameter("rolePO");
		String ids = request.getParameter("ids");
		JSONObject jsonObject = JSONObject.parseObject(param);
		RolePO rolePO = (RolePO) JSONObject.toJavaObject(jsonObject, RolePO.class);
		RolePO rolePO1 = roleService.findOne(rolePO.getId());
		rolePO.setPerList(rolePO1.getPerList());
		rolePO.setUpdateUserid(user.getId());
		rolePO.setUpdateTime(new Date());
		rolePO=roleService.saveOrUpdateInfo(rolePO,ids);
		map.put("rolePO", rolePO);
		map.put("msg", "修改成功");
		return map;
	}

	/**
	 * 角色删除;
	 * 
	 * @return
	 */
	@RequestMapping("/roleDel")
	public Map<String, Object> roleDel(HttpServletRequest request) {
		Map<String, Object> map = new HashedMap();
		String roleid = request.getParameter("roleid");
		roleService.deleteById(Integer.valueOf(roleid));
		map.put("msg", "删除成功");
		return map;
	}
	
	/**
	 * 获取下拉列表
	 * 
	 * @return
	 */
	@RequestMapping("/roleOpinionList")
	public Map<String, Object> roleOpinionList(HttpServletRequest request) {
		Map<String, Object> map = new HashedMap();
		List<RolePO> roleOpinionList  = roleService.roleOpinionList();
		List<PermissionPO> perOpinionList  = perService.perOpinionList();
		JSONArray jsonArray=new JSONArray();
		
		for(int i=0;i<perOpinionList.size();i++){
			JSONObject json=new JSONObject();
			json.put("id", perOpinionList.get(i).getId());
			json.put("pId", perOpinionList.get(i).getPerUpperId()==null ? "0" : perOpinionList.get(i).getPerUpperId() );
			json.put("name", perOpinionList.get(i).getPerName());
			if(perOpinionList.get(i).getPerUpperId()==null){
				json.put("open", true);
			}
			jsonArray.add(json);
		}
		map.put("json", jsonArray);
		map.put("roleOpinionList", roleOpinionList);
		return map;
	}

}
