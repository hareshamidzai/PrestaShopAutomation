package com.prestashop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class positiveScenarios {
	
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
	

}}
