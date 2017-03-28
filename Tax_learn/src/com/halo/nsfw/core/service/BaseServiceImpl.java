package com.halo.nsfw.core.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletOutputStream;

import com.halo.nsfw.core.dao.baseDao;
import com.halo.nsfw.core.page.PageResult;
import com.halo.nsfw.core.utils.QueryHelper;
import com.halo.nsfw.info.entity.Info;
import com.halo.nsfw.user.entity.User;
import com.halo.nsfw.user.entity.UserRole;
import com.halo.nsfw.user.service.UserService;

public class BaseServiceImpl<T> implements BaseService<T> {
	
	private baseDao<T> baseDao;
	
	public void setBaseDao(baseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void save(T t) {
		baseDao.save(t);
	}

	@Override
	public T findById(Serializable id) {
		return baseDao.findById(id);
	}

	@Override
	public void delect(Serializable id) {
		baseDao.delect(id);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public List<T> findList() {
		return baseDao.findList();
	}
	public List<T> findList(String hql,List<Object> parameters){
		return baseDao.findList(hql, parameters);
	}
	public List<T> findList(QueryHelper queryHelper){
		return baseDao.findList(queryHelper);
	}

	@Override
	public PageResult getPageResult(QueryHelper qh, int pageNo, int pageSize) {
		return baseDao.getPageResult(qh,pageNo,pageSize);
	}

}
