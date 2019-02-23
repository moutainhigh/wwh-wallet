package com.wwh.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.FixedRebateVO;

public interface IFixedRebateDao {
	/**
	 * 查询定返比例
	 * @Title: getFixedRate 
	 * @Description: TODO
	 * @param idCard
	 * @return: BigDecimal
	 */
	public BigDecimal getFixedRate();
	/**
	 * 通过idCard得到定返统计信息
	 * @Title: getRebateInfoByIdCard 
	 * @Description: TODO
	 * @param idCard
	 * @return: FixedRebateVo
	 */
	public FixedRebateVO getRebateInfoByIdCard(String idCard);
	/**
	 * 更新定返统计信息
	 * @Title: updateRebateInfo 
	 * @Description: TODO
	 * @param fixedrebatevo
	 * @return: void
	 */
	public void updateRebateInfo(FixedRebateVO fixedrebatevo);
	/**
	 * 新增定返统计信息
	 * @Title: insertRebateInfo 
	 * @Description: TODO
	 * @param fixedrebatevo
	 * @return: void
	 */
	public void insertRebateInfo(FixedRebateVO fixedrebatevo);
	/**
	 * 通过用户id得到所有统计信息
	 * @Title: getRebateInfoByUserId 
	 * @Description: TODO
	 * @param userId
	 * @return: List<FixedRebateVo>
	 */
	public List<FixedRebateVO> getRebateInfoByUserId(Long userId);
	/**
	 * 新增定返详情信息
	 * @Title: insertRebateDetailInfo 
	 * @Description: TODO
	 * @param fixedrebatevo
	 * @return: void
	 */
	public void insertRebateDetailInfo(FixedRebateVO fixedrebatevo);
	/**
	 * 通过用户idCard得到所有详情信息
	 * @Title: getRebateDetailInfoByIdCard 
	 * @Description: TODO
	 * @param userId
	 * @return: List<FixedRebateVo>
	 */
	public List<FixedRebateVO> getRebateDetailInfoByIdCard(String idCard);
	/**
	 * 通过用户id得到所有详情信息
	 * @Title: getRebateDetailInfoByUserId 
	 * @Description: TODO
	 * @param userId
	 * @return: List<FixedRebateVo>
	 */
	public List<FixedRebateVO> getRebateDetailInfoByUserId(@Param("userId") Long userId,@Param("type") String type);
	/**
	 * 分页得到可定返的所有统计信息
	 * @Title: getRebateInfo 
	 * @Description: TODO
	 * @param pageFrom,pageEnd
	 * @return: List<FixedRebateVo>
	 */
	public List<FixedRebateVO> getRebateInfo(@Param("pageFrom") Long pageFrom,@Param("pageEnd") Long pageEnd);
	/**
	 * 得到可定返的所有统计信息条数
	 * @Title: getRebateInfo 
	 * @Description: TODO
	 * @return: List<FixedRebateVo>
	 */
	public Long getRebateInfoCount();
	/**
	 *更新定返状态
	 * @Title: insertRebateRate 
	 * @Description: TODO
	 * @param fixedrebatevo
	 * @return: void
	 */
	public void updateRebateRate(FixedRebateVO fixedrebatevo);
	/**
	 * 新增定返比例
	 * @Title: insertRebateRate 
	 * @Description: TODO
	 * @param fixedrebatevo
	 * @return: void
	 */
	public void insertRebateRate(FixedRebateVO fixedrebatevo);
	/**
	 * 得到定返功能开关
	 * @Title: getRebateConfig 
	 * @Description: TODO
	 * @return: List<Map<String,Object>>
	 */
	public String getRebateConfig(String configName);
	/**
	 * 查询昨日总收益
	 */
	public BigDecimal getCountDetailInfoByUserId(Long userId);
}
