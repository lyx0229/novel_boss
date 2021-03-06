package com.novel.web.admin.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import java.util.Date;
   /**
    * tbl_recharge_template 
    * Mon Jun 25 11:52:36 CST 2018 lyx
    */ 
 @Entity 
 @Table(name = "tbl_recharge_template") 
public class RechargeTemplate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4214340213083263455L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	@Column 
	private String template_name;
	@Column 
	private double recharge_money;
	@Column 
	private int book_peas;
	@Column 
	private int pre_book_peas;
	@Column 
	private int terms;
	@Column 
	private String head_img;
	@Column 
	private String description;
	@Column 
	private Date create_time;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTemplate_name() {
		return template_name;
	}
	public void setTemplate_name(String template_name) {
		this.template_name = template_name;
	}
	public double getRecharge_money() {
		return recharge_money;
	}
	
	public int getTerms() {
		return terms;
	}
	public void setTerms(int terms) {
		this.terms = terms;
	}
	public void setRecharge_money(double recharge_money) {
		this.recharge_money = recharge_money;
	}
	public int getBook_peas() {
		return book_peas;
	}
	public void setBook_peas(int book_peas) {
		this.book_peas = book_peas;
	}
	public int getPre_book_peas() {
		return pre_book_peas;
	}
	public void setPre_book_peas(int pre_book_peas) {
		this.pre_book_peas = pre_book_peas;
	}
	public String getHead_img() {
		return head_img;
	}
	public void setHead_img(String head_img) {
		this.head_img = head_img;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

