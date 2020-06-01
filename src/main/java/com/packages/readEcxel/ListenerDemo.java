package com.packages.readEcxel;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
		String testcasename =result.getMethod().getDescription();
		System.out.println(testcasename);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSuccess" +result.getMethod().getDescription());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailure" +result.getMethod().getDescription());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped" +result.getMethod().getDescription());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedButWithinSuccessPercentage" +result.getMethod().getDescription());

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onStart" );

		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
