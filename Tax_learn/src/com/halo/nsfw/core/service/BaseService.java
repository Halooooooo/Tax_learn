package com.halo.nsfw.core.service;

import java.io.Serializable;
import java.util.List;

import com.halo.nsfw.core.page.PageResult;
import com.halo.nsfw.core.utils.QueryHelper;

public interface BaseService<T> {
	public void save(T t);
	public T findById(Serializable id);
	public void delect(Serializable id);
	public void update(T t);
	public List<T> findList();
	public List<T> findList(String hql,List<Object> parameters);
	public List<T> findList(QueryHelper queryHelper);
	public PageResult getPageResult(QueryHelper qh, int pageNo, int pageSize);

}
