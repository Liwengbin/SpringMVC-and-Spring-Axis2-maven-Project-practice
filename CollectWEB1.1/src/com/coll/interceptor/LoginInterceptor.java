package com.coll.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ��¼������
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
        //��ȡSession  
        HttpSession session = request.getSession();
        String user_email = (String) session.getAttribute("user_email"); 
        logger.info("===============================��¼��֤:"+user_email+"�û�====================================");
        if(user_email != null){
            return true;
        }
      //��ȡ�����URL  
        String url = request.getRequestURI();
        //�����������ģ���ת����¼����  
        request.getRequestDispatcher("../pub/login?topage="+url).forward(request, response);  
          
        return false;
	}

}
