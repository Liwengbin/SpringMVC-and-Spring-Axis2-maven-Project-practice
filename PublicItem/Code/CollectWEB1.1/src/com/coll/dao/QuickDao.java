package com.coll.dao;

import java.util.ArrayList;

import com.coll.model.QuickModel;
import com.coll.model.UrlquickModel;

public interface QuickDao {
	/**
	 * 添加快速查询用户
	 * @param quickModel
	 */
	public void addQuick(QuickModel quickModel);
	
	/**
	 * 修改用户
	 * @param quick_id
	 */
	public void updataQuick(String quick_id);
	
	/**
	 * 查询快速查询用户
	 * @param quick_id
	 * @return
	 */
	public QuickModel loadQuick(String quick_id);
	
	/**
	 * 添加快速url
	 * @param urlquick
	 */
	public void addUrlQuick(UrlquickModel urlquick);
	
	/**
	 * 修改url
	 * @param urlquick
	 */
	public void updataUrlQuick(UrlquickModel urlquick);
	
	/**
	 * 返回url列表按时间排序
	 * @param quick_tag
	 * @param word
	 * @return Arraylist
	 */
	public ArrayList<UrlquickModel> loadUrlQuick(int quick_tag, String word);
	
	/**
	 * 删除url
	 * @param url_id
	 */
	public void deleteUrlQuick(String url_id);
}
