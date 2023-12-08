package com.demo.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.qa.base.BaseSetup;


public class Gmail extends BaseSetup{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[contains(@id,'identifierId')]")
	WebElement username;
	
	@FindBy(xpath="//input[contains(@type,'password')]")
	WebElement password;
	
	@FindBy(xpath="//span[normalize-space()='Next']")
	WebElement nextBtn;
	
	@FindBy(xpath="//a[normalize-space()='Gmail']")
	WebElement gmaiLink;
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signInBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	@FindBy(xpath="//a[@href=\"https://accounts.google.com/SignOutOptions?hl=en-GB&continue=https://mail.google.com&service=mail&ec=GBRAFw\"]")
	WebElement signOut;
	
	@FindBy(xpath="//div[contains(text(),'Sign out')]")
	WebElement signOutBtn;
	
	@FindBy(xpath="//span[normalize-space()='Choose an account']")
	WebElement chooseAccount;
	
	//Initializing the Page Objects:
	public Gmail(){
		PageFactory.initElements(driver, this);
	}
	//Initializing the Page Objects:
		public Gmail(WebDriver Driver){
			BaseSetup.driver=Driver;
			PageFactory.initElements(driver, this);
		}
		
	
	//Actions:
		public boolean verifyGmailLinkPresent(){
			return gmaiLink.isDisplayed();
		}
		
	public void clickGmailLink(){
		gmaiLink.click();
	}
	
	public Boolean login() throws InterruptedException{
		clickGmailLink();
		username.sendKeys(prop.getProperty("username"));
		nextBtn.click();
		Thread.sleep(5000);
		password.sendKeys(prop.getProperty("password"));
		nextBtn.click();
		return signOut.isDisplayed();
		
	}
	
	public Boolean logout(){
		Actions action = new Actions(driver);
		action.click(signOut).build().perform();
		signOutBtn.click();
		return chooseAccount.isDisplayed();
		
	}
	
}
