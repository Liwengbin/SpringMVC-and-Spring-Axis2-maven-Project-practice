package com.coll.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coll.dao.UserinfoDaoImpl;
import com.coll.exception.DataException;
import com.coll.model.UserinfoModel;


@Service
public class UserinfoServiceImpl implements UserinfoService{
	Logger logger = Logger.getLogger(UserinfoServiceImpl.class);
	
	@Autowired
	private UserinfoDaoImpl userinfoDaoImpl;
	/**
	 * 验证密码是否正确
	 */
	
	@Override
	public UserinfoModel CheckUser(String user_email,String user_password) {
		
		UserinfoModel userinfoModel = userinfoDaoImpl.getUserInfo(user_email);
		if(user_password == null)
		{
			throw new DataException("用户密码为空！");
		}
		else if(userinfoModel == null)
		{
			throw new DataException("用户不存在！");
		}
		else if(user_password.equals(userinfoModel.getUser_password()) == false)
		{
			throw new DataException("密码错误！");
		}
		return userinfoModel;
	}

	@Override
    public void addUserInfo(UserinfoModel user){
		if(CheckSign(user)){
			userinfoDaoImpl.addUserInfo(user);
		}
		else {
			throw new DataException("用户存在,请重新注册！");
		}
	}
	
	public Boolean CheckSign(UserinfoModel userinfoModel) {
		
		UserinfoModel userdb = userinfoDaoImpl.getUserInfo(userinfoModel.getUser_email());
		if(userdb != null)
		{
			return false;
		}
		else
		{
			return true;
		}	
	}

	/**
	 * 查询用户资料
	 */
	@Override
	public UserinfoModel getUserInfo(String email) {
		logger.info("查询用户资料");
		UserinfoModel userinfoModel = userinfoDaoImpl.getUserInfo(email);
		userinfoModel.setUser_catitmodel(userinfoDaoImpl.loadUserCatit(email,"2"));
		
		return userinfoModel;
	}

}
