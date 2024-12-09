package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;
import com.pageObjects.MyAccountPage;
import com.testBase.TestBase;
import com.utilities.LoginDataProviderCsv;

public class TC_003_LoginDDT extends TestBase{
	@Test(priority=1, dataProvider = "LoginTestAllDataArray", dataProviderClass = LoginDataProviderCsv.class, groups = {"master", "datadriven"})
	public void verify_loginDDT(String email, String password, String expected) {
		logger.info("***Starting tc_003_login_test ****");		
		logger.info("initializing HomePage Class");
		HomePage hp = new HomePage(driver);		
		logger.info("clicking myacct button");
		hp.clickMyAccount();
		logger.info("click login button");
		hp.clickLogin();
		
		logger.info("initialize login page");
		LoginPage lp = new LoginPage(driver);	
		logger.info("enter email address");
		lp.enterEmailAddress(email);
		logger.info("enter password");
		lp.enterPassword(password);
		logger.info("click login");
		lp.clickLoginButton();
		logger.info("init MyAccount Page object");
		MyAccountPage acct = new MyAccountPage(driver);
		logger.info("store result to a variable");
		Boolean rslt = acct.doesAccountExist();
		logger.info("asserting result");
		
		switch(expected.toLowerCase()) {
		case "valid":

			if(rslt == true) {
				acct.clickLogoutButton();
				Assert.assertTrue(true);
				logger.info("test passed");
			}
			else 
			{
				//acct.clickLogoutButton();
				Assert.fail();
				logger.info("test failed");

			}
			break;
			
		case "invalid": 
			if(rslt == false) {
				//acct.clickLogoutButton();
				Assert.assertTrue(true);
				logger.info("test pass");
			}
			else {
				acct.clickLogoutButton();
				Assert.fail();
				logger.info("test fail");
			}
			break;
		}
	}
	

}
