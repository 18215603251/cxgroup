package com.cxhu.cxgroup.service;

import java.util.List;

import com.cxhu.cxgroup.domain.CertList;

/**
 * 荣誉证书分页的pageBean
 * @author admin
 */
public class DivideCertPageService {
	public static final int nav_max = 3;	// 根据自己想要设定多少个导航标签来设置这个值
	
	/*传递的已知值*/
	private int currentPage;		// 当前页
	private int onePageSize;		// 一页要显示多少条
	private long totalSize;			// 记录总数
	
	/*要计算的值*/
	private int totalPageSize;		// 总页数
	private int startIndex;			// 查询表记录的起始下标
	
	/*页面内容*/
	private List<CertList> certs;	// 主要内容
	private int start;				// 分页导航开始
	private int end;				// 分页导航结束
	
	/*构造器(一个页面, 没有为sert赋值值, 因为它只要通过查询获得后, 再通过setter赋值)*/
	public DivideCertPageService (int currentPage, int onePageSize, long totalSize) {
		this.currentPage = currentPage;
		this.onePageSize = onePageSize;
		this.totalSize = totalSize;
		
		// 计算总页数
		if(totalSize % onePageSize == 0) {
			totalPageSize = (int) (totalSize / onePageSize);
		} else {
			totalPageSize = (int) (totalSize / onePageSize) + 1;
		}
		
		// 计算查询的起始索引
		this.startIndex = (this.currentPage -1) * onePageSize;
		
		// 分页导航 (总页数与导航个数比较)
		if(totalPageSize <= DivideCertPageService.nav_max) {   	// 如果总页数小于3
			this.start = 1;
			this.end = this.totalPageSize;		
		} else {												// 总页数大于3
			this.start = this.currentPage - 1;					// 左边一个
			this.end = this.currentPage + 1;					// 右边一个
			
			if (start <= 0) {			 // 左边不够显示的情况
				this.start = 1;
				this.end = DivideCertPageService.nav_max;
			}
			if (end >= this.totalPageSize) {			// 右边不够显示的情况
				this.end = totalPageSize;
				this.start = end - DivideCertPageService.nav_max + 1;
			}
		}
	}

	/*getter /setter*/
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getOnePageSize() {
		return onePageSize;
	}

	public void setOnePageSize(int onePageSize) {
		this.onePageSize = onePageSize;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public int getTotalPageSize() {
		return totalPageSize;
	}

	public void setTotalPageSize(int totalPageSize) {
		this.totalPageSize = totalPageSize;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public List<CertList> getCerts() {
		return certs;
	}

	public void setCerts(List<CertList> certs) {
		this.certs = certs;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
}