package com.gowri.End2End;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



/**
 * @author Gowri
 *
 */
public class Base {
	public static WebDriver driver;
	public Properties prop;
	public static Select mySelect; 

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\com\\gowri\\Resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("Browser");
		System.out.println(browserName);

		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\gowri\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();
			// execute in chrome driver

		} else if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
			// firefox code
		} else if (browserName.equals("IE")) {
			// IE code
		}

		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
		
	}

}
