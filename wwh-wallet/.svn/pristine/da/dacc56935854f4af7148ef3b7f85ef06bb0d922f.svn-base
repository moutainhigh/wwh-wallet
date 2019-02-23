package com.wwh.service.impl;

import com.wwh.dao.IDiskDao;
import com.wwh.dao.IUserDao;
import com.wwh.enums.DiskStatusEnum;
import com.wwh.enums.OrderByTypeEnum;
import com.wwh.service.IDiskEnterService;
import com.wwh.service.IStapDiskEnterService;
import com.wwh.util.CommonConstant;
import com.wwh.util.StringUtils;
import com.wwh.vo.DiskVO;
import com.wwh.vo.IdcardRelationVO;
import com.wwh.vo.WalletDiskRelationVO;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StapDiskEnterService
  implements IStapDiskEnterService
{
  private static Logger logger = LogManager.getLogger(DiskEnterService.class);
  @Autowired
  private IUserDao userDao;
  @Autowired
  private IDiskDao diskDao;
  @Autowired
  private IDiskEnterService diskEnterService;
  /**
   * 新入盘方法
   */
  public void enterOverIdentityDisk(String diskType, Long receiveUserId, String receiveUserIdCard, Boolean isFirst, IdcardRelationVO isFromWaitingIdCardVO)
    throws Exception
  {
    logger.info("入盘开始 :" + diskType);
    //查询该会员推荐人
    Long queryReferenceId = userDao.getUserReferenceIdByUserId(receiveUserId);
    //判断是否存在推荐人
    Boolean flag = Boolean.valueOf(StringUtils.isLongEmpty(queryReferenceId));
    if ((flag.booleanValue()) || (queryReferenceId.equals(CommonConstant.SYSTEM_USER_ID)))
    {
      //查询最慢的盘	
      DiskVO diskVOSlowest = diskDao.getRunningTheFastestOrTheSlowestDisk2(diskType, OrderByTypeEnum.ASC
        .name());
      if (diskVOSlowest == null) {
        return;
      }
      logger.info("无推荐人进入慢盘");
      //没有推荐人直接进入满盘
      diskEnterService.enterSlowestDisk(diskType, receiveUserId, receiveUserIdCard, diskVOSlowest, isFirst, isFromWaitingIdCardVO);
    }
    else
    {
      //有推荐人查询推荐人存在系统中的盘
      List<WalletDiskRelationVO> diskUserRelationVOs = diskEnterService.isExistsUserIdInDiskType(diskType, queryReferenceId, DiskStatusEnum.RUNNING
        .name());
      //若推荐人在系统不存在任何身份，则查询上上级推荐人
      if ((null == diskUserRelationVOs) || (diskUserRelationVOs.size() == 0))
      {
        logger.info("推荐人不在该系统任何一个盘中");
        //查询最快的盘
        DiskVO diskVOFastest = diskDao.getRunningTheFastestOrTheSlowestDisk(diskType, OrderByTypeEnum.DESC.name());
        if (diskVOFastest == null) {
          return;
        }
        //进入上上级推荐人的盘
        enterNotIdentityDisk(diskType, receiveUserId, receiveUserIdCard, queryReferenceId, diskVOFastest, isFirst, isFromWaitingIdCardVO);
      }
      //如果只存在一个身份
      else if (diskUserRelationVOs.size() == 1)
      {
    	//只存在一个身份则进入此身份的盘  
        enterOnlyIdentityDisk(diskType, receiveUserId, receiveUserIdCard, isFirst, isFromWaitingIdCardVO, diskUserRelationVOs);
      }
      //如果存在两个身份，则进入低角色的身份盘
      else if (diskUserRelationVOs.size() == 2)
      {
    	//进入角色低的身份盘中  
        enterMoreIdentityDisk(diskType, receiveUserId, receiveUserIdCard, isFirst, isFromWaitingIdCardVO, diskUserRelationVOs);
      }
    }
    logger.info("入盘结束 ");
  }
  /**
   * 进入存在的一个上上级推荐人的盘
   */
  public void enterNotIdentityDisk(String diskType, Long receiveUserId, String receiveUserIdCard, Long ReferenceId, DiskVO diskVOFastest, Boolean isFirst, IdcardRelationVO isFromWaitingIdCardVO)
    throws Exception
  {
    logger.info("直推荐人在系统无身份，进入存在的间接推荐人盘 ");
    //查询存在的一个上上级
    List<WalletDiskRelationVO> diskUserRelationVOs = getHaveLevelInvite(diskType, receiveUserId);
    //判断上上级是否有身份在系统
    if ((null != diskUserRelationVOs) && (diskUserRelationVOs.size() != 0))
    {
      if (diskUserRelationVOs.size() == 1) {
    	//只存在一个身份则进入此身份的盘  
        enterOnlyIdentityDisk(diskType, receiveUserId, receiveUserIdCard, isFirst, isFromWaitingIdCardVO, diskUserRelationVOs);
      } else if (diskUserRelationVOs.size() == 2) {
    	//如果存在两个身份，则进入低角色的身份盘  
        enterMoreIdentityDisk(diskType, receiveUserId, receiveUserIdCard, isFirst, isFromWaitingIdCardVO, diskUserRelationVOs);
      }
    }
    else
    {//上上级推荐人不存在系统，直接进入快盘
      logger.info("进入间接推荐人没有身份,进入快盘");
      diskEnterService.enterSlowestDisk(diskType, receiveUserId, receiveUserIdCard, diskVOFastest, isFirst, isFromWaitingIdCardVO);
    }
  }
  /**
   * 进入只有一个身份的盘
   */
  public void enterOnlyIdentityDisk(String diskType, Long receiveUserId, String receiveUserIdCard, Boolean isFirst, IdcardRelationVO isFromWaitingIdCardVO, List<WalletDiskRelationVO> diskUserRelationVOs)
    throws Exception
  {
	//得到该盘盘号  
    String diskSeq = ((WalletDiskRelationVO)diskUserRelationVOs.get(0)).getDiskSeq();
    //查询推荐人信息
    DiskVO diskVOInvite = diskDao.getByDiskTypeAndDiskSeq(diskType, diskSeq);
    if (diskVOInvite == null) {
      return;
    }
    logger.info("进入间接推荐人身份1的盘,进入快盘");
    diskEnterService.enterSlowestDisk(diskType, receiveUserId, receiveUserIdCard, diskVOInvite, isFirst, isFromWaitingIdCardVO);
  }
  /**
   * 多个身份进入地身份盘
   */
  public void enterMoreIdentityDisk(String diskType, Long receiveUserId, String receiveUserIdCard, Boolean isFirst, IdcardRelationVO isFromWaitingIdCardVO, List<WalletDiskRelationVO> diskUserRelationVOs)
    throws Exception
  {
    String diskSeq = "";
    //得到低身份盘号
    if (((WalletDiskRelationVO)diskUserRelationVOs.get(0)).getLocaltion().intValue() > ((WalletDiskRelationVO)diskUserRelationVOs.get(1)).getLocaltion().intValue()) {
      diskSeq = ((WalletDiskRelationVO)diskUserRelationVOs.get(0)).getDiskSeq();
    } else {
      diskSeq = ((WalletDiskRelationVO)diskUserRelationVOs.get(1)).getDiskSeq();
    }
    //得到推荐人信息
    DiskVO diskVOInvite = diskDao.getByDiskTypeAndDiskSeq(diskType, diskSeq);
    if (diskVOInvite == null) {
      return;
    }
    logger.info("进入间接推荐人身份2的盘,进入快盘");
    diskEnterService.enterSlowestDisk(diskType, receiveUserId, receiveUserIdCard, diskVOInvite, isFirst, isFromWaitingIdCardVO);
  }
  /**
   * 查询一个存在的上上级
   */
  public List<WalletDiskRelationVO> getHaveLevelInvite(String diskType, Long userId)
    throws Exception
  {
    logger.info("循环查出存在的间接上级推荐人");
    Long queryReferenceId = null;
    List<WalletDiskRelationVO> diskUserRelationVOs = new ArrayList();
    do
    {
      //得到推荐人
      queryReferenceId = userDao.getUserReferenceIdByUserId(userId);
      if (null==queryReferenceId||queryReferenceId.equals( CommonConstant.SYSTEM_USER_ID)) {
        break;
      }
      //得到推荐人存在盘中信息
      diskUserRelationVOs = diskEnterService.isExistsUserIdInDiskType(diskType, queryReferenceId, DiskStatusEnum.RUNNING
        .name());
      //重新赋值循环查询
      userId = queryReferenceId;
    } while (diskUserRelationVOs.size() == 0);
    
    return diskUserRelationVOs;
  }
  
  /**
   * 查询下级推荐人（不完善不使用）
   */
  public List<WalletDiskRelationVO> getHaveLevelReceive(String diskType, Long userId)
    throws Exception
  {
    logger.info("循环查出存在的下级推荐人");
    Long queryReceiveId = null;
    List<WalletDiskRelationVO> diskUserRelationVOs = new ArrayList();
    //得到所有下级
    List<Long> ReceiveIds = userDao.getReceiveUserId(userId);
    if ((null != ReceiveIds) && (ReceiveIds.size() > 0))
    {
      for (int j = 0; j < ReceiveIds.size(); j++)
      {//循环查询下级推荐人在盘中信息
        diskUserRelationVOs = diskEnterService.isExistsUserIdInDiskType(diskType, (Long)ReceiveIds.get(j), DiskStatusEnum.RUNNING
          .name());
        if (diskUserRelationVOs.size() > 0)
        {
          //查询到一个存在的下级，则推出循环	
          queryReceiveId = (Long)ReceiveIds.get(j);
          break;
        }
      }
      //下级没有人在盘中，则查询下下级
      if (diskUserRelationVOs.size() == 0) {
        diskUserRelationVOs = getHaveDownReceive(diskType, ReceiveIds);
      }
    }
    else
    {
      return diskUserRelationVOs;
    }
    return diskUserRelationVOs;
  }
  /**
   * 查询下下级推荐人(不完善不使用)
   */
  public List<WalletDiskRelationVO> getHaveDownReceive(String diskType, List<Long> userIds)
    throws Exception
  {
    logger.info("循环查出存在的间接下级推荐人");
    List<WalletDiskRelationVO> diskUserRelationVOs = new ArrayList();
    for (int i = 0; i < userIds.size(); i++)
    {
      //循环查询下级推荐人的所有下下级 	 
      List<Long> ReceiveIds = userDao.getReceiveUserId((Long)userIds.get(i));
      if ((null == ReceiveIds) || (ReceiveIds.size() <= 0)) {
        break;
      }
      //循环查询存在盘中的下下级推荐人
      for (int j = 0; j < ReceiveIds.size(); j++){
        diskUserRelationVOs = diskEnterService.isExistsUserIdInDiskType(diskType, (Long)ReceiveIds.get(j), DiskStatusEnum.RUNNING
          .name());
        //查询到一个存在下下级推荐人则推出循环
        if (diskUserRelationVOs.size() > 0) {
          break;
        }
      }
    }
    return diskUserRelationVOs;
  }
}
