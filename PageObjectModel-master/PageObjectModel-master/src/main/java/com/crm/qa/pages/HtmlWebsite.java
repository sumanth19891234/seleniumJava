package com.crm.qa.pages;
import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseSetup;

public class HtmlWebsite  extends BaseSetup{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[contains(@id,'username')]")
	WebElement username;
	
	@FindBy(xpath="//input[contains(@id,'password')]")
	WebElement password;
	
	@FindBy(xpath="//button[contains(@id,'submit')]")
	WebElement submitBtn;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement logoutBtn;
	
	public HtmlWebsite() {
		PageFactory.initElements(driver, this);
		String path = new File("src/main/java/com/crm/qa/testdata/htmlwebsite.html").getAbsolutePath();
		driver.get("https://practicetestautomation.com/practice-test-login/");	
	}
	public void loginHTML() throws InterruptedException{
		username.sendKeys(prop.getProperty("userNameHTML"));
		Thread.sleep(2000);
		password.sendKeys(prop.getProperty("passwordHTML"));
		submitBtn.click();
		
	}
	
	public void logoutHTML(){
		logoutBtn.click();
		
	}
	

}
