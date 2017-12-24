package com.coll.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

import com.coll.service.DivideService;
import com.coll.util.JudgmentCE;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.CRF.CRFSegment;
import com.hankcs.hanlp.seg.common.Term;

/**
 * �ִ���
 * ClassName: DivideServiceImpl 
 * @Description: TODO
 * @author liwengbincoll@foxmail.com
 * @date 2017��12��26��
 */
@Service
public class DivideServiceImpl implements DivideService{
	
	public List<?> getDivideWorde(String context) {		
		HanLP.Config.ShowTermNature = false; // �رմ�����ʾ
        Segment segment = new CRFSegment().enableCustomDictionary(false);
        
        List<Term> termList =null;
        List<String> keywords = new ArrayList<String>();
        termList = segment.seg(context);
        for(Term tem:termList){
        	String temstr = tem.toString();
        	if(JudgmentCE.isChinese(temstr)){
        		if(!JudgmentCE.isChinesePunctuation(temstr) && temstr.length() >=2){
        			keywords.add(temstr);
        		}
        	}else{
        		if(temstr.length() >=2){
        			keywords.add(temstr);
        		}
        	}
        }

        /**
         * �ڴ�CookBook:
         * HanLP�ڲ������ܵ��ڴ�أ�����ͬһ��CRFģ�ͣ�ģ���ļ�·����Ϊid���֣���ֻҪ��û���ͷŻ����ڴ���㣬�Ͳ������¼��ء�
         */
        for (int i = 0; i < 5; ++i)
        {
            segment = new CRFSegment();
        }
		return keywords;
	}
	
	public List<String> getDivideWorde(String[] contexts) {
		List<String> list_keywords = new ArrayList<String>();
		for(String context:contexts){
			list_keywords.add(JSONArray.fromObject(getDivideWorde(context)).toString());
		}
		return list_keywords;
	}
}
