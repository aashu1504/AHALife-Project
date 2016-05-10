package AHALIFESITE;

import java.util.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import Utility.GenericClass;

class ProductDisplayPageAndCart extends GenericClass{
    
    private final By ADD_TO_BAG_PDP = By.xpath(".//*[@id='buy-button']");
    private final By PRODUCT_NAME = By.xpath(".//div[@class='product_mainContainer']/div/h1");
    private final By MY_BAG = By.xpath(".//*[@id='id-header-top-level-menu']/li[5]/a");
    private final By MY_BAG_LOGGED_IN = By.xpath(".//*[@id='id-header-top-level-menu']/li[4]/a");
    private final By CART_PRODUCT_NAME = By.xpath(".//*[@id='cart_products']/li/div[2]/h3");
    private final By BEGIN_CHECKOUT = By.xpath(".//*[@id='begin-checkout-button']/div/input");
    private final By CONTINUE_AS_GUEST = By.xpath(".//*[@id='id-checkout-auth-continue']/div[2]/input");
    private final By CONTINUE_AS_REGISTERED_USER = By.xpath(".//*[@id='id-checkout-auth-login']/div[2]/input");
    private final By REMOVE_ITEM_FROM_CART = By.xpath(".//*[@id='productRow1']/div[3]/div/div[2]/a");
    private final By ACTUAL_EMPTY_CART_TEXT = By.xpath(".//div[@class='emptyBagText']");
    
    static String productNameAtProductDisplayPage = null;
    static String productNameAtCart = null;
    static String actualEmptyCartText = null;
     
    public void getProductNameFromProductDisplayPage(HashMap<String, String> productDisplayName)
    {
        String productNameAtProductDisplayPage = getTextFromAnElement(PRODUCT_NAME);
        return product;
    }
    
    //public void verifyNavigationToProductDisplayPage(HashMap<String, String> productName)
    //{
      //  pageToLoad();
        //productNameAtProductDisplayPage = getTextFromAnElement(PRODUCT_NAME);
        //System.out.println("Product Name at Home page : " + productName.get("ProductNameAtHomePage"));
        //System.out.println("Product Name at PDP Page : " + productNameAtProductDisplayPage);
        //Assert.assertTrue(productNameAtProductDisplayPage.equalsIgnoreCase(productName.get("ProductNameAtHomePage")));
    //}
    
    public void clickAddToBagPDP(HashMap<String, String> addPDP)
    {
        buttonClick(ADD_TO_BAG_PDP);
    }
    
    public void clickMyBag(HashMap<String, String> myBag)
    {
        pageToLoad();
        buttonClick(MY_BAG);
    }
    
    public void clickMyBagWhenSignedIn(HashMap<String, String> myBagSignedIn)
    {
        pageToLoad();
        buttonClick(MY_BAG_LOGGED_IN);
    }
    
    public void verifyProductAddedToCartFromPDP(HashMap<String, String> productAtCart)
    {
        pageToLoad();
        productNameAtProductDisplayPage = productAtCart.get("PDPProductName");
        System.out.println("Product Name at PDP : " + productNameAtCart);
        productNameAtCart = getTextFromAnElement(CART_PRODUCT_NAME);
        System.out.println("Product Name at Cart : " + productNameAtCart);
        Assert.assertTrue(productNameAtProductDisplayPage.equalsIgnoreCase(productNameAtCart));
    }
    
    public void verifyProductAddedToCartFromQuickView(HashMap<String, String> productAtCartFromQV)
    {
        pageToLoad();
        productNameAtCart = getTextFromAnElement(CART_PRODUCT_NAME);
        System.out.println("Product Name at Cart : " + productNameAtCart);
        Assert.assertTrue(productNameAtCart.equalsIgnoreCase(productAtCartFromQV.get("ProductNameHomePage")));
    }
    
    public void navigateToProductPage(HashMap<String, String> productURL)
    {
        String websiteURL = productURL.get("WebsiteURL");
        String sellingProductURL = productURL.get("ProductURL");
        System.out.println(websiteURL + sellingProductURL);
        driver.get(websiteURL + sellingProductURL);
        pageToLoad();
    }
    
    public void beginCheckout(HashMap<String, String> checkoutClick)
    {
        pageToLoad();
        buttonClick(BEGIN_CHECKOUT);
    }
    
    public void continueAsGuest(HashMap<String, String> guestContinue)
    {
        pageToLoad();
        buttonClick(CONTINUE_AS_GUEST);
        pageToLoad();
    }
    
    public void continueAsRegisteredUser(HashMap<String, String> registeredUserContinue)
    {
        pageToLoad();
        buttonClick(CONTINUE_AS_REGISTERED_USER);
    }
    
    public void removeItemFromCart(HashMap<String, String> removeItem)
    {
        pageToLoad();
        buttonClick(REMOVE_ITEM_FROM_CART);
    }
    
    public void verifyIfProductIsRemoved(HashMap<String, String> productRemove)
    {
        pageToLoad();
        actualEmptyCartText = getTextFromAnElement(ACTUAL_EMPTY_CART_TEXT);
        System.out.println("Actual Remove Cart Text : " + actualEmptyCartText);
        System.out.println("Expected Remove Cart Text : " + productRemove.get("ExpectedEmptyCartText"));
        Assert.assertTrue((productRemove.get("ExpectedEmptyCartText")).equalsIgnoreCase(actualEmptyCartText));
    }
}
