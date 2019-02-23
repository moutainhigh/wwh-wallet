package com.wwh.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.WWHResultData;
import com.wwh.service.IFixedRebateService;
import com.wwh.vo.FixedRebateVO;

@Controller
@RequestMapping("/FixedRebate")
public class FixedRebateContorller {
		@Autowired
		private IFixedRebateService fixedRebateService;

		@ResponseBody
		@RequestMapping(value = "/getCount/{userId}", method = { RequestMethod.POST, RequestMethod.GET })
		public BigDecimal getCount(@PathVariable Long userId) throws Exception {
			BigDecimal result = fixedRebateService.getCountDetailInfoByUserId(userId);
			return result;
		}

		@ResponseBody
		@RequestMapping(value = "/getdetail/{userId}/{type}", method = { RequestMethod.POST, RequestMethod.GET })
		public WWHResultData<List<FixedRebateVO>> getdetail(@PathVariable Long userId,@PathVariable String type) throws Exception {
			WWHResultData<List<FixedRebateVO>> resultData= new WWHResultData<List<FixedRebateVO>>();
			List<FixedRebateVO> fixedRebateVO=fixedRebateService.getRebateDetailInfoByUserId(userId,type);
			if (null==fixedRebateVO) {
				resultData.setCode("1");
				resultData.setMsg("fial");
			}
			resultData.setData(fixedRebateVO);
			return resultData;
		}

}
