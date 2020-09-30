package com.revature.selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;

public class GenerateWorkoutTest {
	

	public static WebDriver driver;
	public static LoginPage loginPage;
	public static HomePage homePage;

	@BeforeSuite
	public void setUp() {

		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}
	
	@BeforeTest
	public void openLoginPage() {
		driver.get("http://revfitbucket.s3-website.us-east-2.amazonaws.com/");
		driver.manage().window().maximize(); 
		
			String username = "username";
			String password = "password";

			loginPage.inputUsername(username);
			loginPage.inputPassword(password);
			loginPage.clickLogin();

			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			
		}
	
	@Test
	public void generateWorkout() throws InterruptedException {
		
		homePage.clickWorkout_Generator();
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		homePage.inputWorkoutName("testworkout");
		
		homePage.inputWorkoutType("testworkouttype");
		
		homePage.clickAdd_Workout();
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		homePage.selectExerciseAddPushup();
		
		homePage.inputSets("5");

		homePage.inputTime("50");
		
		homePage.click_addExercise();
		
		Select addpushup = new Select(driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/div/div/table/tr[2]/td/div/select")));
		
		addpushup.selectByIndex(0);
		
		driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/div/div/table/tr[2]/td/div/input[1]")).sendKeys("99");
		
		driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/div/div/table/tr[2]/td/div/input[2]")).sendKeys("50");
		
		homePage.click_deleteExercise();
		
		homePage.click_submitWorkout();
		
		Thread.sleep(2000);
		
		driver.switchTo().alert().dismiss();
		
		homePage.click_myWorkouts();
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		Assert.assertNotNull(driver.findElement(By.xpath("/html/body/app-root/app-home/div/div[2]/app-workoutdash/div/div[1]/div/div[1]/table/tr/td/button")));
	}
	
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
