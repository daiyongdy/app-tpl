package com.app.tpl.service.dao.util.https;

import com.app.tpl.service.dao.util.MD5Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by daiyong on 2018/7/3.
 * email daiyong@qiyi.com
 */
public class Test {
	public static void main(String[] args) {
		String url = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
		Map<String, String> param = new HashMap<>();
		param.put("accountSid", "5c404f71b1c54c46b73e531d5b8809f2");
//		param.put("smsContent", "测试验证码");
		param.put("templateid", "353940017");
		param.put("param", "8363, 2");
		param.put("to", "15201541109");
		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		param.put("timestamp", date);
		param.put("sig", MD5Utils.MD5("5c404f71b1c54c46b73e531d5b8809f2" + "6c86694df40a41e18818437aa7be401e" + date));

		String s = HttpClientUtil.doPost(url, param, "UTF-8");
		System.out.println(s);
	}
}
