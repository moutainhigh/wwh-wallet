package com.wwh.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.common.ResultMsg;
import com.wwh.dao.ICertificationDao;
import com.wwh.dao.IPlatformInviteDao;
import com.wwh.dao.IPlatformInviteDetailDao;
import com.wwh.dao.IUserDao;
import com.wwh.enums.ActiveFlagEnum;
import com.wwh.enums.DatabaseType;
import com.wwh.enums.DeleteFlagEnum;
import com.wwh.service.ICertificationService;
import com.wwh.service.IExternalService;
import com.wwh.util.CommonConstant;
import com.wwh.util.StringUtils;
import com.wwh.vo.AreaRelationVO;
import com.wwh.vo.AreaVO;
import com.wwh.vo.CityVO;
import com.wwh.vo.CountryVO;
import com.wwh.vo.PlatformInviteDetailVO;
import com.wwh.vo.PlatformInviteVO;
import com.wwh.vo.ProvinceVO;
import com.wwh.vo.UserVO;

@Service
public class CertificationService implements ICertificationService {
	private static Logger logger = LogManager.getLogger(CertificationService.class);

	@Autowired
	private ICertificationDao certificationDao;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IExternalService externalService;
	@Autowired
	private IPlatformInviteDao platformInviteDao;
	@Autowired
	private IPlatformInviteDetailDao platformInviteDetailDao;

