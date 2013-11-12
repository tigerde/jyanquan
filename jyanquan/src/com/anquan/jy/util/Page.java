package com.anquan.jy.util;

public class Page {
private int pageNo;//当前第几页
private int pageSize;//一共显示多少条
private int dataCount;//总条数

public int getPageNo() {
	if(pageNo<1) pageNo=1;
	if(pageNo>this.getPageCount()) pageNo = this.getPageCount();		
	return pageNo;
}
public void setPageNo(int pageNo) {
	this.pageNo = pageNo;
	
}
public int getDataCount() {
	return dataCount;
}
public void setDataCount(int dataCount) {
	this.dataCount = dataCount;		
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	if(pageSize<=0) pageSize=10;
	this.pageSize = pageSize;		
}
//返回总页数
public int getPageCount() {
	return (dataCount-1)/pageSize+1;		
}
}
