package com.novel.web.boss.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 权限表
 * @author lyx
 *
 */
@Entity
@Table(name="tbl_bms_per")
public class PermissionPO {
	@Id
	@GeneratedValue
	private Integer id; // 主键
	
	@Column
	private String perName;// 权限名称
	
	@Column
	private String perCode;// 权限编号
	
	@Column
	private String perUrl;// 资源路径
	
	@Column
	private Integer perUpperId;// 上级菜单ID
	
	@Column
	private Integer perLevel;// 菜单等级
	
	@Column
	private String image;// 图片
	
	@Column
	private Integer dataStatus;// 数据状态(0：未使用；1：使用。默认1)

	@Column
	private String remark;// 备注

	@Column
	private Integer createUserid;// 创建人ID

	@Column
	private Integer updateUserid;// 更新人ID

	@Column
	private Date createTime;// 创建时间

	@Column
	private Date updateTime;// 更新时间


	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getPerCode() {
		return perCode;
	}

	public void setPerCode(String perCode) {
		this.perCode = perCode;
	}

	public String getPerUrl() {
		return perUrl;
	}

	public void setPerUrl(String perUrl) {
		this.perUrl = perUrl;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPerUpperId() {
		return perUpperId;
	}

	public void setPerUpperId(Integer perUpperId) {
		this.perUpperId = perUpperId;
	}

	public Integer getPerLevel() {
		return perLevel;
	}

	public void setPerLevel(Integer perLevel) {
		this.perLevel = perLevel;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Integer getCreateUserid() {
		return createUserid;
	}

	public void setCreateUserid(Integer createUserid) {
		this.createUserid = createUserid;
	}

	public Integer getUpdateUserid() {
		return updateUserid;
	}

	public void setUpdateUserid(Integer updateUserid) {
		this.updateUserid = updateUserid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	

}
