package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWorkoutsPage {
	
	@FindBy(xpath = "/html/body/app-root/app-home/div/div[2]/app-workoutdash/div/div[1]/div/div[1]/h5")
	private WebElement mainCard;
	
	public MyWorkoutsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getMainCard() {
		return mainCard;
	}
}
