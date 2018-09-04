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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 用户表
 * 
 * @author lyx
 *
 */
@Entity
@Table(name = "tbl_bms_user")
public class UserPO {
	@Id
	@GeneratedValue
	private Integer id; // 主键

	@Column
	private String userName;// 用户姓名

	@Column
	private String passWord;// 密码

	@Column
	private String phoneNum;// 电话号码

	@Column
	private String userIp; // IP

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

	@Column
	private Date loginTime;// 最后更新时间

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_bms_user_role", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = {
			@JoinColumn(name = "roleId") })
	private Set<RolePO> roleList;// 一个用户具有多个角色

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="userId")
	private List<UserRoleRelationPO> roleRelationList;// 角色关系表
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
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

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}


	public Set<RolePO> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<RolePO> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "UserPO [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", phoneNum=" + phoneNum
				+ ", userIp=" + userIp + ", dataStatus=" + dataStatus + ", remark=" + remark + ", dataStatus="
				+ dataStatus + ", createTime=" + createTime + ", createUserid=" + createUserid + ", loginTime="
				+ loginTime + ", updateTime=" + updateTime + ", updateUserid=" + updateUserid + "]";
	}
	
	public List<UserRoleRelationPO> getRoleRelationList() {
		return roleRelationList;
	}

	public void setRoleRelationList(List<UserRoleRelationPO> roleRelationList) {
		this.roleRelationList = roleRelationList;
	}

	@Transient
	public Set<String> getRolesName() {
		Set<RolePO> roles = getRoleList();
		Set<String> set = new HashSet<String>();
		if (roles != null && roles.size() > 0) {
			for (RolePO role : roles) {
				set.add(role.getRoleName());
			}
		}
		return set;
	}
}
