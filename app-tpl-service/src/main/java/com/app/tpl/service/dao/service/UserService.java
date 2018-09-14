package com.app.tpl.service.dao.service;

/**
 * Created by daiyong on 2018/7/3.
 * email daiyong@qiyi.com
 */
public interface UserService {

	Boolean register(String mobile, String password, String code);

	Boolean getRegisterSms(String mobile);

	Boolean getLoginSms(String mobile);

	String smsLogin(String mobile, String code);

}
