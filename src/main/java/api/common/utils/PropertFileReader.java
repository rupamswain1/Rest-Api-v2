package api.common.utils;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author RUPAM
 *This Class is made to read the properties file
 */
public class PropertFileReader {
/**
 * 
 * @param data It is the name of the property we want to fetch from application.properties file
 * @return It returns a string i.e value from application.properties for the given key in data parameter
 * @throws Exception
 */
	public String getApplicationData(String data) throws Exception
	{
		Properties properties=new Properties();
		properties.load(new FileInputStream(".//src//test//resources//application.properties"));
		
		String returnData=null;
		try {
			returnData=properties.getProperty(data).toString();
		}
		catch (NullPointerException e) {
			throw new Exception("Data with name: \""+data+"\" was not found in application.properties file");
		}
		return  returnData;
	}
	/*public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(new PropertFileReader().getApplicationData("names"));
	}*/

}
