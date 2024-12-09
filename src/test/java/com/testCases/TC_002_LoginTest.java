package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;
import com.pageObjects.MyAccountPage;
import com.testBase.TestBase;

public class TC_002_LoginTest extends TestBase{
	
	@Test(priority=1, groups = {"master", "sanity"}, testName = "Login Test 002")
	public void verify_login() {
		logger.info("***Starting tc_002_login_test ****");		
		logger.info("initializing HomePage Class");
		HomePage hp = new HomePage(driver);		
		logger.info("clicking myacct button");
		hp.clickMyAccount();
		logger.info("click login button");
		hp.clickLogin();
		
		logger.info("initialize login page");
		LoginPage lp = new LoginPage(driver);	
		logger.info("enter email address");
		lp.enterEmailAddress(p.getProperty("email"));
		logger.info("enter password");
		lp.enterPassword(p.getProperty("password"));
		logger.info("click login");
		lp.clickLoginButton();
		logger.info("init MyAccount Page object");
		MyAccountPage acct = new MyAccountPage(driver);
		logger.info("store result to a variable");
		Boolean rslt = acct.doesAccountExist();
		logger.info("asserting result");
		if(rslt == true) {
			logger.info("Login test passed");
			Assert.assertTrue(true);
		}
		else {
			logger.error("test fail");
			Assert.fail();
		}
		logger.info("logging out");
		acct.clickLogoutButton();
	}

}
