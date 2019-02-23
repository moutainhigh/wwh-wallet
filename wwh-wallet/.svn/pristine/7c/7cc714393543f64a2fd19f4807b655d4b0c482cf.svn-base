package com.wwh.service;

import java.util.List;

import com.wwh.vo.DiskUserRelationVO;
import com.wwh.vo.DiskVO;
import com.wwh.vo.IdcardRelationVO;
import com.wwh.vo.WalletDiskRelationVO;

/**
 * 入盘后要操作的逻辑
 * 
 * @ClassName: IDiskEnterService
 * @Description: TODO
 * @author: asd
 * @date: 2016年11月9日 下午2:44:54
 */
public interface IDiskEnterService {

	/**
	 * 
	 * @Title: tandemService
	 * @Description: 入盘业务
	 * @param rechargeAmount
	 * @param diskTypeEnum
	 * @param receiveUserId
	 * @param receiveUserIdCard
	 * @param inviteUserId
	 * @param inviteUserIdCard
	 * @return: void
	 */
	public void tandemService(String diskTypeEnum, Long receiveUserId, String receiveUserIdCard, IdcardRelationVO isFromWaitingIdCardVO) throws Exception;

	/**
	 * 盘裂变，插入新的三个盘； 通过diskSeq 找出本盘所有人，裂变成新的三个盘 ；2、并且 计算出 B 点 ,及 抢点关系; 要算出这 4人(包括
	 * 本盘的三个经理， 和本盘的总监) A 点 B 点
	 * 
	 * @param diskSeq
	 */
	public void fissionDisk(String diskSeq, Long lastUpdateBy, String enterDiskIdCard) throws Exception;

	/**
	 * 
	 * @Title: finiskedDiskAndRelation
	 * @Description: 结束盘关系
	 * @param diskTypeEnum
	 * @param diskSeq
	 * @return
	 * @return: Boolean
	 */
	public Boolean finiskedDiskAndRelation(String diskTypeEnum, String diskSeq, Long lastUpdateBy) throws Exception;

	/**
	 * 检查某盘是否有我的记录
	 * 
	 * @Title: isExistsMyRecordIndiskType
	 * @Description: 检查某盘是否有我的记录
	 * @param diskTypeEnum
	 * @param userId
	 * @param userIdCard
	 * @return
	 * @return: Boolean false 不存在 true 存在
	 */
	public Boolean isExistsMyRecordIndiskType(String diskTypeEnum, Long userId) throws Exception;

	/**
	 * 
	 * @Title: whenInviteUserIdNoInDisk
	 * @Description: 查看邀请人在某盘中是否存在身份 ,版本一至多只有一条
	 * @param diskTypeEnum
	 * @param inviteUserId
	 * @param inviteUserIdCard
	 * @return
	 * @return: Boolean
	 */
	public List<DiskUserRelationVO> isExistsInviteUserIdInDiskType(String diskTypeEnum, Long inviteUserId) throws Exception;

	/**
	 * 
	 * @Title: enterDiskType
	 * @Description: 正常进入盘 ， 查看有没有邀请人，没有邀请人进入慢盘<br/>
	 *               有邀请人<br/>
	 *               查看邀请人在本盘还有没有身份,有身份跟着身份走,没有身份进入快盘<br/>
	 *               <br/>
	 * @param diskTypeEnum
	 * @param receiveUserId
	 * @param receiveUserIdCard
	 * @param isFirst
	 * @throws Exception
	 * @return: void
	 */
	public void enterDiskType(String diskTypeEnum, Long receiveUserId, String receiveUserIdCard, Boolean isFirst, IdcardRelationVO isFromWaitingIdCardVO)
			throws Exception;

	/**
	 * 
	 * @Title: enterDiskTypeByFassion
	 * @Description: 有身份就等待， 不管有没有推荐人都进入快盘
	 * @param diskTypeEnum
	 * @param receiveUserId
	 * @param receiveUserIdCard
	 * @param isFirst
	 * @throws Exception
	 * @return: void
	 */
	public void enterDiskTypeByFassion(String diskTypeEnum, Long receiveUserId, String oldReceiveUserIdCard, Boolean isFirst) throws Exception;

	/**
	 * 
	 * @Title: updateWaittingDisk
	 * @Description: 操作 等待表 (将某一个身份加入 等待,或者变为完成)
	 * @param diskTypeEnum
	 * @param receiveUserId
	 * @param receiveUserIdCard
	 * @param waittingType
	 * @throws Exception
	 * @return: void
	 */
	public void updateWaittingDisk(String diskTypeEnum, Long receiveUserId, String receiveUserIdCard, String waittingType) throws Exception;

	/**
	 * 入盘
	 * 
	 * @Title: enterSlowestDisk
	 * @Description: 入盘
	 * @param diskTypeEnum
	 *            系统类型
	 * @param enterDiskUserId
	 *            入盘用户ID
	 * @param enterDiskUserIdCard
	 *            入盘身份
	 * @param targetDiskVO
	 *            目标盘
	 * @return
	 * @throws Exception
	 * @return: void
	 */
	public void enterSlowestDisk(String diskTypeEnum, Long enterDiskUserId, String enterDiskUserIdCard, DiskVO targetDiskVO, Boolean isFirst,
			IdcardRelationVO isFromWaitingIdCardVO) throws Exception;

	/**
	 * 
	 * @Title: calcDiskProfit
	 * @Description: 计算盘相关人收益 盘收益详情表插入记录<br/>
	 *               盘总收益表插入记录<br/>
	 *               系统类型收益表插入记录<br/>
	 *               平台总收益表插入记录<br/>
	 *               钱包表插入记录<br/>
	 * @param diskTypeEnum
	 * @param diskSeq
	 * @return
	 * @return: DiskVO
	 */
	public Boolean calcProfitAndInsertBatchDiskProfit(Integer location, String diskTypeEnum, String diskSeq, Long enterDiskUserId, String enterDiskIdCard,
			DiskVO targetDiskVO) throws Exception;

	/**
	 * 
	 * @Title: isExistsMyInviteInDiskType
	 * @Description: 查询制定盘中,有没有该userId 记录 ;增加 找我的推荐人业务，去一个系统里面找正在找正在运行的盘。
	 *               有没有我的唯一身份
	 * @param diskTypeEnum
	 * @param userId
	 * @return
	 * @throws Exception
	 * @return: Boolean false 不存在 true 存在
	 */
	public List<WalletDiskRelationVO> isExistsUserIdInDiskType(String diskTypeEnum, Long userId, String diskStatus) throws Exception;

}
