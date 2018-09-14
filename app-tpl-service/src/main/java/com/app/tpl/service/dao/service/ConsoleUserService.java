package com.app.tpl.service.dao.service;

import com.app.tpl.service.dao.model.console.login.LoginResultDto;

/**
 * Created by daiyong on 2018/9/14.
 * email daiyong@qiyi.com
 */
public interface ConsoleUserService {
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	LoginResultDto login(String username, String password);

	/**
	 * 退出登录
	 * @return
	 */
	boolean logout();
}
