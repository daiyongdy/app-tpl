package com.app.tpl.console;

import com.alibaba.fastjson.JSON;
import com.app.tpl.common.exception.BizException;
import com.app.tpl.service.dao.model.console.login.ConsoleUserDto;
import com.app.tpl.service.dao.model.console.login.ConsoleUserHolder;
import com.app.tpl.service.dao.model.db.TplUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

public class ApiInceptor implements HandlerInterceptor {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	private static final String TOKEN = "ck";

	private static final String USER_KEY = "user:";

	private static final Long EXPIRE_TIMES = 24L * 60L * 60L;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		String token = request.getParameter(TOKEN);
		if (!StringUtils.isNotBlank(token)) {
			throw BizException.NO_LOGIN;
		} else {
			String userJson = stringRedisTemplate.opsForValue().get(USER_KEY + token);
			if (!StringUtils.isNotBlank(userJson)) {
				throw BizException.NO_LOGIN;
			} else {
				TplUser tplUser = JSON.parseObject(userJson, TplUser.class);
				ConsoleUserDto consoleUserDto = new ConsoleUserDto();
				consoleUserDto.setUserId(tplUser.getUserId());
				consoleUserDto.setMerchantId(tplUser.getMerchantId());
				consoleUserDto.setUserName(tplUser.getUsername());
				consoleUserDto.setToken(token);
				ConsoleUserHolder.setUser(consoleUserDto);

				//刷新登录状态
				stringRedisTemplate.opsForValue().set(USER_KEY + token, JSON.toJSONString(tplUser), EXPIRE_TIMES, TimeUnit.SECONDS);
			}
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

}
