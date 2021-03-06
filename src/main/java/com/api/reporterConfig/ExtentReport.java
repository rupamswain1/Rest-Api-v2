package com.api.reporterConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	private static ExtentReports extent;
	public String reportPath=".//test-output//Extent.html";
	public static ThreadLocal<ExtentTest> testReport=null;
	public static ExtentReports initializeReport()
	{
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(new ExtentReport().reportPath);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Api Test");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Api Report");
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation tester", "Pheonix");
		extent.setSystemInfo("Organization", "My Org");
		extent.setSystemInfo("Build no", "5");
		testReport=new ThreadLocal<ExtentTest>();
		return extent;
	}
	public static void setTest(String testName)
	{
		ExtentTest extTest=extent.createTest(testName);
		testReport.set(extTest);
	}
	public static ExtentTest getTestReport()
	{
		return testReport.get();
	}
}
