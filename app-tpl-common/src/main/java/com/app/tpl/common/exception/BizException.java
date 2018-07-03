package com.app.tpl.common.exception;

/**
 * Created by daiyong on 2018/7/3.
 * email daiyong@qiyi.com
 */
public class BizException extends RuntimeException {

	private String code;
	private String msg;

	public BizException(String code, String msg) {
		super(code + ":" + msg);
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
