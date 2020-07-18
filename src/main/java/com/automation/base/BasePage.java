package com.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.util.TestUtil;


public class BasePage 
{

	public static WebDriver driver;
	public static Properties prop;
	
	
	public BasePage() 
	{
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/automation/configuration/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	
	public static void initilization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		implicitwait();
		
		driver.get(prop.getProperty("url"));
	}
	
	public static void implicitwait()
	{
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
	}
	
	public static void explicitwait(String Xpath,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,TestUtil.PAGE_LOAD_TIMEOUT);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
		
	}
	
	public static void scrolldown()
	{
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,550)");
	}
	
	public static void scrollup()
	{
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)");
	}
	
	public static void mousehover(WebElement element)
	{
		 Actions action = new Actions(driver);
		 action.moveToElement(element).build().perform();
		
	}
	
	public static String randomEmail(){
		
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		String emailprefix = "automation";
		String emailDomain = "@mailsac.com";
		String email = emailprefix + timeStamp + emailDomain;
		System.out.println(email);
		return email;
	}
	
public static void selectDropdown(WebElement element,String value)
{
		Select sel = new Select(element);
		sel.selectByValue(value);
		
	}
	
	
	
}
