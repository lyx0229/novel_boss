package com.novel.web.boss.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.novel.web.boss.entity.RolePO;
import com.novel.web.boss.entity.UserPO;

public interface RoleService {

	public Page<RolePO> findRoleByCondition(RolePO rolePO,Pageable basicPage);
	
	public RolePO findRoleByCode(String roleCode);
	
	
	public RolePO findOne(Integer id);

	public RolePO saveOrUpdate(RolePO rolePO);
	
	public RolePO saveOrUpdateInfo(RolePO rolePO,String ids);
	
	public void deleteById(Integer id);
	
	public List<RolePO> roleOpinionList();
}
