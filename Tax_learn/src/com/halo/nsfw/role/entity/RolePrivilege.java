package com.halo.nsfw.role.entity;
/**
 * 
 * 角色权限表
 * @author donghao
 *
 */
public class RolePrivilege {
	private RolePrivilegeId id;

	public RolePrivilege() {
	}

	public RolePrivilege(RolePrivilegeId id) {
		this.id = id;
	}

	public RolePrivilegeId getId() {
		return id;
	}

	public void setId(RolePrivilegeId id) {
		this.id = id;
	}
	
	
}
