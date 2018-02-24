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

/**
 * @author Gowri Kumar
 *
 */
public class Tc1CustomersLogin extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public Select select;
	public WebElement element;
	public List<WebElement> listofelements;

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}

	@Test(enabled = true)
	public void customerLogin() throws InterruptedException {
		driver.get(prop.getProperty("URL"));
		PageObjects.HomePage home = new PageObjects.HomePage(driver);
		PageObjects.CustomerLoginPage login = new PageObjects.CustomerLoginPage(driver);
		PageObjects.CustomerAccountsPage accounts = new PageObjects.CustomerAccountsPage(driver);
		String title = home.banktitle().getText();
		log.info("Comparing Bank Name");
		Assert.assertEquals(prop.getProperty("BankName"), title);
		log.info("Bank name comparision successful");
		home.customerlogin().click();
		log.info("Now clicking on Customer Login button ");
		login.customer().click();
		log.info("Successfully clicked on customer login button");
		log.info("Now Looking for the available Accounts ");
		element = login.customer();
		Select select = new Select(element);
		List<WebElement> listofelements = select.getOptions();
		// iterate through each and every option in the drop down
		for (int j = 1; j < listofelements.size(); j++) {

			Thread.sleep(3000);
			log.info("Selecting the elements in the customer list " + j);
			login.customer().click();
			String elementText = listofelements.get(j).getText();
			select.selectByVisibleText(elementText);
			log.info("Selected the " + j + "element from the list");
			log.info("Clicking on the login button");
			login.loginbutton().click();
			log.info("Clicked on the Login button");
			Thread.sleep(3000);
			log.info("Comparing the customer name from drop down and Accounts page ");
			Assert.assertEquals(accounts.customername().getText(), elementText);
			log.info("Comparision complete");
			log.info("Clicking on Logout button ");
			accounts.logout().click();
			log.info("Logout successful ");
			element = login.customer();
			select = new Select(element);
			listofelements = select.getOptions();
			

		}
		
	
	}

	

	@AfterTest
	public void teardown() {

		driver.quit();
		driver = null;

	}

}