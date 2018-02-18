package com.gowri.End2End;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public static Properties Param;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFSheet ws1;
	public static FileInputStream fin;
	public static FileOutputStream fout;

	//Code to Initialize driver
	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\gowri\\Resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("Browser");
		System.out.println(browserName);

		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\gowri\\Resources\\chromedriver.exe");
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

	// Get Screenshots on Failure
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//" + result + "screenshot.png"));

	}

	// Read from Excel
	public void ReadFromExcel() throws Exception {
		
		

		// File for reading data from Contacts 
		fin = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\gowri\\Resources\\Contacts.xlsx");
		wb = new XSSFWorkbook(fin);
		ws = wb.getSheet("Contacts");
		// ws1=wb.getSheet("Registration");

	}

}
