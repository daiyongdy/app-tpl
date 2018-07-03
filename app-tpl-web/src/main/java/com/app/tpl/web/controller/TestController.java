package com.app.tpl.web.controller;

import com.app.tpl.web.model.WebMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daiyong on 2018/7/3.
 * email daiyong@qiyi.com
 */
@RestController
@RequestMapping("test")
public class TestController {

	@RequestMapping("/test")
	public Object test() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "daiyong");
		return WebMessage.build(map);
	}
}
