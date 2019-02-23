package com.wwh.service;

import java.util.List;

import com.wwh.vo.PayDetailVO;

/**
 * 充值接口
 * 
 * @author lilinxiang 2016年11月2日 下午4:25:37
 *
 */
public interface IPayService {

	public PayDetailVO prePay(PayDetailVO payDetailVO) throws Exception;

	 public PayDetailVO updatePrePaySuccess(String payAmountType, String paySeq,String returnCode) throws Exception;
	 
	 public Boolean updatePrePaySuccessAndDoNext(String payAmountType, String paySeq,PayDetailVO payDetailVO) throws Exception;

//	public Boolean updatePrePaySuccessUnder500(String payseq);
//	public Boolean updatePrePaySuccess500(String payseq);
//	public Boolean updatePrePaySuccess5000(String payseq);
//	public Boolean updatePrePaySuccess50000(String payseq);
//	public Boolean updatePrePaySuccess500000(String payseq);

	/**
	 * 查询 改单是否交易完成
	 * 
	 * @param payAmountType
	 * @param paySeq
	 * @return
	 */
	public PayDetailVO getPayDetailByPayAmountTypeAndPaySeq(String payAmountType, String paySeq)throws Exception;
	
	
//	public PayDetailVO getPayDetailByPaySeq(String paySeq);
	
//	public Integer updateSuccessByPaySeq500Selective(PayDetailVO payDetailVO);
//
//	public Integer updateSuccessByPaySeq5000Selective(PayDetailVO payDetailVO);
//
//	public Integer updateSuccessByPaySeq50000Selective(PayDetailVO payDetailVO);
//
//	public Integer updateSuccessByPaySeq500000Selective(PayDetailVO payDetailVO);
	
	/**
	 * 获取微支付时间超过30分钟的支付记录
	 * @return
	 */
	public List<PayDetailVO> getPayDetailMoreThan30Min();
	
	/**
	 * 更新支付订单信息通过主键id
	 * @param payDetailVo
	 * @return
	 */
	public Integer updatePayDetailById(PayDetailVO payDetailVo);
	/**
	 * 
	 * @Title: aboutPoint
	 * @Description: 关于推荐点分配的操作
	 * @param payAmountType
	 * @param userId
	 * @return: void
	 */
	public void aboutPoint(String payAmountType, Long userId);
	
}
