package com.coll.service;

import org.springframework.stereotype.Service;

@Service
public interface TransformService {
	/**
	 * ����ͼƬ��ַ����base64��ʽ����ַ������쳣�򷵻�null
	 * @Description: TODO
	 * @param @param imgAddress
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��26��
	 */
	public String getImgBase64(String imgAddress);
}
