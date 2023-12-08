package com.demo.qa.testcases;

import java.io.File; 
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.JavascriptExecutor; 
import org.openqa.selenium.OutputType; 
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert; 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.demo.qa.base.BaseSetup;
import com.demo.qa.pages.Gmail;
import com.demo.qa.util.TestUtil;
import com.demo.qa.util.WebEventListener;
  
  
  public class GmailTest {
		public static WebDriver driver;
		public static Properties prop;
		public  static EventFiringWebDriver e_driver;
		public static WebEventListener eventListener;
		Gmail gmail;
  /**
	 * This function will execute before each Test tag in testng.xml
	 * @param browser
	 * @throws Exception
	 */
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		//Check if parameter passed as 'chrome'
		if(browser.equals("chrome")){
			//create chrome instance
			System.setProperty("webdriver.chrome.driver", "C:/SeleniumJava/Demo/BrowserDrivers/chromedriver_win32/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}		
		else if(browser.equals("FF")){
			
			System.setProperty("webdriver.gecko.driver", "C:/SeleniumJava/Demo/BrowserDrivers/geckodriver/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		else if(browser.equalsIgnoreCase("Edge")){
			//set path to Edge.exe
			System.setProperty("webdriver.edge.driver","C:/SeleniumJava/Demo/BrowserDrivers/edgedriver_win64/msedgedriver.exe");
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
		gmail=new Gmail(driver);

	}
	 @Test 
	 public void GmailClickTest() 
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
 