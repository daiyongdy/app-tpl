package com.app.tpl.service.dao.sms;

/**
 * Created by daiyong on 2018/7/3.
 * email daiyong@qiyi.com
 */
public interface SmsProvider {
	boolean sendSms(String content, String mobile);
}
