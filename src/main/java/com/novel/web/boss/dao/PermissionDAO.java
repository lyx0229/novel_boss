package com.novel.web.boss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.novel.web.boss.entity.PermissionPO;
import com.novel.web.boss.entity.RolePO;

/**
 * 权限DAO
 * @author lyx
 *
 */
public interface PermissionDAO extends  JpaSpecificationExecutor<PermissionPO>,JpaRepository<PermissionPO, Integer>{
	
	@Query(value="select m from PermissionPO m where m.id=?1")
	PermissionPO findByid(Integer id);
	
	@Query(value="select r from PermissionPO r where r.perCode=?1")
	PermissionPO findPermissionPOByCode(String perCode);
}
