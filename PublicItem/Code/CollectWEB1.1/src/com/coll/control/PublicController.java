package com.coll.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.coll.exception.DataException;
import com.coll.model.NavModel;
import com.coll.model.UserinfoModel;
import com.coll.service.UrlContentServiceImpl;
import com.coll.service.UserinfoServiceImpl;


/**
 * @Author:liwengbincoll@foxmail.com
 * @Date:Created in 2017/10/21 0021 13:53
 * @explain:
 */
@Controller
@RequestMapping("/pub")
public class PublicController {

	Logger logger = Logger.getLogger(PublicController.class);

	@Autowired
	private UrlContentServiceImpl urlContentServiceImpl;

	@Autowired
	private UserinfoServiceImpl userinfoServiceImpl;

	/**
	 * @path com.coll.control/PublicController
	 * @parem [model]
	 * @return java.lang.String
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		System.out.println("=============================index===============================");
		//File fi = new File(PathsysConfig.importFile);
		//urlContentServiceImpl.importMenu(fi, "2768559446@qq.com");
		return "index";
	}

	@RequestMapping(value = "sign", method = RequestMethod.GET)
	public ModelAndView sign(ModelMap model) {
		logger.info("=============================跳转到注册页面===============================");
		return new ModelAndView("sign", "command", new UserinfoModel());
	}

	@RequestMapping(value = "collnav", method = RequestMethod.GET)
	public String collnav(HttpSession session,ModelMap model) {
		logger.info("=============================跳转到collnav页面===============================");
		String email = (String) session.getAttribute("user_email");
		if(email != null){
			model.addAttribute("user", userinfoServiceImpl.getUserInfo(email));
		}
		
		List<NavModel> list = urlContentServiceImpl.load_Nav();
		model.addAttribute("list", list);
    	return "collnav";
	}
	
	@RequestMapping(value = "feedback", method = RequestMethod.GET)
	public String feedback(ModelMap model) {
		logger.info("=============================跳转到feedback页面===============================");
		
		return "feedback";
	}
	
	/**
	 * 注册
	 *
	 * @path:com.coll.control/feedback
	 * @parame:[]
	 * @return:java.lang.String
	 */
	@RequestMapping(value = "sign/adduser", method = RequestMethod.POST)
	public String sign_adduser(@ModelAttribute UserinfoModel userinfoModel,
			ModelMap modelMap) {
		logger.info("=============================注册新用户===============================");
		userinfoServiceImpl.addUserInfo(userinfoModel);
		logger.info("新用户:" + userinfoModel.toString());
		return "redirect:../login";
	}

	/**
	 * 跳转到登录页面
	 *
	 * @path:com.coll.control/login
	 * @parame:[]
	 * @return:java.lang.String
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(ModelMap modelMap,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		logger.info("=============================跳转到登录页面===============================");
		//获取请求的URL  
        String url = request.getParameter("topage");
        
        logger.info(url);
		modelMap.addAttribute("forword", url);
		if(session.getAttribute("user_email")== null)
		{
		return "login";
		}
		else{
			return "redirect:../sec/collpage";
		}
	}
	
	/**
	 * ajax检查登录信息登录
	 *
	 * @path:com.coll.control/ajaxlogin
	 * @parame:[]
	 * @return:java.lang.String
	 */
	@RequestMapping(value = "ajaxlogin",produces={"text/html;charset=UTF-8;","application/json;"}, method = RequestMethod.POST)
	public @ResponseBody String ajaxlogin(HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		logger.info("=============================ajax检查登录信息登录===============================");
		String logindata = request.getParameter("logindata");
		String msg="true";
		@SuppressWarnings("rawtypes")
		Map mapTypes = new HashMap<Object, Object>();
		try{
		mapTypes = JSON.parseObject(logindata);
		UserinfoModel user = new UserinfoModel();
		user=userinfoServiceImpl.CheckUser((String)mapTypes.get("user_email"), (String)mapTypes.get("user_password"));
		
		/*登录成功存session供拦截器使用*/
		session.setAttribute("user_email", user.getUser_email());
		}catch(DataException e){
			msg=e.getMessage();
			return msg;
		}catch(Exception ex){
			msg="登录异常！";
		}
		return msg;
	}

	/**
	 * 接收异步请求检查用户是否存在
	 *
	 * @path:com.coll.control/signcheck
	 * @parame:[]
	 * @return:java.lang.String
	 */
	@RequestMapping(value = "signcheck", method = RequestMethod.GET)
	public @ResponseBody String signcheck(HttpServletRequest request,HttpServletResponse response) {
		logger.info("=============================接收异步请求检查用户是否存在===============================");
		UserinfoModel user = new UserinfoModel();
		user.setUser_email(request.getParameter("user_email"));
		if (userinfoServiceImpl.CheckSign(user)) {
			return "true";
		} else {
			return "false";
		}
	}
	
	@RequestMapping(value = "uc", method = RequestMethod.GET)
	public String adduc(HttpServletRequest request) {
		System.out.println("=============================adduc===============================");
		//int type_id =Integer.valueOf(request.getParameter("type"));
		//urlContentServiceImpl.add_Nav_Url(type_id);
		return "index";
	}
}
