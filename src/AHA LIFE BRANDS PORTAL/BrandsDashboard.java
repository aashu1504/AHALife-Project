package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class BrandsDashboard extends GenericClass{
   
    private final By ENTER_BRAND_TO_SEARCH = By.xpath(".//input[@placeholder='Brands']");
    private final By ENTER_PRODUCTS_TO_SEARCH = By.xpath(".//input[@placeholder='Products']");
    private final By ENTER_SKU_TO_SEARCH = By.xpath(".//input[@placeholder='SKUs']");
    private final By SEARCH_BRAND = By.xpath(".//form[@action='/admin/brands']/button");
    private final By SEARCH_PRODUCT = By.xpath(".//form[@action='/admin/products']/button");
    private final By SEARCH_SKU = By.xpath(".//form[@action='/admin/skus']/button");
    private final By ACTUAL_SEARCHED_BRAND_NAME = By.xpath(".//*[@id='crudListTable']/table/tbody/tr/td[3]/a");
    private final By ACTUAL_SEARCHED_BRAND_ID = By.xpath(".//*[@id='crudListTable']/table/tbody/tr/td[1]/a");
    private final By ACTUAL_SEARCHED_PRODUCT_NAME = By.xpath(".//*[@id='crudListTable']/table/tbody/tr/td[3]/a");
    private final By ACTUAL_SEARCHED_PRODUCT_ID = By.xpath(".//*[@id='crudListTable']/table/tbody/tr/td[2]/a");
    private final By BRAND_NAME_BRAND_PAGE = By.xpath(".//*[@id='object_STOREFRONT_NAME']");
    private final By PRODUCT_NAME_PRODUCT_PAGE = By.xpath(".//*[@id='object_NAME']");
    private final By MANANGE_PRODUCTS = By.xpath(".//*[@id='crudIndex']/div/div[2]/div/div/ul/li[1]/a");
    private final By MANANGE_BRANDS = By.xpath(".//*[@id='crudIndex']/div/div[1]/div/div/ul/li[1]/a");
    private final By BRAND_OR_PRODUCT_DATA_LIST = By.xpath(".//*[@id='crudListTable']/table/tbody/tr");
    private final By MANAGE_BRAND_PAGE_HEADER_ONE = By.xpath(".//*[@id='crudListTable']/table/thead/tr/th[1]/a");
    private final By MANAGE_PRODUCT_PAGE_HEADER_TWO = By.xpath(".//*[@id='crudListTable']/table/thead/tr/th[2]/a");
    private final By MANAGE_PAGE_SEARCH_INPUT = By.xpath(".//*[@id='crudList']/form/div/div[1]/div/div[1]/input");
    private final By MANAGE_PAGE_SEARCH_BUTTON = By.xpath(".//*[@id='crudList']/form/div/div[1]/div/div[2]/button");
    private final By VIEW_PRODUCT_CHANGE_LOG = By.xpath(".//*[@id='id-model-view']/div[1]/div[3]/a");
    private final By VIEW_BRAND_CHANGE_LOG = By.xpath(".//*[@id='id-model-view']/div[3]/div[5]/a");
    private final By CHANGE_LOG_MESSAGE = By.xpath(".//*[@id='crudContent']/div/h2");
    
    
    static String expectedBrandName = null;
    static String expectedBrandID = null;
    static String actualSearchedBrandName = null;
    static String actualSearchedBrandID = null;
    static String expectedProductName = null;
    static String expectedProductID = null;
    static String actualProductName = null;
    static String actualProductID = null;
    static String actualProductNameAtProductPage = null;
    static String actualBrandNameAtBrandPage = null;
    static String actualBrandNameManagePage = null;
    static String actualProductNameManagePage = null;
    static String expectedBrandOrProductName = null;
    static String firstWindow = null;
    static String secondWindow = null;
    static String expectedBrandChangeLogMessage = null;
    static String actualBrandChangeLogText = null;
    static String expectedProductChangeLogMessage = null;
    static String actualProductChangeLogText = null;
        
    
    public void enterBrandName(HashMap<String, String> brandName)
    {
        expectedBrandName = brandName.get("BrandName");
        enterText(ENTER_BRAND_TO_SEARCH,expectedBrandName);
    }
    
    public void enterBrandID(HashMap<String, String> brandID)
    {
        expectedBrandID = brandID.get("BrandID");
        enterText(ENTER_BRAND_TO_SEARCH,expectedBrandID);
    }
    
    public void clickBrandSearch(HashMap<String, String> brandSearch)  
    {
        buttonClick(SEARCH_BRAND);
        pageToLoad();
    }
    
    public void verifySearchedBrandByName(HashMap<String, String> searchBrandByName) 
    {
        actualSearchedBrandName = getTextFromAnElement(ACTUAL_SEARCHED_BRAND_NAME);
        Assert.assertTrue(actualSearchedBrandName.equalsIgnoreCase(expectedBrandName));
    }
    
    public void verifySearchedBrandByID(HashMap<String, String> searchBrandByID) 
    {
        actualSearchedBrandID = getTextFromAnElement(ACTUAL_SEARCHED_BRAND_ID);
        Assert.assertTrue(actualSearchedBrandID.equalsIgnoreCase(expectedBrandID));
    }
    
    public void enterProductName(HashMap<String, String> productName)
    {
        expectedProductName = productName.get("ProductName");
        enterText(ENTER_PRODUCTS_TO_SEARCH,expectedProductName);
    }
    
    public void enterProductID(HashMap<String, String> productID)
    {
        expectedProductID = productID.get("ProductID");
        enterText(ENTER_PRODUCTS_TO_SEARCH,expectedProductID);
    }
    
    public void clickProductSearch(HashMap<String, String> productSearch)  
    {
        buttonClick(SEARCH_PRODUCT);
        pageToLoad();
    }
    
    public void verifySearchedProductByName(HashMap<String, String> searchProductByName) 
    {
        actualProductName = getTextFromAnElement(ACTUAL_SEARCHED_PRODUCT_NAME);
        Assert.assertTrue(actualProductName.equalsIgnoreCase(expectedProductName));
    }
    
    public void verifySearchedProductByID(HashMap<String, String> searchProductByID) 
    {
        actualProductID = getTextFromAnElement(ACTUAL_SEARCHED_PRODUCT_ID);
        Assert.assertTrue(actualProductID.equalsIgnoreCase(expectedProductID));
    }
    
    public void clickBrandName(HashMap<String, String> brandName)
    {
        buttonClick(ACTUAL_SEARCHED_BRAND_NAME);
        pageToLoad();
    }
    
    public void clickProductName(HashMap<String, String> productName)
    {
        buttonClick(ACTUAL_SEARCHED_PRODUCT_NAME);
        pageToLoad();
    }
    
    public void verifyNavigationToBrandPage(HashMap<String, String> brandPageNavigation) 
    {
        actualBrandNameAtBrandPage = getAttributeValue(BRAND_NAME_BRAND_PAGE,"value");
        Assert.assertTrue(actualBrandNameAtBrandPage.equalsIgnoreCase(expectedBrandName));
    }
    
    public void verifyNavigationToProductPage(HashMap<String, String> productPageNavigation) 
    {
        actualProductNameAtProductPage = getAttributeValue(PRODUCT_NAME_PRODUCT_PAGE,"value");
        Assert.assertTrue(actualProductNameAtProductPage.equalsIgnoreCase(expectedProductName));
    }
    
    public void clickManageBrands(HashMap<String, String> manageBrands)
    {
        buttonClick(MANANGE_BRANDS);
        pageToLoad();
    }
    
     public void clickManageProducts(HashMap<String, String> manageProducts)
    {
        buttonClick(MANANGE_PRODUCTS);
         pageToLoad();
    }
    
    public void verifyNavigationToManageBrands(HashMap<String, String> manageBrandsNavigation)   //verify if list of brands are visible
    {
       if(getTextFromAnElement(MANAGE_BRAND_PAGE_HEADER_ONE).equalsIgnoreCase("Brand ID")) 
       {
        if(isElementExist(BRAND_OR_PRODUCT_DATA_LIST))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
       }
        else
        {
            Assert.assertTrue(false);
        }
    }
    
    public void verifyNavigationToManageProducts(HashMap<String, String> manageProductNavigation)   //verify if list of brands are visible
    {
       if(getTextFromAnElement(MANAGE_PRODUCT_PAGE_HEADER_TWO).equalsIgnoreCase("Product ID")) 
       {
        if(isElementExist(BRAND_OR_PRODUCT_DATA_LIST))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
       }
        else
        {
            Assert.assertTrue(false);
        }
    }
    
    public void enterBrandOrProductNameAtManagePage(HashMap<String, String> brandOrProductName)
    {
        expectedBrandOrProductName = brandOrProductName.get("BrandOrProductName");
        enterText(MANAGE_PAGE_SEARCH_INPUT,expectedBrandOrProductName);
    }
    
    public void clickSearchAtManagePage(HashMap<String, String> searchClick)
    {
        buttonClick(MANAGE_PAGE_SEARCH_BUTTON);
    }
    
    public void verifySearchedBrandAtManagePage(HashMap<String, String> searchBrandManagePage) 
    {
        actualBrandNameManagePage = getTextFromAnElement(ACTUAL_SEARCHED_BRAND_NAME);
        Assert.assertTrue(actualBrandNameManagePage.equalsIgnoreCase(expectedBrandOrProductName));
    }
    
    public void verifySearchedProductAtManagePage(HashMap<String, String> searchProductManagePage) 
    {
        actualProductNameManagePage = getTextFromAnElement(ACTUAL_SEARCHED_PRODUCT_NAME);
        Assert.assertTrue(actualProductNameManagePage.equalsIgnoreCase(expectedBrandOrProductName));
    }
    
    public void verifyNavigationToBrandPageFromManageBrands(HashMap<String, String> brandsPageNavigation) 
    {
        actualBrandNameAtBrandPage = getAttributeValue(BRAND_NAME_BRAND_PAGE,"value");
        Assert.assertTrue(actualBrandNameAtBrandPage.equalsIgnoreCase(expectedBrandOrProductName));
    }
    
    public void verifyNavigationToProductPageFromManageProducts(HashMap<String, String> productsPageNavigation) 
    {
        actualProductNameAtProductPage = getAttributeValue(PRODUCT_NAME_PRODUCT_PAGE,"value");
        Assert.assertTrue(actualProductNameAtProductPage.equalsIgnoreCase(expectedBrandOrProductName));
    }
    
    public void clickViewProductChangeLog(HashMap<String, String> productChangeLog)
    {
        buttonClick(VIEW_PRODUCT_CHANGE_LOG);
    }
    
    public void clickViewBrandChangeLog(HashMap<String, String> brandChangeLog)
    {
        buttonClick(VIEW_BRAND_CHANGE_LOG);
    }
    
    public void switchToChangeLogWindow(HashMap<String, String> switchToWindow) throws InterruptedException
    {
        Thread.sleep(4000L);
        Set<String> windows = driver.getWindowHandles();
		Iterator<String> window = windows.iterator();
		firstWindow = window.next();
		secondWindow = window.next();
		driver.switchTo().window(secondWindow); 
    }
    
   public void verifyBrandChangeLog(HashMap<String, String> brandChangeLog)
    {
        expectedBrandChangeLogMessage = "Brands " + expectedBrandID + " change log";
        actualBrandChangeLogText = getTextFromAnElement(CHANGE_LOG_MESSAGE);
        Assert.assertTrue(expectedBrandChangeLogMessage.equalsIgnoreCase(actualBrandChangeLogText));
    }
    
     public void verifyProductChangeLog(HashMap<String, String> productChangeLog)
    {
        expectedProductChangeLogMessage = "Products " + expectedProductID + " change log";
        actualProductChangeLogText = getTextFromAnElement(CHANGE_LOG_MESSAGE);
        Assert.assertTrue(expectedProductChangeLogMessage.equalsIgnoreCase(actualProductChangeLogText));
    }
}