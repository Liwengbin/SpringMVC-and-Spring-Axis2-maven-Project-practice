package com.coll.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface DivideService {
	/**
	 * �������ı��ִ�
	 * @Description: TODO
	 * @param @param context
	 * @param @return   
	 * @return String[]  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��26��
	 */
	public List<?> getDivideWorde(String context);
	
	/**
	 * �����ϴ��ִ�
	 * @Description: TODO
	 * @param @param contexts
	 * @param @return   
	 * @return List<String>
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��26��
	 */
	public List<String> getDivideWorde(String[] contexts);
}
