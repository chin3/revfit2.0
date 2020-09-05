package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	@FindBy(xpath = "/html/body/app-root/app-home/div/div[2]/app-homedash/div/div[1]")
	private WebElement bodyCard;
	
	@FindBy(xpath = "/html/body/app-root/app-home/nav/div/ul/li[2]/a")
	private WebElement workoutGenNavBar;
	
	@FindBy(xpath = "/html/body/app-root/app-home/nav/div/ul/li[3]/a")
	private WebElement myWorkoutsNavBar;
	
	@FindBy(xpath = "//*[@id=\"nameValue\"]")
	private WebElement workoutName;
	
	@FindBy(xpath = "//*[@id=\"typeValue\"]")
	private WebElement workoutType;
	
	@FindBy(xpath = "/html/body/app-root/app-home/div/div[2]/app-workoutgendash/div/div[2]/button")
	private WebElement addWorkoutButton;
	
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/div/table/tr[1]/td/div/select")
	private WebElement selectExerciseBox;
	
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/div/table/tr[2]/td/div/select")
	private WebElement selectExerciseBox2;
	
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/div/table/tr[1]/td/div/input[1]")
	private WebElement inputSets;
	
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/div/table/tr[2]/td/div/input[1]")
	private WebElement inputSets2;
	
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/div/table/tr[1]/td/div/input[2]")
	private WebElement inputTime;
	
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/div/table/tr[2]/td/div/input[2]")
	private WebElement inputTime2;
	
	
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/div/table/tr[2]/td[1]/div/div/button[1]")
	private WebElement addExerciseButton;
	
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[2]/div/div/table/tr[3]/td[1]/div/div/button[2]")
	private WebElement deleteRecentButton;
	
	@FindBy(xpath = "/html/body/ngb-modal-window/div/div/div[3]/button")
	private WebElement submitWorkoutButton;

	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getBodyCard() {
		return bodyCard;
	}
	
	public void clickWorkout_Generator() {
		workoutGenNavBar.click();
	}
	
	public void inputWorkoutName(String workoutname) {
		workoutName.sendKeys(workoutname);
	}
	
	public void inputWorkoutType(String workouttype) {
		workoutType.sendKeys(workouttype);
	}
	
	public void clickAdd_Workout() {
		addWorkoutButton.click();
	}
	
	
	public void selectExerciseAddPushup() {
		Select addpushup = new Select(selectExerciseBox);
		addpushup.selectByIndex(0);
	}
	
	public void selectExerciseAddPushup2() {
		Select addpushup = new Select(selectExerciseBox2);
		addpushup.selectByIndex(0);
	}
	
	
	public void inputSets(String sets) {
		inputSets.sendKeys(sets);
	}
	
	public void inputSets2(String sets) {
		inputSets2.sendKeys(sets);
	}
	
	public void inputTime(String time) {
		inputTime.sendKeys(time);
	}
	
	public void inputTime2(String time) {
		inputTime2.sendKeys(time);
	}
	
	public void click_addExercise() {
		addExerciseButton.click();
	}
	
	public void click_deleteExercise() {
		deleteRecentButton.click();
	}
	
	public void click_submitWorkout() {
		submitWorkoutButton.click();
	}
	
	public void click_myWorkouts() {
		myWorkoutsNavBar.click();
	}
	
	
}
