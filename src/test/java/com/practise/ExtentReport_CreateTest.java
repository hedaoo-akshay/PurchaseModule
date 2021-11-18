package com.practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReport_CreateTest {
 WebDriver driver;
 ExtentHtmlReporter reporter;
 ExtentReports reports;
 ExtentTest test;
	
	@BeforeSuite
	public void setupExtent()
	{
		String dirpath = System.getProperty("user.dir");
		String extentpath= dirpath+"/VtigerReport.html";
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		reporter=new ExtentHtmlReporter(extentpath);
		reporter.config().setDocumentTitle("vTiger");
		reporter.config().setTheme(Theme.DARK);
		
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("Tester", "Akshay");
		reports.setSystemInfo("Env", "windows");
		reports.setSystemInfo("Build", "5.0.0");
		reports.setSystemInfo("Browser version", "91");
	}
	
	@Test
	public void lanch_fb()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test=reports.createTest("lanch_fb");
		driver.get("https://www.facebook.com/");
		String actual_title = driver.getTitle();
		Assert.assertEquals(actual_title, "Facebook" );
	}
	
	@Test
	public void launch_vTiger()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test=reports.createTest("launch_vTiger");
		driver.get("http://localhost:8888/");
		String actual_vtitle = driver.getTitle();
		Assert.assertEquals(actual_vtitle, "abc" );
	}
	
	@AfterSuite
	public void closeSetup()
	{
		driver.close();
		reports.flush();
		
	}
	
	


}
