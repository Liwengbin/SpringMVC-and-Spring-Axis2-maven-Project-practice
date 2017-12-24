package com.coll.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录拦截器
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor{
	Logger logger = Logger.getLogger(LoginInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse httpServletResponse, Object object, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object object, ModelAndView modelAndview) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {  
        //获取Session  
        HttpSession session = request.getSession();
        String user_email = (String) session.getAttribute("user_email"); 
        logger.info("===============================登录验证:"+user_email+"用户====================================");
        if(user_email != null){
            return true;
        }
      //获取请求的URL  
        String url = request.getRequestURI();
        //不符合条件的，跳转到登录界面  
        request.getRequestDispatcher("../pub/login?topage="+url).forward(request, response);  
          
        return false;
	}

}
