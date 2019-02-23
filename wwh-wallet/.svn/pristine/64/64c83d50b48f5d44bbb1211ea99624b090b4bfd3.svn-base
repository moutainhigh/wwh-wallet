package com.wwh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.DiskTypeUpWaittingVO;
import com.wwh.vo.WalletDiskWaittingVO;

/**
 * 
 * @ClassName: IWalletDiskWaittingDao 
 * @Description: 盘等待表
 * @author: Administrator
 * @date: 2016年10月26日 下午4:19:12
 */
public interface IWalletDiskWaittingDao {
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 插入对象
	 * @param walletDiskWaittingVO
	 * @return
	 * @return: Integer
	 */
	public Integer insert(WalletDiskWaittingVO walletDiskWaittingVO);
	
	/**
	 * 
	 * @Title: updateByPrimaryKeySelective 
	 * @Description: 通过主键修改对象
	 * @param walletDiskWaittingVO
	 * @return
	 * @return: Integer
	 */
	public Integer updateByPrimaryKeySelective(WalletDiskWaittingVO walletDiskWaittingVO);
	
	void addDiskTypeUpWaitting(DiskTypeUpWaittingVO diskTypeUpWaittingVO);
	
	List<WalletDiskWaittingVO> getDiskWaittingVOByUserId (@Param("userId")Long userId,@Param("waittingStatus") String waittingStatus,@Param("diskType")String diskType);
	
	void updateDiskWaittingVOByIdCard(WalletDiskWaittingVO diskWaittingVO);
	
}
