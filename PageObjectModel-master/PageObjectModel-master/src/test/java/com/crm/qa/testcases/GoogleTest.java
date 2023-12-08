package com.crm.qa.testcases;

import java.io.File; 
import java.io.IOException;  
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
  
  public class GoogleTest extends BaseSetup{
  
  
  @BeforeMethod public void setUp() throws Exception{ initialization(); }
  
  @Test 
  public void GoogleTitleTest() 
  { 
	  driver.get("https://www.google.co.in");
	  String title = driver.getTitle(); 
	  System.out.println("title is: " + title);
	  if (title.equals("Google")) { 
		Assert.assertTrue(true);
		}
	  else 
		{
		Assert.assertTrue(false); 
		}
	  String url = driver.getCurrentUrl();
	  System.out.println(url);
	  if (url.equals("https://www.google.co.in/")) { 
			Assert.assertTrue(true);
	   }
		  else 
			{
			Assert.assertTrue(false,"Found URL :" +url+ " But was expecting https://www.google.co.in"); 
			}
  	}
}
 