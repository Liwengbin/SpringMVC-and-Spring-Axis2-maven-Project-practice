package com.coll.service;

import org.springframework.stereotype.Service;

@Service
public interface TransformService {
	/**
	 * 给定图片地址返回base64格式，地址或程序异常则返回null
	 * @Description: TODO
	 * @param @param imgAddress
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017年12月26日
	 */
	public String getImgBase64(String imgAddress);
}
