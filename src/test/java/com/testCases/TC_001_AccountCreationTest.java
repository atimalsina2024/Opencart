package com.testCases;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.pageObjects.AccountRegistrationPage;
import com.pageObjects.HomePage;
import com.testBase.TestBase;

public class TC_001_AccountCreationTest extends TestBase{
	
	
	
	@Test(priority=1, groups = {"regression", "master"})
	public void test_account_registration() {
		logger.debug("application logs");
		logger.info("Starting TC 1");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked MyAccount");
		hp.clickRegister();
		logger.info("Clicked Register Link");

		logger.info("Initiate Registration Page");
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		logger.info("entering name, lname etc");
		regPage.setName(fake.name().firstName());
		regPage.setLastname(fake.name().lastName());
		regPage.setEmail(fake.internet().emailAddress());
		regPage.setTelephone(fake.phoneNumber().phoneNumber());
		String pwd = fake.internet().password();
		regPage.setPassword(pwd);
		regPage.confirmPassword(pwd);
		
		logger.info("Check Privacy Button TC 1");
		regPage.checkPrivacyCheckBox();
		logger.info("Click Continue TC 1");
		regPage.clickContinueButton();
		String msg = regPage.registrationConfirmation();
		logger.info("asserting account creation assertion");
		Assert.assertEquals(msg, "Your Account Has Been Created!");
		
				
	}
	
	

}
