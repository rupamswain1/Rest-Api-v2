package com.api.dataprovider;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.api.common.utils.TestDataReader;

public class DataProviders {

	@DataProvider(name="dataProvider")
	public Object[][] getTestData(Method m) throws Exception
	{
		String methodName=m.getName().toString();
		System.out.println(methodName);
		TestDataReader dataReader=new TestDataReader();
		List<Map<String, String>>excelData=dataReader.getData(methodName);
		Object[][] data=new Object[excelData.size()][1];
		for(int i=0;i<excelData.size();i++)
		{
			data[i][0]=excelData.get(i);
		}
		return data;
	}
}
