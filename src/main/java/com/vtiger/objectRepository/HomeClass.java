package com.vtiger.objectRepository;




import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericLib.WebDriverUtility;




public class HomeClass extends WebDriverUtility{
	WebDriver driver;
	public HomeClass(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='More']") private WebElement moreLink;
	@FindBy(xpath="//a[@name='Purchase Order']") private WebElement poLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']") private WebElement adminImg;
	@FindBy(xpath="//a[text()='Sign Out']") private WebElement signOutLink;
	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getPoLink() {
		return poLink;
	}
	public WebElement getAdminImg() {
		return adminImg;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void clickOnMore()
	{
		moreLink.click();
	}
	
	public void clickOnPOLink()
	{	
		poLink.click();
	}
	public void signOutFromApp() throws Throwable
	{ Thread.sleep(2000);
		mouseHover(driver, adminImg);
		Thread.sleep(2000);
		signOutLink.click();	
	}
	

}
