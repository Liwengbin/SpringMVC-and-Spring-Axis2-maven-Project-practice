package com.coll.util;

/**
 * �ж���Ӣ���ַ���
 * ClassName: JudgmentCE 
 * @Description: TODO
 * @author liwengbincoll@foxmail.com
 * @date 2017��12��26��
 */
public class JudgmentCE {

	/**
	 * ����Unicode�����������ж����ĺ��ֺͷ���
	 * @Description: TODO
	 * @param @param c
	 * @param @return   
	 * @return boolean  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��26��
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
     * ����UnicodeBlock�����ж����ı�����
     * @Description: TODO
     * @param @param c
     * @param @return   
     * @return boolean  
     * @throws
     * @author liwengbincoll@foxmail.com
     * @date 2017��12��26��
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
     * �������ж����ĺ��ֺͷ���
     * ע����������ַ���Ϊ���򷵻�false
     * @Description: TODO
     * @param @param str
     * @param @return   
     * @return boolean  
     * @throws
     * @author liwengbincoll@foxmail.com
     * @date 2017��12��26��
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
     * �ж�String���͵��ַ��Ƿ�Ϊ���ķ���
     * ע����������ַ���Ϊ���򷵻�false,�������str.lenght()����1���ַ���ֻ�жϵ�һ���ַ�
     * @Description: TODO
     * @param @param str
     * @param @return   
     * @return boolean  
     * @throws
     * @author liwengbincoll@foxmail.com
     * @date 2017��12��26��
     */
    public static boolean isChinesePunctuation(String str) {
    	if(str != null && isChinesePunctuation(str.toCharArray()[0])){
    		return true;
    	}else{
    		return false;
    	}
    }
}