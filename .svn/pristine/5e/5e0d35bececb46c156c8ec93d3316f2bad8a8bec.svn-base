package com.novel.web.boss.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.novel.web.boss.entity.UserPO;

public interface UserService {

	public UserPO findByUserName(String userName);
	
	public UserPO findOne(Integer id);

	public UserPO findByPhone(String phoneNum);

	public UserPO updateUserPOById(UserPO user);
	/**
	 * 更新用户和用户角色关联信息
	 * @param user
	 * @param ids
	 * @return
	 */
	public UserPO updateUserInfo(UserPO user,String ids);

	public UserPO saveOrUpdate(UserPO userPO,String ids);
	
	public UserPO saveUser(UserPO userPO);
	
	public void deleteById(Integer id);
	
	public Page<UserPO> findUserByPhone(UserPO userPO,Pageable basicPage);
}
