package com.halo.nsfw.role.dao;

import org.hibernate.Query;

import com.halo.nsfw.core.dao.impl.baseDaoimpl;
import com.halo.nsfw.role.entity.Role;

public class RoleDao extends baseDaoimpl<Role> {

	public void delectRolePrivilegeByRoleId(String roleId) {
		Query query = getSession().createQuery("delete from RolePrivilege where id.role.roleId = ?");
		query.setParameter(0, roleId);
		query.executeUpdate();
	}

}
