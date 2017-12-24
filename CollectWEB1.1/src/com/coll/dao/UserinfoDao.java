package com.coll.dao;

import java.util.ArrayList;

import com.coll.model.CatitModel;
import com.coll.model.UserinfoModel;

/**
 * 用户数据dao
*@author:liwengbincoll@foxmail.com
*@date:2017/10/24 0024 11:37
*@explain:
*/
public interface UserinfoDao {
    public void addUserInfo(UserinfoModel user);

    public UserinfoModel getUserInfo(String email);

    public void updataUserInfo(UserinfoModel user);
    public void removeUserInfo(String email);
    
    public ArrayList<CatitModel> loadUserCatit(String user_email,String f_catit_id);
    public ArrayList<CatitModel> loadUrlCatit(String url_id,String f_catit_id);
}
