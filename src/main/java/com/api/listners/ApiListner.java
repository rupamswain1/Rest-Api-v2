package com.api.listners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.api.reporterConfig.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ApiListner implements ITestListener{

	private static ExtentReports extent=ExtentReport.initializeReport();
	public static ThreadLocal<ExtentTest> testReport=new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("-------------------------test start"+result.getInstanceName());
		ExtentTest test=extent.createTest(result.getTestClass().getName()+" @TestCase: "+result.getMethod().getMethodName());
		testReport.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("---------------------------test success"+result.getTestName());
		String methodName=result.getMethod().getMethodName();
		String logTest="<b>"+"TEST CASE: "+methodName.toUpperCase()+"PASSED"+"</b>";
		Markup m=MarkupHelper.createLabel(logTest,ExtentColor.GREEN);
		testReport.get().pass(m);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("----------------------------Failed test");
		String exceptionMsg=Arrays.toString(result.getThrowable().getStackTrace());

				testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" +exceptionMsg.replaceAll(",", "<br>")+"</details>"+" \n");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("---------------------------Skipped Test");
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//System.out.println("-----------------------------------On Start");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//System.out.println("----------------------------------On Finish");
		if (extent != null) {

			extent.flush();
		}

	}

}
