package com.coll.model;

import java.util.List;

/**
 * 存放返回到试图层的集合
 * @author Administrator
 *
 */
public class UrllistModel {
	private UrlModel urlModel;
	private List<UrlModel> urllist;//表示前端点击下拉后的列中的网址
	
	public UrlModel getUrlModel() {
		return urlModel;
	}
	public void setUrlModel(UrlModel urlModel) {
		this.urlModel = urlModel;
	}
	public List<UrlModel> getUrllist() {
		return urllist;
	}
	public void setUrllist(List<UrlModel> urllist) {
		this.urllist = urllist;
	}
}
