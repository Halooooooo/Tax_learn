package cn.halo.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class testPOI2Excel {

	@Test
	public void testwriting03() throws Exception{
		//gongzuobu
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("hello word");
		// begin index is 0
		HSSFRow row = sheet.createRow(2);
		
		HSSFCell cell = row.createCell(2);
		cell.setCellValue("Hello Word");
		
		FileOutputStream stream = new FileOutputStream("/Users/donghao/Desktop/l/test/ceshi.xls");
		workbook.write(stream);
		workbook.close();
		stream.close();
		
	}	
	@Test
	public void testReading03() throws Exception{
		//gongzuobu
		FileInputStream inputStream = new FileInputStream("/Users/donghao/Desktop/l/test/ceshi.xls");
		
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = workbook.getSheet("hello word");
		// begin index is 0
		HSSFRow row = sheet.getRow(2);
		
		HSSFCell cell = row.getCell(2);
		String value = cell.getStringCellValue();
		System.out.println(value);
		workbook.close();
		inputStream.close();
		
	}
	@Test
	public void testwriting07() throws Exception{
		//gongzuobu
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("hello word");
		// begin index is 0
		XSSFRow row = sheet.createRow(2);
		
		XSSFCell cell = row.createCell(2);
		cell.setCellValue("Hello Word");
		
		FileOutputStream stream = new FileOutputStream("/Users/donghao/Desktop/l/test/ceshi.xlsx");
		workbook.write(stream);
		workbook.close();
		stream.close();
		
	}	
	@Test
	public void testReading07() throws Exception{
		//gongzuobu
		FileInputStream inputStream = new FileInputStream("/Users/donghao/Desktop/l/test/ceshi.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("hello word");
		// begin index is 0
		XSSFRow row = sheet.getRow(2);
		
		XSSFCell cell = row.getCell(2);
		String value = cell.getStringCellValue();
		System.out.println(value);
		workbook.close();
		inputStream.close();
		
	}

	@Test
	public void testwritingstyle() throws Exception{
		//gongzuobu
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 1.1hebing cell
		CellRangeAddress rangeAddress = new CellRangeAddress(2,2,2,4);
		HSSFSheet sheet = workbook.createSheet("hello word");
		sheet.addMergedRegion(rangeAddress);
		//1.2style
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//1.3 font
		HSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 16);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);
		
		// begin index is 0
		HSSFRow row = sheet.createRow(2);
		HSSFCell cell = row.createCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("Hello Word");
		
		FileOutputStream stream = new FileOutputStream("/Users/donghao/Desktop/l/test/ceshi.xls");
		workbook.write(stream);
		workbook.close();
		stream.close();
		
	}	
	@Test
	public void testwritingstyle2() throws Exception{
		//gongzuobu
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 1.1hebing cell
		CellRangeAddress rangeAddress = new CellRangeAddress(2,2,2,4);
		XSSFSheet sheet = workbook.createSheet("hello word");
		sheet.addMergedRegion(rangeAddress);
		//1.2style
		XSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		//1.3 font
		XSSFFont font = workbook.createFont();
		font.setFontHeightInPoints((short) 16);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);
		
		// begin index is 0
		XSSFRow row = sheet.createRow(2);
		XSSFCell cell = row.createCell(3);
		cell.setCellStyle(style);
		cell.setCellValue("Hello Word");
		
		FileOutputStream stream = new FileOutputStream("/Users/donghao/Desktop/l/test/ceshi.xls");
		workbook.write(stream);
		workbook.close();
		stream.close();
		
	}	
}
