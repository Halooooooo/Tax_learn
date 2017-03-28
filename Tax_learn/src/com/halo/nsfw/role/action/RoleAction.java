package com.halo.nsfw.role.action;

import java.net.URLDecoder;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.halo.nsfw.core.action.BaseAction;
import com.halo.nsfw.core.constant.Constant;
import com.halo.nsfw.core.utils.QueryHelper;
import com.halo.nsfw.info.entity.Info;
import com.halo.nsfw.role.entity.Role;
import com.halo.nsfw.role.entity.RolePrivilege;
import com.halo.nsfw.role.entity.RolePrivilegeId;
import com.halo.nsfw.role.service.RoleService;
import com.opensymphony.xwork2.ActionContext;

public class RoleAction extends BaseAction{
	@Resource
	private RoleService roleService;
	private Role role;
	private String[] privilegeIds;
	private String strName;
	//列表显示
	public String listUI()
	{
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		try {
			ActionContext.getContext().getContextMap().put("infoTypeMap", Info.INFO_TYPE_MAP);
			QueryHelper qh = new QueryHelper(Role.class, "r");
			if(role != null){
				if(StringUtils.isNotBlank(role.getName())){
					role.setName(URLDecoder.decode(role.getName(), "utf-8"));
					qh.addWhereCondition("r.name like ? ", "%"+role.getName()+"%");
				}
			}
			pageResult = roleService.getPageResult(qh,getPageNo(),getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listUI";
	}
	
	//跳转新增页面
	public String addUI()
	{
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		return "addUI";
	}
	//保存新增
	public String add()
	{
		try {
			if(role!=null)
			{
				if(privilegeIds!=null)
				{
					HashSet<RolePrivilege> set = new HashSet<RolePrivilege>();
					for(int i = 0;i<privilegeIds.length;i++)
					{
						set.add(new RolePrivilege(new RolePrivilegeId(role, privilegeIds[i])));
					}
					role.setRolePrivilege(set);
				}
				roleService.save(role);
				role=null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	//跳转更新页面
	public String editUI()
	{
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		if(role!=null&&role.getRoleId()!=null)
		{
			strName = role.getName();
			role = roleService.findById(role.getRoleId());
			if(role.getRolePrivilege()!=null)
			{
				privilegeIds = new String[role.getRolePrivilege().size()];
				int i=0;
				for(RolePrivilege rp:role.getRolePrivilege())
				{
					privilegeIds[i++]=rp.getId().getCode();
				}
			}
		}
		return "editUI";
	}
	//保存更新
	public String edit()
	{
		try {
			if(role!=null)
			{
				if(privilegeIds!=null)
				{
					HashSet<RolePrivilege> set = new HashSet<RolePrivilege>();
					for(int i = 0;i<privilegeIds.length;i++)
					{
						set.add(new RolePrivilege(new RolePrivilegeId(role, privilegeIds[i])));
					}
					role.setRolePrivilege(set);
				}
				roleService.update(role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	//删除
	public String delete()
	{
		strName = role.getName();
		if(role.getRoleId()!=null)
		{
			roleService.delect(role.getRoleId());
		}
		return "list";
	}
	//批量删除
	public String deleteselected()
	{
		strName = role.getName();
		if(selectedRow!=null)
		{
			for(String id:selectedRow)
			{
				roleService.delect(id);
			}
		}
		return "list";
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public String[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(String[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

}
