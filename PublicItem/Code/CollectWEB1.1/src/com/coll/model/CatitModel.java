package com.coll.model;

/**
 * �û�ģ������
 * @author Administrator
 *
 */
public class CatitModel {
	private String catit_id;//�����û�user_email
	private String catit_name;//��������
	//private Integer value;//��Ӧ�ֵ��е�value
	private Double catit_intension;//������ǿ��
	private String f_catit_id;//��id/����ʾ��������
	public CatitModel() {
		super();
	}
	public CatitModel(String catit_id, String catit_name,
			Double catit_intension, String f_catit_id) {
		super();
		this.catit_id = catit_id;
		this.catit_name = catit_name;
		this.catit_intension = catit_intension;
		this.f_catit_id = f_catit_id;
	}
	public String getCatit_id() {
		return catit_id;
	}
	public void setCatit_id(String catit_id) {
		this.catit_id = catit_id;
	}
	public String getCatit_name() {
		return catit_name;
	}
	public void setCatit_name(String catit_name) {
		this.catit_name = catit_name;
	}
	public Double getCatit_intension() {
		return catit_intension;
	}
	public void setCatit_intension(Double catit_intension) {
		this.catit_intension = catit_intension;
	}
	public String getF_catit_id() {
		return f_catit_id;
	}
	public void setF_catit_id(String f_catit_id) {
		this.f_catit_id = f_catit_id;
	}

}
