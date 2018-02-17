package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerLoginPage {
	public WebDriver driver;
	//public Select dropdown;
	
	By CustomerDDown=By.id("userSelect");
	By login = By.xpath("//button[text()='Login']");
	
	public CustomerLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	
	public WebElement customer()
	{
		return driver.findElement(CustomerDDown);
	}
	
	public WebElement loginbutton()
	{
		return driver.findElement(login);
	}
	
}
