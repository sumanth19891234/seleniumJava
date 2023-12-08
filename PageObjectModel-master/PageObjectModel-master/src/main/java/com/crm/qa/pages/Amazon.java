package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BaseSetup;

public class Amazon extends BaseSetup{
		
		@FindBy(xpath="//input[@id='twotabsearchtextbox']")
		WebElement searchBox;
		
		@FindBy(xpath="//input[@id='nav-search-submit-button']")
		WebElement searchBtn;
		
		@FindBy(xpath="//div[@data-cel-widget='search_result_2']/descendant::img")
		WebElement seconddevice;	
		
		@FindBy(xpath="//div[@class='JFPqaw']/span")
		WebElement closeBtn;
		
		@FindBy(xpath="//div[@class='sc-list-item-content']/descendant::input[@value='Delete']")
		List<WebElement> deleteBtns;
		
		//Initializing the Page Objects:
		public Amazon(){
			PageFactory.initElements(driver, this);
			driver.get("https://www.amazon.in/");
		}
			
		public void NavigateAndAddToCart(String devices)  throws InterruptedException{
			searchBox.clear();
			searchBox.click();
			searchBox.sendKeys(prop.getProperty(devices));
			searchBtn.click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(3000);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,500)");
			Thread.sleep(1000);
			//seconddevice.click();
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", seconddevice);	
			Thread.sleep(2000);
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());			
			if(tabs.size()>0)
				driver.switchTo().window(tabs.get(1));	
			Thread.sleep(2000);
			jse.executeScript("window.scrollBy(0,500)");
			WebElement addToCartBtn= driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
			addToCartBtn.click();		
			driver.close();
			driver.switchTo().window(tabs.get(0));			
		}
		
		public void SearchAndAddToCart() throws InterruptedException{
			NavigateAndAddToCart("mobileamazon");
			NavigateAndAddToCart("laptop");
			NavigateAndAddToCart("airdopes");			
		}	
		
		public void DeleteFromCart() throws InterruptedException{
			WebElement cartBtn= driver.findElement(By.xpath("//a[@id='nav-cart']"));
			cartBtn.click();			
			for(WebElement btn : deleteBtns) {
				DeleteCart(btn);			
            }  
		}
		public void DeleteCart(WebElement btn)  throws InterruptedException{
			boolean isNameHtmlElementStale = ExpectedConditions.stalenessOf(btn).apply(driver);
			if(isNameHtmlElementStale){
				btn= driver.findElement(By.xpath("//div[@class='sc-list-item-content']/descendant::input[@value='Delete']"));
			}
			 WebDriverWait wait = new WebDriverWait(driver, 30);
			 wait.until(ExpectedConditions.visibilityOf(btn));			    
			btn.click();
		}
}
