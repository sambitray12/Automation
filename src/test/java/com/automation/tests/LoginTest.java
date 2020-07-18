package com.automation.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.BasePage;
import com.automation.pages.LoginPage;
import com.automation.util.TestUtil;

public class LoginTest extends BasePage
{
	
	LoginPage loginpage;
	TestUtil testutil;
	String sheetname = "credentials";
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeClass
	public void Initiate()
	{
		
		initilization();
		loginpage = new LoginPage();
	
	}
	
	
	  @DataProvider 
	  public Object [][] getTestData() 
	  {
		  Object [][] data = testutil.getTestData(sheetname); 
		  return data; 
	  }
	 
	
	@Test(priority=1,dataProvider = "getTestData")
	public void LoginVerification(String email,String password)
	{
		
		loginpage.loginTest(email,password);
	}
	
	
	
	@AfterClass
	public void Terminate()
	{
		driver.quit();
	}

}
