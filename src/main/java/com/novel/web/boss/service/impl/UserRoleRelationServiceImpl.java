package com.novel.web.boss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novel.web.boss.dao.UserRoleRelationDAO;
import com.novel.web.boss.entity.RolePO;
import com.novel.web.boss.service.UserRoleRelationService;
import com.novel.web.boss.vo.TestQuery;

@Service
public class UserRoleRelationServiceImpl implements UserRoleRelationService{
	@Autowired
	UserRoleRelationDAO userRoleRelationDAO;

	public List<RolePO> findRoleByUserName(String userName) {

		return userRoleRelationDAO.findRoleByUserName(userName);
	}
	
}
