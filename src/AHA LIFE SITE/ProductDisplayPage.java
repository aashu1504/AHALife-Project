package AHALIFESITE;

import java.util.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ProductDisplayPage{
    
    private final By ADD_TO_BAG_PDP = By.xpath(".//*[@id='buy-button']");
    private final By PRODUCT_NAME = By.xpath(".//div[@class='product_mainContainer']/div/h1");
    
    static String productNameAtProductDisplayPage = null;
     
    public void verifyNavigationToProductDisplayPage(HashMap<String, String> productName)
    {
        productNameAtProductDisplayPage = getTextFromAnElement(PRODUCT_NAME);
        Assert.assertTrue(productNameAtProductDisplayPage.equalsIgnoreCase(productName.get("ProductNameAtHomePage")));
    }
    
    public void clickAddToBagPDP(HashMap<String, String> addPDP)
    {
        buttonClick(ADD_TO_BAG);
    }
}