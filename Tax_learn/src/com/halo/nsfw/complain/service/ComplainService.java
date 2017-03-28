package com.halo.nsfw.complain.service;

import java.util.List;
import java.util.Map;

import com.halo.nsfw.complain.entity.Complain;
import com.halo.nsfw.core.service.BaseService;

public interface ComplainService extends BaseService<Complain> {
	public void AutoDeal();
	public List<Map> getAnnualStatisticDataByYear(int year);
}
