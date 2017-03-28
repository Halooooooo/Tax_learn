package com.halo.nsfw.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.halo.nsfw.core.dao.baseDao;
import com.halo.nsfw.core.page.PageResult;
import com.halo.nsfw.core.utils.QueryHelper;

public abstract class baseDaoimpl<T> extends HibernateDaoSupport implements baseDao<T> {

	Class<T> clazz;
	
	public baseDaoimpl(){
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	
	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	@Override
	public T findById(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public void delect(Serializable id) {
		getHibernateTemplate().delete(findById(id));
	}

	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public List<T> findList() {
		List<T> list = getSession().createQuery("from "+clazz.getSimpleName()).list();
		return list;
	}
	public List<T> findList(String hql,List<Object> parameters){
		Query query = getSession().createQuery(hql);
		for(int i = 0;i<parameters.size();i++)
		{
			query.setParameter(i, parameters.get(i));
		}
		return query.list();
	}

	@Override
	public List<T> findList(QueryHelper queryHelper) {
		Query query = getSession().createQuery(queryHelper.getQueryListHql());
		List<Object> parameters = queryHelper.getParameters();
		if(parameters!=null){
			for(int i = 0;i<parameters.size();i++)
			{
				query.setParameter(i, parameters.get(i));
			}
		}
		return query.list();
	}

	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize){
		Query query = getSession().createQuery(queryHelper.getQueryListHql());
		List<Object> parameters = queryHelper.getParameters();
		if(parameters!=null){
			for(int i = 0;i<parameters.size();i++)
			{
				query.setParameter(i, parameters.get(i));
			}
		}
		if(pageNo<1) pageNo=1;
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		List items = query.list();
		
		
		Query querytotalCount = getSession().createQuery(queryHelper.gettotalCountListHql());
		if(parameters!=null){
			for(int i = 0;i<parameters.size();i++)
			{
				querytotalCount.setParameter(i, parameters.get(i));
			}
		}
		long totalCount = (Long) querytotalCount.uniqueResult();
		return new PageResult(totalCount, pageNo, pageSize, items);
	}

}
