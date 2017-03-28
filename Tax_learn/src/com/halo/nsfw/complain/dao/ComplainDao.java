package com.halo.nsfw.complain.dao;

import java.util.List;

import com.halo.nsfw.complain.entity.Complain;
import com.halo.nsfw.core.dao.baseDao;

public interface ComplainDao extends baseDao<Complain> {

	List<Object[]> getAnnualStatisticDataByYear(int year);

}
