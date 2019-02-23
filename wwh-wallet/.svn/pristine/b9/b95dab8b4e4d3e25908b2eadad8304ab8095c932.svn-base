package com.wwh.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwh.common.DatabaseContextHolder;
import com.wwh.common.WWHResultData;
import com.wwh.enums.DatabaseType;
import com.wwh.enums.PayAmountTypeEnum;
import com.wwh.enums.PayStatusEnum;
import com.wwh.service.IPayService;
import com.wwh.util.CommonConstant;
import com.wwh.vo.PayDetailVO;

/**
 * 预支付接口
 * 
 * @author lilinxiang 2016年11月2日 下午3:45:23
 *
 */
@Controller
@RequestMapping("/pay")
public class PayPreController {

	private static Logger logger = LogManager.getLogger(PayPreController.class);

	@Autowired
	private IPayService payService;

	/**
	 * 跳转用的 跳到支付界面
	 * 
	 * @param payDetailVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/alipayhtml", method = RequestMethod.POST)
	public String alipay(PayDetailVO payDetailVO, Model model) {
		model.addAttribute("orderId", payDetailVO.getPaySeq());
		model.addAttribute("payAmountType", payDetailVO.getPayAmountType());
		model.addAttribute("amount", payDetailVO.getAmount());
		return "wallet/charge/charge-step2";
	}

	@ResponseBody
	@RequestMapping(value = "/getpaydetail", method = RequestMethod.GET)
	public PayDetailVO getPayDetailInfo(String payAmountType, String orderId) throws Exception {
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		PayDetailVO payDetail = payService.getPayDetailByPayAmountTypeAndPaySeq(payAmountType, orderId);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return payDetail;
	}

	/**
	 * 生成预付订单
	 * 
	 * @param payDetailVO
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/pre", method = RequestMethod.POST)
	public String pre(PayDetailVO payDetailVO, HttpServletResponse response, HttpSession session, Model model)
			throws Exception {
		logger.info("pre post start: " + payDetailVO);
		payDetailVO.setRechargeUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		PayDetailVO returnPayDetailVO = payService.prePay(payDetailVO);
		model.addAttribute("orderId", returnPayDetailVO.getPaySeq());
		model.addAttribute("payAmountType", returnPayDetailVO.getPayAmountType());
		model.addAttribute("amount", returnPayDetailVO.getAmount());
		logger.info("pre post end");
		return "wallet/charge/charge-step2";
	}

	/**
	 * 生成预付订单
	 * 
	 * @param payDetailVO
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/pre2", method = RequestMethod.POST)
	public PayDetailVO pre(PayDetailVO payDetailVO, HttpServletResponse response, HttpSession session)
			throws Exception {
		logger.info("pre post start: " + payDetailVO);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		payDetailVO.setRechargeUserId((Long) session.getAttribute(CommonConstant.WALLET_USER_ID));
		PayDetailVO returnPayDetailVO = payService.prePay(payDetailVO);
		logger.info("pre post end");
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return returnPayDetailVO;
	}

	/**
	 * 查看单个充值记录是否充值成功
	 * 
	 * @param payAmountType
	 * @param paySeq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/ispayok/{payAmountType}/{paySeq}", method = RequestMethod.GET)
	@ResponseBody
	public WWHResultData<Boolean> isPayOK(@PathVariable String payAmountType, @PathVariable String paySeq)
			throws Exception {

		logger.info("isPayOK post start: " + paySeq);
		WWHResultData<Boolean> wwhResultData = new WWHResultData<>();

		PayDetailVO returnPayDetailVO = payService.getPayDetailByPayAmountTypeAndPaySeq(payAmountType, paySeq);

		wwhResultData.setData(false);

		if (null != returnPayDetailVO) {
			if (PayStatusEnum.PAYSUCCESSED.name().equals(returnPayDetailVO.getPayStatus())) {
				wwhResultData.setData(true);

				// PayDetailVO payDetailVO =
				// payService.updatePrePaySuccess(payAmountType, paySeq,null);
				// if (null == payDetailVO) {
				// logger.info("微信支付成功后， 本地服务修改数据 为成功状态失败 ，payAmountType" +
				// payAmountType + ",paySeq" + paySeq);
				// } else {
				// payService.updatePrePaySuccessAndDoNext(payAmountType,
				// payDetailVO.getIdCard(), payDetailVO);
				// }

			} else if (PayStatusEnum.PAYPREED.name().equals(returnPayDetailVO.getPayStatus())) {
				logger.info("订单未支付成功！类型  payAmountType:" + payAmountType + " 订单号paySeq:" + paySeq);
			} else {
				logger.info("无此订单号！类型  payAmountType:" + payAmountType + " 订单号paySeq:" + paySeq);
			}
		}

		logger.info("isPayOK post end");
		return wwhResultData;
	}

	/**
	 * 查询单个充值记录 getrecharge
	 * 
	 * @param payAmountType
	 * @param paySeq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getrecharge/{payAmountType}/{paySeq}", method = RequestMethod.GET)
	@ResponseBody
	public WWHResultData<PayDetailVO> getRecharge(@PathVariable String payAmountType, @PathVariable String paySeq)
			throws Exception {
		logger.info("getRecharge post start: " + paySeq);
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		WWHResultData<PayDetailVO> wwhResultData = new WWHResultData<>();

		PayDetailVO returnPayDetailVO = payService.getPayDetailByPayAmountTypeAndPaySeq(payAmountType, paySeq);

		wwhResultData.setData(returnPayDetailVO);

		logger.info("getRecharge post end");
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;

	}

	/**
	 * 查询所有的充值方式
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/methodlist", method = RequestMethod.GET)
	@ResponseBody
	public WWHResultData<List<String>> methodList() throws Exception {
		logger.info("methodList GET START");
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		WWHResultData<List<String>> wwhResultData = new WWHResultData<>();

		List<String> list = PayAmountTypeEnum.listAll();

		wwhResultData.setData(list);

		logger.info("methodList  GET END");
		DatabaseContextHolder.setDatabaseType(DatabaseType.walletdataSource);
		return wwhResultData;
	}

}
