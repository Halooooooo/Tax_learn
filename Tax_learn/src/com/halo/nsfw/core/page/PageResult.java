package com.halo.nsfw.core.page;

import java.util.List;

public class PageResult {
	//总记录数
	private long totalCount;
	//当前页号
	private int currentPageNo;
	//总页数
	private int totalPageCount;
	//一页显示的行数
	private int pageSize;
	//一页的信息
	private List items;
	
	
	public PageResult() {
	}
	public PageResult(long totalCount, int currentPageNo, int pageSize,
			List items) {
 		this.totalCount = totalCount;
		this.currentPageNo = currentPageNo;
		this.pageSize = pageSize;
		this.items = items;
		
		if(totalCount!=0)
		{
			int tem = (int) (totalCount/pageSize);
			this.totalPageCount=(totalCount%pageSize==0)?tem:(tem+1);
			this.currentPageNo=currentPageNo;
		}else{
			this.currentPageNo=0;
		}
	}

	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List getItems() {
		return items;
	}
	public void setItems(List items) {
		this.items = items;
	}
	
	
}
