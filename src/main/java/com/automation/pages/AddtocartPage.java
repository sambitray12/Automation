package com.automation.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.BasePage;

public class AddtocartPage extends BasePage
{
	RegisterPage RegisterPage;
	HomePage homepage;

	@FindBy(xpath = "//a[normalize-space()='Sign in']")
	WebElement Signin;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement Logo;
	
	//Always click the 1st product in the section
	@FindBy(xpath="//*[@id='homefeatured']/li[1]/div/div[1]/div/a[1]/img")
	WebElement product;
	
	@FindBy(xpath="//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span")
	WebElement addtocart;
	
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/h2/span[2]")
	WebElement addedtocart;
	
	public AddtocartPage()
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void AddtoCartFunctionality(String username,String password,String msg)
	{
		new RegisterPage().registerfuctionality();
		new HomePage().ClickLogo();
		scrolldown();
		mousehover(product);
		VerifyAddtoCartSuccessmsg(msg);
		
		
	}
	
	public void VerifyAddtoCartSuccessmsg(String expected)
	{
		addtocart.click();
		explicitwait("//*[@id='layer_cart']/div[1]/div[2]/h2/span[2]", addedtocart);
		String successmsg = addedtocart.getText();
		assertEquals(successmsg, expected);
	}
	

}
