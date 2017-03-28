package com.halo.nsfw.info.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.halo.nsfw.core.action.BaseAction;
import com.halo.nsfw.core.page.PageResult;
import com.halo.nsfw.core.utils.QueryHelper;
import com.halo.nsfw.info.entity.Info;
import com.halo.nsfw.info.service.InfoService;
import com.opensymphony.xwork2.ActionContext;

public class InfoAction extends BaseAction {
	@Resource
	private InfoService infoService;
	private Info info;
	private String[] privilegeIds;
	private String strTitle;
	
	//列表显示
	public String listUI()
	{
		try {
			ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
			QueryHelper qh = new QueryHelper(Info.class, "i");
			if(info != null){
				if(StringUtils.isNotBlank(info.getTitle())){
					info.setTitle(URLDecoder.decode(info.getTitle(), "utf-8"));
					qh.addWhereCondition("i.title like ? ", "%"+info.getTitle()+"%");
				}
			}
			qh.addOrderCondition("i.createTime", QueryHelper.ORDER_BY_DESC);
			pageResult = infoService.getPageResult(qh,getPageNo(),getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listUI";
	}
	
	//跳转新增页面
	public String addUI()
	{
		ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
		info=new Info();
		info.setCreateTime(new Timestamp(new Date().getTime()));
		return "addUI";
	}
	//保存新增
	public String add()
	{
		try {
			if(info!=null)
			{
				infoService.save(info);
			}
			info=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	//跳转更新页面
	public String editUI()
	{
		ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
		if(info!=null&&info.getInfoId()!=null)
		{
			strTitle=info.getTitle();
			info = infoService.findById(info.getInfoId());
		}
		return "editUI";
	}
	//保存更新
	public String edit()
	{
		try {
			if(info!=null)
			{
				infoService.update(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	//删除
	public String delete()
	{
		strTitle=info.getTitle();
		if(info.getInfoId()!=null)
		{
			infoService.delect(info.getInfoId());
		}
		return "list";
	}
	//批量删除
	public String deleteSelected()
	{
		strTitle=info.getTitle();
		if(selectedRow!=null)
		{
			for(String id:selectedRow)
			{
				infoService.delect(id);
			}
		}
		return "list";
	}
	public void publicInfo()
	{
		try {
			if(info!=null)
			{
				Info tem = infoService.findById(info.getInfoId());
				tem.setState(info.getState());
				infoService.update(tem);
				
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write("更新状态成功".getBytes("utf-8"));
				outputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public InfoService getInfoService() {
		return infoService;
	}

	public void setInfoService(InfoService infoService) {
		this.infoService = infoService;
	}

	public String[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(String[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}

	public String getStrTitle() {
		return strTitle;
	}


	
}
