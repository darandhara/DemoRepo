package com.rave.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.rave.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT =  20;
	public static String TESTDATA_SHEET_PATH="F:\\eclipse-workspace\\LatestFramework\\src\\main\\java\\com\\rave\\qa\\testData\\TestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public void swithToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	
	public static Object[][] getTestData(String sheetName) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException{
		FileInputStream file=null;
		try{
			//object creation and initialization with file path
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			book=WorkbookFactory.create(file);
		}catch (IOException e){
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++){
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		FileHandler.copy(scrFile, new File( "./screenshot/" + System.currentTimeMillis() + ".png"));
	
	}

}
