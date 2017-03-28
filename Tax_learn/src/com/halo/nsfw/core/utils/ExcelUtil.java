package com.halo.nsfw.core.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.halo.nsfw.user.entity.User;

public class ExcelUtil {
	public static void exportExcel(List<User> list, ServletOutputStream outputStream) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("userinfo");
			sheet.setDefaultColumnWidth(25);
			CellRangeAddress rangeAddress = new CellRangeAddress(0, 0, 0, 4);
			sheet.addMergedRegion(rangeAddress);
			XSSFCellStyle style0 = createStyle(workbook, (short)20);
			XSSFCellStyle style1 = createStyle(workbook, (short)13);
			int rowIndex = 2;
			XSSFRow row0 = sheet.createRow(0);
			XSSFCell headcell = row0.createCell(0);
			headcell.setCellValue("员工信息表");
			headcell.setCellStyle(style0);
			XSSFRow row1 = sheet.createRow(1);
			String[] tites = {"姓名","账户","部门","性别","email"};
			for(int i=0;i<tites.length;i++){
				XSSFCell cell = row1.createCell(i);
				cell.setCellValue(tites[i]);
				cell.setCellStyle(style1);
			}
			for(User u:list)
			{
				XSSFRow row = sheet.createRow(rowIndex);
				row.createCell(0).setCellValue(u.getName());
				row.createCell(1).setCellValue(u.getAccount());
				row.createCell(2).setCellValue(u.getDept());
				row.createCell(3).setCellValue(u.isGender()?"男":"女");
				row.createCell(4).setCellValue(u.getEmail());
				rowIndex++;
			}
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 创建样式表
	 * @param workbook 工作簿
	 * @param fontsize 字体大小
	 * @return 返回样式
	 */
	private static XSSFCellStyle createStyle(XSSFWorkbook workbook,short fontsize)
	{
		XSSFFont font = workbook.createFont();
		XSSFCellStyle style = workbook.createCellStyle();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints(fontsize);
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		style.setFont(font);
		return style;
	}

}
