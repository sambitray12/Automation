package com.automation.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil 
{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_TIMEOUT = 10;
	
	public static String Sheetpath = System.getProperty("user.dir")+"/src/main/java/com/automation/testdata/LoginTestData.xlsx"; 
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] getTestData(String sheetname)
	{
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(Sheetpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++)
		{
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
			
		}
		return data;
		
	}
	
}
