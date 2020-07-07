package com.automation.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.BasePage;

public class LoginPage extends BasePage
{

	
	@FindBy(id = "email")
	WebElement username;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(id = "SubmitLogin")
	WebElement signin;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement pagelogo;
	
	@FindBy(xpath = "//a[text()='Best Sellers']")
	WebElement purchasesection;
	
	@FindBy(xpath = "//a[@title='Log me out']")
	WebElement Signout;
	
	HomePage homepage;
	
	//Initialzing the page objects
	public LoginPage()
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	public LoginPage loginfuctionality(String usr,String pwd)
	{
		
		new HomePage().ClickSignin();
		username.sendKeys(usr);
		password.sendKeys(pwd);
		signin.click();
		return this;
		
	}
	
	public LoginPage loginTest(String usr,String pwd)
	{
		loginfuctionality(usr,pwd);
		assertTrue(ValidateLoginSuccess());
		return this;
		
	}
	
	
	public boolean ValidateLoginSuccess()
	{
		return Signout.isDisplayed();
	}
	
	public boolean ValidatePageLoago()
	{
		
		return pagelogo.isDisplayed();
	}
	
	
	
}
