package com.coll.webservice;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coll.service.DivideService;
import com.coll.service.HtmlService;
import com.coll.service.TransformService;
/**
 * coll服务类（网页信息提取服务，分词服务，转base64服务）
 * ClassName: AllService 
 * @Description: TODO
 * @author liwengbincoll@foxmail.com
 * @date 2017年12月7日
 */
@Service("AllService")
public class AllService {
	@Autowired
	private DivideService divideService;
	@Autowired
	private HtmlService htmlService;
	@Autowired
	private TransformService transformService;
	/**
	 * 返回分词结果
	 * @Description: TODO
	 * @param String context
	 * @param @return   
	 * @return String
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017年12月25日
	 */
	public String getDivideWord(String context){
		
		return JSONArray.fromObject(divideService.getDivideWorde(context)).toString();
	}
	
	/**
	 * 批量上传进行分词
	 * @Description: TODO
	 * @param String[] context
	 * @param @return   
	 * @return String  
	 * 
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017年12月26日
	 */
	public String getArrayDivideWords(String[] context){
		
		return JSONArray.fromObject(divideService.getDivideWorde(context)).toString();
	}
	
	
	/**
	 * 返回分析后的HTMLMETA对象
	 * @Description: TODO
	 * @param @param url
	 * @param @return 
	 * @return String
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017年12月25日
	 */
	public String getHtmlMeta(String href){
		return JSONArray.fromObject(htmlService.getHtmlAnalysis(href)).toString();
	}
	
	
	/**
	 * 将给定地址中的图片转为base64格式,如果地址错误则返回null
	 * @Description: TODO
	 * @param @param imgAdress
	 * @param @return
	 * @return String
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017年12月25日
	 */
	public String getBase64(String imgAddress){
		return transformService.getImgBase64(imgAddress);
	}
}
