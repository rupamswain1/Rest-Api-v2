package com.api.listners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.api.reporterConfig.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import static com.api.reporterConfig.ExtentReport.*;
import static com.api.reporterConfig.LogStatus.*;
public class ApiListner extends TestListenerAdapter implements ITestListener{

	private static ExtentReports extent=ExtentReport.initializeReport();

	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("-------------------------test start"+result.getInstanceName());
		//extent=ExtentReport.initializeReport();
		String testName=result.getTestClass().getName()+" @TestCase: "+result.getMethod().getMethodName();
		setTest(testName);
		super.onTestStart(result);
		Object[] params=result.getParameters();
		if(params.length<=0)
		{
			testReport.get().log(Status.INFO, "Test is running without any parameters");
		}
		else {
		testReport.get().log(Status.INFO, Arrays.toString(params));
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("---------------------------test success"+result.getTestName());
		String methodName=result.getMethod().getMethodName();
		String logTest="<b>"+"TEST CASE: "+methodName.toUpperCase()+"PASSED"+"</b>";
		Markup m=MarkupHelper.createLabel(logTest,ExtentColor.GREEN);
		testReport.get().log(Status.PASS, result.getMethod().getAttributes().toString());
		testReport.get().pass(m);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("----------------------------Failed test");
		String exceptionMsg=Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().log(Status.FAIL, result.getMethod().getAttributes().toString());
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
