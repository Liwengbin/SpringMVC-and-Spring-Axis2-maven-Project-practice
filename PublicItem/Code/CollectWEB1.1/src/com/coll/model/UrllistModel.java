package com.coll.model;

import java.util.List;

/**
 * ��ŷ��ص���ͼ��ļ���
 * @author Administrator
 *
 */
public class UrllistModel {
	private UrlModel urlModel;
	private List<UrlModel> urllist;//��ʾǰ�˵������������е���ַ
	
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
