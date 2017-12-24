package com.coll.model;

import java.util.ArrayList;

public class NavModel {
	private Integer type_id;//类型id
	private Integer f_type_id;//类型父亲id
	private String type_name;
	private Double type_intension;
	private ArrayList<NavModel> nawModellist;//类型集合
	private ArrayList<UrlnavModel> urlnavModellist;//url集合
	
	public NavModel() {
		super();
	}
	
	public NavModel(Integer type_id, Integer f_type_id, String type_name,Double type_intension,
			ArrayList<NavModel> nawModellist, ArrayList<UrlnavModel> urlnavModellist) {
		super();
		this.type_id = type_id;
		this.f_type_id = f_type_id;
		this.type_name = type_name;
		this.type_intension = type_intension;
		this.nawModellist = nawModellist;
		this.urlnavModellist = urlnavModellist;
	}

	public Double getType_intension() {
		return type_intension;
	}

	public void setType_intension(Double type_intension) {
		this.type_intension = type_intension;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public Integer getF_type_id() {
		return f_type_id;
	}
	public void setF_type_id(Integer f_type_id) {
		this.f_type_id = f_type_id;
	}
	public ArrayList<NavModel> getNawModellist() {
		return nawModellist;
	}
	public void setNawModellist(ArrayList<NavModel> nawModellist) {
		this.nawModellist = nawModellist;
	}

	public ArrayList<UrlnavModel> getUrlnavModellist() {
		return urlnavModellist;
	}

	public void setUrlnavModellist(ArrayList<UrlnavModel> urlnavModellist) {
		this.urlnavModellist = urlnavModellist;
	}

	@Override
	public String toString() {
		return "NavModel [type_id=" + type_id + ", f_type_id=" + f_type_id
				+ ", type_name=" + type_name + ", type_intension="
				+ type_intension + ", nawModellist=" + nawModellist
				+ ", urlnavModellist=" + urlnavModellist + "]";
	}
}
