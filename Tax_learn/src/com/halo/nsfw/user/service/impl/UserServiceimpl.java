package com.halo.nsfw.user.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.halo.nsfw.core.service.BaseServiceImpl;
import com.halo.nsfw.core.utils.ExcelUtil;
import com.halo.nsfw.role.entity.Role;
import com.halo.nsfw.user.dao.UserDao;
import com.halo.nsfw.user.entity.User;
import com.halo.nsfw.user.entity.UserRole;
import com.halo.nsfw.user.entity.UserRoleId;
import com.halo.nsfw.user.service.UserService;
@Service("userService")
public class UserServiceimpl extends BaseServiceImpl<User> implements UserService {

	private UserDao userDao;
	
	@Resource
	public void setUserdao(UserDao userdao) {
		super.setBaseDao(userdao);
		this.userDao = userdao;
	}

	@Override
	public void delect(Serializable id) {
		userDao.delect(id);
		userDao.delectUserRoleByUserId(id);
	}

	@Override
	public void exportExcel(List<User> list, ServletOutputStream outputStream) {
		ExcelUtil.exportExcel(list, outputStream);
	}
	private FileInputStream stream;
	private Workbook wk;
	@Override
	public void importExcel(File userExcel, String userExcelFileName) {
		try {
			stream = new FileInputStream(userExcel);
			if(".xls".equals(userExcelFileName.substring(userExcelFileName.lastIndexOf("."))))
			{
				wk = new HSSFWorkbook(stream);
			}else
			{
				wk = new XSSFWorkbook(stream);
			}
			System.out.println(wk);
			Sheet sheet = wk.getSheetAt(0);
			if(sheet.getPhysicalNumberOfRows()>2)
			{
				User user = null;
				for(int i=2;i<sheet.getPhysicalNumberOfRows();i++)
				{
					Row row = sheet.getRow(i);
					user = new User();
					Cell yonghuming = row.getCell(0);
					if("".equals(yonghuming.getStringCellValue())||yonghuming.getStringCellValue()==null)
					{
						continue;
					}
					System.out.println(yonghuming.getStringCellValue()+"a");
					user.setName(yonghuming.getStringCellValue());
					Cell account = row.getCell(1);
					user.setAccount(account.getStringCellValue());
					Cell dept = row.getCell(2);
					user.setDept(dept.getStringCellValue());
					Cell gender = row.getCell(3);
					user.setGender(gender.getStringCellValue().equals("男"));
					String mobile = "";
					Cell phone = row.getCell(4);
					try {
						mobile = phone.getStringCellValue();
					} catch (Exception e) {
						double mobilephone = phone.getNumericCellValue();
						mobile = BigDecimal.valueOf(mobilephone).toString();
					}
					user.setMobile(mobile);
					Cell email = row.getCell(5);
					user.setEmail(email.getStringCellValue());
					Cell birth = row.getCell(6);
					if(birth!=null)
					{
						user.setBirthday(birth.getDateCellValue());
					}
					user.setPassword("123456");
					user.setState(user.USER_STATE_VALID);
					save(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			try {
				if(wk!=null)
				{
					wk.close();
				}
				if(stream!=null)
				{
					stream.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
	}

	@Override
	public List<User> findUserByAccountAndId(String id, String account) {
		
		return userDao.findUserByAccountAndId(id,account);
	}

	@Override
	public void saveUserAndRole(User user, String... roleIds) {
		save(user);
		
		if(roleIds!=null)
		{
			for(String roleId:roleIds)
			{
				userDao.saveUserRole(new UserRole(new UserRoleId(new Role(roleId),user.getId())));
			}
			
		}
	}
	@Override
	public void updateUserAndRole(User user, String... roleIds) {
		userDao.delectUserRoleByUserId(user.getId());
		
		update(user);
		
		if(roleIds!=null)
		{
			for(String roleId:roleIds)
			{
				userDao.saveUserRole(new UserRole(new UserRoleId(new Role(roleId),user.getId())));
			}
			
		}
	}

	@Override
	public List<UserRole> findUserRoleByUserId(String id) {
		return userDao.findUserRoleByUserId(id);
	}

	@Override
	public List<User> findUserByAccountAndPass(String account, String password) {
		
		return userDao.findUserByAccountAndPass(account,password);
	}


}
