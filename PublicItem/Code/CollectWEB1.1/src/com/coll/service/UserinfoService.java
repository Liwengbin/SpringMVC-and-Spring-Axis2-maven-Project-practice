package com.coll.service;

import com.coll.model.UserinfoModel;

public interface UserinfoService {
	public UserinfoModel CheckUser(String user_email,String user_password);
	
	/**
	 * 注册检测，检测账号是否存在(不存在返回true,存在返回false)
	 * @Description: TODO
	 * @param @param userinfoModel
	 * @param @return
	 * @return Boolean  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017年12月8日
	 */
	public Boolean CheckSign(UserinfoModel userinfoModel);
	
	public void addUserInfo(UserinfoModel user);
	
	public UserinfoModel getUserInfo(String email);
}
