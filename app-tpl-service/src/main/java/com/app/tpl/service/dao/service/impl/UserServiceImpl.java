package com.app.tpl.service.dao.service.impl;

import com.app.tpl.common.exception.BizException;
import com.app.tpl.service.dao.mapper.db.TplUserMapper;
import com.app.tpl.service.dao.model.db.TplUser;
import com.app.tpl.service.dao.model.db.TplUserExample;
import com.app.tpl.service.dao.service.UserService;
import com.app.tpl.service.dao.sms.SmsUtils;
import com.app.tpl.service.dao.util.RandomCodeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by daiyong on 2018/7/3.
 * email daiyong@qiyi.com
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private TplUserMapper tplUserMapper;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	private static final String USER_REGISTER_PRERIX = "re:";

	private static final String USER_LOGIN_PRERIX = "login:";

	@Override
	public Boolean register(String mobile, String password, String code) {

		String regCode = stringRedisTemplate.opsForValue().get(USER_REGISTER_PRERIX + mobile);
		if (!StringUtils.isNotBlank(regCode)) {
			throw new BizException("0003", "注册验证码失效，请重新获取验证码");
		}

		if (!regCode.equals(code)) {
			throw new BizException("0004", "验证码错误");
		}

		TplUser tplUser = new TplUser();
		tplUser.setMobile(mobile);
		tplUser.setPassword(password);
		tplUser.setCreateTime(new Date());
		tplUserMapper.insertSelective(tplUser);

		return true;
	}

	/**
	 * 发送注册验证码
	 * @param mobile
	 * @return
	 */
	@Override
	public Boolean getRegisterSms(String mobile) {

		TplUserExample tplUserExample = new TplUserExample();
		tplUserExample.createCriteria().andMobileEqualTo(mobile);
		List<TplUser> tplUsers = tplUserMapper.selectByExample(tplUserExample);
		if (tplUsers.size() > 0) {
			throw new BizException("0001", "此手机号已经注册");
		}

		String code = RandomCodeUtils.random(4);
		boolean smsSendResult = SmsUtils.send(code + ", 2", mobile);
		LOG.info("{} 发送注册短信 {}", mobile, smsSendResult);

		if (!smsSendResult) {
			throw new BizException("0002", "注册短信验证码发送失败");
		}

		stringRedisTemplate.opsForValue().set(USER_REGISTER_PRERIX + mobile, code, 2L * 60, TimeUnit.SECONDS);

		return Boolean.TRUE;
	}

	@Override
	public Boolean getLoginSms(String mobile) {

		String code = RandomCodeUtils.random(4);
		boolean smsSendResult = SmsUtils.send(code + ", 2", mobile);
		LOG.info("{} 发送登录短信 {}", mobile, smsSendResult);

		if (!smsSendResult) {
			throw new BizException("0002", "登录短信验证码发送失败");
		}

		stringRedisTemplate.opsForValue().set(USER_LOGIN_PRERIX + mobile, code, 2L * 60, TimeUnit.SECONDS);

		return Boolean.TRUE;
	}

	@Override
	public String smsLogin(String mobile, String code) {
		return null;
	}


}
