package AHALIFESITE;

import java.util.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import Utility.GenericClass;

class ProductDisplayPage extends GenericClass{
    
    private final By ADD_TO_BAG_PDP = By.xpath(".//*[@id='buy-button']");
    private final By PRODUCT_NAME = By.xpath(".//div[@class='product_mainContainer']/div/h1");
    private final By MY_BAG = By.xpath(".//*[@id='id-header-top-level-menu']/li[4]/a");
    private final By CART_PRODUCT_NAME = By.xpath(".//*[@id='cart_products']/li/div[2]/h3");
    
    static String productNameAtProductDisplayPage = null;
    static String productNameAtCart = null;
     
    public void verifyNavigationToProductDisplayPage(HashMap<String, String> productName)
    {
        pageToLoad();
        productNameAtProductDisplayPage = getTextFromAnElement(PRODUCT_NAME);
        System.out.println("Product Name at Home page : " + productName.get("ProductNameAtHomePage"));
        System.out.println("Product Name at PDP Page : " + productNameAtProductDisplayPage);
        Assert.assertTrue(productNameAtProductDisplayPage.equalsIgnoreCase(productName.get("ProductNameAtHomePage")));
    }
    
    public void clickAddToBagPDP(HashMap<String, String> addPDP)
    {
        buttonClick(ADD_TO_BAG_PDP);
    }
    
    public void clickMyBag(HashMap<String, String> myBag)
    {
        buttonClick(MY_BAG);
    }
    
    public void verifyProductAddedToCart(HashMap<String, String> productAtCart)
    {
        pageToLoad();
        productNameAtCart = getTextFromAnElement(CART_PRODUCT_NAME);
        System.out.println("Product Name at PDP Page " + productNameAtProductDisplayPage);
        System.out.println("Product Name at Cart " + productNameAtCart);
        Assert.assertTrue(productNameAtProductDisplayPage.equalsIgnoreCase(productNameAtCart));
    }
}