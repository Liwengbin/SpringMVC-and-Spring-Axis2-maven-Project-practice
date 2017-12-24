package com.coll.dao;

import java.util.ArrayList;

import com.coll.model.QuickModel;
import com.coll.model.UrlquickModel;

public interface QuickDao {
	/**
	 * ��ӿ��ٲ�ѯ�û�
	 * @param quickModel
	 */
	public void addQuick(QuickModel quickModel);
	
	/**
	 * �޸��û�
	 * @param quick_id
	 */
	public void updataQuick(String quick_id);
	
	/**
	 * ��ѯ���ٲ�ѯ�û�
	 * @param quick_id
	 * @return
	 */
	public QuickModel loadQuick(String quick_id);
	
	/**
	 * ��ӿ���url
	 * @param urlquick
	 */
	public void addUrlQuick(UrlquickModel urlquick);
	
	/**
	 * �޸�url
	 * @param urlquick
	 */
	public void updataUrlQuick(UrlquickModel urlquick);
	
	/**
	 * ����url�б�ʱ������
	 * @param quick_tag
	 * @param word
	 * @return Arraylist
	 */
	public ArrayList<UrlquickModel> loadUrlQuick(int quick_tag, String word);
	
	/**
	 * ɾ��url
	 * @param url_id
	 */
	public void deleteUrlQuick(String url_id);
}
