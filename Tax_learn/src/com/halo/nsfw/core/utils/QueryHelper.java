package com.halo.nsfw.core.utils;

import java.util.ArrayList;
import java.util.List;

public class QueryHelper {
	private String fromClause = "";
	private String whereClause = "";
	private String orderByClause = "";
	private String parm = "";
	private List<Object> parameters;
	public static String ORDER_BY_DESC="desc";//降序
	public static String ORDER_BY_ASC="asc";//升序
	/**
	 * 设置form子句
	 * @param clazz 得到类名
	 * @param parm	得到类名简称标示
	 */
	public QueryHelper(Class clazz,String parm){
		fromClause="from "+ clazz.getSimpleName()+" "+parm+" ";
		this.parm=parm;
	}
	/**
	 * 
	 * @param condition where 语句条件如 : i.title like ?
	 * @param parameter 参数 如 : %title%
	 */
	public void addWhereCondition(String condition,Object... parameter){
		if(whereClause.length()>1){
			whereClause+="and "+ condition +" ";
		}else{
			whereClause="where "+condition +" ";
		}
		if(parameters==null){
			parameters = new ArrayList<Object>();
		}
		if(parameter!=null){
			for(Object param:parameter){
				parameters.add(param);
			}
		}
	}
	/**
	 * 配置order by 子句
	 * @param condition 如 i.title 
	 * @param order static 属性
	 */
	public void addOrderCondition(String condition,String order){
		if(orderByClause.length()>2){
			orderByClause+=","+condition +" "+order; // order by title desc , name asc 对
		}else{
			orderByClause+="order by "+condition+ " "+order;
		}
	}
	public String getQueryListHql()
	{
		return fromClause+whereClause+orderByClause;
	}
	
	public List<Object> getParameters()
	{
		return parameters;
	}
	public String gettotalCountListHql() {
		return "select count(*) " + fromClause+whereClause;
	}
}
