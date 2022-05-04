package com.github.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.github.base.Base;

public class TestReport extends Base implements ITestListener {
	
	public void onStart(ITestContext context) {
		pTest=ex.createTest(context.getName());
		pTest.info( context.getName()+ " Started");
	}
	
	public void onFinish(ITestContext context) {
		pTest.info(context.getName() + " finished");

	}
	public void onTestStart(ITestResult result) {
		cTest=pTest.createNode(result.getName());
		cTest.info(result.getName() + " Started");
	}

	public void onTestSuccess(ITestResult result) {
	}
	public void onTestFailure(ITestResult result) {

	}
	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
}
