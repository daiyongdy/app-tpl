package com.app.tpl.service.dao.sms.miaodi;

import java.util.List;

/**
 * Created by daiyong on 2018/7/3.
 * email daiyong@qiyi.com
 */
public class MiaoDiResponse {


	/**
	 * respCode : 00000
	 * respDesc : 成功
	 * failCount : 1
	 * failList : [{"phone":"13896543210","respCode":"00111","respDesc":"匹配到黑名单"}]
	 * smsId : 913945fec0204b1e94baa75a5c013f59
	 */

	private String respCode;
	private String respDesc;
	private String failCount;
	private String smsId;
	private List<FailListBean> failList;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public String getFailCount() {
		return failCount;
	}

	public void setFailCount(String failCount) {
		this.failCount = failCount;
	}

	public String getSmsId() {
		return smsId;
	}

	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}

	public List<FailListBean> getFailList() {
		return failList;
	}

	public void setFailList(List<FailListBean> failList) {
		this.failList = failList;
	}

	public static class FailListBean {
		/**
		 * phone : 13896543210
		 * respCode : 00111
		 * respDesc : 匹配到黑名单
		 */

		private String phone;
		private String respCode;
		private String respDesc;

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getRespCode() {
			return respCode;
		}

		public void setRespCode(String respCode) {
			this.respCode = respCode;
		}

		public String getRespDesc() {
			return respDesc;
		}

		public void setRespDesc(String respDesc) {
			this.respDesc = respDesc;
		}
	}
}
