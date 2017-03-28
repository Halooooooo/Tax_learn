package com.halo.nsfw.core.exception;

public class ServiceException extends SysException {

	public ServiceException() {
		super("业务操作失败");
	}

	public ServiceException(String arg0) {
		super(arg0);
	}
	
	
}
