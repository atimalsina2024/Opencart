package com.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentHtmlReporter htmlReporter;
	
	public void onStart(ITestContext context) {
		//all this to create a meaningful filename
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String fileName = "Test-Report.html";
		//creating a html report file
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/reports/" + fileName);
		//setting details of the html file
		htmlReporter.config().setDocumentTitle("Opencart Reports");
		htmlReporter.config().setReportName("Opencart functional Testing");
		htmlReporter.config().setTheme(Theme.STANDARD);
		//creating a report instance and associating it with html file from above
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		//fetching few testng details from testng xml
		String browser = context.getCurrentXmlTest().getParameter("browser");
		String os = context.getCurrentXmlTest().getParameter("os");
		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		//attaching retrieved details to the report instance 
		extent.setSystemInfo("browser", browser);
		extent.setSystemInfo("os", os);
		extent.setSystemInfo("Groups", includedGroups.toString());				
	}
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		//to display testng test groups
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName() +" got executed successfully");		
	}
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName() + " test failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + " test skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	

}
