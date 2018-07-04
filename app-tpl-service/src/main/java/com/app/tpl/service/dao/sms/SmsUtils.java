package com.app.tpl.service.dao.sms;

import com.app.tpl.service.dao.sms.miaodi.MiaoDiSmsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daiyong on 2018/7/3.
 * email daiyong@qiyi.com
 */
public class SmsUtils {

	private static final Logger LOG = LoggerFactory.getLogger(SmsUtils.class);

	private static final List<SmsProvider> SMS_PROVIDER_LIST = new ArrayList<>();

	static {
		SMS_PROVIDER_LIST.add(new MiaoDiSmsProvider());
	}

	/**
	 * 发送短信
	 * @param content
	 * @param mobile
	 * @return
	 */
	public static boolean send(String content, String mobile) {
		for (SmsProvider smsProvider : SMS_PROVIDER_LIST) {
			try {
				boolean sendResult = smsProvider.sendSms(content, mobile);
				if (sendResult) {
					return sendResult;
				}
			} catch (Exception e) {
				LOG.error("发送短信验证码异常", e);
			}
		}
		return false;
	}



}
