package com.wwh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wwh.vo.NullPointVO;

/**
 * 
 * @ClassName: IEmptyPointDiskDao
 * @Description: 空点表 wallet_empty_point_disk_t
 * @author: lilinxiang
 * @date: 2016年11月13日 下午7:33:46
 */
public interface IEmptyPointDiskDao {

	/**
	 * 
	 * @Title: selectByEmptyPointDisk
	 * @Description: TODO
	 * @param nullPointVO
	 * @return
	 * @return: List<NullPointVO>
	 */
	public List<NullPointVO> selectByEmptyPointDisk(NullPointVO nullPointVO);

	/**
	 * 
	 * @Title: insertEmptyPointDisk
	 * @Description: 插入空点表
	 * @param nullPointVO
	 * @return
	 * @return: Integer
	 */
	public Integer insertEmptyPointDisk(NullPointVO nullPointVO);

	/**
	 * 
	 * @Title: getNullPointByIdCards
	 * @Description: 获取 某些IDCARD 的 空点状态
	 * @param records
	 * @return
	 * @return: List<NullPointVO>
	 */
	public List<NullPointVO> getNullPointByIdCards(@Param("records") List<String> records);

	void updateNullPointIsUsableByDiskSeq(@Param("isUsable") String isUsable, @Param("diskSeq") String diskSeq);
}
