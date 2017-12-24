package com.coll.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coll.exception.DataException;
import com.coll.model.BehaviorModel;
import com.coll.model.UrlModel;
import com.coll.model.UrllistModel;
import com.coll.service.UrlContentServiceImpl;
import com.coll.service.UserinfoServiceImpl;
import com.coll.service.WebServiceBean;
import com.coll.util.Tools;

/**
 * �����¼�������
*@author:liwengbincoll@foxmail.com
*@date:2017/10/24 0024 10:17
*@explain:
*/
@Controller
@RequestMapping("sec")
public class SecurityController {
	Logger logger = Logger.getLogger(SecurityController.class);
	
	@Autowired
	private UrlContentServiceImpl urlContentServiceImpl;
	@Autowired
	private UserinfoServiceImpl userinfoServiceImpl;
	@Autowired
	private WebServiceBean webServiceBean;
    /**
     * ��ת������ҳ������Ϣ
     *@path:com.coll.control/feedback
     *@parame:[]
     *@return:java.lang.String
     */
    @RequestMapping(value = "tofeedback",method = RequestMethod.GET)
    public String to_feedback()
    {
    	logger.info("=============================tofeedback===============================");
        return "collfeedback";
    }
    
    @RequestMapping(value = "client", method = RequestMethod.GET)
	public String client(ModelMap model) {
		logger.info("=============================��ת��ע��ҳ��===============================");
		
		return "client";
	}
    
    @RequestMapping(value = "userdata", method = RequestMethod.GET)
   	public String userdata(HttpSession session,ModelMap model) {
   		logger.info("=============================��ת���û���Ϣҳ��===============================");
   		model.addAttribute("userinfo",userinfoServiceImpl.getUserInfo("2768559446@qq.com"));
   		model.addAttribute("user", userinfoServiceImpl.getUserInfo((String) session.getAttribute("user_email")));
   		return "userdata";
   	}
    
    @RequestMapping(value = "logout", method = RequestMethod.GET)
   	public String logout(HttpSession session) {
   		logger.info("=============================ע����½logout===============================");
   		session.removeAttribute("user_email");
   		return "redirect:../pub/collnav";
   	} 
    
    /**
     * ��ҳ�ղ�ҳ��
     *@path:com.coll.control/collpage
     *@parame:[]
     *@return:java.lang.String
     */
    @RequestMapping(value = "collpage",method = RequestMethod.GET)
    public String collpage(HttpSession session,HttpServletRequest request, HttpServletResponse response,ModelMap model)
    {
    	logger.info("=============================��ҳ�ղ�ҳ��===============================");
    	List<UrllistModel> list = urlContentServiceImpl.load_one_AllUrl((String) session.getAttribute("user_email"));
    	model.addAttribute("user", userinfoServiceImpl.getUserInfo((String) session.getAttribute("user_email")));
    	model.addAttribute("list",list);
    	return "collpage";
    			//new ModelAndView("collpage", "list", list);
    }
    
    /**
	 * ajaxt��ӷ�����ַ��Ϣ
	 *
	 * @path:com.coll.control
	 * @parame:[]
	 * @return:java.lang.String
	 */
	@RequestMapping(value = "ajaxhavior",produces={"text/html;charset=UTF-8;"}, method = RequestMethod.GET)
	public @ResponseBody String ajaxhavior(HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		logger.info("=============================ajaxt��ӷ�����ַ��Ϣ===============================");
		String haviorurlid = request.getParameter("haviorurlid");
		logger.info("��ӱ�������ַ"+haviorurlid);
		String msg="true";
		BehaviorModel behavior = new BehaviorModel();
		String email = (String) session.getAttribute("user_email");
		if(email != null)
		{
			try{
				behavior.setUrl_id(haviorurlid);
				behavior.setUser_email(email);
				urlContentServiceImpl.addBehavior(behavior);
			}catch(DataException e){
				msg=e.getMessage();
				logger.info(msg);
				return msg;
			}catch(Exception ex){
				msg="��¼�쳣��";
			}
		}
		return msg;
	}
	
	/**
	 * �첽��ȡ��ҳ��Ϣ
	 * @Description: TODO
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return String  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��8��
	 */
	@RequestMapping(value = "htmlMeta",produces={"text/html;charset=UTF-8;"}, method = RequestMethod.GET)
	public @ResponseBody String ajaxgetHtmlMeta(HttpServletRequest request,HttpServletResponse response) {
		logger.info("=============================ajax�Զ���ȡ��ҳtitle��logo===============================");
		String url = request.getParameter("url");
		logger.info("������ַ="+url);
		String jsonMeta = webServiceBean.getAllServicePortType().getHtmlMeta(url);
		return jsonMeta;
	}
	
	/**
	 * �ύ��ַ
	 * @Description: TODO
	 * @param @param session
	 * @param @param request
	 * @param @param response
	 * @param @return
	 * @return String  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��8��
	 */
	@RequestMapping(value = "addurl",produces={"text/html;charset=UTF-8;"}, method = RequestMethod.POST)
	public @ResponseBody String ajaxaddUrl(HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		logger.info("=============================ajax�����ַ===============================");
		String urlstrdata = request.getParameter("urlJsondata");
		JSONObject urljsonobj = JSONObject.fromObject(urlstrdata);
		
		String msg="true";

		String email = (String) session.getAttribute("user_email");
		
		try{
			UrlModel urlModel = new UrlModel();
			urlModel.setUrl_id("url_"+Tools.creatUUID());
			urlModel.setFather(false);
			urlModel.setHref(urljsonobj.getString("href"));
			urlModel.setLoction(Integer.valueOf(urljsonobj.getString("loction")));
			urlModel.setLogo(urljsonobj.getString("logo"));
			urlModel.setSize(1);
			urlModel.setTitle(urljsonobj.getString("title"));
			urlModel.setUser_email(email);
			urlContentServiceImpl.addUrl(urlModel);
			logger.info("�����ַ"+urlstrdata+"�ɹ���");
		}catch(DataException e){
			msg=e.getMessage();
			logger.info(msg);
			return msg;
		}catch(Exception ex){
			msg="��������쳣��";
			ex.getStackTrace();
			return msg;
		}
		return msg;
	}
}
