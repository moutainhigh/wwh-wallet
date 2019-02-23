package com.wwh.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.wwh.vo.FixedRebateVO;

/**
 * 定返功能接口
 * @ClassName: IFixedRebate 
 * @Description: TODO
 * @author: ranle
 * @date: 2017年3月7日 下午4:10:25
 */
public interface IFixedRebateService {
	/**
	 * 查询定返比例
	 * @Title: getRebateInfoByIdCard 
	 * @Description: TODO
	 * @param idCard
	 * @return: FixedRebateVo
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
	public List<FixedRebateVO> getRebateDetailInfoByIdCard(String IdCard);
	/**
	 * 通过用户id得到所有详情信息
	 * @Title: getRebateDetailInfoByUserId 
	 * @Description: TODO
	 * @param userId
	 * @return: List<FixedRebateVo>
	 */
	public List<FixedRebateVO> getRebateDetailInfoByUserId(Long userId,String type);
	/**
	 * 新增定返比例
	 * @Title: insertRebateRate 
	 * @Description: TODO
	 * @param fixedrebatevo
	 * @return: void
	 */
	public void insertRebateRate(FixedRebateVO fixedrebatevo);
	/**
	 *更新定返状态
	 * @Title: insertRebateRate 
	 * @Description: TODO
	 * @param fixedrebatevo
	 * @return: void
	 */
	public void updateRebateRate(FixedRebateVO fixedrebatevo);
	/**
	 * 得到定返功能开关
	 * @Title: getRebateConfig 
	 * @Description: TODO
	 * @return: List<Map<String,Object>>
	 */
	public boolean getRebateConfig(String configName);
	/**
	 * 查询昨日总收益
	 * @param userId
	 * @return
	 */
	public BigDecimal getCountDetailInfoByUserId(Long userId);
	/**
	 * 计算可定返的充值身份每日定返金额
	 * @Title: doCalculateRebate 
	 * @Description: TODO
	 * @return: boolean
	 */
	public void doCalculateRebate();
}
