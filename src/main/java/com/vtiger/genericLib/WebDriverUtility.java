package com.vtiger.genericLib;


import java.io.File;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class WebDriverUtility {
	//	public static WebDriver driver=null;
	@Test
	public void selectByIndex(WebElement ele, int index)
	{
		Select sel=new Select(ele);
		sel.selectByIndex(index);
	}
	public void selectByVisibleText(WebElement ele, String text)
	{
		Select sel= new Select(ele);
		sel.selectByVisibleText(text);
	}
	public void selectByValue(WebElement ele, String value)
	{
		Select sel= new Select(ele);
		sel.selectByValue(value);
	}
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void mouseHover(WebDriver driver, WebElement element)
	{

		Actions ac=new Actions(driver);
		ac.moveToElement(element).perform();
	}
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions ac=new Actions(driver);
		ac.doubleClick(element).perform();

	}
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions ac=new Actions(driver);
		ac.contextClick(element).perform();
	}
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest)
	{
		Actions ac=new Actions(driver);
		ac.dragAndDrop(src, dest).perform();
	}
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void popupText(WebDriver driver)
	{
		String popupText = driver.switchTo().alert().getText();
		Reporter.log(popupText);
	}
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String winID=it.next();
			String title = driver.switchTo().window(winID).getTitle();
			if(title.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	public void switchToFrame(String element,WebDriver driver)
	{
		driver.switchTo().frame(element);
	}
	public String takesScreenshot(WebDriver driver,  String screenshotName) throws IOException
	{	String current_date = new Date().toString().replace(" ", "_");
	String screenshotpath="./screenshot/"+screenshotName+current_date+".PNG";
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest= new File(screenshotpath);
	Files.copy(src, dest);
	return screenshotpath;

	}
	public void scrollToWebElement(WebDriver driver, WebElement element)
	{
		Point loc=element.getLocation();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy"+loc);
	}

	public void sendKeys( WebDriver driver, WebElement textbox, String value, String script)
	{
		if(textbox.isEnabled())
		{
			textbox.sendKeys(value);
		}
		else
		{

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript(script);
		}

	}




}
