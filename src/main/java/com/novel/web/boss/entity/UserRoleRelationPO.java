package com.novel.web.boss.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户角色关联表
 * @author lyx
 *
 */
@Entity
@Table(name="tbl_bms_user_role")
public class UserRoleRelationPO {
	@Id
	@GeneratedValue
	private Integer id; // 主键
	
	@Column
	private Integer roleId;// 角色id
	
	@Column
	private Integer userId;// 用户Id
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
