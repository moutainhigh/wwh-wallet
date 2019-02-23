package com.wwh.service;

import com.wwh.vo.DiskVO;
import com.wwh.vo.IdcardRelationVO;
import com.wwh.vo.WalletDiskRelationVO;
import java.util.List;

public abstract interface IStapDiskEnterService
{
  /**
   * 新入盘方法
   * @param paramString1
   * @param paramLong
   * @param paramString2
   * @param paramBoolean
   * @param paramIdcardRelationVO
   * @throws Exception
   */
  public abstract void enterOverIdentityDisk(String diskType, Long receiveUserId, String receiveUserIdCard, Boolean isFirst, IdcardRelationVO isFromWaitingIdCardVO)
    throws Exception;
  /**
   * 无身份在盘入盘方法
   * @param paramString1
   * @param paramLong1
   * @param paramString2
   * @param paramLong2
   * @param paramDiskVO
   * @param paramBoolean
   * @param paramIdcardRelationVO
   * @throws Exception
   */
  public abstract void enterNotIdentityDisk(String diskType, Long receiveUserId, String receiveUserIdCard, Long ReferenceId, DiskVO diskVOFastest, Boolean isFirst, IdcardRelationVO isFromWaitingIdCardVO)
    throws Exception;
  /**
   * 只有一个身份入盘
   * @param paramString1
   * @param paramLong
   * @param paramString2
   * @param paramBoolean
   * @param paramIdcardRelationVO
   * @param paramList
   * @throws Exception
   */
  public abstract void enterOnlyIdentityDisk(String diskType, Long receiveUserId, String receiveUserIdCard, Boolean isFirst, IdcardRelationVO isFromWaitingIdCardVO, List<WalletDiskRelationVO> diskUserRelationVOs)
    throws Exception;
  /**
   * 多身份入盘
   * @param paramString1
   * @param paramLong
   * @param paramString2
   * @param paramBoolean
   * @param paramIdcardRelationVO
   * @param paramList
   * @throws Exception
   */
  public abstract void enterMoreIdentityDisk(String diskType, Long receiveUserId, String receiveUserIdCard, Boolean isFirst, IdcardRelationVO isFromWaitingIdCardVO, List<WalletDiskRelationVO> diskUserRelationVOs)
    throws Exception;
  /**
   * 查询存在的上级推荐人
   * @param paramString
   * @param paramLong
   * @return
   * @throws Exception
   */
  public abstract List<WalletDiskRelationVO> getHaveLevelInvite(String diskType, Long userId)
    throws Exception;
  /**
   * 查询下级推荐人
   * @param paramString
   * @param paramLong
   * @return
   * @throws Exception
   */
  public abstract List<WalletDiskRelationVO> getHaveLevelReceive(String diskType, Long userId)
    throws Exception;
  /**
   * 查询存在的下下级推荐人
   * @param paramString
   * @param paramList
   * @return
   * @throws Exception
   */
  public abstract List<WalletDiskRelationVO> getHaveDownReceive(String diskType, List<Long> userIds)
    throws Exception;
}
