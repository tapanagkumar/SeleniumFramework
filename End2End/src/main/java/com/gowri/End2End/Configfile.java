package com.gowri.End2End;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Configfile {

	
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFSheet ws1;
	public static FileInputStream fin;
	public static FileOutputStream fout;

	//Read from Excel
		public void ReadFromExcel() throws Exception
		{
			// Read the login details from excel sheet stored in resources folder

					// file for reading the user name and password
					 fin = new FileInputStream(
							 System.getProperty("user.dir") + "\\src\\main\\java\\com\\gowri\\Resources\\data.xlsx");
					 wb = new XSSFWorkbook(fin);
					 ws = wb.getSheet("contacts");
					 ws1=wb.getSheet("Registration");

					
			
		}
}
