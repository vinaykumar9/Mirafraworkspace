package com.google.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class GoogleSearchTC2 {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
    public void setup(String browser) throws Exception{
            //Check if parameter passed from TestNG is 'firefox'
            if(browser.equalsIgnoreCase("firefox")){
            //create firefox instance
                     System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
                     driver = new FirefoxDriver();
            }
            //Check if parameter passed as 'chrome'
            else if(browser.equalsIgnoreCase("chrome")){
                     //set path to chromedriver.exe
                     System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
                     //create chrome instance
                     driver = new ChromeDriver();
            }
            //Check if parameter passed as 'Edge'
                              else if(browser.equalsIgnoreCase("Edge")){
                                       //set path to Edge.exe
                                       System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
                                       //create Edge instance
                                       driver = new EdgeDriver();
                              }
            else{
                     //If no browser passed throw exception
                     throw new Exception("Browser is not correct");
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

	
	@Test
	public void TC01() throws InterruptedException {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
       // WebDriver driver = new FirefoxDriver(); 
		driver.get("http://google.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("overdrive");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		driver.close();

	}
	

	
	

}
