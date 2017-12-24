package com.coll.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.springframework.stereotype.Component;

import com.coll.model.UrlModel;
import com.coll.model.UrlnavModel;

/**
 * html��ҳ����
 * @author Administrator
 * ������δ��htmllexer.jar/htmlparser.jar
 */
@Component
public class HtmlAnalysis {
	Logger logger = Logger.getLogger(HtmlAnalysis.class);
	private static final String ENCODE = "UTF-8";//�����ʽ
	
	/**
	 * ��ȡ��ҳ����/�û�ͬ���ղؼ�ʱ��Ҫ����������ղؼ��ļ�
	 * @param szFileName
	 * @return
	 */
	public String openHtml(File file ) {
        try {  
            BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(file), ENCODE) );  
            String szContent="";  
            String szTemp;
              
            while ( (szTemp = bis.readLine()) != null) {  
                szContent+=szTemp+"\n";
            }  
            bis.close();  
            return szContent;  
        }
        catch( Exception e ) {  
        	System.out.println(e);
            return "";  
        }  
	}
	
	
	/**
	 * ��ÿһ��htmlת��ΪurlModel����
	 * @param parser
	 * @param textnode
	 * @return
	 */
	public UrlModel Browser(Parser parser, String textnode){
		  String regex360[] ={"LAST_MODIFIED=\"(.*?)\"","HREF=\"(.*?)\"","ADD_DATE=\"(.*?)\"","ICON=\"(.*?)\""};
		  UrlModel urlModel = new UrlModel();
		  urlModel.setFather(false);
		  for(int i=0;i<regex360.length;i++){
			  String regex =regex360[i] ;  
			  
			  System.out.println(regex);
			  final Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);  
			  final Matcher ma = pa.matcher(textnode);
			  while (ma.find()){
			   String str=null;
			   str= ma.group(1);
			   
			   if(i==0){
				      urlModel.setFather(true);
					  final Pattern pa1 = Pattern.compile(">(.*?)</H3>", Pattern.CANON_EQ);  
					  final Matcher ma1 = pa1.matcher(textnode);
					  while (ma1.find()){ 
						  urlModel.setTitle(ma1.group(1)); 
					  }
			   }
			   else if(i==1){
				   urlModel.setHref(str);
				   final Pattern pa2 = Pattern.compile(">(.*?)</A>", Pattern.CANON_EQ);  
					  final Matcher ma2 = pa2.matcher(textnode);
					  while (ma2.find()){ 
						  urlModel.setTitle(ma2.group(1)); 
					  }
			   }
			   else if(i==2){
			   }if(i==3){
					  urlModel.setLogo(str);
				   }
			   	 }
			  }
		  logger.info(urlModel.toString());
		  return urlModel;
	}
	
	/**
	 * �����ȸ�/360������ղؼ�
	 * @param file
	 * @param email
	 * @return 
	 */
	public List<UrlModel> importMenu(File file,String email) {
		String HTML = openHtml(file);
		List<UrlModel> urlModellist = new ArrayList<UrlModel>();

		try{  
            Parser parser = new Parser( HTML );  
           
            NodeFilter filter = new HasAttributeFilter("ADD_DATE");

            NodeList nodes = parser.extractAllNodesThatMatch(filter);

            
            if(nodes!=null) {
            	for (int i = 0; i < nodes.size(); i++) {
            		
            	//logger.info("��ַ����Ŀ"+nodes.size());
            	
            	Node textnode = (Node) nodes.elementAt(i);
            	UrlModel urlModel= null;
            	urlModel=Browser(parser,textnode.toHtml());
            	if(urlModel != null)
            		urlModellist.add(urlModel);
            	}
            }
        }  
        catch( Exception e ) {
        	logger.info(e.getStackTrace());
        }
		return urlModellist;
	}
	
	/**
	 * ����UC����
	 * @return
	 */
	public List<UrlnavModel> getHTML(int type_id){
		UrlnavModel urlnavModel = null;
		List<UrlnavModel> urlnavModels = new ArrayList<UrlnavModel>();		

		try {
			Parser parser = new Parser(rFile.getContext(PathsysConfig.ucFile));
			//���ù�����
			NodeFilter aNodeFilter = new NodeClassFilter(LinkTag.class);
			//ʹ�ù�����
			NodeList nodeList = parser.extractAllNodesThatMatch(aNodeFilter);
			
			//��ȡ�õ�Node���д���  
            for(int i = 0; i<nodeList.size();i++){
                Node node = nodeList.elementAt(i);
                urlnavModel = new UrlnavModel(null, null, null, null, 0, type_id);
                LinkTag link = (LinkTag)node;
                urlnavModel.setHref(link.getLink());
                urlnavModel.setTitle(link.getStringText());
                urlnavModel.setUrl_id("url_"+Tools.creatUUID());
                urlnavModels.add(urlnavModel);
            }
            
		} catch (ParserException e) {
			e.printStackTrace();
		}
		
		return urlnavModels;
	}
}
