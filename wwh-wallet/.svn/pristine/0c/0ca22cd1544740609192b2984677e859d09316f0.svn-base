package com.wwh.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName: RoleVO
 * @Description: 角色VO
 * @author: ranletian
 * @date: 2016年10月26日 下午8:07:54
 */
public class RoleVO implements Serializable {

	private static final long serialVersionUID = 7800279797490834066L;

	/**
	 * 主键ID
	 */
	private String roleID;

	/**
	 * 角色名称
	 */
	private String roleName;
	

	public List<PrivilegeVO> getPrivilegeVO() {
		return privilegeVO;
	}

	public void setPrivilegeVO(List<PrivilegeVO> privilegeVO) {
		this.privilegeVO = privilegeVO;
	}

	/**
	 * 角色描述
	 */
	private String roleDescription;

	/**
	 * 一个角色对应多个权限
	 */
	private List<PrivilegeVO> privilegeVO;

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public List<PrivilegeVO> getPermissionList() {
		return privilegeVO;
	}

	public void setPermissionList(List<PrivilegeVO> permissionList) {
		this.privilegeVO = permissionList;
	}
}
