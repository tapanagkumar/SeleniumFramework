package com.gowri.End2End;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Tc4AddCustomers extends Base {
	public static XSSFWorkbook wb;

	public static XSSFSheet sheet;

	public static XSSFRow row;

	public static XSSFCell cell;

	public static FileInputStream fis;

	public static Logger log = LogManager.getLogger(Base.class.getName());
	Configfile co = new Configfile();
	

	@BeforeTest
	public void initialize() throws Exception {
		
		driver = initializeDriver();
		co.ReadFromExcel();

	}

	@Test
	public void addCustomers() throws Exception {
		PageObjects.ManagerHomePage MgrHome = new PageObjects.ManagerHomePage(driver);
		PageObjects.HomePage homepage = new PageObjects.HomePage(driver);
		driver.get(prop.getProperty("URL"));
		String title = homepage.banktitle().getText();
		Assert.assertEquals(prop.getProperty("BankName"), title);
		homepage.bankManagerlogin().click();
		Thread.sleep(3000);
		Row row;
		
		//Cell cell;
		// for all the rows in work sheet
		for (int r = 1; r <= Configfile.ws.getLastRowNum(); r++)
		{
			MgrHome.addcustomer().click();
			row = Configfile.ws.getRow(r);//each row
			MgrHome.addfirstname().sendKeys(row.getCell(0).getStringCellValue());
			MgrHome.addlastname().sendKeys(row.getCell(1).getStringCellValue());
			DataFormatter formatter = new DataFormatter();
			String val = formatter.formatCellValue(row.getCell(2));
			MgrHome.addpincode().sendKeys(val);
			MgrHome.confirmaddcustomer().click();
			driver.switchTo().alert().accept();
		}

		homepage.home().click();

	}

	@AfterTest
	public void teardown() throws IOException {

		driver.quit();
		driver = null;
		Configfile.fin.close();
		
		

	}

}
