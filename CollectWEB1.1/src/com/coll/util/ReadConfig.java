package com.coll.util;

import com.coll.exception.NotfondException;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

/**
 * ��.properties/.xml�ļ�����Ϣ
*@author:liwengbincoll@foxmail.com
*@date:2017/10/25 0025 16:26
*@explain:
*/

public class ReadConfig {
	
	//static Logger logger = Logger.getLogger(ReadConfig.class);
    /**
     * ��ȡ.properties�ļ�
     * @param filename �����ļ�·��eg:[src/config/sys-config.properties]
     */
    public static Properties getProperties(String filename)
    {
        Properties prop = new Properties();
        File file = new File(filename);
        try{
            //��ȡ�����ļ�a.properties
            InputStream in = new FileInputStream(file);
            prop.load(new InputStreamReader(in, "GBK"));     ///���������б�
            Iterator<String> it=prop.stringPropertyNames().iterator();

            System.out.println("=============================��ȡ�������ļ���Ϣ��=============================");
            while(it.hasNext()){
                String key=it.next();
                System.out.println(key+":"+prop.getProperty(key));
            }
            in.close();
        }
        catch(Exception e){
            e.printStackTrace();
            throw new NotfondException("�Ҳ�����Դ��");
        }
        return prop;
    }
}
