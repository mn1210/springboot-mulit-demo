package org.springboot.multi.demo.web.exception;

import org.springboot.multi.demo.common.ResultEnum;

public class ApiException extends RuntimeException {

	private Integer code;
	

	public ApiException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
