package com.automation.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.BasePage;

public class RegisterPage extends BasePage
{

	
	@FindBy(xpath = "//*[@id='SubmitCreate']/span")
	WebElement create_account;
	
	@FindBy(xpath = "//*[@id='email_create']")
	WebElement email;
	
	@FindBy(id = "id_gender1")
	WebElement mr_title;
	
	@FindBy(id = "customer_firstname")
	WebElement firstname;
	
	@FindBy(id = "customer_lastname")
	WebElement lastname;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(id = "firstname")
	WebElement address_firstname;
	
	@FindBy(id = "lastname")
	WebElement address_lastname;
	
	@FindBy(id = "company")
	WebElement company;
	
	@FindBy(id = "address1")
	WebElement address;
	
	@FindBy(id = "city")
	WebElement city;
	
	@FindBy(id = "postcode")
	WebElement zip;
	
	@FindBy(id = "phone_mobile")
	WebElement mobile;
	
	@FindBy(xpath = "//*[@value='My address']")
	WebElement myaddress;
	
	@FindBy(xpath = "//*[@id='submitAccount']")
	WebElement registersubmit;
	
	@FindBy(id = "days")
	WebElement date_dropdown;
	
	@FindBy(id = "months")
	WebElement month_dropdown;
	
	@FindBy(id = "years")
	WebElement year_dropdown;
	
	@FindBy(id = "id_state")
	WebElement state_dropdown;
	
	@FindBy(id = "id_country")
	WebElement country_dropdown;
	
	
	
	HomePage homepage;
	
	//Initialzing the page objects
	public RegisterPage()
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	public RegisterPage registerfuctionality()
	{
		
		new HomePage().ClickSignin();
		email.sendKeys(randomEmail());
		create_account.click();
		mr_title.click();
		firstname.sendKeys(prop.getProperty("firstname"));
		lastname.sendKeys(prop.getProperty("lastname"));
		password.sendKeys(prop.getProperty("password"));
		selectDropdown(date_dropdown, "12");
		selectDropdown(month_dropdown, "12");
		selectDropdown(year_dropdown, "2012");
		address_firstname.sendKeys(prop.getProperty("firstname"));
		address_lastname.sendKeys(prop.getProperty("firstname"));
		company.sendKeys(prop.getProperty("company"));
		address.sendKeys(prop.getProperty("Address"));
		city.sendKeys(prop.getProperty("city"));
		selectDropdown(state_dropdown, "12");
		zip.sendKeys(prop.getProperty("zip"));
		selectDropdown(country_dropdown, "21");
		mobile.sendKeys(prop.getProperty("mobile"));
		registersubmit.click();
		
		
		return this;
		
	}
	
	
	
	/*
	public boolean ValidateLoginSuccess()
	{
		return Signout.isDisplayed();
	}
	
	public boolean ValidatePageLoago()
	{
		
		return pagelogo.isDisplayed();
	}
	*/
	
	
}
