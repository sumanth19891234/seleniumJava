package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class BaseSetup {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public BaseSetup(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			String path = new File("BrowserDrivers/chromedriver_win32/chromedriver.exe").getAbsolutePath();
			System.out.println(path);
			System.setProperty("webdriver.chrome.driver", path);	
			/* Handle PushNotifications
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-notifications");
			*/
			/* Handle geo notification bar
			 ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("disable-geolocation");
			ChromeDriver driver = new ChromeDriver(options); 			 
			 */			
			/* Handle Chrome Automation InfoBar 
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("start-maximized");
			 options.addArguments("disable-infobars");
			 driver = new ChromeDriver(options); */			 
			 driver = new ChromeDriver(); 		
		}
		else if(browserName.equals("FF")){
			String path = new File("BrowserDrivers/geckodriver/geckodriver.exe").getAbsolutePath();
			System.out.println(path);
			System.setProperty("webdriver.gecko.driver", path);	
			driver = new FirefoxDriver(); 
		}	else if(browserName.equalsIgnoreCase("Edge")){
			String path = new File("BrowserDrivers/edgedriver_win64/msedgedriver.exe").getAbsolutePath();
			//set path to Edge.exe
			System.setProperty("webdriver.edge.driver",path);
			//create Edge instance
			driver = new EdgeDriver();
		}
				
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				
	}
	
	
	
	
	
	
	
	

}
