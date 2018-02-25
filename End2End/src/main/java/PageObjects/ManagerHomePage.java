package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManagerHomePage {
	public WebDriver driver;

	By addCustomer = By.cssSelector("body>div.ng-scope>div>div.ng-scope>div>div.center>button:nth-child(1)");
	
	By firstName = By
			.cssSelector("body>div.ng-scope>div>div.ng-scope>div>div.ng-scope>div>div>form>div:nth-child(1)>input");
	By lastName = By
			.cssSelector("body>div.ng-scope>div>div.ng-scope>div>div.ng-scope>div>div>form>div:nth-child(2)>input");
	By pinCode = By
			.cssSelector("body>div.ng-scope>div>div.ng-scope>div>div.ng-scope>div>div>form>div:nth-child(3)>input");
	By confirmAddCustomer = By
			.xpath("//button[@class=\"btn btn-default\"]");

	public ManagerHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement addcustomer() {
		return driver.findElement(addCustomer);
	}

	public WebElement addfirstname() {
		return driver.findElement(firstName);
	}

	public WebElement addlastname() {
		return driver.findElement(lastName);
	}

	public WebElement addpincode() {
		return driver.findElement(pinCode);
	}
	
	public WebElement confirmaddcustomer() {
		return driver.findElement(confirmAddCustomer);
	}
}
