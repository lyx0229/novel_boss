package com.novel.web.boss.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.novel.web.boss.dao.PerRoleRelationDAO;
import com.novel.web.boss.dao.RoleDAO;
import com.novel.web.boss.entity.PerRoleRelationPO;
import com.novel.web.boss.entity.RolePO;
import com.novel.web.boss.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDAO roleDAO;
	@Autowired
	PerRoleRelationDAO perRoleRelationDAO;

	/**
	 * 分页查询
	 */
	public Page<RolePO> findRoleByCondition(RolePO rolePO, Pageable basicPage) {

		Specification<RolePO> specification = new Specification<RolePO>() {
			@Override
			public Predicate toPredicate(Root<RolePO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<String> roleName = root.get("roleName");
				Path<String> roleCode = root.get("roleCode");
				Predicate p = null;
				if (rolePO.getRoleName() != null && !"".equals(rolePO.getRoleName())) {
					p = cb.equal(roleName, rolePO.getRoleName());
				}
				if (rolePO.getRoleCode() != null && !"".equals(rolePO.getRoleCode())) {
					Predicate c = p;
					p = cb.like(roleCode, rolePO.getRoleCode());
					if(c!=null){
						p=cb.and(p,c);
					}
				}
				return p;
			}
		};
		return roleDAO.findAll(specification, basicPage);
	}

	public RolePO findRoleByCode(String roleCode) {
		return roleDAO.findRoleByCode(roleCode);
	}

	public RolePO findOne(Integer id) {
		return roleDAO.findOne(id);
	}

	public RolePO saveOrUpdate(RolePO rolePO) {
		return roleDAO.saveAndFlush(rolePO);
	}
	
	@Transactional
	public void deleteById(Integer id) {
		perRoleRelationDAO.deleteByRoleId(id);
		roleDAO.delete(id);
	}

	public List<RolePO> roleOpinionList() {
		return roleDAO.findAll();
	}
	/**
	 * 更新角色和资源关联信息
	 */
	@Transactional
	public RolePO saveOrUpdateInfo(RolePO rolePO,String ids) {
		if(ids==null){
			return null;
		}
		
		rolePO=roleDAO.saveAndFlush(rolePO);
		ids=ids.substring(ids.indexOf("[")+1, ids.lastIndexOf("]"));		
		perRoleRelationDAO.deleteByRoleId(rolePO.getId());
		String [] idlist=ids.split(",");
		for(String id: idlist){
			PerRoleRelationPO po=new PerRoleRelationPO();
			po.setRoleId(rolePO.getId());
			po.setDataStatus(1);
			po.setUpdateTime(new Date());
			po.setCreateTime(new Date());
			po.setPerId(Integer.valueOf(id));
			po.setUpdateUserid(rolePO.getCreateUserid());
			po.setCreateUserid(rolePO.getCreateUserid());
			perRoleRelationDAO.saveAndFlush(po);
		}
		return rolePO;
	}


}
