package com.coll.dao;

import java.util.ArrayList;

import com.coll.model.BehaviorModel;
import com.coll.model.DhModel;
import com.coll.model.NavModel;
import com.coll.model.UrlModel;
import com.coll.model.UrlnavModel;


public interface UrlContentDao{
	public void addDH(String user_email);
	public void updataDH(DhModel dh);
	public DhModel loadDh(String user_email);

    public void addUrl(UrlModel urlmodel);
    public ArrayList<UrlModel> loadUrl(String user_email, boolean isfather);
    public ArrayList<UrlModel> load_one_Url(int loction,boolean isfather,String user_email);
    
    public ArrayList<NavModel> load_Nav(int f_type_id);
    
    public void add_Nav_Url(UrlnavModel urlnavModel);
    public ArrayList<UrlnavModel> load_Nav_Url(int type_id);
    
    public void addBehavior(BehaviorModel behavior);
    
}
