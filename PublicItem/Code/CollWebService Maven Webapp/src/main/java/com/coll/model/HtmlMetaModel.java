package com.coll.model;

import java.util.List;

import net.sf.json.JSONArray;

/**
 * 网页信息实体
 * ClassName: HtmlMetaModel 
 * @Description: TODO
 * @author liwengbincoll@foxmail.com
 * @date 2017年12月25日
 */
public class HtmlMetaModel {
	private String title;
	private String icoBase64;
	private List<?> keyWord;
	public HtmlMetaModel() {
		super();
	}
	public HtmlMetaModel(String title, String icoBase64, List<?> keyWord) {
		super();
		this.title = title;
		this.icoBase64 = icoBase64;
		this.keyWord = keyWord;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the icoBase64
	 */
	public String getIcoBase64() {
		return icoBase64;
	}
	/**
	 * @param icoBase64 the icoBase64 to set
	 */
	public void setIcoBase64(String icoBase64) {
		this.icoBase64 = icoBase64;
	}
	/**
	 * @return the keyWord
	 */
	public List<?> getKeyWord() {
		return keyWord;
	}
	/**
	 * @param list the keyWord to set
	 */
	public void setKeyWord(List<?> list) {
		this.keyWord = list;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[title=" + title + ", icoBase64=" + icoBase64
				+ ", keyWord=" + JSONArray.fromObject(keyWord) + "]";
	}
}
