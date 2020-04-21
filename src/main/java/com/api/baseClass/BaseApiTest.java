package com.api.baseClass;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.api.asserts.Assert;
import com.api.listners.ApiListner;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import static com.api.reporterConfig.ExtentReport.*;
@Listeners(com.api.listners.ApiListner.class)
public class BaseApiTest extends Assert{

	
	
	public void logPass(String data)
	{
		getTestReport().log(Status.PASS, data);
	}
	public void logFail(String data)
	{
		getTestReport().log(Status.FAIL, data);
	}
	public void logskip(String data)
	{
		getTestReport().log(Status.SKIP, data);
	}
}
