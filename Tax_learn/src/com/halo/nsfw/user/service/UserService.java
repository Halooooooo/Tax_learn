package com.halo.nsfw.user.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletOutputStream;

import com.halo.nsfw.core.service.BaseService;
import com.halo.nsfw.user.entity.User;
import com.halo.nsfw.user.entity.UserRole;

public interface UserService extends BaseService<User>{
	
	public void exportExcel(List<User> list, ServletOutputStream outputStream);
	public void importExcel(File userExcel, String userExcelFileName);
	public List<User> findUserByAccountAndId(String id, String account);
	public void updateUserAndRole(User user, String... roleIds);
	public void saveUserAndRole(User user, String... roleIds);
	//根据用户id查找userrole 回显使用
	public List<UserRole> findUserRoleByUserId(String id);
	public List<User> findUserByAccountAndPass(String account, String password);
}
