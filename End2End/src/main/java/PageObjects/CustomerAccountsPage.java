package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerAccountsPage {
	public WebDriver driver;

	By logout = By.xpath("//button[text()='Logout']");
	By customername = By.xpath("//span[@class='fontBig ng-binding']");
	By Deposit = By.cssSelector("body>div.ng-scope>div>div.ng-scope>div>div:nth-child(5)>button:nth-child(2)");

	public CustomerAccountsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;

	}

	public WebElement logout() {
		return driver.findElement(logout);
	}

	public WebElement customername(){
		return driver.findElement(customername);
	}
	public WebElement deposit()
	{
		return driver.findElement(Deposit);
		
				
		}
	
}

