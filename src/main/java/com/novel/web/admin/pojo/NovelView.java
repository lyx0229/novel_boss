package com.novel.web.admin.pojo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
/**
 * 小说信息
 * @author Administrator
 *
 */
public class NovelView  {
	
	private Date update_time;
	private BigInteger id;
	private String novel_name;
	private String novel_imgurl;
	private String novel_brief;
	private String novel_author;
	private int sex_status;
	private int type_status;
	private int novel_state;
	private int hot_status;
	private String novel_new_chapter;
	private Date novel_update_time;
	private BigInteger novel_number_votes;
	private String novel_page_url;
	private String sex_str;
	private String type_str;
	private String novel_str;
	private int isflag;
	private BigDecimal new_price;
	private BigDecimal old_price;
//	1:滚动list2:本周主打3:新书试读4:连载更新5:人气推荐
	public int getIsflag() {
		switch(getHot_status()){
		 case 1: isflag=0;break;
		 case 2: isflag=0;break;
		 default : isflag=1;break;
		}
		return isflag;
	}
	
	public BigDecimal getNew_price() {
		return new_price;
	}

	public void setNew_price(BigDecimal new_price) {
		this.new_price = new_price;
	}

	public BigDecimal getOld_price() {
		return old_price;
	}

	public void setOld_price(BigDecimal old_price) {
		this.old_price = old_price;
	}

	public void setIsflag(int isflag) {
		this.isflag = isflag;
	}
	public int getHot_status() {
		return hot_status;
	}
	public void setHot_status(int hot_status) {
		this.hot_status = hot_status;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	
	public BigInteger getNovel_number_votes() {
		return novel_number_votes;
	}
	public void setNovel_number_votes(BigInteger novel_number_votes) {
		this.novel_number_votes = novel_number_votes;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public String getType_str() {
		switch(getType_status()){
		  case 1: type_str="奇幻玄幻";break;
		  case 2: type_str="武侠仙侠";break;
		  case 3: type_str="都市言情";break;
		  case 4: type_str="历史穿越";break;
		  case 5: type_str="官场军事";break;
		  case 6: type_str="都市异能";break;
		  case 7: type_str="惊悚恐怖";break;
		  case 8: type_str="豪门总裁";break;
		  case 9: type_str="古代言情";break;
		  case 10: type_str="现代言情";break;
		  case 11: type_str="穿越重生";break;
		  case 12: type_str="耿美百合";break;
		  case 13: type_str="惊悚恐怖";break;
		  default : type_str="";break;
		}
		return type_str;
	}
	public void setType_str(String type_str) {
		this.type_str = type_str;
	}
	public String getSex_str() {
		if(getSex_status()==1){
			this.sex_str="女";
		}if(getSex_status()==0){
			this.sex_str="男";
		}
		return sex_str;
	}
	public String getNovel_str() {
		
		if(getNovel_state()==1){
			this.novel_str="连载中";
		}if(getNovel_state()==2){
			this.novel_str="已完成";
		}
		return novel_str;
	}
	public void setNovel_str(String novel_str) {
		this.novel_str = novel_str;
	}
	public void setSex_str(String sex_str) {
		this.sex_str = sex_str;
	}
	public String getNovel_name() {
		return novel_name;
	}
	public void setNovel_name(String novel_name) {
		this.novel_name = novel_name;
	}
	public String getNovel_imgurl() {
		return novel_imgurl;
	}
	public void setNovel_imgurl(String novel_imgurl) {
		this.novel_imgurl = novel_imgurl;
	}
	public String getNovel_brief() {
		return novel_brief;
	}
	public void setNovel_brief(String novel_brief) {
		this.novel_brief = novel_brief;
	}
	public String getNovel_author() {
		return novel_author;
	}
	public void setNovel_author(String novel_author) {
		this.novel_author = novel_author;
	}
	public int getSex_status() {
		return sex_status;
	}
	public void setSex_status(int sex_status) {
		this.sex_status = sex_status;
	}
	public int getType_status() {
		return type_status;
	}
	public void setType_status(int type_status) {
		this.type_status = type_status;
	}
	public int getNovel_state() {
		return novel_state;
	}
	public void setNovel_state(int novel_state) {
		this.novel_state = novel_state;
	}
	public String getNovel_new_chapter() {
		return novel_new_chapter;
	}
	public void setNovel_new_chapter(String novel_new_chapter) {
		this.novel_new_chapter = novel_new_chapter;
	}
	public Date getNovel_update_time() {
		return novel_update_time;
	}
	public void setNovel_update_time(Date novel_update_time) {
		this.novel_update_time = novel_update_time;
	}
	public String getNovel_page_url() {
		return novel_page_url;
	}
	public void setNovel_page_url(String novel_page_url) {
		this.novel_page_url = novel_page_url;
	}
	
	
}
