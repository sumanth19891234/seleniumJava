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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod; 
import org.testng.annotations.Test;

import com.crm.qa.base.BaseSetup;
import com.crm.qa.pages.Amazon;
import com.crm.qa.pages.Flipkart;
import com.crm.qa.pages.Gmail;
import com.crm.qa.pages.HtmlWebsite;
import com.crm.qa.util.TestUtil;
  

public class AmazonTest  extends BaseSetup{
	 Amazon amazon;
	  @BeforeClass
	  public void setUp() throws Exception{ 
		  initialization(); 
		  }
	  
	  // TestCase1 : Verify Search functionality by searching a muliplte products in 
	  // amazon website and add to cart
	  @Test (priority=1)
	  public void AmazonSearch_Test() throws InterruptedException
	  { 
		  amazon= new Amazon();	 
		  amazon.SearchAndAddToCart();
	  }
	  
	  // TestCase2 : Verify delete cart functionality by deleting a muliplte products in 
	  // amazon cart
	  @Test (priority=2)
	  public void AmazonDeleteCart_Test() throws InterruptedException
	  { 
		  amazon.DeleteFromCart();
	  }
	  
}
