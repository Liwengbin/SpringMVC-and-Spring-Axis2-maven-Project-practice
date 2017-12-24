package com.coll.serviceImpl;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import com.coll.service.TransformService;
import com.coll.util.SystemTools;
import com.coll.util.UtilPath;

/**
 * תΪbase64����
 * ClassName: TransformServiceImpl 
 * @Description: TODO
 * @author liwengbincoll@foxmail.com
 * @date 2017��12��25��
 */
@Service
public class TransformServiceImpl implements TransformService{
	
	public String getImgBase64(String imgAddress) {		
		return DownAndTransform(imgAddress);
	}
	
	/**
	 * ���ص�ַ�е�ͼƬ�����ַ�����򷵻�null
	 * @Description: TODO
	 * @param @param imgAddress
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��25��
	 */
	public String DownAndTransform(String imgAddress) {
        URL url = null;
        String relativelyPath=UtilPath.getWEB_INF();
        String imageNumber = SystemTools.getUUID();
        String urlString = imgAddress;
        String base64 = null;
            try { 
                url = new URL(urlString);
                DataInputStream dataInputStream = new DataInputStream(url.openStream());  
                String imageName = relativelyPath+"iconCache/"+imageNumber+ ".png";  
                FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName)); 
                byte[] buffer = new byte[1024];
                int length;
                while ((length = dataInputStream.read(buffer)) > 0) {  
                    fileOutputStream.write(buffer, 0, length);
                }
                dataInputStream.close();  
                fileOutputStream.close();
                base64 = getBaxe64(imageName);
            } catch (MalformedURLException e) {  
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return base64;
        }    
	
	/**
	 * ��������·����������ȡ�ļ���תΪbase64
	 * @Description: TODO
	 * @param @param icopath
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author liwengbincoll@foxmail.com
	 * @date 2017��12��26��
	 */
	public String getBaxe64(String icopath){
		//��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��    
        InputStream in = null;
        byte[] data = null;
        //��ȡͼƬ�ֽ�����
        try 
        {
            in = new FileInputStream(icopath);      
            data = new byte[in.available()];
            in.read(data);
            in.close();
            /**
             * ɾ����������ļ�
             */
            File file = new File(icopath);
            if(file.exists()&&file.isFile()){
                file.delete();
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            return null;
        }
        return new String(Base64.encodeBase64(data));
	}
}
