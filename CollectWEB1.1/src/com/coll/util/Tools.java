package com.coll.util;

import java.util.Date;
import java.util.UUID;

/**
 * ϵͳ������
 * @author Administrator
 *
 */

public class Tools {
	/**
	 * ����id
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
