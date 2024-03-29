package com.obsqura.selenium.FinalProject;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import utilities.ExtendedReportUtility;

public class Listerners extends Base implements ITestListener {
	ExtentTest test;

	ExtentReports extent=ExtendedReportUtility.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test =extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
		String testMethodName=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * try { driver
		 * =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").
		 * get(result.getInstance()); } catch (Exception e) { }
		 */
		/*	try {
	getScreenShotPath(testMethodName,driver);
	} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	}
	try {
	takeSnapShot(driver, "c://test.png");
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}*/
		/*
		 * try {
		 * extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,
		 * driver),result.getMethod().getMethodName()); } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped");
		String testMethodName=result.getMethod().getMethodName();
		/*try {
	getScreenShotPath(testMethodName,driver);
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	try {
	takeSnapShot(driver, "C://Users//ahkil//eclipse-workspace//payrollapplication//reports//test.png");
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}*/
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();
	}


}

