package org.springboot.multi.demo.common;

public enum ResultEnum {

	UNKONW_ERROR(-1, "未知错误"), 
	SUCCESS(200, "成功"), 
	NOT_EXISTS_ID(100, "ID不存在"), 
	NOT_NULL_ID(101, "ID不能为空"),
	PRIMARY(102, "违反唯一主键约束"),;

	private Integer code;

	private String msg;

	ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
