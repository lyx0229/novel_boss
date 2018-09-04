package com.novel.web.boss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.novel.web.boss.entity.UserPO;
/**
 * 用户DAO
 * 
 * @author lyx
 *
 */
public interface UserDao extends  JpaSpecificationExecutor<UserPO>,JpaRepository<UserPO, Integer>{

	@Query(value = "select u from UserPO u where u.userName=?1")
	UserPO findByUserName(String userName);
	
	@Query(value = "select u from UserPO u where u.phoneNum=?1")
	UserPO findByPhone(String phoneNum);
	
	
}
