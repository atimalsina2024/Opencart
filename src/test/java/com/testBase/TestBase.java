package com.testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;

public class TestBase {

	public WebDriver driver;
	public Faker fake;
	public Logger logger;
	public Properties p;
	@BeforeClass(groups = {"master", "sanity", "regression", "datadriven"})
	@Parameters({"os", "browser" })
	public void setup(String os, String browser) throws IOException {
		
		//loading property file
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		p = new Properties();
		p.load(fs);
		// initializing logger
		logger = LogManager.getLogger(this.getClass());
		
		//driver selection based on testng xml
		switch (browser.toLowerCase()) {
		case "safari":
			driver = new SafariDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("no valid browser");
			return;

		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
		fake = new Faker();

	}

	@AfterClass(groups = {"master", "sanity", "regression", "datadriven"})
	public void tearDown() {
		driver.close();

	}
}
