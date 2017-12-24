package com.coll.model;

public class UrlnavModel {
	private String url_id;
    private String href;
    private String title;
    private String logo;
    private Integer size;
    private Integer type_id;
    
	public UrlnavModel() {
		super();
	}
	public UrlnavModel(String url_id, String href, String title, String logo,
			Integer size, Integer type_id) {
		super();
		this.url_id = url_id;
		this.href = href;
		this.title = title;
		this.logo = logo;
		this.size = size;
		this.type_id = type_id;
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	
	@Override
	public String toString() {
		return "UrnavModel [url_id=" + url_id + ", href=" + href + ", title="
				+ title + ", logo=" + logo + ", size=" + size + ", type_id="
				+ type_id + "]";
	}
}
