package com.novel.web.admin.pojo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
/**
 * 推广信息
 * @author Administrator
 *
 */
public class SchemeView {

	private int id;
	private int novel_detail_id;
	private int novel_id;
	private String scheme_url;
	private String image_url;
	private int click_no;
	private String channel;
	private Date create_time;
	private Date update_time;
	private BigDecimal recharge_money;
	private BigInteger recharge_num;
	private BigInteger subscribe_num;
	private String chapter_name;
	private String novel_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNovel_detail_id() {
		return novel_detail_id;
	}
	public void setNovel_detail_id(int novel_detail_id) {
		this.novel_detail_id = novel_detail_id;
	}
	public int getNovel_id() {
		return novel_id;
	}
	public void setNovel_id(int novel_id) {
		this.novel_id = novel_id;
	}
	public String getScheme_url() {
		return scheme_url;
	}
	public void setScheme_url(String scheme_url) {
		this.scheme_url = scheme_url;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public int getClick_no() {
		return click_no;
	}
	public void setClick_no(int click_no) {
		this.click_no = click_no;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public BigDecimal getRecharge_money() {
		return recharge_money;
	}
	public void setRecharge_money(BigDecimal recharge_money) {
		this.recharge_money = recharge_money;
	}
	
	public BigInteger getRecharge_num() {
		return recharge_num;
	}
	public void setRecharge_num(BigInteger recharge_num) {
		this.recharge_num = recharge_num;
	}
	public BigInteger getSubscribe_num() {
		return subscribe_num;
	}
	public void setSubscribe_num(BigInteger subscribe_num) {
		this.subscribe_num = subscribe_num;
	}
	public String getChapter_name() {
		return chapter_name;
	}
	public void setChapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
	}
	public String getNovel_name() {
		return novel_name;
	}
	public void setNovel_name(String novel_name) {
		this.novel_name = novel_name;
	}
	
	
}
