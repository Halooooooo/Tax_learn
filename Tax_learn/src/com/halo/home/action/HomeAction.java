package com.halo.home.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.struts2.ServletActionContext;

import com.halo.nsfw.complain.entity.Complain;
import com.halo.nsfw.complain.service.ComplainService;
import com.halo.nsfw.core.constant.Constant;
import com.halo.nsfw.core.utils.QueryHelper;
import com.halo.nsfw.info.entity.Info;
import com.halo.nsfw.info.service.InfoService;
import com.halo.nsfw.user.entity.User;
import com.halo.nsfw.user.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {
	@Resource
	private UserService userService;
	@Resource
	private ComplainService complainService;
	@Resource
	private InfoService infoService;
	private Complain comp;
	private Info info;
	
	@Override
	public String execute() throws Exception {
		//info
		ActionContext.getContext().getContextMap().put("infoTypeMap", info.INFO_TYPE_MAP);
		QueryHelper queryHelper1 = new QueryHelper(Info.class,"i");
		queryHelper1.addOrderCondition("i.createTime", QueryHelper.ORDER_BY_DESC);
		List<Info> infoList = infoService.getPageResult(queryHelper1, 1, 5).getItems();
		ActionContext.getContext().getContextMap().put("infoList", infoList);
		
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute(Constant.USER);
		//complain
		ActionContext.getContext().getContextMap().put("compTypeMap", comp.COMPLAIN_STATE_MAP);
		QueryHelper queryHelper2 = new QueryHelper(Complain.class,"c");
		queryHelper1.addWhereCondition("c.compName = ? ", user.getName());
		queryHelper1.addOrderCondition("c.createTime", QueryHelper.ORDER_BY_DESC);
		queryHelper1.addOrderCondition("c.state", QueryHelper.ORDER_BY_ASC);
		List<Info> compList = complainService.getPageResult(queryHelper2, 1, 6).getItems();
		ActionContext.getContext().getContextMap().put("compList", compList);
		
		return "home";
	}
	//xiangmu/nsfw/HomeAction/complainAddUI
	//tou su
	public String complainAddUI(){
		return "complainAddUI";
	}
	public void getUserJson()
	{
			
		String dept = ServletActionContext.getRequest().getParameter("dept");
			try {
				if(StringUtils.isNotBlank(dept)){
				QueryHelper queryHelper = new QueryHelper(User.class, "u");
				queryHelper.addWhereCondition(" u.dept like ? ", "%"+dept);
				
				List<User> userList = userService.findList(queryHelper);
				
				JSONObject json = new JSONObject();
				json.put("msg", "success");
				json.accumulate("userList", userList);
				
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write(json.toString().getBytes("utf-8"));
				outputStream.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	public void complainAdd()
	{
		if(comp!=null)
		{
			comp.setState(Complain.COMPLAIN_STATE_UNDONE);
			comp.setCompTime(new Timestamp(new Date().getTime()));
			complainService.save(comp);
			try{
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write("success".getBytes("utf-8"));
				outputStream.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
	
	public String infoViewUI(){
		ActionContext.getContext().getContextMap().put("infoTypeMap", info.INFO_TYPE_MAP);
		if(info!=null){
			info = infoService.findById(info.getInfoId());
		}
		return "infoViewUI";
	}
	public String complainViewUI(){
		ActionContext.getContext().getContextMap().put("compTypeMap", comp.COMPLAIN_STATE_MAP);
		if(comp!=null){
			comp = complainService.findById(comp.getCompId());
		}
		return "complainViewUI";
	}
	public Complain getComp() {
		return comp;
	}
	public void setComp(Complain comp) {
		this.comp = comp;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	
}
