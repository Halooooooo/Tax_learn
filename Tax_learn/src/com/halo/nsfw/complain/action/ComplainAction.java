package com.halo.nsfw.complain.action;

import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.ServletActionContext;

import com.halo.nsfw.complain.entity.Complain;
import com.halo.nsfw.complain.entity.ComplainReply;
import com.halo.nsfw.complain.service.ComplainService;
import com.halo.nsfw.core.action.BaseAction;
import com.halo.nsfw.core.utils.QueryHelper;
import com.opensymphony.xwork2.ActionContext;

public class ComplainAction extends BaseAction {
	@Resource
	private ComplainService complainService;
	private Complain complain;
	private String startTime;
	private String endTime;
	private ComplainReply reply;
	private Map<String,Object> statisticMap;
	public String listUI(){
		try {
			ActionContext.getContext().getContextMap().put("complainStateMap", Complain.COMPLAIN_STATE_MAP);
			QueryHelper queryHelper = new QueryHelper(Complain.class, "c");
			if(StringUtils.isNotBlank(startTime)){
				startTime = URLDecoder.decode(startTime, "utf-8");
				queryHelper.addWhereCondition("c.compTime >= ?",DateUtils.parseDate(startTime,"yyyy-MM-dd HH:mm"));
			}
			if(StringUtils.isNotBlank(endTime)){
				startTime = URLDecoder.decode(endTime, "utf-8");
				queryHelper.addWhereCondition("c.compTime <= ?",DateUtils.parseDate(endTime,"yyyy-MM-dd HH:mm"));
			}
			if(complain != null){
				if(StringUtils.isNotBlank(complain.getState())){
					queryHelper.addWhereCondition("c.state=?", complain.getState());
				}
				if(StringUtils.isNotBlank(complain.getCompTitle())){
					complain.setCompTitle(URLDecoder.decode(complain.getCompTitle(), "utf-8"));
					queryHelper.addWhereCondition("c.compTitle like ?", "%"+complain.getCompTitle()+"%");
				}
			}
			queryHelper.addOrderCondition("c.state", QueryHelper.ORDER_BY_ASC);
			queryHelper.addOrderCondition("c.compTime", QueryHelper.ORDER_BY_ASC);
			pageResult = complainService.getPageResult(queryHelper, getPageNo(), getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listUI";
	}
	public String dealUI(){
		ActionContext.getContext().getContextMap().put("complainStateMap", Complain.COMPLAIN_STATE_MAP);
		if(complain!=null){
			complain = complainService.findById(complain.getCompId());
		}
		return "dealUI";
	}
	
	public String deal()
	{
		if(complain!=null){
			Complain tmp = complainService.findById(complain.getCompId());
			if(!Complain.COMPLAIN_STATE_DONE.equals(complain.getState())){
				tmp.setState(Complain.COMPLAIN_STATE_DONE);//设置状态为已经受理
			}
			if(reply!=null){
				reply.setComplain(tmp);
				reply.setReplyTime(new Timestamp(new Date().getTime()));
				tmp.getComplainReplies().add(reply); //级联操作
			}
			complainService.update(tmp);
		}
		return "list";
	}
	public String annualStatisticChartUI()
	{
		return "annualStatisticChartUI";
	}
	
	public String getAnnualStatisticData(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int year = 0;
		if(request.getParameter("year")!=null){
			year = Integer.valueOf(request.getParameter("year"));
		}else{
			year = Calendar.getInstance().get(Calendar.YEAR);
		}
		statisticMap = new HashMap<String,Object>();
		statisticMap.put("msg", "success");
		statisticMap.put("chartData", complainService.getAnnualStatisticDataByYear(year));
		return "annualStatisticData";
	}
	public Complain getComplain() {
		return complain;
	}
	public void setComplain(Complain complain) {
		this.complain = complain;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public ComplainReply getReply() {
		return reply;
	}
	public void setReply(ComplainReply reply) {
		this.reply = reply;
	}
	public Map<String, Object> getStatisticMap() {
		return statisticMap;
	}
	public void setStatisticMap(Map<String, Object> statisticMap) {
		this.statisticMap = statisticMap;
	}
	
}
