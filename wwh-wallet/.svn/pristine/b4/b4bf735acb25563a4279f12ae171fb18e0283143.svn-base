package com.wwh.util;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;
import com.wwh.common.PagedResult;

/**
 * 
 * @ClassName: BeanUtils
 * @Description: 分页返回结果集转换
 * @author: ranletian
 * @date: 2016年10月25日 下午5:18:08
 */
public class BeanUtils implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 序列ID
	 */
	private static final long serialVersionUID = 6206607221253291988L;

	public static <E> PagedResult<E> toPagedResult(List<E> datas) {
		PagedResult<E> result = new PagedResult<E>();
		if (datas instanceof Page) {
			Page<E> page = (Page<E>) datas;
			result.setCurrentPage(page.getPageNum());
			result.setPageSize(page.getPageSize());
			result.setDataList(page.getResult());
			result.setTotal(page.getTotal());
			result.setPages(page.getPages());
		} else {
			result.setCurrentPage(1);
			result.setPageSize(datas.size());
			result.setDataList(datas);
			result.setTotal(datas.size());
		}
		return result;
	}
}
