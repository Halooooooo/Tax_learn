package cn.halo.test;

import javax.annotation.Resource;


import cn.halo.test.service.Iservice;

import com.opensymphony.xwork2.ActionSupport;

public class testaction extends ActionSupport {
	@Resource
	Iservice service;
	
	
	@Override
	public String execute() throws Exception {
		service.say();
		return SUCCESS;
	}
}
