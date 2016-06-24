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

class HomePage extends GenericClass{
    
    //private final By PRODUCT_ID = By.xpath(".//div[@class='container homepage ng-scope']/div[5]/div/div/div/div/ul/li[3]/a/div[2]/h4");
    //private final By QUICK_VIEW = By.xpath(".//div[@class='container homepage ng-scope']/div[5]/div/div/div/div/ul/li[3]/a/div[1]/div[3]");
    //private final By ADD_TO_BAG_HOME = By.xpath(".//*[@id='buy-button']");
    //private final By CLOSE_QUICK_VIEW = By.xpath(".//*[@id='id-close-quick-view']");
    //private final By PRODUCT_NAME_QUICK_VIEW = By.xpath(".//*[@id='id-product-quick-view']/div[3]/div[2]/a[1]");
    private final By SEARCH_TEXT = By.xpath(".//div[@class='search-wrap']/a/form/input");
    private final By ACTUAL_SEARCHED_PRODUCT_NAME = By.xpath(".//ul[@id='products']/li/a/div[2]/h4");
    private final By ACTUAL_SEARCHED_BRAND_NAME = By.xpath(".//ul[@id='brands-list']/li/a/div[2]/div/div[1]");
    private final By BRAND_TAB_SWITCH = By.xpath(".//*[@id='tab2']");
    private final By ANCHOR_TAG = By.tagName("a");
    
    static String actualSearchedProductName = null;
    static String expectedSearchedItem = null;
    static String actualSearchedBrand = null;
    static List<WebElement> urlListElements = null;
    static int statusCode;
    static List<Integer> statusCodeList = new ArrayList<Integer>();
    static Stopwatch pageLoad = null;

    
    public void enterSearchItem(HashMap<String, String> searchItem)
    {
        expectedSearchedItem = searchItem.get("SearchItem");
        enterText(SEARCH_TEXT,expectedSearchedItem);
        pageToLoad();
    }
    
    public void pressEnter(HashMap<String, String> enter)
    {
        pressKey(SEARCH_TEXT,Keys.ENTER);
    }
    
    
    public void clickBrandTab(HashMap<String, String> brandTab)
    {
        buttonClick(BRAND_TAB_SWITCH);
    }
    
    public void verifySearchedProduct(HashMap<String, String> searchProduct) 
    {
        actualSearchedProductName = getTextFromAnElement(ACTUAL_SEARCHED_PRODUCT_NAME);
        Assert.assertTrue(actualSearchedProductName.equalsIgnoreCase(expectedSearchedItem));
    }
    
    public void verifySearchedBrand(HashMap<String, String> searchBrand) 
    {
        actualSearchedBrand = getTextFromAnElement(ACTUAL_SEARCHED_BRAND_NAME);
        Assert.assertTrue(actualSearchedBrand.equalsIgnoreCase(expectedSearchedItem));
    }
    
    //public String clickProduct(HashMap<String, String> product)
    //{
      //  productNameAtHomePage = getTextFromAnElement(PRODUCT_ID);
        //buttonClick(PRODUCT_ID);
        //return productNameAtHomePage;
    //}
    
    //public String clickQuickView(HashMap<String, String> quickView)
    //{
      //  productNameAtHomePage = getTextFromAnElement(PRODUCT_ID);
        //buttonClick(QUICK_VIEW);
        //return productNameAtHomePage;
    //}
    
   // public void clickAddToBagHome(HashMap<String, String> quickViewAdd)
    //{
      //  WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_BAG_HOME));
        //buttonClick(ADD_TO_BAG_HOME);
    //}
    
    //public void closeQuickView(HashMap<String, String> quickViewClose)
    //{
      //  buttonClick(CLOSE_QUICK_VIEW);
    //}
    
    //public void verifyProductNameAtQuickView(HashMap<String, String> productQuickView) 
    //{
		//WebDriverWait wait = new WebDriverWait(driver, 15);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_NAME_QUICK_VIEW));
       // productNameAtQuickView = getTextFromAnElement(PRODUCT_NAME_QUICK_VIEW);
       // System.out.println("Product Name at Home page : " + productNameAtHomePage);
       // System.out.println("Product Name at Quick View : " + productNameAtQuickView);
       // Assert.assertTrue(productNameAtQuickView.equalsIgnoreCase(productNameAtHomePage));
   // }
    
    public void verifyIfBrokenLinksPresent(HashMap<String, String> homePageBrokenLinks) throws MalformedURLException, IOException
    { 
       if(isElementExist(ANCHOR_TAG))
       {  
          urlListElements = listOfWebElements(ANCHOR_TAG);
          System.out.println("Total URL Count is : " + urlListElements.size());
          for (int i = 0; i < urlListElements.size(); i++)
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
                        //System.out.println("LINK# "+i+" "+urlListElements.get(i).getAttribute("href") + " is NOT BROKEN");  
                    }
                    statusCodeList.add(statusCode);
	             }  
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
}