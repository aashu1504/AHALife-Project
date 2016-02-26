package Utility;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Utility.WebDriverProvider;
import org.openqa.selenium.Keys;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenericClass extends WebDriverProvider{
    
    public static List<WebElement> webElementCount = null;
        
    public static void pageToLoad() {
	    String  pageLoadStatus;
	    JavascriptExecutor   js;
	      do {
	          js = (JavascriptExecutor) driver;
	        pageLoadStatus = (String)js.executeScript("return document.readyState");
	        try {
	     Thread.sleep(6000L);
	    } catch (InterruptedException e) {
	     
	     e.printStackTrace();
	    }
	        
	      } while ( !pageLoadStatus.equals("complete") );
	      
	    }

    public void navigateToUrl(HashMap<String, String> navigateUrl) throws InterruptedException
    {
        String urlToNavigate = navigateUrl.get("URL");
        driver.get(urlToNavigate);
        Thread.sleep(4000L);
    }
    
    public String getTextFromAnElement(By elementUniqueID)
    {
        return driver.findElement(elementUniqueID).getText();
    }
    
    public String getPageTitle()
    {
        return driver.getTitle();
    }
    
    public void enterText(By elementUniqueID,String inputText)
    {
        driver.findElement(elementUniqueID).sendKeys(inputText);
    }
    
    public void pressKey(By elementUniqueID,Keys key)
    {
        driver.findElement(elementUniqueID).sendKeys(key);
    }
    
    public void buttonClick(By elementUniqueID)
    {
        driver.findElement(elementUniqueID).click();
    }
    
    public String getAttributeValue(By elementUniqueID,String attributeType)
    {
        return driver.findElement(elementUniqueID).getAttribute(attributeType);
    } 
    
    public boolean isElementExist(By xpath)
    {
        webElementCount = driver.findElements(xpath);
		if(webElementCount.size()>0){
			return true;
		}else{
			return false;
		}
    } 
    
    public int countOfElements(By xpath)
    {
        webElementCount = driver.findElements(xpath);
        return webElementCount.size();
    }
    
    public List<WebElement> listOfWebElements(By xpath)
    {
        return driver.findElements(xpath);
    }
    
    public int getResponseCode(String urlString) throws MalformedURLException, IOException
    {
        URL urlToCheck = new URL(urlString); 
        HttpURLConnection urlConnection = (HttpURLConnection) urlToCheck.openConnection();  
        urlConnection.setRequestMethod("GET");  
        urlConnection.connect();  
        return urlConnection.getResponseCode();  
    }
    
    public void mouseHoverOn(By elementUniqueID) throws InterruptedException
    {
        Actions action = new Actions(driver);
        //action.moveToElement(driver.findElement(elementUniqueID)).moveToElement(driver.findElement(secondElementToMoveTo)).click(driver.findElement(secondElementToMoveTo));
	    action.moveToElement(driver.findElement(elementUniqueID)).build().perform();
        Thread.sleep(4000L);
        
    }
    
    public void waitTillElementVisible(By elementUniqueID)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementUniqueID));
    }
    
}