package AHALIFESITE;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.net.MalformedURLException;
import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

class HomePage extends GenericClass{

    private final By SEARCH_TEXT = By.xpath(".//input[@class='desktop-search-input']");
    private final By ACTUAL_SEARCHED_PRODUCT_NAME = By.xpath(".//ul[@id='products']/li/a[2]/div/h2/p");
    private final By ACTUAL_SEARCHED_BRAND_NAME = By.xpath(".//ul[@id='brands-list']/li[1]/a/div[2]/div/div[1]");
    private final By BRAND_TAB_SWITCH = By.xpath(".//*[@id='tab2']");
    private final By ANCHOR_TAG = By.tagName("a");
    private final By FOOTER_BUTTON = By.xpath(".//*[@id='show-footer-btn']");
    private final By FOOTER_EMAIL_SUBSCRIPTION_EMAIL_ID = By.xpath(".//*[@id='footerSubscriptionEmailAddress']");
    private final By HOME_FOOTER_SUBSCRIBE_CLICK = By.xpath(".//*[@id='footerEmailSubscriptionForm']/div[1]/input[2]");
    private final By PDP_FOOTER_SUBSCRIBE_CLICK = By.xpath(".//*[@id='footerEmailSubscriptionForm']/input[2]");
    private final By HOME_SUBSCRIPTION_CONFIRMATION_MESSAGE = By.xpath(".//*[@id='footerEmailSubscriptionForm']/div[2]");
    private final By PDP_SUBSCRIPTION_CONFIRMATION_MESSAGE = By.xpath(".//*[@id='footerEmailSubscriptionForm']/div");
    //private final By SUBSCRIPTION_CONFIRMATION_WINDOW = By.xpath(".//*[@id='thankYouModal']");
    private final By GIFT_POPUP = By.xpath(".//*[@id='simpleRegModal']");
    private final By CLOSE_GIFT_POPUP = By.xpath(".//a[@id='id-close-auth-modal']/img");
    
    static String actualSearchedProductName = null;
    static String expectedSearchedItem = null;
    static String actualSearchedBrand = null;
    static List<WebElement> urlListElements = null;
    static int statusCode;
    static List<Integer> statusCodeList = new ArrayList<Integer>();
    static Stopwatch pageLoad = null;
    static String actualSubscriptionMessage = null;
    static String expectedSubscriptionMessage = null;
	static int int1;
    
    public void enterSearchItem(HashMap<String, String> searchItem)
    {
        pageToLoad();
        expectedSearchedItem = searchItem.get("SearchItem");
        enterText(SEARCH_TEXT,expectedSearchedItem);
        System.out.println("expectedSearchedItem= "+ expectedSearchedItem);
    }
    
    public void pressEnter(HashMap<String, String> enter)
    {
        pressKey(SEARCH_TEXT,Keys.ENTER);
        pageToLoad();
    }
    
    
    public void clickBrandTab(HashMap<String, String> brandTab)
    {
        pageToLoad();
        buttonClick(BRAND_TAB_SWITCH);
    }
    
    public void verifySearchedProduct(HashMap<String, String> searchProduct) 
    {
        actualSearchedProductName = getTextFromAnElement(ACTUAL_SEARCHED_PRODUCT_NAME);
        System.out.println("actualSearchedProductName= "+ actualSearchedProductName);
        int1 = expectedSearchedItem.compareToIgnoreCase(actualSearchedProductName);
        if(int1!=0)             
        {
              System.out.println("Verified Searched item!");
        }
    }
    
    public void verifySearchedBrand(HashMap<String, String> searchBrand) 
    {
        actualSearchedBrand = getTextFromAnElement(ACTUAL_SEARCHED_BRAND_NAME);
        Assert.assertTrue(actualSearchedBrand.equalsIgnoreCase(expectedSearchedItem));
    }
    
    public void clickFooterButton(HashMap<String, String> footerButton) throws InterruptedException
    {
        buttonClick(FOOTER_BUTTON);
        Thread.sleep(2000L);
    }
    
    public void enterSubscriptionEmailID(HashMap<String, String> footerSubscribeEmailId)
    {
        pageToLoad();
        enterText(FOOTER_EMAIL_SUBSCRIPTION_EMAIL_ID,footerSubscribeEmailId.get("SubscriptionEmailID"));
    }
    
    public void clickSubscribeHome(HashMap<String, String> subscribeClick) throws InterruptedException
    {
       
        //Actions actions = new Actions(driver);
        //actions.moveToElement(driver.findElement(FOOTER_SUBSCRIBE_CLICK)).click().perform();
        buttonClick(HOME_FOOTER_SUBSCRIBE_CLICK);
        Thread.sleep(5000L);
      
    }
      public void clickSubscribePDP(HashMap<String, String> subscribeClick) throws InterruptedException
    {
        buttonClick(PDP_FOOTER_SUBSCRIBE_CLICK);
        Thread.sleep(5000L);
      
    }
    
