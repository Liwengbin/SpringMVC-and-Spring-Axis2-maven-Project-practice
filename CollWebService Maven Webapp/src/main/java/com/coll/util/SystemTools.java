package com.coll.util;

import java.util.UUID;

/**
 * 系统工具类
 * ClassName: SystemTools 
 * @Description: TODO
 * @author liwengbincoll@foxmail.com
 * @date 2017年12月26日
 */
public class SystemTools {
	/**
	 * 工具生成唯一标识UUID
	 * @Description: TODO
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017年12月25日
	 */
	public static String getUUID(){
		String uuid = null;
		for(int i=0;i<10;i++){
			 uuid = UUID.randomUUID().toString().replaceAll("-", "");
			}
		return uuid;
	}
	
}
