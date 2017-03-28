package com.halo.nsfw.complain.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.halo.nsfw.complain.dao.ComplainDao;
import com.halo.nsfw.complain.entity.Complain;
import com.halo.nsfw.complain.service.ComplainService;
import com.halo.nsfw.core.service.BaseServiceImpl;
import com.halo.nsfw.core.utils.QueryHelper;
@Service("complainService")
public class ComplainServiceImpl extends BaseServiceImpl<Complain> implements ComplainService {
	
	private ComplainDao complainDao;
	@Resource
	public void setComplainDao(ComplainDao complainDao) {
		super.setBaseDao(complainDao);
		this.complainDao = complainDao;
	}
	@Override
	public void AutoDeal() {
		QueryHelper queryHelper = new QueryHelper(Complain.class,"c");
		queryHelper.addWhereCondition("c.state=? ",Complain.COMPLAIN_STATE_UNDONE);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		queryHelper.addWhereCondition("c.compTime > ?", cal.getTime());
		System.out.println(cal.getTime().toString());
		List<Complain> list = findList(queryHelper);
		if(list!=null && list.size()>0){
			for(Complain comp:list){
				comp.setState(Complain.COMPLAIN_STATE_INVALID);
				save(comp);
			}
			
			
		}
	}
	@Override
	public List<Map> getAnnualStatisticDataByYear(int year) {
		List<Map> resList = new ArrayList<Map>();
		List<Object[]> list = complainDao.getAnnualStatisticDataByYear(year);
		if(list!=null){
			Calendar cal = Calendar.getInstance();
			int CurrentMonth = cal.get(Calendar.MONTH)+1;// 八月则输出7
			boolean isCurrentYear = (cal.get(Calendar.YEAR)==year);
			
			int tempMonth = 0;
			Map<String,Object> map =null;
			for (Object[] obj:list){
				map= new HashMap<String,Object>();
				tempMonth = Integer.valueOf(obj[0]+"");
				map.put("label", tempMonth+ " 月");
				if(isCurrentYear){
					if(tempMonth>CurrentMonth){ //未到月份
						map.put("value","");
					}else{ // 已过月份
						map.put("value", obj[1]==null?"0":obj[1]);
					}
				}else{ // not current year
					map.put("value", obj[1]==null?"0":obj[1]);
				}
				resList.add(map);
			}
		}
		return resList;
	}
	
}
