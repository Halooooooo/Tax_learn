package cn.halo.test.service;

import java.io.Serializable;

import cn.halo.test.entity.person;

public interface Iservice {
	public void say();
	public void save(person p);
	public person findPerson(Serializable id);
}
