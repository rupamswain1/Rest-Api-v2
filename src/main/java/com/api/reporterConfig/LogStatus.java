package com.api.reporterConfig;

import static com.api.reporterConfig.ExtentReport.*;

import com.aventstack.extentreports.Status;



public class LogStatus 
	{
		
		private LogStatus()
		{
			//Private constructor to prevent initialization of class
		}
		public static void pass(String message)
		{
			getTestReport().log(Status.PASS, message);
		}
		
		public static void fail(String message)
		{
			getTestReport().log(Status.FAIL, message);
		}
		
		public static void fail(Exception message)
		{
			getTestReport().log(Status.FAIL, message.getStackTrace().toString());
		}
		
		public static void fail(AssertionError a)
		{
			getTestReport().log(Status.FAIL, a);
		}
		
		public static void info(String message)
		{
			getTestReport().log(Status.INFO, message);
		}
		
		public static void error(String message)
		{
			getTestReport().log(Status.ERROR, message);
		}
		
		public static void fatal(String message)
		{
			getTestReport().log(Status.FATAL, message);
		}
		
		public static void skip(String message)
		{
			getTestReport().log(Status.SKIP, message);
		}
		
		public static void unknown(String message)
		{
			getTestReport().log(Status.UNKNOWN, message);
		}
		
		public static void warning(String message)
		{
			getTestReport().log(Status.WARNING, message);
		}
		
	}


