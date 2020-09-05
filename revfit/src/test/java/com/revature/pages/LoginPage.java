package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "username")
	private WebElement usernameInput;
	
	@FindBy(name = "password")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//*[@id=\"background\"]/div[2]/article/button[1]")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void inputUsername(String username) {
		usernameInput.sendKeys(username);
	}
	
	public void inputPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButton.click();
	}

}
