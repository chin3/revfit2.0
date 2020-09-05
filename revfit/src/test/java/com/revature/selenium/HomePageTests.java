package com.revature.selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.MyWorkoutsPage;
import com.revature.pages.WorkoutGenPage;

public class HomePageTests {
	
	public static WebDriver driver;
	public static MyWorkoutsPage myWorkoutsPage;
	public static HomePage homePage;
	public static WorkoutGenPage workoutgen;
	
	@BeforeSuite
	public void setUp() {

		File file = new File("D:\\Program Files\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		myWorkoutsPage = new MyWorkoutsPage(driver);
		homePage = new HomePage(driver);
		workoutgen = new WorkoutGenPage(driver);
		
	}
	
	@BeforeTest
	public void login() {
		driver.get("http://revfitbucket.s3-website.us-east-2.amazonaws.com/");
		driver.manage().window().maximize(); 
		LoginPage temp = new LoginPage(driver);
		temp.inputUsername("user1");
		temp.inputPassword("password");
		temp.clickLogin();
	}
	
	@BeforeMethod
	public void returnHome(){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		homePage.goHome();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void onHomePage() {
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/app-root/app-home/div/div[2]/app-homedash/div/div[1]")), homePage.getBodyCard());
	}
	
	
	@Test
	public void onMyWorkoutsPage() {
		driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul/li[3]/a")).click();
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/app-root/app-home/div/div[2]/app-workoutdash/div/div[1]/div/div[1]/h5")), myWorkoutsPage.getMainCard());
	}
	
	@Test
	public void workoutGenPage() {
		workoutgen.goToWorkoutsGen();
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/app-root/app-home/div/div[2]/app-workoutgendash/div/div[1]/h5")), workoutgen.getBodyCard());
		
	}
	
	
	
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
