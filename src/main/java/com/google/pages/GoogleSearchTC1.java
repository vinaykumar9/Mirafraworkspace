package com.google.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;


public class GoogleSearchTC1 {
	
	@Test()
	public void TC01() throws InterruptedException {
		// TODO Auto-generated method stub
		//testcase
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
     /*   WebDriver driver = new ChromeDriver(); 
		driver.get("https://www.youtube.com/watch?v=rs4xt1M_5BI");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("autocarindia");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		Thread.sleep(3000);
*/
		
		
		WebDriver ds = new ChromeDriver();
		
		EventFiringWebDriver driver = new EventFiringWebDriver(ds);
		
		EventCapture ec= new EventCapture();
		driver.register(ec);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

			driver.get("https://www.spicejet.com/");
			
			// create object for mouse hover
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//*[@id='highlight-addons']"))).build().perform();
			Thread.sleep(3000);
			driver.findElement(By.linkText("SpiceMax")).click();
			//driver.quit();
			
		
		
		
	}
	
	@Test()
	public void TC02() throws InterruptedException {
		// TODO Auto-generated method stub
		//testcase
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
     /*   WebDriver driver = new ChromeDriver(); 
		driver.get("https://www.youtube.com/watch?v=rs4xt1M_5BI");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("autocarindia");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		Thread.sleep(3000);
*/
		
		
		WebDriver ds = new ChromeDriver();
		
		EventFiringWebDriver driver = new EventFiringWebDriver(ds);
		
		EventCapture ec= new EventCapture();
		driver.register(ec);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

			driver.get("https://www.spicejet.com/");
			
			// create object for mouse hover
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//*[@id='q']"))).build().perform();
			Thread.sleep(3000);
			driver.findElement(By.linkText("SpiceMax")).click();
			//driver.quit();
			
		
		
		
	}
	
}
