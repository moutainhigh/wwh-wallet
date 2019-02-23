package com.wwh.task.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wwh.service.IFixedRebateService;
import com.wwh.task.service.ITaskService;
import com.wwh.util.CommonConstant;

@Component
public class TaskScheduler {
	public final static long ONE_MINUTE =  60 * 1000;
	public final static long TEN_MINUTE = 60*1000*10;
	public final static long THIRSTY_MINUTE = 60*1000*30;
	public final static String FIXEDREBATE_TIME = "0 30 23 * * ?";
	
	@Autowired
	private ITaskService taskService;
	
	@Autowired
	private IFixedRebateService fixedRebateService;
	
	
	@Scheduled(fixedDelay = TEN_MINUTE)
    public void cronJob2(){
		taskService.updateOderStatus();
    }
//	@Scheduled(fixedDelay = THIRSTY_MINUTE)
//	public void cronJob3(){
//		// TODO 每十分钟扫描一下未入盘用户
//
//	}
	/**
	 * 每天固定23:30分执行计算定返
	 * @Title: fixedRebateTask 
	 * @Description: TODO
	 * @return: void  
	 */
	@Scheduled(cron = FIXEDREBATE_TIME)
    public void fixedRebateTask(){
		if(fixedRebateService.getRebateConfig(CommonConstant.ONOFF_FIXEDREBATE)){
			fixedRebateService.doCalculateRebate();
		}
    }
}
