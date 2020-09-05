package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "/html/body/app-root/app-home/div/div[2]/app-homedash/div/div[1]")
	private WebElement bodyCard;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getBodyCard() {
		return bodyCard;
	}
}
