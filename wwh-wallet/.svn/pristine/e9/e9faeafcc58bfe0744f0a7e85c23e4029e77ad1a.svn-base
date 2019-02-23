package com.wwh.service;

import com.wwh.vo.SaveGoldCustromVO;
import com.wwh.vo.UserVO;
import com.wwh.vo.WalletAmountExtendVO;

/**
 * 
 * @ClassName: ISaveGoldService
 * @Description: 储备金Service
 * @author: YuZihao
 * @date: 2016年11月6日 下午1:55:51
 */
public interface ISaveGoldService {

	/**
	 * 
	 * @Title: getPlatformProfitExtend
	 * @Description: 查询用户的平台收益详情和邀请详情(邀请注册人数，邀请充值人数，投入资金，总收益)
	 * @param userVo
	 * @return
	 * @return: PlatformProfitExtendVO
	 */
	WalletAmountExtendVO getPlatformProfitExtend(UserVO userVo);

	/**
	 * 
	 * @Title: getProfitExtendVO
	 * @Description: 根据用户ID判断我有哪些系统，然后获取各个系统中我参与的盘的所有收益记录，一个list存放一个盘的收益记录信息
	 * @param userVo
	 * @return
	 * @return: SaveGoldCustromVO
	 */
	SaveGoldCustromVO getProfitExtendVO(UserVO userVo, String diskType,Integer currentPage,
			Integer pageSize);
	
	/**
	 * 
	 * @Title: getProfitExtendVO
	 * @Description: 根据用户ID判断我有哪些系统，然后获取各个系统中我参与的盘的所有收益记录，一个list存放一个盘的收益记录信息
	 * @param userVo
	 * @return
	 * @return: SaveGoldCustromVO
	 */
	SaveGoldCustromVO getProfitExtendVO(UserVO userVo, Integer currentPage,
			Integer pageSize);
}
