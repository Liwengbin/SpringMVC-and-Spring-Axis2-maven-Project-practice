package com.coll.model;

public class DhModel {
	private String user_email;
	private int H0;//标记网址目录的父类最后一个的值
	private int H1;
	private int H2;
	private int H3;
	private int H4;
	private int H5;
	private int H6;
	private int H7;
	private int H8;
	private int H9;
	
	
	public DhModel(String user_email) {
		super();
		this.user_email = user_email;
		this.H0 = 1;
		this.H1 = 1;
		this.H2 = 1;
		this.H3 = 1;
		this.H4 = 1;
		this.H5 = 1;
		this.H6 = 1;
		this.H7 = 1;
		this.H8 = 1;
		this.H9 = 1;
	}
	
	public DhModel() {
		super();
	}

	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getH0() {
		return H0;
	}
	public void setH0(int h0) {
		H0 = h0;
	}
	public int getH1() {
		return H1;
	}
	public void setH1(int h1) {
		H1 = h1;
	}
	public int getH2() {
		return H2;
	}
	public void setH2(int h2) {
		H2 = h2;
	}
	public int getH3() {
		return H3;
	}
	public void setH3(int h3) {
		H3 = h3;
	}
	public int getH4() {
		return H4;
	}
	public void setH4(int h4) {
		H4 = h4;
	}
	public int getH5() {
		return H5;
	}
	public void setH5(int h5) {
		H5 = h5;
	}
	public int getH6() {
		return H6;
	}
	public void setH6(int h6) {
		H6 = h6;
	}
	public int getH7() {
		return H7;
	}
	public void setH7(int h7) {
		H7 = h7;
	}
	public int getH8() {
		return H8;
	}
	public void setH8(int h8) {
		H8 = h8;
	}
	public int getH9() {
		return H9;
	}
	public void setH9(int h9) {
		H9 = h9;
	}

	@Override
	public String toString() {
		return "DhModel [user_email=" + user_email + ", H0=" + H0 + ", H1="
				+ H1 + ", H2=" + H2 + ", H3=" + H3 + ", H4=" + H4 + ", H5="
				+ H5 + ", H6=" + H6 + ", H7=" + H7 + ", H8=" + H8 + ", H9="
				+ H9 + "]";
	}

}
