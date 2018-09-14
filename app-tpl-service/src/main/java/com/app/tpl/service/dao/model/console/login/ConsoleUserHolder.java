package com.app.tpl.service.dao.model.console.login;

public class ConsoleUserHolder {

	private static ThreadLocal<ConsoleUserDto> threadLocal = new ThreadLocal<ConsoleUserDto>();

	public static void setUser(ConsoleUserDto userDto) {
		threadLocal.set(userDto);
	}

	public static ConsoleUserDto getUser() {
		return threadLocal.get();
	}

}
