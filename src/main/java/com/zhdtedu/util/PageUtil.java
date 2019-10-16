package com.zhdtedu.util;

public class PageUtil {

	//每页显示记录数
	private static final int pageNum = 4;

	//当前页数
	private int currentPage ;

	//起始行数
	private int start ;

	public void setStart(int start) {
		this.start = start;
	}

	//结束行数
	private int end ;

	//总记录数
	private int totalCount ;

	//总页数
	private int pageCount ;

	public PageUtil(){

	}

	public PageUtil(int currentPage ){
		this.currentPage = currentPage ;
		this.start = (this.currentPage - 1) * this.pageNum;
		this.end = this.currentPage * this.pageNum ;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.pageCount = (this.totalCount - 1) / this.pageNum + 1 ;
	}

}
