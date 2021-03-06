package com.novel.web.admin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.novel.web.admin.entity.PlayTourGoods;
import com.novel.web.admin.entity.RechargeDetail;
import com.novel.web.admin.entity.RechargeTemplate;
import com.novel.web.admin.repository.ExchangeDetailRepository;
import com.novel.web.admin.repository.PlayTourGoodsRepository;
import com.novel.web.admin.repository.RechargeDetailRepository;
import com.novel.web.admin.repository.RechargeTemplateRepository;
import com.novel.web.boss.service.UserService;

@Service
public class CommonService {
	@Autowired
	ExchangeDetailRepository exchangeRep;
	@Autowired
	RechargeTemplateRepository rechargeTemplate;
	@Autowired
	RechargeDetailRepository rechargeDetail;
	@Autowired
	PlayTourGoodsRepository playTourGoodsRep;
	@Autowired
	UserService userService;
	
	public PlayTourGoods findPlayTourGoodsByID(int id){
		return playTourGoodsRep.findOne(id);
	}
	public PlayTourGoods saveAndUpdate(PlayTourGoods po){
		return playTourGoodsRep.saveAndFlush(po);
	}
	
	public RechargeTemplate findRechargeTemplatesByID(int id){
		return rechargeTemplate.findOne(id);
	}
	public RechargeTemplate saveAndUpdate(RechargeTemplate po){
		return rechargeTemplate.saveAndFlush(po);
	}
	/**
	 * 礼物模板
	 * @param po
	 * @param basicPage
	 * @return
	 */
	public Page<PlayTourGoods> findPlayTourGoodsByCondition(PlayTourGoods po, Pageable basicPage) {

		Specification<PlayTourGoods> specification = new Specification<PlayTourGoods>() {
			@Override
			public Predicate toPredicate(Root<PlayTourGoods> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				
				if (po.getGoods_name() != null && !"".equals(po.getGoods_name())) {
					predicates.add(cb.like(root.get("goods_name").as(String.class), "%" + po.getGoods_name() + "%"));
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		return playTourGoodsRep.findAll(specification, basicPage);
	}
	
	
	
	/**
	 * 充值模板
	 * @param po
	 * @param basicPage
	 * @return
	 */
	public Page<RechargeTemplate> findRechargeTemplateByCondition(RechargeTemplate po, Pageable basicPage) {

		Specification<RechargeTemplate> specification = new Specification<RechargeTemplate>() {
			@Override
			public Predicate toPredicate(Root<RechargeTemplate> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if (po.getTemplate_name() != null && !"".equals(po.getTemplate_name())) {
					predicates.add(cb.like(root.get("template_name").as(String.class), "%" + po.getTemplate_name() + "%"));
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		return rechargeTemplate.findAll(specification, basicPage);
	}
	/**
	 * 充值明细
	 * @param po
	 * @param basicPage
	 * @return
	 */
	public Page<RechargeDetail> findRechargeDetailByCondition(RechargeDetail po, Pageable basicPage, Date invoiceCreateStart, Date invoiceCreateEnd) {

		Specification<RechargeDetail> specification = new Specification<RechargeDetail>() {
			@Override
			public Predicate toPredicate(Root<RechargeDetail> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if (po.getUser_id() != 0) {
					predicates.add(cb.equal(root.get("user_id").as(Integer.class), po.getUser_id()));
				}
				if (po.getResult() != 0) {
					predicates.add(cb.equal(root.get("result").as(Integer.class), po.getResult()));
				}
				if (po.getOrder_no() != null && !"".equals(po.getOrder_no())) {
					predicates.add(cb.like(root.get("order_no").as(String.class), "%" + po.getOrder_no() + "%"));
				}

				if (invoiceCreateStart != null) {
					predicates.add(cb.greaterThanOrEqualTo(root.get("recharge_time").as(Date.class), invoiceCreateStart));
				}

				if (invoiceCreateEnd != null) {
					predicates.add(cb.lessThanOrEqualTo(root.get("recharge_time").as(Date.class), invoiceCreateEnd));
				}

				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		return rechargeDetail.findAll(specification, basicPage);
	}
}
