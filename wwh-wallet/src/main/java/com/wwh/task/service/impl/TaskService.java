package com.wwh.task.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.enums.PayStatusEnum;
import com.wwh.service.IPayService;
import com.wwh.task.service.ITaskService;
import com.wwh.util.CommonConstant;
import com.wwh.vo.PayDetailVO;

@Service
public class TaskService implements ITaskService {

	private static Logger logger = LogManager.getLogger(TaskService.class);

	@Autowired
	private IPayService payService;

	@Override
	public void updateOderStatus() {
		// 查询未支付的订单列表
		List<PayDetailVO> payDetailList = payService.getPayDetailMoreThan30Min();
		logger.info("超过30分钟微支付的订单记录payDetailList={}", payDetailList);
		// 更新状态
		if (null != payDetailList && payDetailList.size() > 0) {
			for (int i = 0; i < payDetailList.size(); i++) {
				PayDetailVO payDetail = payDetailList.get(i);
				payDetail.setPayStatus(PayStatusEnum.PAYCANCELED.name());
				payDetail.setLastUpdatedBy(CommonConstant.SYSTEM_USER_ID);
				Integer result = payService.updatePayDetailById(payDetail);
				logger.info("更新订单状态 result={}", result);
			}
		}
	}
}
