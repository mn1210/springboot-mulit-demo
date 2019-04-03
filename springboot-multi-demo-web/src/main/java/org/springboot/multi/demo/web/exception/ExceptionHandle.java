package org.springboot.multi.demo.web.exception;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springboot.multi.demo.common.Result;
import org.springboot.multi.demo.common.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 统一的异常处理
 * 
 * @author Think
 *
 */
@ControllerAdvice
public class ExceptionHandle {

	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		if (e instanceof ApiException) {
			ApiException aiException = (ApiException) e;
			return ResultUtil.error(aiException.getCode(), aiException.getMessage());
		} else {
			logger.error("【系统异常】{}", e);
			return ResultUtil.error(-1, e.getMessage());
		}
	}

}
