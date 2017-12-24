package com.coll.model;

/**
 * 用户模型特征
 * @author Administrator
 *
 */
public class CatitModel {
	private String catit_id;//关联用户user_email
	private String catit_name;//特征名称
	//private Integer value;//对应字典中的value
	private Double catit_intension;//特征的强度
	private String f_catit_id;//父id/及表示所属分类
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
