package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerAccountsPage {
	public WebDriver driver;

	By logout = By.xpath("//button[text()='Logout']");
	By customername = By.xpath("//span[@class='fontBig ng-binding']");
	By Deposit = By.cssSelector("body>div.ng-scope>div>div.ng-scope>div>div:nth-child(5)>button:nth-child(2)");
	By Amount = By.cssSelector(
			"body>div.ng-scope>div>div.ng-scope>div>div.container-fluid.mainBox.ng-scope>div>form>div>input");
	By Depositconfirm = By.cssSelector(
			"body> div.ng-scope>div>div.ng-scope>div>div.container-fluid.mainBox.ng-scope>div>form>button");

	By VerifyDeposit = By
			.cssSelector("body>div.ng-scope>div>div.ng-scope>div>div.container-fluid.mainBox.ng-scope>div>span");

	public CustomerAccountsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement logout() {
		return driver.findElement(logout);
	}

	public WebElement customername() {
		return driver.findElement(customername);
	}

	public WebElement depositbutton() {
		return driver.findElement(Deposit);

	}

	public WebElement money() {
		return driver.findElement(Amount);
	}

	public WebElement confirmdeposit() {
		return driver.findElement(Depositconfirm);
	}
	
	public WebElement verifydeposit() {
		return driver.findElement(VerifyDeposit);
	}
}
