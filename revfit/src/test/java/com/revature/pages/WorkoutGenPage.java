package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkoutGenPage {
	@FindBy(xpath = "/html/body/app-root/app-home/div/div[2]/app-workoutgendash/div/div[1]/h5")
	private WebElement bodyCard;
	
	@FindBy(xpath = "//*[@id=\"navbarNavDropdown\"]/ul/li[2]/a")
	private WebElement workoutGenAnchor;
	
	public WorkoutGenPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getBodyCard() {
		return bodyCard;
	}
	
	public void goToWorkoutsGen() {
		workoutGenAnchor.click();
	}

}
