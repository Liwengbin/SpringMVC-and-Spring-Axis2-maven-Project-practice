package com.coll.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
*@author:liwengbincoll@foxmail.com
*@date:2017/10/22 0022 13:47
*@explain:用户信息实体类
*/
public class UserinfoModel {
    private String user_email;
    private String user_password;
    private String user_name;//昵称
    private byte[] user_img;//头像
    private ArrayList<String> interest;//兴趣爱好
    private String profession;//职业
    private ArrayList<CatitModel> user_catitmodel;//用户特征集合
    
    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public byte[] getUser_img() {
        return user_img;
    }

    public void setUser_img(byte[] user_img) {
        this.user_img = user_img;
    }

    public ArrayList<String> getInterest() {
        return interest;
    }

    public void setInterest(ArrayList<String> interest) {
        this.interest = interest;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

	public ArrayList<CatitModel> getUser_catitmodel() {
		return user_catitmodel;
	}

	public void setUser_catitmodel(ArrayList<CatitModel> user_catitmodel) {
		this.user_catitmodel = user_catitmodel;
	}
	
    public UserinfoModel() {
        super();
    }

	public UserinfoModel(String user_email, String user_password,
			String user_name, byte[] user_img, ArrayList<String> interest,
			String profession, ArrayList<CatitModel> user_catitmodel) {
		super();
		this.user_email = user_email;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_img = user_img;
		this.interest = interest;
		this.profession = profession;
		this.user_catitmodel = user_catitmodel;
	}

	@Override
	public String toString() {
		return "UserinfoModel [user_email=" + user_email + ", user_password="
				+ user_password + ", user_name=" + user_name + ", user_img="
				+ Arrays.toString(user_img) + ", interest=" + interest
				+ ", profession=" + profession + ", user_catitmodel="
				+ user_catitmodel + "]";
	}

}
