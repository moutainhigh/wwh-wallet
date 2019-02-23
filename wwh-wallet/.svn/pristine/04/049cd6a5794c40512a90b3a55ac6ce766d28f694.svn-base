package com.wwh.service;

import java.util.List;

import com.wwh.vo.DiskCustromVO;
import com.wwh.vo.DiskVO;
import com.wwh.vo.ProfitExtendVO;
import com.wwh.vo.UserVO;

/**
 * @ClassName: IDiskService
 * @Description: 首页service
 * @author: Administrator
 * @date: 2016年10月18日 上午11:10:10
 */
public interface IDiskService {

	/**
	 * 
	 * @Title: getItemByDiskType
	 * @Description: 查询按照时间倒序的若干条收益记录
	 * @param diskType
	 * @param num
	 * @return
	 * @return: List<ProfitExtendVO>
	 */
	List<ProfitExtendVO> getItemByDiskType(String diskType, Integer num);

	/**
	 * 
	 * @Title: getDiskType
	 * @Description: 通过盘号获取盘类型
	 * @param diskSeq
	 * @return
	 * @return: DiskVO
	 */
	DiskVO getDiskType(String diskSeq);

	/**
	 * 
	 * @Title: getDiskAll
	 * @Description: 获取盘总信息（包括各个系统的收益，盘总信息，各个系统的参与人数）
	 * @return
	 * @return: DiskCustromVO
	 */
	DiskCustromVO getDiskAll();

	/**
	 * 
	 * @Title: getUserDetail
	 * @Description: 当前登陆用户的所有统计信息
	 * @param userVo
	 * @return
	 * @return: DiskCustromVO
	 */
	DiskCustromVO getUserDetail(UserVO userVo);

	/**
	 * 获取盘号之 盘号头部分
	 * 
	 * @param diskType
	 * @return
	 */
	String getDiskHead(String diskType);

	/**
	 * 获取盘号之 盘号序号部分
	 * 
	 * @param diskType
	 * @return
	 */
	Integer getDiskTail(String diskType);

	/**
	 * 
	 * @Title: integerToStringFromDiskTail
	 * @Description: 数字to字符串 从 disktail
	 * @param num
	 * @return
	 * @return: String
	 */
	String integerToStringFromDiskTail(Integer num);
}