package com.crm.qa.testcases.Examples;

import java.io.File; 
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.JavascriptExecutor; 
import org.openqa.selenium.OutputType; 
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod; 
import org.testng.annotations.Test;

import com.crm.qa.base.BaseSetup;
import com.crm.qa.pages.Amazon;
import com.crm.qa.pages.Flipkart;
import com.crm.qa.pages.Gmail;
import com.crm.qa.pages.HtmlWebsite;
import com.crm.qa.util.TestUtil;
  

public class Notifications  extends BaseSetup{
	 Amazon amazon;
	  @BeforeClass
	  public void setUp() throws Exception{ 
		  initialization(); 
		  }

	  @Test (priority=1)
	  public void Suppress_PushNotification() throws InterruptedException
	  { 
			driver.get("https://www.redbus.in");
	  }
	 
	  @Test (priority=2)
	  public void Suppress_PushNotification2() throws InterruptedException
	  { 
			driver.get("https://www.redbus.in");
	  }
	  
	  @Test (priority=3)
	  public void Suppress_GeoLocationPopup() throws InterruptedException
	  { 
			driver.get("https://www.google.com");
	  }
	  
}
