package com.revature.selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;


public class RegisterTest {

	public static WebDriver driver;
	public static LoginPage loginPage;
	public static HomePage homePage;

	@BeforeSuite
	public void setUp() {

		File file = new File("../../ChromeDriverFolder/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}
	
	@BeforeTest
	public void openLoginPage() {
		driver.get("http://revfitbucket.s3-website.us-east-2.amazonaws.com/");
	}
	
	
	
	@Test
	public void registerUser() {
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		loginPage.clickRegister();
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		loginPage.inputRegisterUsername("username");
		
		loginPage.inputRegisterFirstName("firstname");
		
		loginPage.inputRegisterLastName("lastname");
		
		loginPage.inputRegisterEmail("email@email.com");
		
		loginPage.inputRegisterPassword("password");
		
		loginPage.inputRegisterReenterPassword("password");
		
		loginPage.inputRegisterWeight("99");
		
		loginPage.inputRegisterHeight("72");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		loginPage.clickRegisterSubmit();
		
		
		String username = "username";
		String password = "password";

		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		loginPage.clickLogin();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		Assert.assertEquals(driver.findElement(By.xpath("/html/body/app-root/app-home/div/div[2]/app-homedash/div/div[1]")), homePage.getBodyCard());
	
		}
	
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}