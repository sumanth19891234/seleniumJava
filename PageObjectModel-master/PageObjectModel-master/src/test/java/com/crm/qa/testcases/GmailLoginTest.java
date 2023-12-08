package com.crm.qa.testcases;

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
import org.testng.annotations.BeforeMethod; 
import org.testng.annotations.Test;

import com.crm.qa.base.BaseSetup;
import com.crm.qa.pages.Gmail;
import com.crm.qa.pages.HtmlWebsite;
import com.crm.qa.util.TestUtil;
  
  
  public class GmailLoginTest extends BaseSetup{
  Gmail gmail= new Gmail();
  
  @BeforeMethod public void setUp() throws Exception{ 
	  initialization(); 
	  }
  
  @Test 
  public void GmailLogin_Test() throws InterruptedException 
  { 
	  gmail= new Gmail();

	  driver.get("https://www.google.co.in");
	  driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

	  if (gmail.login()) { 
		Assert.assertTrue(true);
		}
	  else 
		{
		Assert.assertTrue(false,"Gmail Login Functionality Failed!!!!"); 
		}
	  if (gmail.logout()) { 
			Assert.assertTrue(true);
	   }
		  else 
			{
			Assert.assertTrue(false,"Gmail Logout Functionality Failed!!!!"); 
			}
  }
  
  
}
 