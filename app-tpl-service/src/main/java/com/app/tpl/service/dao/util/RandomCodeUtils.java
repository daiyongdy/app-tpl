package com.app.tpl.service.dao.util;

import java.util.Random;

/**
 * Created by daiyong on 2018/7/3.
 * email daiyong@qiyi.com
 */
public class RandomCodeUtils {

	public static String random(int size) {
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb=new StringBuilder(4);
		for(int i=0;i<size;i++)
		{
			char ch=str.charAt(new Random().nextInt(str.length()));
			sb.append(ch);
		}

		return sb.toString();
	}

}
