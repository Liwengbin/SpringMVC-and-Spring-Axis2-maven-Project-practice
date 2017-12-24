package com.coll.service;

import org.springframework.stereotype.Service;

import com.coll.webservice.AllService;
import com.coll.webservice.AllServicePortType;

/**
 * web�����װ��
 * ClassName: WebServiceBean 
 * @Description: TODO
 * @author liwengbincoll@foxmail.com
 * @date 2017��12��8��
 */
@Service
public class WebServiceBean {
	private AllService allService = new AllService();
	
	/**
	 * ����AllService����AllServicePortType
	 * @Description: TODO
	 * @param @return
	 * @return AllServicePortType  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��8��
	 */
	public AllServicePortType getAllServicePortType() {
		return allService.getAllServiceHttpSoap11Endpoint();
	}
	
}
