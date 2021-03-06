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
    * 打赏礼物信息表
    * Fri Jul 13 17:30:53 CST 2018 lyx
    */ 
 @Entity 
 @Table(name = "tbl_play_tour_goods") 


public class PlayTourGoods implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9216146259902176525L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	@Column 
	private String goods_name;
	@Column 
	private String imgurl;
	@Column 
	private int bookpeas;
	@Column 
	private Date update_time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getBookpeas() {
		return bookpeas;
	}
	public void setBookpeas(int bookpeas) {
		this.bookpeas = bookpeas;
	}
	
	
}

