package com.app.tpl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.app.tpl.service.dao.mapper.db","com.app.tpl.service.dao.mapper.biz"})
public class AppTplWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppTplWebApplication.class, args);
	}
}
