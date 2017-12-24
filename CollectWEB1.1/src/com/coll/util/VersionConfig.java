package com.coll.util;

import java.util.Properties;

public class VersionConfig {
    //application info
    public final static String APP_NAME;
    public final static String APP_VERSION;
    public final static String APP_STATUS;
    public final static String APP_BUILDATE;
    public final static String APP_BUILDVER;
    //application author
    public final static String APP_AUTHOR;
    public final static String APP_WORKSTUDIO;
    public final static String Y_EMAIL;
       
    private final static Properties properties=ReadConfig.getProperties(PathsysConfig.sys_configpath);

    static {
        APP_NAME=properties.getProperty("version.APP_NAME");
        APP_VERSION=properties.getProperty("version.APP_VERSION");
        APP_STATUS=properties.getProperty("version.APP_STATUS");
        APP_BUILDATE=properties.getProperty("version.APP_BUILDATE");
        APP_BUILDVER=properties.getProperty("version.APP_BUILDVER");
        APP_AUTHOR=properties.getProperty("version.APP_AUTHOR");
        APP_WORKSTUDIO=properties.getProperty("version.APP_WORKSTUDIO");
        Y_EMAIL=properties.getProperty("version.Y_EMAIL");
    }

    /**
     * 设置网页版本信息
     * @return
     */
    public final static String buildFooterStr()
    {
        StringBuffer sb=new StringBuffer();

        sb.append(APP_NAME);
        sb.append(" "+"(版本:"+APP_STATUS+APP_VERSION);
        sb.append(" &nbsp;&nbsp;Build:"+APP_BUILDVER);
        sb.append(" "+APP_BUILDATE+")");
        sb.append("&nbsp;&nbsp;&nbsp;&nbsp;开发团队:&nbsp;<a href=\"#\">"+APP_AUTHOR+"</a><br/>");
        sb.append("©COLLECT MUX, powered by alimama THX.法律声明转载内容版权归作者及来源网站所有，本站原创内容转载请注明来源，请先联系："+Y_EMAIL);
        sb.append("(C)&nbsp;"+APP_WORKSTUDIO+"&nbsp;&nbsp;");

        return sb.toString();
    }
}
