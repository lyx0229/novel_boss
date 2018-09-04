package com.novel.web.boss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.novel.web.boss.entity.RolePO;
import com.novel.web.boss.entity.UserRoleRelationPO;

/**
 * 用户角色关联DAO接口
 * 
 * @author Administrator
 *
 */
public interface UserRoleRelationDAO extends JpaRepository<UserRoleRelationPO, Integer> {
	@Query(value = "select ur from UserRoleRelationPO ur  where ur.id=?1")
	UserRoleRelationPO findById(Integer id);

	@Query(value = "SELECT tbr.* FROM  tbl_bms_user tbu "
			+ "LEFT JOIN tbl_bms_user_role tbur ON tbur.userId=tbu.id"
			+ "LEFT JOIN tbl_bms_role tbr on tbr.id=tbur.roleId where tbu.userName=?1", nativeQuery = true)
	List<RolePO> findRoleByUserName(String userName);
	
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM UserRoleRelationPO t  where t.userId =?1")
    int deleteByUserId(Integer userId);
}
