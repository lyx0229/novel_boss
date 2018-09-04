package com.novel.web.boss.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 角色表
 * 
 * @author lyx
 *
 */
@Entity
@Table(name = "tbl_bms_role")
public class RolePO {
	@Id
	@GeneratedValue
	private Integer id; // 主键

	@Column
	private String roleName;// 角色名称

	@Column
	private Integer roleUpperId;// 上级领导角色ID

	@Column
	private String roleCode;// 角色编码

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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_bms_per_role", joinColumns = { @JoinColumn(name = "roleId") }, inverseJoinColumns = {
			@JoinColumn(name = "perId") })
	private Set<PermissionPO> perList;// 一个角色具有多个权限

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleUpperId() {
		return roleUpperId;
	}

	public void setRoleUpperId(Integer roleUpperId) {
		this.roleUpperId = roleUpperId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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

	public Set<PermissionPO> getPerList() {
		return perList;
	}

	public void setPerList(Set<PermissionPO> perList) {
		this.perList = perList;
	}

	@Override
	public String toString() {
		return "UserPO [id=" + id + ", roleName=" + roleName + ", roleCode=" + roleCode + ", roleUpperId=" + roleUpperId
				+ ", dataStatus=" + dataStatus + ", remark=" + remark + ", dataStatus=" + dataStatus + ", createTime="
				+ createTime + ", createUserid=" + createUserid + ", updateTime=" + updateTime + ", updateUserid="
				+ updateUserid + "]";
	}

	@Transient
	public Set<String> getMenusName() {
		Set<PermissionPO> menus = getPerList();
		Set<String> set = new HashSet<String>();
		if (menus != null) {
			for (PermissionPO menu : menus) {
				set.add(menu.getPerName());
			}
		}
		return set;
	}

}
