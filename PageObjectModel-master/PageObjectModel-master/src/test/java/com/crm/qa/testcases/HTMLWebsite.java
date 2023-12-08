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
  

public class HTMLWebsite  extends BaseSetup{

	  @BeforeMethod public void setUp() throws Exception{ 
		  initialization(); 
	  }
	  
	  @Test 
	  public void WebsiteLogin_Test() throws InterruptedException
	  { 
		  HtmlWebsite htmlweb = new HtmlWebsite();	 
		  htmlweb.loginHTML();
		  htmlweb.logoutHTML();
	  }
}
