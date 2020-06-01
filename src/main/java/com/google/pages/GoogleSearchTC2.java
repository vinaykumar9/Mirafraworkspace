package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class GoogleSearchTC2 {
	
	@Test
	public void TC01() throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); 
		driver.get("http://google.co.in/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("overdrive");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		driver.close();

	}

}
