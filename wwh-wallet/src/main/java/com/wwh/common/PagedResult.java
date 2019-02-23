package com.wwh.common;

import java.util.List;

/**
 * 
 * @ClassName: PagedResult
 * @Description: 分页返回结果
 * @author: ranletian
 * @date: 2016年10月25日 下午5:13:06
 * @param <T>
 */
public class PagedResult<T> {

	/**
	 * 返回结果值
	 */
	private List<T> dataList;

	/**
	 * 当前页
	 */
	private long currentPage;

	/**
	 * 页面条数
	 */
	private long pageSize;

	/**
	 * 总条数
	 */
	private long total;

	/**
	 * 总页面数目
	 */
	private long pages;

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getPages() {
		return pages;
	}

	public void setPages(long pages) {
		this.pages = pages;
	}
}
