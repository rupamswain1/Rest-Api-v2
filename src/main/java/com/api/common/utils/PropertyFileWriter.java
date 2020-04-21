package com.api.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertyFileWriter {

	public final String tempPropertyPath=".//src//test//resources//temp.properties";
	public void writeProperty(String key,Object value) throws Exception
	{
		Properties props=new Properties();
		InputStream is=new FileInputStream(new File(new PropertyFileWriter().tempPropertyPath));
		props.load(is);
		Enumeration<Object> prop=props.keys();
		ArrayList<Object> ll = Collections.list(prop);
		Map<String, String> propData=new Hashtable<>();
		for(Object o: ll)
		{
			PropertFileReader read=new PropertFileReader();
			String existinData=read.getApplicationData(o.toString(), tempPropertyPath);
			propData.put(o.toString(), existinData.toString());
		}
		
		for(Map.Entry<String, String> d:propData.entrySet())
		{
			props.setProperty(d.getKey(), d.getValue());
		}
		props.setProperty(key, value.toString());
		OutputStream os=new FileOutputStream(new PropertyFileWriter().tempPropertyPath);
		props.store(os, "");
		os.close();
	}
	
	public void cleanTemp() throws IOException
	{
		Properties props=new Properties();
		props.setProperty("","");
		OutputStream os=new FileOutputStream(new PropertyFileWriter().tempPropertyPath);
		props.store(os, "");
		os.close();
	}
	/*public static void main(String args[]) throws IOException
	{
		new PropertyFileWriter().cleanTemp();
	}*/

}
