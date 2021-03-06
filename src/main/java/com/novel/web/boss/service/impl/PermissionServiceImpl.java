package com.novel.web.boss.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.novel.web.boss.dao.PermissionDAO;
import com.novel.web.boss.entity.PermissionPO;
import com.novel.web.boss.service.PermissionService;
import com.novel.web.boss.vo.PermissionVO;

@Service()
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	PermissionDAO permissionDAO;
	// 生成EntityManger
	@Autowired
	private EntityManager entityManager;

	public List<PermissionVO> findPerInfoByUserName(String phoneNum) {
		// 执行原生SQL
		Query nativeQuery = entityManager.createNativeQuery(
				"SELECT DISTINCT tbp.* FROM  tbl_bms_per tbp " + "LEFT JOIN tbl_bms_per_role tbpr ON tbpr.perId=tbp.id "
						+ "LEFT JOIN tbl_bms_role tbr on tbr.id=tbpr.roleId  "
						+ "left join tbl_bms_user_role tbur on tbur.roleId=tbr.id "
						+ "left join tbl_bms_user tbu on tbu.id=tbur.userId  where tbu.phoneNum=:phoneNum");
		nativeQuery.setParameter("phoneNum", phoneNum);
		// 指定返回对象类型
		nativeQuery.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(PermissionVO.class));
		// 返回对象 List<T>
		@SuppressWarnings("unchecked")
		List<PermissionVO> list = nativeQuery.getResultList();
		if (list.size() == 0) {
			return null;
		}
		return list;
	}

	/**
	 * 分页查询
	 */
	public Page<PermissionPO> findPerByCondition(PermissionPO PermissionPO, Pageable basicPage) {

		Specification<PermissionPO> specification = new Specification<PermissionPO>() {
			@Override
			public Predicate toPredicate(Root<PermissionPO> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<String> perName = root.get("perName");
				Path<String> perCode = root.get("perCode");
				Predicate p = null;
				if (PermissionPO.getPerName() != null && !"".equals(PermissionPO.getPerName())) {
					p = cb.equal(perName, PermissionPO.getPerName());
				}
				if (PermissionPO.getPerCode() != null && !"".equals(PermissionPO.getPerCode())) {
					Predicate c = p;
					p = cb.like(perCode, PermissionPO.getPerCode());
					if(c!=null){
						p=cb.and(p,c);
					}
				}
				return p;
			}
		};
		return permissionDAO.findAll(specification, basicPage);
	}

	public PermissionPO findPermissionPOByCode(String roleCode) {
		return permissionDAO.findPermissionPOByCode(roleCode);
	}

	public PermissionPO findOne(Integer id) {
		return permissionDAO.findOne(id);
	}

	public PermissionPO saveOrUpdate(PermissionPO PermissionPO) {
		return permissionDAO.saveAndFlush(PermissionPO);
	}

	public void deleteById(Integer id) {
		permissionDAO.delete(id);
	}

	public List<PermissionPO> perOpinionList() {
		return permissionDAO.findAll();
	}
}
