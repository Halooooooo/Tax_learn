package com.halo.nsfw.info.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.halo.nsfw.core.service.BaseServiceImpl;
import com.halo.nsfw.info.dao.InfoDao;
import com.halo.nsfw.info.entity.Info;
import com.halo.nsfw.info.service.InfoService;
@Service("infoService")
public class InfoServiceImpl extends BaseServiceImpl<Info> implements InfoService {
	
	private InfoDao infoDao;
	
	@Resource
	public void setInfoDao(InfoDao infoDao) {
		super.setBaseDao(infoDao);
		this.infoDao = infoDao;
	}


}
