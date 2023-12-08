package com.demo.qa.testcases;

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
import com.demo.qa.base.BaseSetup;
import com.demo.qa.pages.Gmail;
import com.demo.qa.util.TestUtil;
  
  
  public class GmailLoginTest extends BaseSetup{
  Gmail gmail= new Gmail();
  
  @BeforeMethod public void setUp() throws Exception{ 
	  initialization(); 
	  gmail= new Gmail();
	  }
  
  @Test 
  public void GmailLogin_Test() throws InterruptedException 
  { 
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
 