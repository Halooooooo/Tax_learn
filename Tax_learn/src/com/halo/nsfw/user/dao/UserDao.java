package com.halo.nsfw.user.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.halo.nsfw.core.dao.impl.baseDaoimpl;
import com.halo.nsfw.user.entity.User;
import com.halo.nsfw.user.entity.UserRole;
import com.mysql.jdbc.StringUtils;

public class UserDao extends baseDaoimpl<User> {
	public List<User> findUserByAccountAndId(String id, String account) {
		String hql ="From User where account = ?";
		if(!StringUtils.isNullOrEmpty(id))
		{
			hql += " and id != ?";
		}
		Query query = getSession().createQuery(hql);
		query.setParameter(0, account);
		if(!StringUtils.isNullOrEmpty(id))
		{
			query.setParameter(1, id);
		}
		
		return query.list();
	}

	public void saveUserRole(UserRole userRole) {
		getHibernateTemplate().save(userRole);
	}

	public void delectUserRoleByUserId(Serializable id) {
		Query query = getSession().createQuery("delete from UserRole where id.userId = ?");
		query.setParameter(0, id);
		query.executeUpdate();
	}

	public List<UserRole> findUserRoleByUserId(Serializable id) {
		Query query = getSession().createQuery("from UserRole where id.userId = ?");
		query.setParameter(0, id);
		return query.list();
	}

	public List<User> findUserByAccountAndPass(String account, String password) {
		Query query = getSession().createQuery("from User where account = ? and password = ?");
		query.setParameter(0, account);
		query.setParameter(1, password);
		return query.list();	}
	
}
