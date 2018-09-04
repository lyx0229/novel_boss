package com.novel.web.boss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.novel.web.boss.entity.RolePO;

/**
 * 角色DAO接口
 * 
 * @author Administrator
 *
 */
public interface RoleDAO extends   JpaSpecificationExecutor<RolePO>,JpaRepository<RolePO, Integer>{

	@Query(value="select r from RolePO r where r.id=?1")
	RolePO findById(Integer id);
	
	
	@Query(value="select r from RolePO r where r.roleCode=?1")
	RolePO findRoleByCode(String roleCode);
}
