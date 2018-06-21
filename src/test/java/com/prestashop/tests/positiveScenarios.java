
	package com.prestashop.tests;

	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.github.javafaker.Faker;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class PositiveScenarios {
		WebDriver driver;

		Faker faker = new Faker();
		String email = faker.name().firstName() + "@yahoo.com";

		@BeforeMethod
		public void setUp() {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		@Test
		public void posativeLoginTest() throws InterruptedException {
			driver.get("http://automationpractice.com");
			driver.findElement(By.className("login")).click();

			String email = faker.name().firstName() + "@yahoo.com";
			driver.findElement(By.id("email_create")).sendKeys(email);
			driver.findElement(By.id("SubmitCreate")).click();
			// name line

			String winHandleBefore = driver.getWindowHandle();

			driver.findElement(By.xpath("//i[@class='icon-user left']")).click();

			// Perform the click operation that opens new window

			Thread.sleep(3000);
			// Switch to new window opened
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}

			String name = faker.name().firstName();
			driver.findElement(By.id("customer_firstname")).sendKeys(name);

			String lastName = faker.name().lastName();
			driver.findElement(By.id("customer_lastname")).sendKeys(lastName);

			String pasword = faker.number().digits(7);
			driver.findElement(By.id("passwd")).sendKeys(pasword);

			driver.findElement(By.id("lastname")).sendKeys(lastName);

			String addresLine1 = faker.address().streetAddress();

			String addresNumber = faker.address().streetAddress();
			driver.findElement(By.id("address1")).sendKeys(addresNumber);

			String city = faker.address().cityName();
			driver.findElement(By.id("city")).sendKeys(city);

			// state
			Select dropdown = new Select(driver.findElement(By.id("id_state")));
			dropdown.selectByIndex(faker.number().numberBetween(0, 49));

			driver.findElement(By.id("postcode")).sendKeys(faker.number().digits(5));
			driver.findElement(By.id("phone")).sendKeys(faker.number().digits(11));
			driver.findElement(By.id("phone_mobile")).sendKeys(faker.number().digits(10));
			driver.findElement(By.id("alias")).clear();
			driver.findElement(By.id("alias")).sendKeys(email);
			driver.findElement(By.id("submitAccount")).click();

			driver.findElement(By.className("logout")).click();
			driver.findElement(By.id("email")).sendKeys(email);
			driver.findElement(By.id("passwd")).sendKeys(pasword);
			driver.findElement(By.id("SubmitLogin")).click();

			Assert.assertTrue(driver.findElement(By.className("account")).getText().contains(name + " " + lastName));

			Thread.sleep(5000);
			// driver.quit();

		}

		@AfterClass
		public void tearDown() {
			driver.quit();
		}
	}


	
	
	

