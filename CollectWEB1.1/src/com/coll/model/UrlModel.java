package com.coll.model;

import java.util.ArrayList;

/**
*@author:liwengbincoll@foxmail.com
*@date:2017/10/22 0022 13:14
*@explain:网址信息实体类
*/
public class UrlModel {
    private String url_id;
    private String href;
    private String title;
    private String logo;
    private ArrayList<CatitModel> typelist;//网页所属类型
    private Boolean father;//是父亲吗
    private Integer loction;//网址所在的位置
    private Integer size;//一个时间段内网页被点击的次数
    private String user_email;//外键对应用户id

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

    public ArrayList<CatitModel> getTypelist() {
        return typelist;
    }

    public void setTypelist(ArrayList<CatitModel> typelist) {
        this.typelist = typelist;
    }

    public Boolean getFather() {
        return father;
    }

    public void setFather(Boolean father) {
        this.father = father;
    }

    public Integer getLoction() {
        return loction;
    }

    public void setLoction(Integer loction) {
        this.loction = loction;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public UrlModel()
    {
        super();
    }

    /**
     *@path:com.coll.model/UrlModel
     *@parame:[url_id, href, title, logo, typelist, father, loction, size, user_email]
     *@return:[]
     */
    public UrlModel(String url_id, String href, String title, String logo, ArrayList<CatitModel> typelist, Boolean father, Integer loction, Integer size, String user_email) {
        super();
        this.url_id = url_id;
        this.href = href;
        this.title = title;
        this.logo = logo;
        this.typelist = typelist;
        this.father = father;
        this.loction = loction;
        this.size = size;
        this.user_email = user_email;
    }

	@Override
	public String toString() {
		return "UrlModel [url_id=" + url_id + ", href=" + href + ", title="
				+ title + ", logo=" + logo + ", typelist=" + typelist
				+ ", father=" + father + ", loction=" + loction + ", size="
				+ size + ", user_email=" + user_email + "]";
	}
}
