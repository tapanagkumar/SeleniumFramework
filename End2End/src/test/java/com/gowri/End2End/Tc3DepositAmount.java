package com.gowri.End2End;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CustomerAccountsPage;

public class Tc3DepositAmount extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public Select select;
	public WebElement element;
	public List<WebElement> listofelements;

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}

	@Test
	public void depositMoney() throws InterruptedException {
		driver.get(prop.getProperty("URL"));
		PageObjects.HomePage home = new PageObjects.HomePage(driver);
		PageObjects.CustomerLoginPage login = new PageObjects.CustomerLoginPage(driver);
		PageObjects.CustomerAccountsPage Transaction = new PageObjects.CustomerAccountsPage(driver);
		home.customerlogin().click();
		log.info("Now clicking on Customer Login button ");
		login.customer().click();
		log.info("Successfully clicked on customer login button");
		log.info("Now Looking for the available Accounts ");
		element = login.customer();
		Select select = new Select(element);
		select.selectByIndex(3);
		log.info("Clicking on the login button");
		login.loginbutton().click();
		log.info("Clicked on the Login button");
		Thread.sleep(3000);
		log.info("Clicking on Deposit Money");
		Transaction.depositbutton().click();
		log.info("Enter Money");
		Transaction.money().sendKeys(prop.getProperty("MoneyDeposit"));
		log.info("Confirming Deposit");
		Transaction.confirmdeposit().click();
		String isDepositSuccessful = Transaction.verifydeposit().getText();
		Assert.assertEquals(isDepositSuccessful, "Deposit Successful");
		

	}
	
	@AfterTest
	public void teardown() {

		driver.quit();
		driver = null;

	}
}
