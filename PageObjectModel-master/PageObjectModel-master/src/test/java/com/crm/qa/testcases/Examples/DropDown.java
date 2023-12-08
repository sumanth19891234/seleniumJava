package com.crm.qa.testcases.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseSetup;
import com.crm.qa.pages.HtmlWebsite;

public class DropDown extends BaseSetup {

	 @BeforeMethod public void setUp() throws Exception{ 
		  initialization(); 
	  }
	  
	  @Test 
	  public void WebsiteLogin_Test() throws InterruptedException
	  { 
		  driver.get("https://demo.guru99.com/test/newtours/register.php");
		  Select drpCountry = new Select(driver.findElement(By.name("country")));
			drpCountry.selectByVisibleText("AUSTRIA");

			//Selecting Items in a Multiple SELECT elements
			driver.get("http://jsbin.com/osebed/2");
			Select fruits = new Select(driver.findElement(By.id("fruits")));
			fruits.selectByVisibleText("Banana");
			fruits.selectByIndex(1);
	  }
	
	  
	
}
