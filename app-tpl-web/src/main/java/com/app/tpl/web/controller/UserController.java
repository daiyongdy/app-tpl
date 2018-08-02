package com.app.tpl.web.controller;

import com.app.tpl.service.dao.service.UserService;
import com.app.tpl.web.model.WebMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daiyong on 2018/7/3.
 * email daiyong@qiyi.com
 */
@RestController
@RequestMapping("/u")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 注册验证码
	 * @param mobile
	 * @return
	 */
	@RequestMapping("/reg-sms")
	public WebMessage sms(@RequestParam() String mobile) {
		Boolean regSmsResult = userService.getRegisterSms(mobile);
		return WebMessage.build(regSmsResult);
	}

	@RequestMapping("/reg")
	public WebMessage register(@RequestParam String mobile, String password, String code) {
		Boolean registerResult = userService.register(mobile, password, code);
		return WebMessage.build(registerResult);
	}

	@RequestMapping("/login-sms")
	public WebMessage loginSms(String mobile) {
		Boolean loginSmsResult = userService.getLoginSms(mobile);
		return WebMessage.build(loginSmsResult);
	}

	@RequestMapping("/smsLogin")
	public WebMessage smsLogin(String mobile, String code) {
		String token = userService.smsLogin(mobile, code);
		return WebMessage.build(token);
	}



}
