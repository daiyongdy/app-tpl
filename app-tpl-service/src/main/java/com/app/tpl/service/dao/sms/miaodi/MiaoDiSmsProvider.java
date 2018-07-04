package com.app.tpl.service.dao.sms.miaodi;

import com.alibaba.fastjson.JSON;
import com.app.tpl.service.dao.sms.SmsProvider;
import com.app.tpl.service.dao.util.MD5Utils;
import com.app.tpl.service.dao.util.https.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by daiyong on 2018/7/3.
 * email daiyong@qiyi.com
 */
public class MiaoDiSmsProvider implements SmsProvider {

	protected static final Logger LOG = LoggerFactory.getLogger(MiaoDiSmsProvider.class);

	private static final String URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
	private static final String SID = "5c404f71b1c54c46b73e531d5b8809f2";
	private static final String TEMPLATE_ID = "353940017";
	private static final String TOKEN = "6c86694df40a41e18818437aa7be401e";

	@Override
	public boolean sendSms(String content, String mobile) {

		Map<String, String> param = new HashMap<>();
		param.put("accountSid", SID);
		param.put("templateid", TEMPLATE_ID);
		param.put("param", content);
		param.put("to", mobile);
		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		param.put("timestamp", date);
		param.put("sig", MD5Utils.MD5(SID + TOKEN + date));
		String result = HttpClientUtil.doPost(URL, param, "UTF-8");

		MiaoDiResponse response = JSON.parseObject(result, MiaoDiResponse.class);
		if (response.getRespCode().equals("00000")) {
			return true;
		} else {
			LOG.error("秒嘀发送短信失败，错误码:{}", response.getRespCode());
			return false;
		}

	}
}
