package com.halo.nsfw.user.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import com.halo.nsfw.core.action.BaseAction;
import com.halo.nsfw.core.page.PageResult;
import com.halo.nsfw.core.utils.QueryHelper;
import com.halo.nsfw.role.service.RoleService;
import com.halo.nsfw.user.entity.User;
import com.halo.nsfw.user.entity.UserRole;
import com.halo.nsfw.user.service.UserService;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends BaseAction {
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	private User user;
	private File headImg;
	private String headImgFileName;
	private String headImgContentType;
	private File userExcel;
	private String userExcelFileName;
	private String userExcelContentType;
	private String[] userRoleIds;
	private String strName;
	
	//列表显示
	public String listUI()
	{
		try {
			QueryHelper queryHelper = new QueryHelper(User.class, "u");
			if(user!=null){
				if(StringUtils.isNotBlank(user.getName()))
				{
					user.setName(URLDecoder.decode(user.getName(),"utf-8"));
					queryHelper.addWhereCondition(" u.name like ? ", "%"+user.getName()+"%");
				}
			}
			pageResult = userService.getPageResult(queryHelper, getPageNo(), getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listUI";
	}
	
	//跳转新增页面
	public String addUI()
	{
		ActionContext.getContext().getContextMap().put("roleList", roleService.findList());
		return "addUI";
	}
	//保存新增
	public String add()
	{
		try {
			if(user!=null)
			{
				if(headImg !=null)
				{
					String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
					String fileName = UUID.randomUUID().toString()+ headImgFileName.substring(headImgFileName.lastIndexOf("."));
					FileUtil.copyFile(headImg, new File(filePath,fileName));
					user.setHeadImg("user/"+fileName);
				}
				userService.saveUserAndRole(user,userRoleIds);
				user=null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "list";
	}
	//跳转更新页面
	public String editUI()
	{
		if(user!=null&&user.getId()!=null)
		{
			strName=user.getName();
			user = userService.findById(user.getId());
			List<UserRole> list = userService.findUserRoleByUserId(user.getId());
			if(list!=null && list.size()>0)
			{
				userRoleIds= new String[list.size()];
				for(int i=0;i<list.size();i++)
				{
					userRoleIds[i] = list.get(i).getId().getRole().getRoleId();
				}
			}
		}
		ActionContext.getContext().getContextMap().put("roleList", roleService.findList());
		return "editUI";
	}
	//保存更新
	public String edit()
	{
		try {
			if(user!=null)
			{
				if(headImg !=null)
				{
					String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
					String fileName = UUID.randomUUID().toString()+ headImgFileName.substring(headImgFileName.lastIndexOf("."));
					FileUtil.copyFile(headImg, new File(filePath,fileName));
					user.setHeadImg("user/"+fileName);
				}
				userService.updateUserAndRole(user,userRoleIds);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "list";
	}
	//删除
	public String delect()
	{
		strName=user.getName();
		if(user.getId()!=null)
		{
			userService.delect(user.getId());
		}
		return "list";
	}
	//批量删除
	public String delectselected()
	{
		strName=user.getName();
		if(selectedRow!=null)
		{
			for(String id:selectedRow)
			{
				userService.delect(id);
			}
		}
		return "list";
	}
	//导出Excel
	public void exportExcel()
	{
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/x-excel");
			response.setHeader("Content-Disposition","attachment;filename="+new String("用户列表.xlsx".getBytes(),"ISO-8859-1"));
			ServletOutputStream outputStream = response.getOutputStream();
			userService.exportExcel(userService.findList(),outputStream);
			if(outputStream!=null)
			{
				outputStream.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//导入userExcel
	public String importExcel()
	{
		if(userExcel!=null)
		{
			String isExcel = userExcelFileName.substring(userExcelFileName.lastIndexOf("."));
			if(".xls".equals(isExcel)||".xlsx".equals(isExcel))
			{
				userService.importExcel(userExcel,userExcelFileName);
			}
		}
		return "list";
	}
	//验证账号唯一性
	public void verifyaccount()
	{
		if(user!=null&&StringUtils.isNotBlank(user.getAccount()))
		{
			List<User> Accountlist = userService.findUserByAccountAndId(user.getId(),user.getAccount());
			String strResult = "true";
			if(Accountlist!=null&&Accountlist.size()>0)
			{
				strResult="false";
			}
			try {
				String s = new String(strResult.getBytes(),"ISO-8859-1");//字符转码十分重要 否则导致ajax得不到数据
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html");
				ServletOutputStream stream = response.getOutputStream();
				stream.write(s.getBytes());
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public File getUserExcel() {
		return userExcel;
	}

	public void setUserExcel(File userExcel) {
		this.userExcel = userExcel;
	}

	public String getUserExcelFileName() {
		return userExcelFileName;
	}

	public void setUserExcelFileName(String userExcelFileName) {
		this.userExcelFileName = userExcelFileName;
	}

	public String getUserExcelContentType() {
		return userExcelContentType;
	}

	public void setUserExcelContentType(String userExcelContentType) {
		this.userExcelContentType = userExcelContentType;
	}

	public File getHeadImg() {
		return headImg;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

	public String getHeadImgFileName() {
		return headImgFileName;
	}

	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}

	public String getHeadImgContentType() {
		return headImgContentType;
	}

	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public String[] getUserRoleIds() {
		return userRoleIds;
	}

	public void setUserRoleIds(String[] userRoleIds) {
		this.userRoleIds = userRoleIds;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

}
