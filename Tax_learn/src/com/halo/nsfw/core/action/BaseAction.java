package com.halo.nsfw.core.action;

import com.halo.nsfw.core.page.PageResult;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	protected String[] selectedRow;

	
	protected PageResult pageResult;
	//当前页和页大小
	private int pageNo;
	private int pageSize;
	private static int DEFAULT_PAGESIZE = 10;
	public PageResult getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult pageResult) {
		this.pageResult = pageResult;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		if(pageSize<1) pageSize=DEFAULT_PAGESIZE;
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String[] getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}
}
