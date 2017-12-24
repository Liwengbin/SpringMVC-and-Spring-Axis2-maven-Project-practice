package com.coll.service;

import java.util.ArrayList;

import com.coll.model.QuickModel;
import com.coll.model.UrlquickModel;

public interface QuickService {
	public void addQuick(QuickModel quickModel);
	public void updataQuick(String quick_id);
	public QuickModel loadQuick(String quick_id);
	
	public void addUrlQuick(UrlquickModel urlquick);
	public void updataUrlQuick(UrlquickModel urlquick);
	public ArrayList<UrlquickModel> loadUrlQuick(int quick_tag, String word);
	public void deleteUrlQuick(String url_id);
	
	public boolean checkQuid(String quick_id);
}
