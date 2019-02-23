package com.wwh.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.dao.IBusinessDao;
import com.wwh.dao.IDiskDao;
import com.wwh.dao.IEarningDao;
import com.wwh.dao.IUserDao;
import com.wwh.enums.DiskEnum;
import com.wwh.service.IDiskService;
import com.wwh.vo.DiskCustromVO;
import com.wwh.vo.DiskVO;
import com.wwh.vo.PlatformProfitExtendVO;
import com.wwh.vo.ProfitExtendVO;
import com.wwh.vo.UserVO;

@Service
public class DiskService implements IDiskService {

	@Autowired
	private IDiskDao diskDao;
	@Autowired
	private IEarningDao earningDao;
	@Autowired
	private IBusinessDao businessDao;
	@Autowired
	private IUserDao userDao;

	@Override
	public List<ProfitExtendVO> getItemByDiskType(String diskType, Integer num) {
		List<ProfitExtendVO> wpdcs = diskDao.getItemByDiskType(diskType, num);
		return wpdcs;
	}

	@Override
	public DiskVO getDiskType(String diskSeq) {
		return diskDao.getByDiskSeq(diskSeq);
	}

	@Override
	public DiskCustromVO getDiskAll() {
		// 获取基本信息
		DiskCustromVO diskCustromVO = diskDao.getDiskAll();
		Integer tiyan = diskDao.getDiskCounterByType("TIYAN");
		Integer huimin = diskDao.getDiskCounterByType("HUIMIN");
		Integer fumin = diskDao.getDiskCounterByType("FUMIN");
		Integer xingmin = diskDao.getDiskCounterByType("XINGMIN");
		Long sum = Long.valueOf((tiyan == null ? 0 : tiyan) + (huimin == null ? 0 : huimin) + (fumin == null ? 0 : fumin) + (xingmin == null ? 0 : xingmin));
		// 各个系统的参与人数
		diskCustromVO.setTiyanDiskCounter(tiyan == null ? 0 : tiyan);
		diskCustromVO.setHuiminDiskCounter(huimin == null ? 0 : huimin);
		diskCustromVO.setFuminDiskCounter(fumin == null ? 0 : fumin);
		diskCustromVO.setXingminDiskCounter(xingmin == null ? 0 : xingmin);
		BigDecimal businessProfitAmount = diskDao.getAllBusinessAmount();
		// 招商分红总收益
		diskCustromVO.setAllBusinessProfitAmount(businessProfitAmount == null ? BigDecimal.valueOf(0) : businessProfitAmount);
		diskCustromVO.setAllDiskCounter(sum);
		return diskCustromVO;
	}

	@Override
	public DiskCustromVO getUserDetail(UserVO userVo) {
		DiskCustromVO diskCustromVO = new DiskCustromVO();
		diskCustromVO.setNickName(userDao.getUserByUserId(userVo.getUserId()).getNickName());
		// 用户的各个系统的总收益
		List<BigDecimal> profitDecimals = diskDao.getUesrProfitByAllSys(userVo.getUserId());
		diskCustromVO.setTiyanAmountByCurrentUser(profitDecimals.get(0) == null ? new BigDecimal(0) : profitDecimals.get(0));
		diskCustromVO.setHuiminAmountByCurrentUser(profitDecimals.get(1) == null ? new BigDecimal(0) : profitDecimals.get(1));
		diskCustromVO.setFuminAmountByCurrentUser(profitDecimals.get(2) == null ? new BigDecimal(0) : profitDecimals.get(2));
		diskCustromVO.setXingminAmountByCurrentUser(profitDecimals.get(3) == null ? new BigDecimal(0) : profitDecimals.get(3));
		// 用户的各个系统的总充值金额
		List<BigDecimal> rcgDecimal = diskDao.getUserRcgByAllSys(userVo.getUserId());
		diskCustromVO.setTiyanRcgByCurrentUser(rcgDecimal.get(0) == null ? new BigDecimal(0) : rcgDecimal.get(0));
		diskCustromVO.setHuiminRcgByCurrentUser(rcgDecimal.get(1) == null ? new BigDecimal(0) : rcgDecimal.get(1));
		diskCustromVO.setFuminRcgByCurrentUser(rcgDecimal.get(2) == null ? new BigDecimal(0) : rcgDecimal.get(2));
		diskCustromVO.setXingminRcgByCurrentUser(rcgDecimal.get(3) == null ? new BigDecimal(0) : rcgDecimal.get(3));
		// 用户的招商分红总收入
		PlatformProfitExtendVO platformProfitExtendVO = earningDao.getPlatformProfitByUserId(userVo.getUserId());
		if (platformProfitExtendVO == null) {
			platformProfitExtendVO = new PlatformProfitExtendVO();
		}
		diskCustromVO.setBusinessAmountByCurrentUser(platformProfitExtendVO.getBusinessTotalAmount().add(platformProfitExtendVO.getBusinessUsedAmount()));
		// 查询用户的招商数量
		diskCustromVO.setBusinessCounter(businessDao.getUserBusinessCounter(userVo.getUserId()));
		return diskCustromVO;
	}

	/**
	 * 获取盘号
	 */
	@Override
	public String getDiskHead(String diskType) {
		String firstWords = getHeadType(diskType);
		String time = getTime();
		StringBuffer diskHead = new StringBuffer();
		diskHead = diskHead.append(firstWords).append(time);
		return diskHead.toString();
	}

	/**
	 * 获取盘序号 序号部分
	 * 
	 * @param diskType
	 * @return
	 */
	@Override
	public Integer getDiskTail(String diskType) {
		Integer count = diskDao.countPlatetNum(diskType);
		count = count + 1; // 盘序号要从第一个开始
		return count;
	}

	/**
	 * 根据系统获取盘号的首字母
	 * 
	 * @param deskType
	 * @return
	 */
	private static String getHeadType(String deskType) {
		String firstWords = "";
		if (deskType.equals(DiskEnum.TIYAN.name())) {
			firstWords = "T";
		}
		if (deskType.equals(DiskEnum.HUIMIN.name())) {
			firstWords = "H";
		}
		if (deskType.equals(DiskEnum.FUMIN.name())) {
			firstWords = "F";
		}
		if (deskType.equals(DiskEnum.XINGMIN.name())) {
			firstWords = "X";
		}
		return firstWords;
	}

	/**
	 * 获取当前日期时间的字符串
	 * 
	 * @return
	 */
	private static String getTime() {
		Date date = new Date();
		SimpleDateFormat sp = new SimpleDateFormat("yyyyMMdd");
		String time = sp.format(date);
		return time;
	}

	@Override
	public String integerToStringFromDiskTail(Integer num) {
		if (num < 10) {
			return "0" + num.toString();
		}
		return num.toString();
	}

}
