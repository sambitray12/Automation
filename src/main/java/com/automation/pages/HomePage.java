package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.BasePage;

public class HomePage extends BasePage
{
	LoginPage loginpage = new LoginPage();
	
	//this login button present on Homepage
	@FindBy(xpath = "//a[normalize-space()='Sign in']")
	WebElement Signin;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement Logo;
	
	public HomePage()
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	public LoginPage ClickSignin()
	{
		Signin.click();
		return loginpage;
	}

}
