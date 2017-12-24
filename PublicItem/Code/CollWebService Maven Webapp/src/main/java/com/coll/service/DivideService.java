package com.coll.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface DivideService {
	/**
	 * 给参数文本分词
	 * @Description: TODO
	 * @param @param context
	 * @param @return   
	 * @return String[]  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017年12月26日
	 */
	public List<?> getDivideWorde(String context);
	
	/**
	 * 批量上传分词
	 * @Description: TODO
	 * @param @param contexts
	 * @param @return   
	 * @return List<String>
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017年12月26日
	 */
	public List<String> getDivideWorde(String[] contexts);
}
