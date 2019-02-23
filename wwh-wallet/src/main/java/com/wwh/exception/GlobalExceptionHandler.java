package com.wwh.exception;

import org.apache.ibatis.javassist.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wwh.util.DateUtils;


/**
 * 
 * @ClassName: GlobalExceptionHandler
 * @Description: eb层异常处理器, -- 这里可以根据不同的异常，写多个方法去处理， 可以处理跳转页面请求，跳到异常指定的错误页，
 *               也可以处理Ajax请求，根据不通过异常，在页面输出不同的提示信息 operateExp : 处理普通请求
 *               operateExpAjax ： 处理Ajax请求
 * @author: ranletian
 * @date: 2016年10月24日 上午11:24:46
 */
@ControllerAdvice
public class GlobalExceptionHandler extends Exception{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 3368588424961628364L;
	private static Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

	/**
	 * 
	 * @Title: unauthenticatedException
	 * @Description: 如果抛出UnauthorizedException，将被该异常处理器截获来显示没有权限信息
	 * @param request
	 * @param e
	 * @return
	 * @return: ModelAndView
	 */
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public String unauthenticatedException(UnauthorizedException ex, Model model) {
		logger.error(ex.getMessage(), ex);
		logger.info("************* ------ 异常信息已记录（" + DateUtils.getNowTime() + "） ------- ***********");
		model.addAttribute("errorTips", ex.getMessage());
		model.addAttribute("ex", ex);
		return "error/error_403";
	}

	/**
	 * 
	 * @Title: operateExp404
	 * @Description: 404页面异常
	 * @param ex
	 * @param request
	 * @return
	 * @return: String
	 */
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String operateException404(NotFoundException ex, Model model) {
		logger.error(ex.getMessage(), ex);
		logger.info("************* ------ 异常信息已记录（" + DateUtils.getNowTime() + "） ------- ***********");
		model.addAttribute("errorTips", ex.getMessage());
		model.addAttribute("ex", ex);
		return "error/error_404";
	}

	/**
	 * 
	 * @Title: operateExp
	 * @Description: 全局异常控制，记录日志
	 *               任何一个方法发生异常，一定会被这个方法拦截到。然后，输出日志。封装Map并返回给页面显示错误信息：
	 *               特别注意：返回给页面错误信息只在开发时才使用，上线后，要把错误页面去掉，只打印log日志即可，防止信息外漏
	 * @param ex
	 * @param request
	 * @return
	 * @return: String
	 */
	@ExceptionHandler(Exception.class)
	public String operateException(Exception ex, Model model) {
		logger.error(ex.getMessage(), ex);
		logger.info("************* ------ 异常信息已记录（" + DateUtils.getNowTime() + "） ------- ***********");
		model.addAttribute("errorTips", ex.getMessage());
		model.addAttribute("ex", ex);
		return "error/error";
	}
}
