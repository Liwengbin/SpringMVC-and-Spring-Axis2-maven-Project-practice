package com.coll.service;

import org.springframework.stereotype.Service;

import com.coll.webservice.AllService;
import com.coll.webservice.AllServicePortType;

/**
 * web服务封装类
 * ClassName: WebServiceBean 
 * @Description: TODO
 * @author liwengbincoll@foxmail.com
 * @date 2017年12月8日
 */
@Service
public class WebServiceBean {
	private AllService allService = new AllService();
	
	/**
	 * 返回AllService代理AllServicePortType
	 * @Description: TODO
	 * @param @return
	 * @return AllServicePortType  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017年12月8日
	 */
	public AllServicePortType getAllServicePortType() {
		return allService.getAllServiceHttpSoap11Endpoint();
	}
	
}
