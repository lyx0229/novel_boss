package com.novel.web.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novel.web.admin.entity.RechargeDetail;
import com.novel.web.admin.entity.RechargeTemplate;
import com.novel.web.admin.entity.WeixinUserInfo;
import com.novel.web.admin.repository.RechargeDetailRepository;
import com.novel.web.admin.repository.RechargeTemplateRepository;
import com.novel.web.admin.repository.UserRepository;

@Service
public class RechargeService {
	@Autowired
	private RechargeTemplateRepository template;
	
	@Autowired
	private RechargeDetailRepository detail;
	
	@Autowired
	private UserRepository repository;

	public List<RechargeTemplate> findRechargeTemplate() {
		return template.findAll();
	}
	
	public RechargeTemplate findRechargeTemplateByID(int id) {
		return template.findOne(id);
	}
	
	
	public List<RechargeDetail> findRechargeDetailByUserID(int userid) {
		return detail.findRechargeDetailByUserID(userid);
	}
	
	
	public RechargeDetail findRechargeDetailByOrderNo(String order_no) {
		return detail.findRechargeDetailByOrderNo(order_no);
	}
	
	public RechargeDetail saveAndUpdate(RechargeDetail po){
		return detail.saveAndFlush(po);
	}
	/**
	 * 充值更新
	 * @param po
	 * @return
	 */
	public RechargeDetail saveRechargeAndUserInfo(RechargeDetail po){
		WeixinUserInfo user= repository.findOne(po.getUser_id());
		user.setBook_peas(user.getBook_peas()+po.getBook_peas());
		repository.saveAndFlush(user);
		return detail.saveAndFlush(po);
	}
}
