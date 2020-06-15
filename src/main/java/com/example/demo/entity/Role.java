package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="role")
public class Role {
	private static final Logger LOGGER=LoggerFactory.getLogger(Role.class);
	@Id
	@Column(name="ro_id")
	private int roleId;
	
	@Column(name="ro_name")
	private String roleName;
	
	@ManyToMany(mappedBy="rolesList",fetch=FetchType.EAGER)
	private Set<User> userList;
	
	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	public Role() {
		super();
		LOGGER.debug("Role Default Constructor");
	}
	public Role(int roleId, String roleName, Set<User> userList) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.userList = userList;
		LOGGER.debug("Role Parameterized Constructor");
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<User> getUserList() {
		return userList;
	}
	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}
	
}
