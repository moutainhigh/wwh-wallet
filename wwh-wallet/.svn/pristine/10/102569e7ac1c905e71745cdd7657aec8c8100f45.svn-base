package com.wwh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.PayDetailVO;

public interface IPayDetailDao {

	public Integer insert(PayDetailVO payDetailVO);

	public Integer updateByPrimaryKeySelective(PayDetailVO payDetailVO);

	/**
	 * 
	 * @Title: updateByPayAmountTypeAndPaySeqSelective
	 * @Description: 修改 必须字段 payAmountType 不允许为空 paySeq 不允许为空<br />
	 * @param payDetailVO
	 * @return
	 * @return: Integer
	 */
	public Integer updateByPayAmountTypeAndPaySeqSelective(PayDetailVO payDetailVO);

	public List<PayDetailVO> selectByPayDetail(PayDetailVO payDetailVO);

	public String isCalcuated(@Param("payAmountType") String payAmountType, @Param("paySeq") String paySeq);
	
	public List<PayDetailVO> getPayDetailMoreThan30Min();

}
