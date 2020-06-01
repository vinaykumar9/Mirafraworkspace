package com.mirafra.extentreport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.pages.EventCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class GenerateExtentReport {
	ExtentReports extent; //specify  the location of the report
	ExtentTest test;   // what details should be populated in the report
	
	WebDriver driver;
	
	
	@BeforeTest()
	public void  startReport(){
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/MyOwnReport.html", true);
		extent.addSystemInfo("Host Name", "Localhost");
		extent.addSystemInfo("ENvironment", "IQA");
		extent.addSystemInfo("User Name", "Vinay Kumar Reddy");
		extent.addSystemInfo("data", "web");
		extent.loadConfig(new File(System.getProperty("user.dir")+"/extentreport.xml"));
	}
	
	
	@BeforeMethod
	public void init(){
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	     /*   WebDriver driver = new ChromeDriver(); 
			driver.get("https://www.youtube.com/watch?v=rs4xt1M_5BI");
			driver.manage().window().maximize();
			driver.findElement(By.name("q")).sendKeys("autocarindia");
			driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
			Thread.sleep(3000);
	*/
			
			
			 driver = new ChromeDriver();
			
			//EventFiringWebDriver driver = new EventFiringWebDriver(ds);
			
			//EventCapture ec= new EventCapture();
			//driver.register(ec);
/*			driver.get("https://www.google.com");
*/			driver.manage().window().maximize();
             driver.get("https://www.spicejet.com/");
             
             driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
/*			driver.manage().deleteAllCookies();
*/		
	}
	
	
	
	
	public static String getScreenShot(WebDriver driver, String ScreenShotname) throws IOException{
		
		String date = new SimpleDateFormat("yyMMdd_hhmmss").format(new Date());
		
		System.out.println("print date -------------------------");
		System.out.println(date);
		
		
		// Take screenshot and store as a file format
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile //method
		
		String image_name= System.getProperty("user.dir")+ "/FailedTestsScreenshots/"+ScreenShotname+date +".png";
		FileUtils.copyFile(src, new File(image_name));
		return image_name;
	}
	
	@Test
	public void demoPass(){
		
		test =extent.startTest("extent First1  testcase");
		
		String aaTitle =driver.getTitle();
		System.out.println(aaTitle);
		Assert.assertEquals("SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets", "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		
		
       // test.log(LogStatus.PASS, "assert statement is true for first test case");
        
	}
	
	
@Test
	public void demofail(){
		
		test =extent.startTest("Signup Second Test  testcase");
		String aaTitle =driver.getTitle();
		System.out.println(aaTitle);
		Assert.assertEquals("SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets", "SpiceJet - Flight stic and International, Cheap Air Tickets");
		       // test.log(LogStatus.FAIL, "ae demofail");
		
	}
	
	@Test
	public void thiedTestCase(){
		
		test =extent.startTest("thiedTestCase testcase");
        Assert.assertTrue(false);
       // test.log(LogStatus.FAIL, "ae demofail");
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		
		
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(LogStatus.FAIL, "Test case failed"+result.getName());
			test.log(LogStatus.FAIL, "Test case failed"+result.getThrowable());
			
			String location;
			try {
				location = GenerateExtentReport.getScreenShot(driver, result.getName());
				test.log(LogStatus.FAIL, test.addScreenCapture(location));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		else if(result.getStatus() == ITestResult.SUCCESS){
			test.log(LogStatus.PASS, "testcase passed"+ result.getName()); //to add screenshoyt in extent report
		}
		
		else{
			test.log(LogStatus.SKIP,"Test case skipped" +result.getName());
		}
		extent.endTest(test);
		
	}
	
	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}


}
