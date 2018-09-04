package com.novel.web.boss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.novel.web.boss.entity.PerRoleRelationPO;
import com.novel.web.boss.entity.RolePO;

/**
 * 菜单角色关联DAO接口
 * 
 * @author Administrator
 *
 */
public interface PerRoleRelationDAO extends JpaRepository<PerRoleRelationPO, Integer> {
	@Query(value = "select mr from PerRoleRelationPO mr where mr.id=?1")
	PerRoleRelationPO findbyId(Integer id);

	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM PerRoleRelationPO t  where t.roleId =?1")
    int deleteByRoleId(Integer roleId);
	
	@Query(value = "select mr from PerRoleRelationPO mr where mr.roleId=?1")
	List<PerRoleRelationPO> findPerRoleRelationByRoleId(Integer roleid);
	
	
}