	@Override
	public boolean queryIsIdValid(Long userId) {
		Integer isIdValid = userDao.getIdValidFlagByUserId(userId);
		if (null != isIdValid && isIdValid == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<CountryVO> getCountryList() {
		return certificationDao.getCountryList();
	}

	@Override
	public List<ProvinceVO> getProvinceList(String CountryCode) {
		return certificationDao.getProvinceList(CountryCode);
	}

	@Override
	public List<CityVO> getCityList(String provinceCode) {
		return certificationDao.getCityList(provinceCode);
	}

	@Override
	public List<AreaVO> getAreaList(String cityCode) {
		return certificationDao.getAreaList(cityCode);
	}

	@Override
	public ResultMsg<String> updateUserInfoById(UserVO userVo) throws Exception {
		ResultMsg<String> resultMsg = new ResultMsg<String>();
		resultMsg.setReturnCode("0");
		resultMsg.setReturnMsg("更新成功");
		// Integer idValidFlag =
		// userDao.getIdValidFlagByUserId(userVo.getUserId());
		UserVO user = userDao.getUserByUserId(userVo.getUserId());
		if (!userVo.getUserName().trim().equals(user.getNickName())) {
			Long userId = userDao.selectUserByUserName(userVo.getUserName().trim());
			if (null != userId) {
				resultMsg.setReturnCode("1");
				resultMsg.setReturnMsg("用户名重复");
				return resultMsg;
			}
		}
		if (!userVo.getIdCardNo().trim().equals(user.getIdCardNo())) {
			Long userId = userDao.selectUserByCardNo(userVo.getIdCardNo().trim());
			if (null != userId && userId != userVo.getUserId()) {
				resultMsg.setReturnCode("3");
				resultMsg.setReturnMsg("身份证号已存在");
				return resultMsg;
			}
		}
		if (!StringUtils.isEmpty(userVo.getReferencePhone())) {
			UserVO userInfo = userDao.getUserByMobilePhone(userVo.getReferencePhone()); // 根据手机好查询用户信息
			if (null != userInfo) {
				userVo.setReferenceId(userInfo.getUserId());

				// 构建邀请统计vo
				PlatformInviteVO platformInvite = new PlatformInviteVO();
				platformInvite.setInviteUserId(userVo.getUserId());
				platformInvite.setInviteTotalCounter(1);
				platformInvite.setLevel1UserCounter(1);
				platformInvite.setLevel2UserCounter(0);
				platformInvite.setActiveFlag(ActiveFlagEnum.Y.name());
				platformInvite.setDeleteFlag(DeleteFlagEnum.N.name());
				platformInvite.setLastUpdatedBy(userVo.getUserId());
				platformInvite.setCreatedBy(userVo.getUserId());
				platformInviteDao.updatePlatformInviteByUserId(platformInvite);

				// 构建用户邀请详情信息vo

				PlatformInviteDetailVO platformInviteDetil = platformInviteDetailDao
						.getPlatformInviteDetailVOByUserId(userVo.getUserId());
				// 如果已经存在了推荐详情记录就更新 否则的化就插入一条新的
				if (null != platformInviteDetil && CommonConstant.SYSTEM_USER_ID.longValue() == platformInviteDetil
						.getReceiveUserId().longValue()) {
					platformInviteDetil.setInviteUserId(userInfo.getUserId());
					platformInviteDetailDao.updatePlatformInviteDetailById(platformInviteDetil);
				} else if (null == platformInviteDetil) {
					PlatformInviteDetailVO platformInviteDetail = new PlatformInviteDetailVO();
					platformInviteDetail.setInviteUserId(userInfo.getUserId());
					platformInviteDetail.setReceiveUserId(userVo.getUserId());
					platformInviteDetail.setActiveFlag(ActiveFlagEnum.Y.name());
					platformInviteDetail.setCreatedBy(userVo.getUserId());
					platformInviteDetail.setDeleteFlag(DeleteFlagEnum.N.name());
					platformInviteDetail.setIsRecharged("N");
					platformInviteDetail.setLastUpdatedBy(userVo.getUserId());
					platformInviteDetailDao.insert(platformInviteDetil);
				}
			} else if (null == userInfo) {
				resultMsg.setReturnCode("2");
				resultMsg.setReturnMsg("推荐人不存在");
				return resultMsg;
			}
		}

		userVo.setLastUpdatedBy(userVo.getUserId());
		// 当已经实名认证了
		if (null != user.getIsIdValid() && user.getIsIdValid() == 1) {
			userDao.updateUserInfoById(userVo);
			DatabaseContextHolder.setDatabaseType(DatabaseType.mallDataSource);
			userDao.updateTmemeberInfo(userVo);
			AreaRelationVO areaRelation = new AreaRelationVO();
			areaRelation.setUserId(userVo.getUserId());
			areaRelation.setAreaCode(userVo.getAreaCode());
			areaRelation.setCityCode(userVo.getCityCode());
			areaRelation.setProvinceCode(userVo.getProvinceCode());
			areaRelation.setCountryCode(userVo.getCountryCode());
			areaRelation.setCreatedBy(userVo.getUserId());
			areaRelation.setLastUpdatedBy(userVo.getLastUpdatedBy());
			DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
			certificationDao.updateAreaRelationInfo(areaRelation);
		} else {
			userDao.updateUserInfoById(userVo);
			AreaRelationVO areaRelation = new AreaRelationVO();
			areaRelation.setUserId(userVo.getUserId());
			areaRelation.setAreaCode(userVo.getAreaCode());
			areaRelation.setCityCode(userVo.getCityCode());
			areaRelation.setProvinceCode(userVo.getProvinceCode());
			areaRelation.setCountryCode(userVo.getCountryCode());
			areaRelation.setCreatedBy(userVo.getUserId());
			areaRelation.setLastUpdatedBy(userVo.getLastUpdatedBy());
			certificationDao.updateAreaRelationInfo(areaRelation);
			DatabaseContextHolder.setDatabaseType(DatabaseType.mallDataSource);
			Integer result = userDao.updateTmemeberInfo(userVo);
			DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
			logger.info("更新temember表用户信息结果 result={}", result);
			/*
			 * DatabaseContextHolder.setDatabaseType(DatabaseType.
			 * walletdataSource); Long referenceId =
			 * userDao.getReferenceId(userVo.getUserId()); ExternalVO externalVo
			 * = new ExternalVO(); externalVo.setMemberId(userVo.getUserId() +
			 * ""); externalVo.setReferenceId(referenceId + "");
			 */
			// externalService.giveScoreMethod(externalVo);
			// todo 调用
		}
		return resultMsg;
	}

	@Override
	public UserVO getPhoneByUserId(Long userId) {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return certificationDao.getPhoneByUserId(userId);
	}

}
