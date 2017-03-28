package com.halo.nsfw.complain.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;

import com.halo.nsfw.complain.dao.ComplainDao;
import com.halo.nsfw.complain.entity.Complain;
import com.halo.nsfw.core.dao.impl.baseDaoimpl;

public class ComplainDaoImpl extends baseDaoimpl<Complain> implements ComplainDao {

	@Override
	public List<Object[]> getAnnualStatisticDataByYear(int year) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT month,c2 ")
		.append(" FROM imonth LEFT JOIN")
		.append(" (SELECT MONTH(comp_time) c1, COUNT(comp_id) c2 ")
		.append(" FROM complain WHERE YEAR(comp_time)=? GROUP BY MONTH(comp_time)) t")
		.append(" ON month = t.c1 ORDER BY month");
		SQLQuery sqlQuery = getSession().createSQLQuery(sb.toString());
		sqlQuery.setParameter(0, year);
		return sqlQuery.list();
	}

}
