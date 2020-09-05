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
	
	public void clickRegister() {
		registerButton.click();
	}
	
	public void inputRegisterUsername(String username) {
		registerUsername.sendKeys(username);
	}
	
	public void inputRegisterFirstName(String firstname) {
		registerFirstName.sendKeys(firstname);
	}
	
	public void inputRegisterLastName(String lastname) {
		registerLastName.sendKeys(lastname);
	}
	
	public void inputRegisterEmail(String email) {
		registerEmail.sendKeys(email);
	}
	
	public void inputRegisterPassword(String password) {
		registerPassword.sendKeys(password);
	}
	
	public void inputRegisterReenterPassword(String reenterpassword) {
		registerReenterPassword.sendKeys(reenterpassword);
	}
	
	public void inputRegisterWeight(String weight) {
		registerWeight.sendKeys(weight);
	}
	
	public void inputRegisterHeight(String height) {
		registerHeight.sendKeys(height);
	}
	
	public void clickRegisterSubmit() {
		registerSubmitButton.click();
	}
	
	
	
	@FindBy(xpath = "/html/body/app-root/app-loginregister/body/div/div[2]/article/button[2]")
	private WebElement registerButton;
	
	@FindBy(xpath = "//*[@id=\"orangeForm-name\"]")
	private WebElement registerUsername;
	
	@FindBy(xpath = "//*[@id=\"orangeForm-first\"]")
	private WebElement registerFirstName;

	@FindBy(xpath = "//*[@id=\"orangeForm-last\"]")
	private WebElement registerLastName;
	
	@FindBy(xpath = "//*[@id=\"orangeForm-email\"]")
	private WebElement registerEmail;
	
	@FindBy(xpath = "//*[@id=\"orangeForm-pass\"]")
	private WebElement registerPassword;
	
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/div[4]/input")
	private WebElement registerReenterPassword;
	
	@FindBy(xpath = "//*[@id=\"orangeForm-weight\"]")
	private WebElement registerWeight;
	
	@FindBy(xpath = "//*[@id=\"orangeForm-height\"]")
	private WebElement registerHeight;
	
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[3]/button")
	private WebElement registerSubmitButton;
	
}
