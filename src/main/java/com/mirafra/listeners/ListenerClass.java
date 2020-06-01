package com.mirafra.listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenerClass  extends TestListenerAdapter{

	@Override
	public void onTestFailure(ITestResult result) {
	System.out.println("Test Failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Skipped");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Success");
	}

	
	
	
	
}
