package com.halo.login.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.halo.nsfw.core.constant.Constant;
import com.halo.nsfw.user.entity.User;
import com.halo.nsfw.user.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	@Resource
	private UserService userService;
	private User user;
	private String loginResult;
	public String toLoginUI(){
		return "loginUI";
	}
	
	public String login()
	{
		if(user.getAccount()=="admin"&&user.getPassword()=="admin"){
			return "home";
		}
		if(user!=null)
		{
			if(StringUtils.isNotBlank(user.getAccount())&&StringUtils.isNotBlank(user.getPassword()))
			{
				List<User> list = userService.findUserByAccountAndPass(user.getAccount(),user.getPassword());
				if(list!=null&&list.size()>0)
				{
					User user  = list.get(0);
					user.setUserRoles(userService.findUserRoleByUserId(user.getId()));
					ServletActionContext.getRequest().getSession().setAttribute(Constant.USER, user);
					Log log = LogFactory.getLog(getClass());
					log.info("用户名称为" +user.getName() +",账号为"+user.getAccount()+"登陆了账户");
					
					return "home";
				}else{
					setLoginResult("账号或者密码不正确");
				}
			}else
			{
				setLoginResult("账号和密码不能为空");
			}
		}else{
			setLoginResult("请输入账号和密码");
		}
		return toLoginUI();
	}
	public String toNoPermissionUI()
	{
		return "noPermissionUI";
	}
	
	public String logout() {
		ServletActionContext.getRequest().getSession().removeAttribute(Constant.USER);
		return toLoginUI();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}
	
	
}
