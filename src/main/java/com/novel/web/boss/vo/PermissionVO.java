package com.novel.web.boss.vo;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class PermissionVO {
	private BigInteger id; // 主键

	private String perName;// 权限名称

	private String perCode;// 权限编号

	private String perUrl;// 资源路径

	private BigInteger perUpperId;// 上级菜单ID

	private BigInteger perLevel;// 菜单等级

	private String image;// 图片

	private Integer dataStatus;// 数据状态(0：未使用；1：使用。默认1)

	private String remark;// 备注

	private BigInteger createUserid;// 创建人ID

	private BigInteger updateUserid;// 更新人ID

	private Date createTime;// 创建时间

	private Date updateTime;// 更新时间

	private List<PermissionVO> perList;

	public List<PermissionVO> getPerList() {
		return perList;
	}

	public void setPerList(List<PermissionVO> perList) {
		this.perList = perList;
	}

	public BigInteger getId() {
		return id;
	}

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

	public BigInteger getPerUpperId() {
		return perUpperId;
	}

	public void setPerUpperId(BigInteger perUpperId) {
		this.perUpperId = perUpperId;
	}

	public BigInteger getPerLevel() {
		return perLevel;
	}

	public void setPerLevel(BigInteger perLevel) {
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

	public BigInteger getCreateUserid() {
		return createUserid;
	}

	public void setCreateUserid(BigInteger createUserid) {
		this.createUserid = createUserid;
	}

	public BigInteger getUpdateUserid() {
		return updateUserid;
	}

	public void setUpdateUserid(BigInteger updateUserid) {
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

	public void setId(BigInteger id) {
		this.id = id;
	}

}
