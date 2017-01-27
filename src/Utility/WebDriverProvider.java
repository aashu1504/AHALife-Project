package Utility;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {
    
    public static WebDriver driver = null;
    static String getBrowserType = null;
    
    public void getBrowser(HashMap<String, String> browser)
    {
         getBrowserType = browser.get("BROWSER");
         openBrowser(getBrowserType);
	}
    
    public void openBrowser(String browserType)
    {
        if(getBrowserType !=null)
        {
            switch (browserType) 
            {
			case "Chrome":
				initializeChromeDriver();
				break;
			case "Firefox":
				initializeFirefoxDriver();
				break;
			default:
				initializeFirefoxDriver();
			}
        }
        else
        {
            initializeChromeDriver();
        }
        
    }
    
    public void initializeFirefoxDriver() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
    
    public void initializeChromeDriver() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","/Users/asishs/Downloads/RedwoodHQAgent/agent/lib/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
    
    
    
    public void closeBrowser(HashMap<String, String> closeBrowser)
    {
		 driver.close();
	}
    
}