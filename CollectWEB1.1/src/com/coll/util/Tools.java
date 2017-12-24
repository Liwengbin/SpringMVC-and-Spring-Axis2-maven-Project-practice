package com.coll.util;

import java.util.Date;
import java.util.UUID;

/**
 * 系统工具类
 * @author Administrator
 *
 */

public class Tools {
	/**
	 * 创建id
	 * @return
	 */
	public static String creatUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
	
	public static Date sysTIME(){
		Date day=new Date();
		return day;
	}
}
