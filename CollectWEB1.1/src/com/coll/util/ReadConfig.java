package com.coll.util;

import com.coll.exception.NotfondException;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

/**
 * 读.properties/.xml文件的信息
*@author:liwengbincoll@foxmail.com
*@date:2017/10/25 0025 16:26
*@explain:
*/

public class ReadConfig {
	
	//static Logger logger = Logger.getLogger(ReadConfig.class);
    /**
     * 读取.properties文件
     * @param filename 配置文件路径eg:[src/config/sys-config.properties]
     */
    public static Properties getProperties(String filename)
    {
        Properties prop = new Properties();
        File file = new File(filename);
        try{
            //读取属性文件a.properties
            InputStream in = new FileInputStream(file);
            prop.load(new InputStreamReader(in, "GBK"));     ///加载属性列表
            Iterator<String> it=prop.stringPropertyNames().iterator();

            System.out.println("=============================读取的配置文件信息！=============================");
            while(it.hasNext()){
                String key=it.next();
                System.out.println(key+":"+prop.getProperty(key));
            }
            in.close();
        }
        catch(Exception e){
            e.printStackTrace();
            throw new NotfondException("找不到资源！");
        }
        return prop;
    }
}
