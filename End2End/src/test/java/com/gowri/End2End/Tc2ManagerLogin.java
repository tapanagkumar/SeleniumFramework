package com.gowri.End2End;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tc2ManagerLogin extends Base{
public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}

	
	@Test
	public void managerLogin() {
		log.info("Entered Test 2");
		driver.get(prop.getProperty("URL"));
		log.info("Navigated to Home Page");
		PageObjects.HomePage home = new PageObjects.HomePage(driver);
		String title = home.banktitle().getText();
		log.info("Comparing Bank Name");
		Assert.assertEquals("XYZ Bank1", title);
		log.info("Bank name comparision successful");
		log.info("Now clicking on Manager Button");
		home.bankManagerlogin().click();
		log.info("Successfully clicked on Manager button");
	}
	
	@AfterTest
	public void teardown() {

		driver.quit();
		driver = null;

	}

}
