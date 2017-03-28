package com.halo.nsfw.core.permission.impl;

import java.util.List;

import javax.annotation.Resource;

import com.halo.nsfw.core.permission.PermissionCheck;
import com.halo.nsfw.role.entity.Role;
import com.halo.nsfw.role.entity.RolePrivilege;
import com.halo.nsfw.user.entity.User;
import com.halo.nsfw.user.entity.UserRole;
import com.halo.nsfw.user.service.UserService;

public class PermissionCheckImpl implements PermissionCheck {
	@Resource
	UserService userService;
	@Override
	public boolean isAccessible(User user, String code) {
		List<UserRole> list = user.getUserRoles();
		if(list==null){
			userService.findUserRoleByUserId(user.getId());
		}
		if(list!=null&&list.size()>0)
		{
			for(UserRole ur:list)
			{
				Role role = ur.getId().getRole();
				for(RolePrivilege rp : role.getRolePrivilege())
				{
					if(code.equals(rp.getId().getCode()))
						return true;
				}
			}
		}
		return false;
	}

}