    public void verifySubscriptionSuccessMessageHome(HashMap<String, String> successfulSubscriptionMessage) 
    {
		
        
        actualSubscriptionMessage = getTextFromAnElement(HOME_SUBSCRIPTION_CONFIRMATION_MESSAGE);
        expectedSubscriptionMessage = successfulSubscriptionMessage.get("ExpectedSuccessfulSubscriptionMessage");
        System.out.println("actualSubscriptionMessage= "+ actualSubscriptionMessage);
        System.out.println("expectedSubscriptionMessage= "+ expectedSubscriptionMessage);
        Assert.assertTrue(actualSubscriptionMessage.equalsIgnoreCase(expectedSubscriptionMessage));
    }
        public void verifySubscriptionSuccessMessagePDP(HashMap<String, String> successfulSubscriptionMessage) 
    {
		
        
        actualSubscriptionMessage = getTextFromAnElement(PDP_SUBSCRIPTION_CONFIRMATION_MESSAGE);
        expectedSubscriptionMessage = successfulSubscriptionMessage.get("ExpectedSuccessfulSubscriptionMessage");
        System.out.println("actualSubscriptionMessage= "+ actualSubscriptionMessage);
        System.out.println("expectedSubscriptionMessage= "+ expectedSubscriptionMessage);
        Assert.assertTrue(actualSubscriptionMessage.equalsIgnoreCase(expectedSubscriptionMessage));
    }
    
    public void verifyIfBrokenLinksPresent(HashMap<String, String> homePageBrokenLinks) throws MalformedURLException, IOException
    { 
       if(isElementExist(ANCHOR_TAG))
       {  
          urlListElements = listOfWebElements(ANCHOR_TAG);
          System.out.println("Total URL Count is : " + urlListElements.size());
           
          for (int i = 0; i < urlListElements.size(); i++)
          { 
           try
           {
	         if (!(urlListElements.get(i).getAttribute("href") == null) && !(urlListElements.get(i).getAttribute("href").equals("")) && !(urlListElements.get(i).getAttribute("href").equals("javascript:void(0);")))
             {
	            if (urlListElements.get(i).getAttribute("href").contains("http")) 
                { 
	                statusCode= getResponseCode(urlListElements.get(i).getAttribute("href").trim());
                    if(statusCode == 403)
                    {
                        System.out.println("HTTP 403 Forbidden# " + i + " " + urlListElements.get(i).getAttribute("href"));
                    }
                    else
	                if (statusCode == 404 || statusCode == 500) 
                    {  
	                    System.out.println("LINK# "+i+" "+urlListElements.get(i).getAttribute("href") + " is BROKEN");  
	                }
                    else
                    {
                        System.out.println("LINK# "+i+" "+urlListElements.get(i).getAttribute("href") + " is NOT BROKEN");  
                    }
                    statusCodeList.add(statusCode);
	             }  
	         }
          }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
             System.out.println("Stale Element Found!!");  
             System.out.println("Stale Element Found at" + i + " " + urlListElements.get(i));  
             System.out.println(urlListElements.get(i).getAttribute("outerHTML"));
            System.out.println(urlListElements.get(i).getAttribute("innerHTML"));  
        }
       }
        
         if(statusCodeList.contains(404) || statusCodeList.contains(500) || statusCodeList.contains(403))
		 	{
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}  
       }
       else
       {
           System.out.println("There are no anchor tags in the AHA Life Home Page"); 
           Assert.assertTrue(true);
       }
    }
    
    
    public void createStopwatch(HashMap<String, String> pageLoadTime)
    {
        pageLoad = Stopwatch.createStarted();
    }
    
    public void getPageLoadTime(HashMap<String, String> pageLoadTime)
    {
		pageLoad.stop();
	    long pageLoadTime_seconds = pageLoad.elapsed(TimeUnit.SECONDS);
	    System.out.println("Total Page Load Time: " + pageLoadTime_seconds + " Seconds");
    }
    
    
    public void closeGiftPopup(HashMap<String, String> giftPopup) throws InterruptedException
    {
        pageToLoad();
        if(isElementExist(GIFT_POPUP))
        {
        if(isElementDisplayed(GIFT_POPUP))
        {
        buttonClick(CLOSE_GIFT_POPUP);
        Thread.sleep(4000L);
        }
        else
        {
          System.out.println("GIFT POPUP NOT DISPLAYED");        
        }
        }
        else
        {
          System.out.println("NO SUCH ELEMENT EXIST");  
        }
    }
    
    
    
    
    
}