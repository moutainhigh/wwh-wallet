package com.wwh.common;

import java.io.Serializable;

import com.wwh.util.ReturnConstant;

public class ResultMsg<T> implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 序列ID
	 */
	private static final long serialVersionUID = -4522207125151962165L;

	private static ResultMsg<Object> resultMsg = new ResultMsg<Object>();

	/**
	 * 返回码
	 */
	private String returnCode;

	/**
	 * 返回消息
	 */
	private String returnMsg;


	/**
	 * 返回结果
	 */
	private T data;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static ResultMsg<Object> returnMsg200(Object obj) {
		resultMsg.setReturnCode(ReturnConstant.RETURN_CODE_200);
		resultMsg.setReturnMsg(ReturnConstant.RETURN_MSG_200);
		resultMsg.setData(obj);
		return resultMsg;
	}

	public static ResultMsg<Object> returnMsg400() {
		resultMsg.setReturnCode(ReturnConstant.RETURN_CODE_400);
		resultMsg.setReturnMsg(ReturnConstant.RETURN_MSG_400);
		return resultMsg;
	}

	public static ResultMsg<Object> returnMsg404() {
		resultMsg.setReturnCode(ReturnConstant.RETURN_CODE_404);
		resultMsg.setReturnMsg(ReturnConstant.RETURN_MSG_404);
		return resultMsg;
	}

	public static ResultMsg<Object> returnMsg403() {
		resultMsg.setReturnCode(ReturnConstant.RETURN_CODE_403);
		resultMsg.setReturnMsg(ReturnConstant.RETURN_MSG_403);
		return resultMsg;
	}

	public static ResultMsg<Object> returnMsg500() {
		resultMsg.setReturnCode(ReturnConstant.RETURN_CODE_500);
		resultMsg.setReturnMsg(ReturnConstant.RETURN_MSG_500);
		return resultMsg;
	}

	public static ResultMsg<Object> returnMsg999(Object obj) {
		resultMsg.setReturnCode(ReturnConstant.RETURN_CODE_999);
		resultMsg.setReturnMsg(ReturnConstant.RETURN_MSG_999);
		resultMsg.setData(obj);
		return resultMsg;
	}
}
