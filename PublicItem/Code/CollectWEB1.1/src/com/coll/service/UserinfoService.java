package com.coll.service;

import com.coll.model.UserinfoModel;

public interface UserinfoService {
	public UserinfoModel CheckUser(String user_email,String user_password);
	
	/**
	 * ע���⣬����˺��Ƿ����(�����ڷ���true,���ڷ���false)
	 * @Description: TODO
	 * @param @param userinfoModel
	 * @param @return
	 * @return Boolean  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��8��
	 */
	public Boolean CheckSign(UserinfoModel userinfoModel);
	
	public void addUserInfo(UserinfoModel user);
	
	public UserinfoModel getUserInfo(String email);
}
