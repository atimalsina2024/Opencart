package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	WebDriver driver;
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myAccountHeader;
	
	@FindBy(xpath="//a[@class='list-group-item' and text()='Logout']")
	WebElement logoutButton;
	
	public void clickLogoutButton() {
		logoutButton.click();
	}
	
	public boolean doesAccountExist() {
		
		try {
		return myAccountHeader.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}

}
