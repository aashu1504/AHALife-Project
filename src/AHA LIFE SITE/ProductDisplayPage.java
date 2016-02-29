package AHALIFESITE;

import java.util.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import Utility.GenericClass;

class ProductDisplayPage extends GenericClass{
    
    private final By ADD_TO_BAG_PDP = By.xpath(".//*[@id='buy-button']");
    private final By PRODUCT_NAME = By.xpath(".//div[@class='product_mainContainer']/div/h1");
    
    static String productNameAtProductDisplayPage = null;
     
    public void verifyNavigationToProductDisplayPage(HashMap<String, String> productName)
    {
        pageToLoad();
        productNameAtProductDisplayPage = getTextFromAnElement(PRODUCT_NAME);
        System.out.println("At PDP Page" + productNameAtProductDisplayPage);
        System.out.println("At Home page" + productName.get("ProductNameAtHomePage"));
        Assert.assertTrue(productNameAtProductDisplayPage.equalsIgnoreCase(productName.get("ProductNameAtHomePage")));
    }
    
    public void clickAddToBagPDP(HashMap<String, String> addPDP)
    {
        buttonClick(ADD_TO_BAG_PDP);
    }
}