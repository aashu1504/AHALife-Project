package AHALIFESITE;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class HomePage extends GenericClass{
    
    private final By PRODUCT_ID = By.xpath(".//div[@class='container homepage ng-scope']/div[5]/div/div/div/div/ul/li[1]/a/div[2]/h4");
    private final By QUICK_VIEW = By.xpath(".//div[@class='container homepage ng-scope']/div[5]/div/div/div/div/ul/li[1]/a/div[1]/div[3]");
    private final By ADD_TO_BAG_HOME = By.xpath(".//*[@id='buy-button']");
    private final By CLOSE_QUICK_VIEW = By.xpath(".//*[@id='id-close-quick-view']");
    private final By PRODUCT_NAME_QUICK_VIEW = By.xpath(".//*[@id='id-product-quick-view']/div[3]/div[2]/a[1]");
    
    static String productNameAtHomePage = null;
    
    public String clickProduct(HashMap<String, String> product)
    {
        productNameAtHomePage = getTextFromAnElement(PRODUCT_ID);
        buttonClick(PRODUCT_ID);
        return productNameAtHomePage;
    }
    
    public void clickQuickView(HashMap<String, String> quickView)
    {
        buttonClick(QUICK_VIEW);
    }
    
    public void clickAddToBagHome(HashMap<String, String> quickViewAdd)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_BAG_HOME));
        buttonClick(ADD_TO_BAG_HOME);
    }
    
    public void closeQuickView(HashMap<String, String> quickViewClose)
    {
        buttonClick(CLOSE_QUICK_VIEW);
    }
    
    public void verifySameProductQuickViewOpened(HashMap<String, String> productQuickView)
    {
        pageToLoad();
        productNameAtQuickView = getTextFromAnElement(PRODUCT_NAME);
        System.out.println("Product Name at Home page : " + productName.get("ProductNameAtHomePage"));
        System.out.println("Product Name at PDP Page : " + productNameAtProductDisplayPage);
        Assert.assertTrue(productNameAtProductDisplayPage.equalsIgnoreCase(productName.get("ProductNameAtHomePage")));
    }
}