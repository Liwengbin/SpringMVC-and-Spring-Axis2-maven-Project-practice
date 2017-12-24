package com.coll.serviceImpl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coll.model.HtmlMetaModel;
import com.coll.service.HtmlService;
import com.sun.istack.internal.logging.Logger;

/**
 * 将给定网址，提取出title,logo,网页关键词的类
 * ClassName: HtmlServiceImpl 
 * @Description: TODO
 * @author liwengbincoll@foxmail.com
 * @date 2017年12月26日
 */
@Service
public class HtmlServiceImpl implements HtmlService{
	private Logger logger = Logger.getLogger(HtmlServiceImpl.class);
	@Autowired
	public TransformServiceImpl transformServiceImpl;
	
	@Autowired
	public DivideServiceImpl divideServiceImpl;
	
	public HtmlMetaModel getHtmlAnalysis(String href) {
		HtmlMetaModel htmlMetaModel = new HtmlMetaModel();
		String title = getTitle(href);
		htmlMetaModel.setTitle(title);
		htmlMetaModel.setIcoBase64(transformServiceImpl.getImgBase64(getImgAddress(href)));
		htmlMetaModel.setKeyWord(divideServiceImpl.getDivideWorde(title));
		
		return htmlMetaModel;
	}
	
	/**
	 * 提取title
	 * @Description: TODO
	 * @param @param href
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017年12月26日
	 */
	private String getTitle(String href) {
			String title = null;
			URL url = null;
			
			try {
				url = new URL(href);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			try{
				HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
				Parser parser = new Parser(httpURLConnection);
				NodeFilter filter_title = new TagNameFilter ("TITLE");
				NodeList nodes_title = parser.extractAllNodesThatMatch(filter_title);
	
				if(nodes_title.size() !=0) {
	                   Node textnode_title = (Node) nodes_title.elementAt(0);
	                   title=textnode_title.toPlainTextString();
				}
			} catch (ParserException e) {
				e.printStackTrace();
				return null;
			} catch (IOException e1) {
				e1.printStackTrace();
				return null;
			}
		return title;
	}
	
	/**
	 * 提取icon地址
	 * @Description: TODO
	 * @param @param href
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017年12月26日
	 */
	private String getImgAddress(String href){
		URL url = null;
		String imgAddress = null;
		
		try {
			url = new URL(href);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try{
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			Parser parser = new Parser(httpURLConnection);

			NodeFilter filter_icon1 = new HasAttributeFilter("rel","shortcut icon");
			NodeFilter filter_icon2 = new HasAttributeFilter("rel","SHORTCUT ICON");
			NodeFilter filter_icon = new OrFilter(filter_icon1, filter_icon2);
			NodeList nodes_icon = parser.extractAllNodesThatMatch(filter_icon);
			
			if(nodes_icon.size() !=0) {
                   Node textnode_icon = (Node) nodes_icon.elementAt(0);
                   String pattern= ".*href=\"(.*?)\"";
                   try{
	                    Pattern p = Pattern.compile(pattern, 2 | Pattern.DOTALL); 
	                    Matcher m = p.matcher(textnode_icon.getText());
	                    if(m.find()){
	                    	String uri = m.group(1);
	                    	if(uri != null && "http".equalsIgnoreCase(uri.substring(0, 4)))
	                    	{
	                    		imgAddress = uri;
	                    	}
	                    	else if(uri != null && "//".equals(uri.substring(0, 2)))
	                    	{
	                    		imgAddress = url.getProtocol()+":"+uri;
	                    	}else{
	                    		int index = uri.indexOf("/");
	                    		imgAddress = url.getProtocol()+"://"+url.getHost()+uri.substring(index);
	                    	}
	                    }
	                    
                   }catch(Exception e){
                   	e.getStackTrace();
                   	return null;
                   }
           }else{
        	   imgAddress = url.getProtocol()+"://"+url.getHost()+"/favicon.ico";
           }
		} catch (ParserException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
		logger.info("取到icon地址="+imgAddress);
		return imgAddress;
	}
}
