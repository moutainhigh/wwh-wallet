package com.wwh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.IdcardRelationVO;
import com.wwh.vo.WalletDiskRelationVO;

public interface IWalletDiskRelationDao {

	/**
	 * 
	 * @Title: selectDiskRelation
	 * @Description: 查询盘关系通过条件
	 * @param diskType
	 * @param diskSeq
	 * @return
	 * @return: List<WalletDiskRelationVO>
	 */
	public List<WalletDiskRelationVO> selectDiskRelationBySelective(WalletDiskRelationVO walletDiskRelationVO);

	/**
	 * 
	 * @Title: selectDiskRelation
	 * @Description: 查询盘关系
	 * @param diskType
	 * @param diskSeq
	 * @return
	 * @return: List<WalletDiskRelationVO>
	 */
	public List<WalletDiskRelationVO> selectDiskRelation(@Param("diskType") String diskType,
			@Param("diskSeq") String diskSeq);

	/**
	 * 
	 * @Title: selectDiskRelationOverWrite 
	 * @Description: 查询盘关系 顺便查出 每个人的名字
	 * @param diskType
	 * @param diskSeq
	 * @return
	 * @return: List<WalletDiskRelationVO>
	 */
	public List<WalletDiskRelationVO> selectDiskRelationOverWrite(@Param("diskType") String diskType, @Param("diskSeq") String diskSeq);

	/**
	 * 按条件查询盘
	 * 
	 * @Title: selectByDiskVO
	 * @param diskVO
	 * @return
	 * @return: List<WalletDiskRelationVO>
	 */
	public List<WalletDiskRelationVO> selectByDiskVO(WalletDiskRelationVO walletDiskRelationVO);

	/**
	 * @Title: selectMyRunningDiskRecord
	 * @Description: 查看本盘参与活动的记录有
	 * @return
	 * @return: List<WalletDiskRelationVO>
	 */
	public List<WalletDiskRelationVO> selectMyRunningDiskByUserId(@Param("userId") Long userId,@Param("diskType") String diskType);

	public WalletDiskRelationVO selectByDiskSeq(String diskSeq);

	public WalletDiskRelationVO selectByPrimaryKey(Long id);

	public Integer insert(WalletDiskRelationVO walletDiskRelationVO);

	/**
	 * 
	 * @Title: insertBatchDiskRelation
	 * @Description: 批量插入盘关系
	 * @param diskType
	 * @param records
	 * @return
	 * @return: Integer
	 */
	public Integer insertBatchDiskRelation(@Param("diskType") String diskType,
			@Param("records") List<WalletDiskRelationVO> records);

	/**
	 * 
	 * @Title: diskRelationFinished
	 * @Description: 修改盘关系完成状态
	 * @param diskType
	 * @param diskSeq
	 * @return
	 * @return: Integer
	 */
	public Integer diskRelationFinished(@Param("diskType") String diskType, @Param("diskSeq") String diskSeq,
			@Param("lastUpdateBy") Long lastUpdateBy);

	/**
	 * 
	 * @Title: getAllIdCardRelationByCurrentIdCard
	 * @Description: 获取所有的idCard 的详细关系信息
	 * @param idCardOldLists
	 * @return
	 * @return: List<IdcardRelationVO>
	 */
	public List<IdcardRelationVO> getAllIdCardRelationByCurrentIdCards(@Param("records") List<String> idCardOldLists);

	/**
	 * 
	 * @Title: getIdCardRelationByCurrentIdCard
	 * @Description: 获取某个用户或某个IDcard的信息
	 * @param userId
	 * @param idCard
	 * @return
	 * @return: IdcardRelationVO
	 */
	public List<IdcardRelationVO> getIdCardRelationByCurrentIdCard(@Param("userId") Long userId,
			@Param("idCard") String idCard);

	/**
	 * 
	 * @Title: getIdCardRelationByCurrentIdCard
	 * @Description: 获取某个用户或某个IDcard集合的所有信息
	 * @param userId
	 * @param idCard
	 * @return
	 * @return: IdcardRelationVO
	 */
	public List<IdcardRelationVO> getIdCardRelationByIdCards(@Param("userId") Long userId,
			@Param("idCards") List<String> idCards);

	/**
	 * 
	 * @Title: updateAllIdCardRelationStatuxx
	 * @Description: 修改某个盘的所有IDcard 的状态
	 * @param diskSeq
	 * @param idCards
	 * @param statuxx
	 * @return: void
	 */
	public void updateAllIdCardRelationStatuxx(@Param("diskSeq") String diskSeq,
			@Param("idCards") List<IdcardRelationVO> idCards, @Param("statuxx") String statuxx);

	/**
	 * 
	 * @Title: addIdcardRelationByList
	 * @Description: 批量插入新的 IDCARD关系 记录
	 * @param records
	 * @return: void
	 */
	public void addIdcardRelationByList(@Param("records") List<IdcardRelationVO> records);

	/**
	 * 
	 * @Title: addIdcardRelationByOne
	 * @Description: 插入新的 IDCARD关系 记录
	 * @param idcardRelationVO
	 * @return: void
	 */
	public void addIdcardRelationByOne(IdcardRelationVO idcardRelationVO);

	/**
	 * 
	 * @Title: getManagersByDiskSeqs
	 * @Description: 通过盘list 获取对应身份的 盘关系记录
	 * @param diskStatus
	 * @param roleId
	 * @param records
	 * @return
	 * @return: List<WalletDiskRelationVO>
	 */
	public List<WalletDiskRelationVO> getManagersByDiskSeqs(@Param("diskStatus") String diskStatus,
			@Param("roleId") Long roleId, @Param("records") List<String> records, @Param("diskType") String diskType);

	/**
	 * 
	 * @Title: getDiskRelationsByIdCards
	 * @Description: 根据idCards集合获取 盘关系
	 * @param diskType
	 * @param records
	 * @return
	 * @return: List<WalletDiskRelationVO>
	 */
	public List<WalletDiskRelationVO> getDiskRelationsByIdCards(@Param("diskType") String diskType,
			@Param("idCards") List<String> records);

	/**
	 * 
	 * @Title: getDiskRelationsByUserId
	 * @Description: 根据userIds集合获取 盘关系
	 * @param diskType
	 * @param userId
	 * @param diskStatus
	 * @return
	 * @return: List<WalletDiskRelationVO>
	 */
	public List<WalletDiskRelationVO> getDiskRelationsByUserId(@Param("diskType") String diskType,
			@Param("userId") Long userId, @Param("diskStatus") String diskStatus);

	public List<IdcardRelationVO> getIdCardsByDiskSeq(String diskSeq);

	List<WalletDiskRelationVO> getDiskRelationVOBylocation(@Param("diskSeq") String diskSeq,
			@Param("diskType") String diskType, @Param("locations") List<Integer> locations);

	/**
	 * 查询我的推荐人
	 * 
	 * @param userId
	 * @return
	 */
	public Integer selectMyUnder(@Param("diskSeq") String diskType, @Param("userId") Long userId);

	/**
	 * 查询我的推荐点
	 * 
	 * @param userId
	 * @return
	 */
	public Integer selectMyRecorment(@Param("userId") Long userId);
	/**
	 * 根据用户现在的身份查询初始进入系统的idcard
	 * @param userId
	 * @param idCard
	 * @return
	 */
	public IdcardRelationVO getStartIdCardRelationByInfo(IdcardRelationVO idcardRelationVO);
	

}
