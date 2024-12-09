package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement passwordConfirm;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='agree']")
	WebElement privacyPolicyCheckBox;
	
	@FindBy(xpath="//input[@class='btn btn-primary' and @value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement registrationConfirmation;
	
	@FindBy(xpath="//a[contains(@href, 'route=account/account') and text()='Continue']")
	WebElement registrationConfirmationContinueButton;
	
	public void setName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String eml) {
		email.sendKeys(eml);
	}
	
	public void setTelephone(String tlf) {
		telephone.sendKeys(tlf);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void confirmPassword(String pwdCnf) {
		passwordConfirm.sendKeys(pwdCnf);
	}
	
	public void checkPrivacyCheckBox() {
		privacyPolicyCheckBox.click();
	}
	
	public void clickContinueButton() {
		continueButton.click();
	}
	
	public String registrationConfirmation() {
		try {
			
			return registrationConfirmation.getText();
				
		} catch(Exception e)
		{
			return e.getMessage();
		}
		
	}
	
	public void clickPostRegistrationContinueButton() {
		registrationConfirmationContinueButton.click();
	}
	
	
	
	
	
	
	

	
	

}
