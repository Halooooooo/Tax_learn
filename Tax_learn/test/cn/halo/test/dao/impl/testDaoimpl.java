package cn.halo.test.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.halo.test.dao.testDao;
import cn.halo.test.entity.person;

public class testDaoimpl extends HibernateDaoSupport implements testDao{

	@Resource
	SessionFactory sessionFactory;
	@Override
	public void save(person p) {
		getHibernateTemplate().save(p);
	}

	@Override
	public person findPerson(Serializable id) {
		
		return getHibernateTemplate().get(person.class, id);
	}

}
