package com.coll.service;

import org.springframework.stereotype.Service;

import com.coll.model.HtmlMetaModel;
@Service
public interface HtmlService {
	/**
	 * ������ҳ��Ϣ�����title,logo,keyword�ֶ�
	 * @Description: TODO
	 * @param @param href
	 * @param @return   
	 * @return htmlMetaModel 
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��26��
	 */
	public HtmlMetaModel getHtmlAnalysis(String url);
}
