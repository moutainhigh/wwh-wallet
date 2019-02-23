package com.wwh.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.EliminateVO;
import com.wwh.vo.RegionUserVO;
import com.wwh.vo.UserVO;

public interface IUserDao {

	public List<Long> getReceiveUserId(@Param("userId") Long userId);

	public UserVO getUserInfo(String userID) throws Exception;

	/**
	 * 
	 * @Title: getUserIdByPaySeq
	 * @Description: 通过充值唯一编号和充值类型获得用户编号
	 * @param paySeq
	 * @return
	 * @return: Long
	 */
	public Long getUserIdByPaySeq(@Param("paySeq") String paySeq, @Param("payType") String payType);

	/**
	 * 
	 * @Title: updateMilestone
	 * @Description: 根据用户ID和充值类型，点亮对应里程碑
	 * @param payType
	 * @param userId
	 * @return
	 * @return: Boolean
	 */
	public Boolean updateMilestone(@Param("diskType") String diskType, @Param("userId") Long userId);

	/**
	 * 
	 * @Title: getUserReferenceIdByUserId
	 * @Description: 获取用户的推荐人ID(如果没有推荐人则为-999999)
	 * @param userId
	 * @return
	 * @return: Long
	 */
	public Long getUserReferenceIdByUserId(Long userId);

	/**
	 * 获取用户角色
	 * 
	 * @param userId
	 * @return
	 */
	public UserVO getUserRole(long userId);

	/**
	 * 获取角色权限
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getRolePrivilege(Map<String, Object> map);

	public List<Map<String, Object>> queryUserIdByLogin(Map<String, Object> map);

	UserVO getUserByUserId(Long userId);

	UserVO getUserByMobilePhone(String mobilePhone);

	List<UserVO> getUsersByUserIds(@Param("records") List<Long> userIds);

	/**
	 * 
	 * @Title: addEliminateVO
	 * @Description: 插入淘汰表
	 * @param eliminateVO
	 * @return: void
	 */
	void addEliminateVO(EliminateVO eliminateVO);

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public List<Map<String, Object>> getUserByCondition(String condition);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	Integer updateUserInfoById(UserVO userVo);

	/**
	 * 查询用户是否实名认证
	 * 
	 * @param userId
	 * @return
	 */
	Integer getIdValidFlagByUserId(Long userId);

	/**
	 * 更新t_member信息
	 * 
	 * @param userId
	 * @return
	 */
	Integer updateTmemeberInfo(UserVO userVo);

	/**
	 * 获取用户的推荐人id
	 * 
	 * @param userId
	 * @return
	 */
	Long getReferenceId(Long userId);

	/**
	 * 
	 * @Title: getRegionByUserId
	 * @Description: TODO
	 * @param userId
	 * @return
	 * @return: RegionUserVO
	 */
	RegionUserVO getRegionByUserId(Long userId);

	/**
	 * 校验手机号是否存在
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> checkMobilePhoneExsits(Map<String, Object> map);

	/**
	 * 根据用户的用户名查询用户
	 * 
	 * @param userName
	 * @return
	 */
	public Long selectUserByUserName(String userName);
	/**
	 * 根据用户的身份证查询用户
	 * 
	 * @param userName
	 * @return
	 */
	public Long selectUserByCardNo(String cardNo);
}
