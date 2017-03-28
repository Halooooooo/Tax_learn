package cn.halo.test.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.halo.test.dao.testDao;
import cn.halo.test.entity.person;

@Service("service")
public class Serviceimpl implements Iservice {
	@Resource
	testDao testDao;
	@Override
	public void say() {
		System.out.println("service say hi.");
	}

	@Override
	public void save(person p) {
		
		testDao.save(p);
		int i=1/0;
	}

	@Override
	public person findPerson(Serializable id) {
		return testDao.findPerson(id);
	}

}
