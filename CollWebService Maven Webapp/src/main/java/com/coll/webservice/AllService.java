package com.coll.webservice;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coll.service.DivideService;
import com.coll.service.HtmlService;
import com.coll.service.TransformService;
/**
 * coll�����ࣨ��ҳ��Ϣ��ȡ���񣬷ִʷ���תbase64����
 * ClassName: AllService 
 * @Description: TODO
 * @author liwengbincoll@foxmail.com
 * @date 2017��12��7��
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
	 * ���طִʽ��
	 * @Description: TODO
	 * @param String context
	 * @param @return   
	 * @return String
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��25��
	 */
	public String getDivideWord(String context){
		
		return JSONArray.fromObject(divideService.getDivideWorde(context)).toString();
	}
	
	/**
	 * �����ϴ����зִ�
	 * @Description: TODO
	 * @param String[] context
	 * @param @return   
	 * @return String  
	 * 
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��26��
	 */
	public String getArrayDivideWords(String[] context){
		
		return JSONArray.fromObject(divideService.getDivideWorde(context)).toString();
	}
	
	
	/**
	 * ���ط������HTMLMETA����
	 * @Description: TODO
	 * @param @param url
	 * @param @return 
	 * @return String
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��25��
	 */
	public String getHtmlMeta(String href){
		return JSONArray.fromObject(htmlService.getHtmlAnalysis(href)).toString();
	}
	
	
	/**
	 * ��������ַ�е�ͼƬתΪbase64��ʽ,�����ַ�����򷵻�null
	 * @Description: TODO
	 * @param @param imgAdress
	 * @param @return
	 * @return String
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��25��
	 */
	public String getBase64(String imgAddress){
		return transformService.getImgBase64(imgAddress);
	}
}
