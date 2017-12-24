package com.coll.service;

import org.springframework.stereotype.Service;

import com.coll.model.HtmlMetaModel;
@Service
public interface HtmlService {
	/**
	 * 返回网页信息类包含title,logo,keyword字段
	 * @Description: TODO
	 * @param @param href
	 * @param @return   
	 * @return htmlMetaModel 
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017年12月26日
	 */
	public HtmlMetaModel getHtmlAnalysis(String url);
}
