package com.coll.model;

import java.util.Date;

/**
 * �û�������ַ���
 * @author Administrator
 *
 */
public class BehaviorModel {
	private String havior_id;
	private String user_email;
	private String url_id;
	private Date havior_time;//������ַʱ��ʱ��

	public BehaviorModel() {
		super();
	}
	public BehaviorModel(String havior_id, String user_email, String url_id,
			Date havior_time) {
		super();
		this.havior_id = havior_id;
		this.user_email = user_email;
		this.url_id = url_id;
		this.havior_time = havior_time;
	}
	
	public String getHavior_id() {
		return havior_id;
	}
	public void setHavior_id(String havior_id) {
		this.havior_id = havior_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUrl_id() {
		return url_id;
	}
	public void setUrl_id(String url_id) {
		this.url_id = url_id;
	}
	public Date getHavior_time() {
		return havior_time;
	}
	public void setHavior_time(Date havior_time) {
		this.havior_time = havior_time;
	}
	@Override
	public String toString() {
		return "BehaviorModel [havior_id=" + havior_id + ", user_email="
				+ user_email + ", url_id=" + url_id + ", havior_time="
				+ havior_time + "]";
	}
}
