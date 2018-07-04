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

	/*@RequestMapping("/sms")
	public WebMessage sms(@RequestParam() String mobile) {
	}

	@RequestMapping("/smsGet")
	public WebMessage smsGet(@RequestParam() String mobile) {
	}*/

	@RequestMapping("/reg")
	public WebMessage register(@RequestParam String mobile) {
		Boolean registerResult = userService.register(mobile);
		return WebMessage.build(registerResult);
	}

}
