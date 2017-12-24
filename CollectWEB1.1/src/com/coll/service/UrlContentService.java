package com.coll.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.coll.model.BehaviorModel;
import com.coll.model.NavModel;
import com.coll.model.UrlModel;
import com.coll.model.UrllistModel;


public interface UrlContentService {
	public void addUrl(UrlModel urlmodel);

    public List<UrllistModel> load_one_AllUrl(String user_email);
    
	public void importMenu(File file,String user_email);
	
	public ArrayList<UrlModel> load_all_Url(String user_email, boolean isfather);
	
	public ArrayList<NavModel> load_Nav();
	
	public void add_Nav_Url(int type_id);
	
	public void addBehavior(BehaviorModel behavior);
}
