package com.app.tpl.web.controller;

import com.app.tpl.web.model.WebMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daiyong on 2018/7/3.
 * email daiyong@qiyi.com
 */
@RestController
@RequestMapping("/u")
public class UserController {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@RequestMapping("/sms")
	public WebMessage sms(@RequestParam() String mobile) {
//		stringRedisTemplate.opsForValue().set("name", "daiyong");
		Map<String, String> map = new HashMap<>();
		map.put("name", "daiyong");
		map.put("age", "28");
		redisTemplate.opsForValue().set("user", map);
		return WebMessage.DEFAULT;
	}

	@RequestMapping("/smsGet")
	public WebMessage smsGet(@RequestParam() String mobile) {
//		String name = stringRedisTemplate.opsForValue().get("name");
		Map<String, String> user = (Map<String, String>) redisTemplate.boundValueOps("user").get();
		return WebMessage.build(user);
	}

}
