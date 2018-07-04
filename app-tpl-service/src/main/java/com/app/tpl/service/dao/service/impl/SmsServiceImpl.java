package com.app.tpl.service.dao.service.impl;

import com.app.tpl.service.dao.service.SmsService;
import com.app.tpl.service.dao.sms.SmsUtils;
import com.app.tpl.service.dao.util.RandomCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by daiyong on 2018/7/3.
 * email daiyong@qiyi.com
 */
@Service
public class SmsServiceImpl implements SmsService {

	private static final Logger LOG = LoggerFactory.getLogger(SmsUtils.class);

	@Override
	public Boolean sendRegisterSmsCode(String mobile) {
		String code = RandomCodeUtils.random(4);
		boolean sendResult = SmsUtils.send(code + ", 2", mobile);
		LOG.info("{} 发送注册短信 {}", mobile, sendResult);
		return sendResult;
	}


}
