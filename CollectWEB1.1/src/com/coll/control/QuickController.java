package com.coll.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coll.model.QuickModel;
import com.coll.model.UrlquickModel;
import com.coll.service.QuickServiceImpl;
import com.coll.util.Tools;

@Controller
@RequestMapping("/q")
public class QuickController {
	Logger logger = Logger.getLogger(QuickController.class);
	@Autowired
	private QuickServiceImpl quickServiceImpl;
	
	/**
	 * 异步验证quick_id
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/checkquick",produces={"text/html;charset=UTF-8;","application/json;"}, method = RequestMethod.GET)
	public @ResponseBody String checkQuick(ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		System.out.println("=============================checkQuick===============================");
		
		String quick_id = request.getParameter("quick_id");
		if(quickServiceImpl.checkQuid(quick_id)){
			QuickModel quickModel =quickServiceImpl.loadQuick(quick_id);
			session.setAttribute("QuickModel", quickModel);
			return "true";
		}else{
			return "false";
		}
	}
	
	/**
	 * 请求quick页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model,HttpSession session) {
		System.out.println("=============================quickindex===============================");
		QuickModel quiclModel = (QuickModel)session.getAttribute("QuickModel");
		List<UrlquickModel> list = null;
		if(quiclModel !=null){
		list = quickServiceImpl.loadUrlQuick(quiclModel.getTag(), null);
		}
		model.addAttribute("list",list);
		model.addAttribute("QuickModel",quiclModel);
		return "quickindex";
	}
	
	/**
	 * 注销quick用户
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/out", method = RequestMethod.GET)
	public String out(ModelMap model,HttpSession session) {
		System.out.println("=============================注销quick===============================");
		session.removeAttribute("QuickModel");
		return "redirect:index";
	}
	
	/**
	 * 添加网址页面
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/add",produces={"text/html;charset=UTF-8;","application/json;"}, method = RequestMethod.GET)
	public @ResponseBody String add(ModelMap model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		System.out.println("=============================addquic===============================");
		String msg = "添加成功！";
		String href = request.getParameter("href");
		String title = request.getParameter("title");
		QuickModel quickModel = (QuickModel)session.getAttribute("QuickModel");
		try{
		if(quickModel != null){
		UrlquickModel urlquick = new UrlquickModel("q_"+Tools.creatUUID(), href, title, Tools.sysTIME(), quickModel.getTag());
		quickServiceImpl.addUrlQuick(urlquick);
		}
		}catch(Exception e){
			msg="系统异常";
			model.addAttribute("msg",msg);
			return "false";
		}
		model.addAttribute("msg",msg);
		return "true";
	}
	
	/**
	 * 删除网址页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delete",produces={"text/html;charset=UTF-8;","application/json;"}, method = RequestMethod.GET)
	public @ResponseBody String delete(HttpServletRequest request,HttpServletResponse response) {
		logger.info("=============================删除quickurl===============================");
		try{
			quickServiceImpl.deleteUrlQuick(request.getParameter("url_id").trim());
		}catch(Exception e){
			e.getStackTrace();
			return "false";
		}
		return "true";
	}
	
}