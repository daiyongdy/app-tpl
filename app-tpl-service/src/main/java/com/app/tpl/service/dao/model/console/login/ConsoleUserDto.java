package com.app.tpl.service.dao.model.console.login;

/**
 * Created by daiyong on 2018/8/10.
 * email daiyong@qiyi.com
 */
public class ConsoleUserDto {
	private Long userId;
	private long merchantId;
	private String userName;
	private String token;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
