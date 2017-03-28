package com.halo.nsfw.core.exception;

public abstract class SysException extends Exception {
	private String message;
	public SysException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SysException(String message, Throwable casue) {
		super(message, casue);
		this.message=message;
	}

	public SysException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SysException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
