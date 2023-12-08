package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseSetup;

public class Flipkart extends BaseSetup{
	
		@FindBy(xpath="//div[normalize-space()='APPLE iPhone 14 (Blue, 128 GB)']")
		WebElement mobileLabel;
		
		@FindBy(xpath="//input[@name='q']")
		WebElement searchBox;
		
		@FindBy(xpath="//div[div[normalize-space()='APPLE iPhone 14 (Blue, 128 GB)']]/following-sibling::div/div/descendant::div[contains(text(),'₹')][1]")
		WebElement mobilePrice;
		
		@FindBy(xpath="//button[@type='submit']")
		WebElement searchBtn;
		
		@FindBy(xpath="//div[@class='JFPqaw']/span")
		WebElement closeBtn;
		
		//Initializing the Page Objects:
		public Flipkart(){
			PageFactory.initElements(driver, this);
			driver.get("https://www.flipkart.com/");
		}
			
		
		public boolean verifyMobilePresent(){
				if(!mobileLabel.isDisplayed())
					driver.navigate().refresh();
				return mobileLabel.isDisplayed();
		}
			
		public String GetMobilePrice(){
			return mobilePrice.getText();
		}
		
		public void Search() throws InterruptedException{
			driver.navigate().refresh();
			if(closeBtn.isDisplayed())
			{
				Thread.sleep(2000);
				closeBtn.click();
			}
			searchBox.click();
			searchBox.sendKeys(prop.getProperty("mobile"));
			searchBtn.click();
			Thread.sleep(5000);
			
		}						
	
}
