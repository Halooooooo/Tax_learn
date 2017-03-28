package com.halo.nsfw.core.constant;

import java.util.HashMap;
import java.util.Map;
	//五大系统 定义名称 防止以后改变名称过多操作
public final  class  Constant {
	//系统中用户在session中的标示符
	public static String USER = "SYS_USER";
	
	private static String PRIVILEGE_XZGL = "xzgl";
	private static String PRIVILEGE_HQFW = "hqfw";
	private static String PRIVILEGE_ZXXX = "zxxx";
	private static String PRIVILEGE_NSFW = "nsfw";
	private static String PRIVILEGE_SPACE = "spaces";
	
	public static Map<String,String> PRIVILEGE_MAP;
	
	static{
		PRIVILEGE_MAP = new HashMap<String, String>();
		PRIVILEGE_MAP.put(PRIVILEGE_XZGL, "行政管理");
		PRIVILEGE_MAP.put(PRIVILEGE_HQFW, "后勤服务");
		PRIVILEGE_MAP.put(PRIVILEGE_ZXXX, "在线学习");
		PRIVILEGE_MAP.put(PRIVILEGE_NSFW, "纳税服务");
		PRIVILEGE_MAP.put(PRIVILEGE_SPACE, "我的空间");
	}
}
