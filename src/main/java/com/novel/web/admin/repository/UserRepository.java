package com.novel.web.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.novel.web.admin.entity.WeixinUserInfo;

public interface UserRepository extends JpaSpecificationExecutor<WeixinUserInfo>,JpaRepository<WeixinUserInfo, Integer> {
	
	//利用原生的SQL进行查询操作
	@Query(value = "select u.* from tbl_user u  where  u.open_id=?1", nativeQuery = true)
	public WeixinUserInfo findUserInfoByOpenID(String openID);

}
