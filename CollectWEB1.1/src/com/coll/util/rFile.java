package com.coll.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class rFile {

	/**
	 * ��ȡ�ļ����ݣ�һ���Զ�ȡ��ʹ����С�ı��ļ���
	 * @param path_name
	 * @return String Context
	 */
	public static String getContext(String path_name){
		File file = new File(path_name);
		InputStream in = null;
		Long lenght = file.length();
		byte[] cont = new byte[lenght.intValue()];
		
		try {
			in = new FileInputStream(file);
			in.read(cont);
			in.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		try {
			return new String(cont,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
