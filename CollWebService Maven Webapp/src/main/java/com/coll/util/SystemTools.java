package com.coll.util;

import java.util.UUID;

/**
 * ϵͳ������
 * ClassName: SystemTools 
 * @Description: TODO
 * @author liwengbincoll@foxmail.com
 * @date 2017��12��26��
 */
public class SystemTools {
	/**
	 * ��������Ψһ��ʶUUID
	 * @Description: TODO
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��25��
	 */
	public static String getUUID(){
		String uuid = null;
		for(int i=0;i<10;i++){
			 uuid = UUID.randomUUID().toString().replaceAll("-", "");
			}
		return uuid;
	}
	
}
