package com.vtiger.genericLib;



//import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;

import com.vtiger.objectRepository.HomeClass;
import com.vtiger.objectRepository.LoginClass;

public class BaseClass {
	public  WebDriver driver;
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	public HomeClass hc;
	public static WebDriver sdriver;
	
//	@Parameters("browser")
	@BeforeClass
	public void openBrowser() throws Throwable
	{
		String browserValue = pUtil.propertyFileUtility("browser");
		if(browserValue.equalsIgnoreCase("chrome"))
	{
	System.setProperty(IPathConstant.CHROME_KEY, IPathConstant.CHROME_VALUE);
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	}
	else if (browserValue.equalsIgnoreCase("Firefox")) {
		System.setProperty(IPathConstant.FIREFOX_KEY, IPathConstant.FIREFOX_VALUE);
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
		sdriver=driver;
	}
	
	@BeforeMethod
	public void login() throws Throwable
	{
		driver.get(pUtil.propertyFileUtility("url"));
		LoginClass lp = new LoginClass(driver);
		lp.LoginToApp(pUtil.propertyFileUtility("username"), pUtil.propertyFileUtility("password"));
		
	}
	
	@AfterMethod
	public void logout() throws Throwable
	{	wUtil.waitForPageLoad(driver);
		hc=new HomeClass(driver);
		hc.signOutFromApp();
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}

}
