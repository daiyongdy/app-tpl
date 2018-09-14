package com.app.tpl.service.dao.model.console.login;

/**
 * Created by daiyong on 2018/9/14.
 * email daiyong@qiyi.com
 */
public class LoginResultDto {

	private boolean loginSuccess;
	private String token;

	public LoginResultDto(boolean loginSuccess, String token) {
		this.loginSuccess = loginSuccess;
		this.token = token;
	}

}
