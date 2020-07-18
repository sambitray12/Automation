package com.automation.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BasePage;
import com.automation.pages.AddtocartPage;
import com.automation.pages.LoginPage;
import com.automation.util.TestUtil;

public class AddtoCartTest extends BasePage
{
	
	LoginPage loginpage;
	AddtocartPage addtocartPage;
	TestUtil testutil;
	String sheetname = "credentials";
	
	public AddtoCartTest()
	{
		super();
	}
	
	@BeforeClass
	public void Initiate()
	{
		
		initilization();
		addtocartPage = new AddtocartPage();
	
	}
	
	
	  @DataProvider 
	  public Object [][] getTestData() 
	  {
		  Object [][] data = testutil.getTestData(sheetname); 
		  return data; 
	  }
	 
	
	@Test(priority=1,dataProvider = "getTestData")
	public void AddToCartVerification(String email,String password)
	{
		
		addtocartPage.AddtoCartFunctionality(email,password,prop.getProperty("addtocart_success_msg"));
	}
	
	
	
	@AfterClass
	public void Terminate()
	{
		driver.quit();
	}


}
