package com.prestashop.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class wrongCredentialsTest  {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	

	@Test
	public void wrongEmail() {
	driver.get("http://automationpractice.com");
	driver.findElement(By.className("login")).click();
	driver.findElement(By.id("email")).sendKeys("CyberTekSchoo@Gmail.com");
	driver.findElement(By.id("passwd")).sendKeys("123456");
	driver.findElement(By.id("SubmitLogin")).click();

			
    Assert.assertTrue(driver.findElement(By.id("center_column")).getText().contains("Authentication failed."));
	
	//String msg = driver.findElement(By.className("alert-danger")).getText();
	//Assert.assertTrue(driver.().contains("fathers day gift"));

	
	
   
}
	
	@Test
	public void invalidEmailTest() {
		driver.get("http://automationpractice.com");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("CyberTekSchoo.gmailcom");
		driver.findElement(By.id("passwd")).sendKeys("123456");
		driver.findElement(By.id("SubmitLogin")).click();
		 Assert.assertTrue(driver.findElement(By.id("center_column")).getText().contains("Invalid email address"));		
	}
	
	@Test
	public void blankEmailTest() {
		driver.get("http://automationpractice.com");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("");
	driver.findElement(By.id("passwd")).sendKeys("123456");
		driver.findElement(By.id("SubmitLogin")).click();
		Assert.assertTrue(driver.findElement(By.id("center_column")).getText().contains("An email address required."));	
		
	}	@Test
	public void blankPassWordTest() {
		driver.get("http://automationpractice.com");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("CyberTec@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("");
		driver.findElement(By.id("SubmitLogin")).click();
		Assert.assertTrue(driver.findElement(By.id("center_column")).getText().contains("Password is required."));	
		
		
		
	}
	
	
	
	
	
	  
	  @AfterMethod
	  public void tearDown() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.close();
	  }
	
	
	
	

	
}