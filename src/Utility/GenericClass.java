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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.JavascriptExecutor;

public class GenericClass extends WebDriverProvider{
    
    private final By CHOOSE_UPLOAD_FILE = By.xpath(".//*[@id='fileUploadInput']");
    
    public static List<WebElement> webElementCount = null;
    public static boolean webElementDisplay;
        
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
        pageToLoad();
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
    
    public void pressKeyDirectly(Keys key)
    {
        Actions action = new Actions(driver);
	    action.sendKeys(Keys.ENTER).perform();
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
    
    public boolean isElementDisplayed(By xpath)
    {
        webElementDisplay = driver.findElement(xpath).isDisplayed();
		if(webElementDisplay){
			return true;
		}else{
			return false;
		}
    } 
    
     public void ScrollToViewElement(By xpath) throws InterruptedException
    {
         JavascriptExecutor jse = (JavascriptExecutor) driver;
  		 jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(xpath));
  		 Thread.sleep(2000L);
         
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
	    action.moveToElement(driver.findElement(elementUniqueID)).build().perform();
        Thread.sleep(4000L);
    }    
    
    public void selectValueFromDropdown(By elementUniqueID,String optionToSelect)
    {
        Select dropdown = new Select(driver.findElement(elementUniqueID));
        dropdown.selectByVisibleText(optionToSelect);
    }
    
    public void clickUploadImage(By elementUniqueProvidedID)
    {
        buttonClick(elementUniqueProvidedID);
        pageToLoad();
        driver.switchTo().frame("filepicker_dialog");
    }
    
   public void directProductImageUpload(String imageFile) throws InterruptedException
    {
        enterText(CHOOSE_UPLOAD_FILE,imageFile);
        Thread.sleep(8000L);
        driver.switchTo().defaultContent();
    }
    
    public void clearData(By elementUniqueID)
    {
        
        driver.findElement(elementUniqueID).clear();
    }
    
    public void acceptAlert()
    {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        pageToLoad();
    }
    
    public static void dragAndDrop(By source, By destination) 
    {    
         WebElement sourceElement = driver.findElement(source);
         WebElement destinationElement = driver.findElement(destination);
		try 
        {
			if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) 
            {
				Actions action = new Actions(driver);
				action.dragAndDrop(sourceElement, destinationElement).build().perform();
			}
            else
            {
				System.out.println("Element was not displayed to drag");
			}
		}
		catch (StaleElementReferenceException e) 
		{
			System.out.println("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document " + e.getStackTrace());
		}
		catch (NoSuchElementException e) 
		{
			System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM " + e.getStackTrace());
		}
		catch (Exception e) 
		{
			System.out.println("Error occurred while performing drag and drop operation " + e.getStackTrace());
		}
	}
    
    public void switchToIFrame(By elementUniqueID)
    {
        WebElement frame = driver.findElement(elementUniqueID);
        driver.switchTo().frame(frame);
    }
}