package com.gowri.End2End;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tc4AddCustomers extends Base{
	
	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}
	
  @Test
  public void addCustomers() {
	  System.out.print("Actual Code Starts Here");
  }
  
  @AfterTest
	public void teardown() {

		driver.quit();
		driver = null;

	}
}
