package com.coll.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coll.dao.UrlContentDaoImpl;
import com.coll.dao.UserinfoDaoImpl;
import com.coll.exception.DataException;
import com.coll.model.BehaviorModel;
import com.coll.model.DhModel;
import com.coll.model.NavModel;
import com.coll.model.UrlModel;
import com.coll.model.UrllistModel;
import com.coll.model.UrlnavModel;
import com.coll.util.HtmlAnalysis;
import com.coll.util.Tools;

@Service
public class UrlContentServiceImpl implements UrlContentService{
	Logger logger = Logger.getLogger(UrlContentServiceImpl.class);
	@Autowired
	private UrlContentDaoImpl urlContentDaoImpl;
	@Autowired
	private HtmlAnalysis htmlAnalysis;
	@Autowired
	private UserinfoDaoImpl userinfoDaoImpl;
	@Override
    public void addUrl(UrlModel urlmodel)
    {
    	urlContentDaoImpl.addUrl(urlmodel);
    }
    
	@Override
	public List<UrllistModel> load_one_AllUrl(String user_email) {

		List<UrlModel> fatherlist = new ArrayList<UrlModel>();//获取每列的父亲
		
		List<UrllistModel> urllist = new ArrayList<UrllistModel>();
		
		fatherlist=urlContentDaoImpl.loadUrl(user_email, true);
		
		if(fatherlist != null){
			for(UrlModel url:fatherlist){
				
				UrllistModel urllistModel = new UrllistModel();
				
				urllistModel.setUrlModel(url);
				
				urllistModel.setUrllist(urlContentDaoImpl.load_one_Url(url.getLoction(), false, user_email));
				
				urllist.add(urllistModel);
			}
		}else {
			logger.info("用户无目录文件！");
		}
		return urllist;
	}

	/**
	 * 将收藏夹文件里的网址读出存到数据库中
	 */
	@Override
	public void importMenu(File file,String email) {
		List<UrlModel> urlModels = htmlAnalysis.importMenu(file, email);
		
		DhModel dhModel = urlContentDaoImpl.loadDh(email);
		int loction = dhModel.getH0();

		for(UrlModel coll:urlModels){
			if(coll.getTitle() != null ){
				if(coll.getFather()==true)
				{
					loction=loction+1;
				}
				coll.setLoction(loction);
				coll.setUrl_id("url="+Tools.creatUUID());
				coll.setUser_email(email);//用户id
				
				urlContentDaoImpl.addUrl(coll);
				}
		}
		
		dhModel.setH0(loction);
		urlContentDaoImpl.updataDH(dhModel);	
	}

	@Override
	public ArrayList<UrlModel> load_all_Url(String user_email, boolean isfather) {
		List<UrlModel> nofatherlist = new ArrayList<UrlModel>();//获取每列的父亲
		
		nofatherlist=urlContentDaoImpl.loadUrl(user_email, false);
		
		for (UrlModel url:nofatherlist) {
			url.setTypelist(userinfoDaoImpl.loadUrlCatit(url.getUrl_id(), null));
		}
		return (ArrayList<UrlModel>)nofatherlist;
	}

	@Override
	public ArrayList<NavModel> load_Nav() {
		ArrayList<NavModel> navlist = new ArrayList<NavModel>();
		navlist = urlContentDaoImpl.load_Nav(0);//查询出父目录
		if(navlist != null){
			try{
				for(NavModel nav:navlist){
					ArrayList<NavModel> nav_dlist = urlContentDaoImpl.load_Nav(nav.getType_id());
					if(nav_dlist != null){
						for(NavModel nav_d:nav_dlist){nav_d.setUrlnavModellist(urlContentDaoImpl.load_Nav_Url(nav_d.getType_id()));}
					}
					nav.setNawModellist(nav_dlist);
				}
			}catch(DataException e){
				logger.info(e.getStackTrace());
			}
		}
		return navlist;
	}

	/**
	 * 添加访问网址记录
	 */
	@Override
	public void addBehavior(BehaviorModel behavior) {
		behavior.setHavior_id("hav_"+Tools.creatUUID());
		behavior.setHavior_time(Tools.sysTIME());
		urlContentDaoImpl.addBehavior(behavior);
	}

	/**
	 * 读取uc导航
	 */
	@Override
	public void add_Nav_Url(int type_id) {
		List<UrlnavModel> urlnavModels = htmlAnalysis.getHTML(type_id);
		
		for (UrlnavModel nav:urlnavModels) {
			urlContentDaoImpl.add_Nav_Url(nav);
		}	
	}
}
