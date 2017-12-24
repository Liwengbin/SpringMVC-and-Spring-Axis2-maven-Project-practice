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
 * 分词类
 * ClassName: DivideServiceImpl 
 * @Description: TODO
 * @author liwengbincoll@foxmail.com
 * @date 2017年12月26日
 */
@Service
public class DivideServiceImpl implements DivideService{
	
	public List<?> getDivideWorde(String context) {		
		HanLP.Config.ShowTermNature = false; // 关闭词性显示
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
         * 内存CookBook:
         * HanLP内部有智能的内存池，对于同一个CRF模型（模型文件路径作为id区分），只要它没被释放或者内存充足，就不会重新加载。
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
