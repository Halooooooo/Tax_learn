package com.halo.nsfw.role.service.impl;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.springframework.stereotype.Service;

import com.halo.nsfw.core.service.BaseServiceImpl;
import com.halo.nsfw.role.dao.RoleDao;
import com.halo.nsfw.role.entity.Role;
import com.halo.nsfw.role.service.RoleService;
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
	
	private RoleDao roleDao;
	
	@Resource
	public void setRoleDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
		this.roleDao = roleDao;
	}


	@Override
	public void update(Role role) {
		//删除权限 否则在更新权限的时候因为update 特性，原有的存在的数据将不会删除 只会增加新的数据
		roleDao.delectRolePrivilegeByRoleId(role.getRoleId());
		roleDao.update(role);
	}



}
