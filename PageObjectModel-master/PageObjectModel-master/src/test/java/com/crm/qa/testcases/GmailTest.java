package com.crm.qa.testcases;

import java.io.File; 
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert; 
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.pages.Gmail;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;
  
  
  public class GmailTest {
		public static WebDriver driver;
		public static Properties prop;
		public  static EventFiringWebDriver e_driver;
		public static WebEventListener eventListener;
  /**
	 * This function will execute before each Test tag in testng.xml
	 * @param browser
	 * @throws Exception
	 */
	@BeforeTest
	@Parameters("browser")
	public void setup(@Optional("FF")String browser) throws Exception
	{
		//Check if parameter passed as 'chrome'
		if(browser.equals("chrome"))
		{
			//create chrome instance
			String path = new File("BrowserDrivers/chromedriver_win32/chromedriver.exe").getAbsolutePath();
			System.setProperty("webdriver.chrome.driver", path);	
			driver = new ChromeDriver(); 
		}		
		else if(browser.equals("FF")){
			String path = new File("BrowserDrivers/geckodriver/geckodriver.exe").getAbsolutePath();
			System.setProperty("webdriver.gecko.driver", path);	
			driver = new FirefoxDriver(); 
		}
		else if(browser.equalsIgnoreCase("Edge")){
			String path = new File("BrowserDrivers/edgedriver_win64/msedgedriver.exe").getAbsolutePath();
			//set path to Edge.exe
			System.setProperty("webdriver.edge.driver",path);
			//create Edge instance
			driver = new EdgeDriver();
		}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}
	 @Test 
	 public void GmailClickTest() 
	 { 
		  Gmail gmail=new Gmail(driver);
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
		  gmail.clickGmailLink();
  	 }
		   
}
 