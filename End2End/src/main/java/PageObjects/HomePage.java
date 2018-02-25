package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

public WebDriver driver;
	
	By customerlogin=By.xpath("//button[text()='Customer Login']");
	By managerlogin=By.xpath("//button[text()='Bank Manager Login']");
	By title=By.xpath("//strong[@class='mainHeading']");
	By home = By.xpath("//button[@class=\"btn home\"]");
	
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}




	public WebElement customerlogin()
	{
		return driver.findElement(customerlogin);
	}
	public WebElement bankManagerlogin()
	{
		return driver.findElement(managerlogin);
	}
	public WebElement banktitle()
	{
		return driver.findElement(title);
	}
	public WebElement home()
	{
		return driver.findElement(home);
	}
}
