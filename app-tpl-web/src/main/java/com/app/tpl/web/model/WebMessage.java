package com.app.tpl.web.model;

import java.io.Serializable;

public class WebMessage<T> implements Serializable {
	private static final long serialVersionUID = 3977946114395430392L;

	public static final int CODE_OK = 0;

	public static final String MESSAGE_EMPTY = "";

	public static final WebMessage<String> DEFAULT = build(CODE_OK);

	private int code = CODE_OK;//成功标识

	private String message = MESSAGE_EMPTY;

	private T result;

	public WebMessage(int code, String message, T result) {
		this.code = code;
		this.message = message;
		this.result = result;
	}

	public static WebMessage<String> build(int code) {
		return build(code, MESSAGE_EMPTY);
	}

	public static WebMessage<String> build(int code, String message) {
		return build(code, message, MESSAGE_EMPTY);
	}

	public static <T> WebMessage<T> build(T result) {
		return build(MESSAGE_EMPTY, result);
	}

	public static <T> WebMessage<T> build(String message, T result) {
		return build(CODE_OK, message, result);
	}

	public static <T> WebMessage<T> build(int code, String message, T result) {
		return new WebMessage(code, message, result);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "WebMessage{" +
				"code=" + code +
				", message='" + message + '\'' +
				", result=" + result +
				'}';
	}
}
