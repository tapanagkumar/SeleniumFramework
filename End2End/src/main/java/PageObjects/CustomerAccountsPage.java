package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerAccountsPage {
	public WebDriver driver;

	By logout = By.xpath("//button[text()='Logout']");
	By customername = By.xpath("//span[@class='fontBig ng-binding']");

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
}

