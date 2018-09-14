package com.app.tpl.console.controller;

import com.app.tpl.common.model.WebMessage;
import com.app.tpl.service.dao.model.console.login.LoginResultDto;
import com.app.tpl.service.dao.service.ConsoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daiyong on 2018/9/14.
 * email daiyong@qiyi.com
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private ConsoleUserService consoleUserService;

	@RequestMapping("login")
	public WebMessage login(String username, String password) {
		LoginResultDto loginResultDto = consoleUserService.login(username, password);
		return WebMessage.build(loginResultDto);
	}

	@RequestMapping("logout")
	public WebMessage logout() {
		boolean logoutResult = consoleUserService.logout();
		return WebMessage.build(logoutResult);
	}

}
