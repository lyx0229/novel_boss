package com.novel.web.boss.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.novel.web.boss.entity.PermissionPO;
import com.novel.web.boss.vo.PermissionVO;

public interface PermissionService {

	List<PermissionVO> findPerInfoByUserName(String userName);

	public Page<PermissionPO> findPerByCondition(PermissionPO perPO, Pageable basicPage);

	public PermissionPO findPermissionPOByCode(String roleCode);

	public PermissionPO findOne(Integer id);

	public PermissionPO saveOrUpdate(PermissionPO perPO);

	public void deleteById(Integer id);

	public List<PermissionPO> perOpinionList();
}
