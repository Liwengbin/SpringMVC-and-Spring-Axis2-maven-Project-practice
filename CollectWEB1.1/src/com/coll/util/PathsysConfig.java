package com.coll.util;

import java.net.URL;

import org.apache.log4j.Logger;

public class PathsysConfig {
	public static String sys_configpath;
	public static String importFile;
	public static String ucFile;
	static Logger logger = Logger.getLogger(ReadConfig.class);
	
	static {
    	URL resourceURL = PathsysConfig.class.getResource("/config/sys-config.properties");
    	URL resource = PathsysConfig.class.getResource("/config/bookmarks.html");
    	URL resourceUC = PathsysConfig.class.getResource("/config/uc.html");
    	
    	sys_configpath = resourceURL.getFile();
    	importFile = resource.getFile();
    	ucFile = resourceUC.getFile();
    	
        logger.info("=====系统资源路径sys-config.properties="+sys_configpath+"=====");
        logger.info("=====html资源路径bookmarks.html="+importFile+"====");
        logger.info("=====html资源路径uc.html="+ucFile+"====");
	}
}
