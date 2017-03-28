package cn.halo.test.dao;

import java.io.Serializable;

import cn.halo.test.entity.person;

public interface testDao {
	public void save(person p);
	public person findPerson(Serializable id);
}
