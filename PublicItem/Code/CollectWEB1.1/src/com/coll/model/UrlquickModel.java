package com.coll.model;

import java.util.Date;

public class UrlquickModel {
	private String url_id;
    private String href;
    private String title;
    private Date time;
    private int tag;
    
	public UrlquickModel() {
		super();
	}
	
	
	public UrlquickModel(String url_id, String href, String title, Date time,
			int tag) {
		super();
		this.url_id = url_id;
		this.href = href;
		this.title = title;
		this.time = time;
		this.tag = tag;
	}


	public int getTag() {
		return tag;
	}


	public void setTag(int tag) {
		this.tag = tag;
	}


	public String getUrl_id() {
		return url_id;
	}
	public void setUrl_id(String url_id) {
		this.url_id = url_id;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "UrlquickModel [url_id=" + url_id + ", href=" + href
				+ ", title=" + title + ", time=" + time + ", tag=" + tag + "]";
	}

    
}
