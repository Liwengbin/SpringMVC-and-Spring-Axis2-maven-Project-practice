package com.coll.service;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coll.dao.QuickDaoImpl;
import com.coll.model.QuickModel;
import com.coll.model.UrlquickModel;

@Service
public class QuickServiceImpl implements QuickService{
	
	Logger logger = Logger.getLogger(QuickServiceImpl.class);
	
	@Autowired
	private QuickDaoImpl quickDaoImpl;
	
	@Override
	public void addQuick(QuickModel quickModel) {
		quickDaoImpl.addQuick(quickModel);
	}

	@Override
	public void updataQuick(String quick_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QuickModel loadQuick(String quick_id) {
		return quickDaoImpl.loadQuick(quick_id);
	}

	@Override
	public void addUrlQuick(UrlquickModel urlquick) {
		quickDaoImpl.addUrlQuick(urlquick);
	}

	@Override
	public void updataUrlQuick(UrlquickModel urlquick) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<UrlquickModel> loadUrlQuick(int quick_tag, String word) {
		return quickDaoImpl.loadUrlQuick(quick_tag, word);
	}

	@Override
	public void deleteUrlQuick(String url_id) {
		quickDaoImpl.deleteUrlQuick(url_id);
	}

	@Override
	public boolean checkQuid(String quick_id) {
		try{
			QuickModel quickModel = quickDaoImpl.loadQuick(quick_id);
			if(quickModel == null) return false;
		}catch(Exception e){
			return false;
		}
		return true;
	}

}
