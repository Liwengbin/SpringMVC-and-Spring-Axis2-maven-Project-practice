package com.coll.model;

/**
 * 快速收藏登陆的类
 * @author Administrator
 *
 */
public class QuickModel {
	private String quick_id;
	private int quick_prm;//id的权限
	private int tag;//作为url表的外键
	private String user_email;
	
	public QuickModel() {
		super();
	}


	public QuickModel(String quick_id, int quick_prm, int tag, String user_email) {
		super();
		this.quick_id = quick_id;
		this.quick_prm = quick_prm;
		this.tag = tag;
		this.user_email = user_email;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getQuick_id() {
		return quick_id;
	}

	public void setQuick_id(String quick_id) {
		this.quick_id = quick_id;
	}

	public int getQuick_prm() {
		return quick_prm;
	}

	public void setQuick_prm(int quick_prm) {
		this.quick_prm = quick_prm;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "QuickModel [quick_id=" + quick_id + ", quick_prm=" + quick_prm
				+ ", tag=" + tag + "]";
	}
	
}
