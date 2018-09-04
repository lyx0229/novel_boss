package com.novel.web.boss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novel.web.boss.dao.PerRoleRelationDAO;
import com.novel.web.boss.dao.UserRoleRelationDAO;
import com.novel.web.boss.entity.PerRoleRelationPO;
import com.novel.web.boss.entity.RolePO;
import com.novel.web.boss.service.PerRoleRelationService;

@Service
public class PerRoleRelationServiceImpl implements  PerRoleRelationService{
	@Autowired
	 PerRoleRelationDAO perRoleRelationDAO;

	public List<PerRoleRelationPO> findPerRoleRelationByRoleId(Integer roleid) {

		return perRoleRelationDAO.findPerRoleRelationByRoleId(roleid);
	}
	
}
