package com.coll.util;

/**
 * 判断中英文字符类
 * ClassName: JudgmentCE 
 * @Description: TODO
 * @author liwengbincoll@foxmail.com
 * @date 2017年12月26日
 */
public class JudgmentCE {

	/**
	 * 根据Unicode编码完美的判断中文汉字和符号
	 * @Description: TODO
	 * @param @param c
	 * @param @return   
	 * @return boolean  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017年12月26日
	 */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS 
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A 
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION 
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }
    
    /**
     * 根据UnicodeBlock方法判断中文标点符号
     * @Description: TODO
     * @param @param c
     * @param @return   
     * @return boolean  
     * @throws
     * @author liwengbincoll@foxmail.com
     * @date 2017年12月26日
     */
    public static boolean isChinesePunctuation(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
        if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || ub == Character.UnicodeBlock.VERTICAL_FORMS) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
    
    /**
     * 完整的判断中文汉字和符号
     * 注：如果传入字符串为空则返回false
     * @Description: TODO
     * @param @param str
     * @param @return   
     * @return boolean  
     * @throws
     * @author liwengbincoll@foxmail.com
     * @date 2017年12月26日
     */
    public static boolean isChinese(String str) {
    	if(str != null){
	        char[] ch = str.toCharArray();
	        for (int i = 0; i < ch.length; i++) {
	            char c = ch[i];
	            if (isChinese(c)) {
	                return true;
	            }
	        }
	        return false;
    	}else{
    		return false;
    	}
    }
    
    /**
     * 判断String类型的字符是否为中文符号
     * 注：如果传入字符串为空则返回false,如果传入str.lenght()大于1的字符串只判断第一个字符
     * @Description: TODO
     * @param @param str
     * @param @return   
     * @return boolean  
     * @throws
     * @author liwengbincoll@foxmail.com
     * @date 2017年12月26日
     */
    public static boolean isChinesePunctuation(String str) {
    	if(str != null && isChinesePunctuation(str.toCharArray()[0])){
    		return true;
    	}else{
    		return false;
    	}
    }
}