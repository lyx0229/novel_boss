package com.novel.web.boss.service.impl;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.novel.web.boss.dao.UserDao;
import com.novel.web.boss.dao.UserRoleRelationDAO;
import com.novel.web.boss.entity.UserPO;
import com.novel.web.boss.entity.UserRoleRelationPO;
import com.novel.web.boss.service.UserService;

/**
 * 用户类
 * 
 * @author HZQ
 *
 */
@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleRelationDAO  userRoleRelationDAO;

	public UserPO findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	public UserPO findOne(Integer id) {
		return userDao.findOne(id);
	}
	
	public UserPO findByPhone(String phoneNum) {
		return userDao.findByPhone(phoneNum);
	}

	public UserPO updateUserPOById(UserPO user) {
		return userDao.saveAndFlush(user);
	}
	@Transactional
	public void deleteById(Integer id) {
		
		 userRoleRelationDAO.deleteByUserId(id);
		 userDao.delete(id);
	}

	public UserPO saveUser(UserPO userPO) {
		return userPO=userDao.saveAndFlush(userPO);
	}
	
	@Transactional
	public UserPO saveOrUpdate(UserPO userPO,String ids) {
		if(ids==null){
			return null;
		}
		userPO=userDao.saveAndFlush(userPO);
		ids=ids.substring(ids.indexOf("[")+1, ids.lastIndexOf("]"));		
		
		String [] idlist=ids.split(",");
		for(String id: idlist){
			UserRoleRelationPO po=new UserRoleRelationPO();
			po.setRoleId(Integer.valueOf(id));
			po.setDataStatus(1);
			po.setUpdateTime(new Date());
			po.setCreateTime(new Date());
			po.setUserId(userPO.getId());
			po.setUpdateUserid(userPO.getId());
			po.setCreateUserid(userPO.getId());
			userRoleRelationDAO.saveAndFlush(po);
		}
		return userPO;
	}
	 
	/**
	 * 更新用户和用户角色关联信息
	 * @param user
	 * @param ids
	 * @return
	 */
	@Transactional
	public UserPO updateUserInfo(UserPO userPO,String ids) {
		if(ids==null){
			return null;
		}
		ids=ids.substring(ids.indexOf("[")+1, ids.lastIndexOf("]"));		
		
		String [] idlist=ids.split(",");
		 userRoleRelationDAO.deleteByUserId(userPO.getId());
		 for(String id: idlist){
			 UserRoleRelationPO po=new UserRoleRelationPO();
				po.setRoleId(Integer.valueOf(id));
				po.setDataStatus(1);
				po.setUpdateTime(new Date());
				po.setCreateTime(new Date());
				po.setUserId(userPO.getId());
				po.setUpdateUserid(userPO.getId());
				po.setCreateUserid(userPO.getId());
				userRoleRelationDAO.saveAndFlush(po);
		 }
		 userPO=userDao.saveAndFlush(userPO);
		 
		 return userPO;
	}

	public Page<UserPO> findUserByPhone(UserPO userPO, Pageable basicPage) {
		
		Specification<UserPO> specification = new Specification<UserPO>() {
			@Override
			public Predicate toPredicate(Root<UserPO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<String> phoneNum = root.get("phoneNum");
				Path<String> userName = root.get("userName");
				Predicate p = null ;
				if(userPO.getPhoneNum()!=null && !"".equals(userPO.getPhoneNum())){
					p= cb.equal(phoneNum, userPO.getPhoneNum());
				}
				if(userPO.getUserName()!=null && !"".equals(userPO.getUserName())){
					Predicate c=p;
					p= cb.like(userName, userPO.getUserName());
					if(c!=null){
						p=cb.and(p,c);
					}
				}
				return p;
			}
		};
		return userDao.findAll(specification, basicPage);
	}
}
