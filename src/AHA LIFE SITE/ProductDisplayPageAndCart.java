package AHALIFESITE;

import java.util.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import Utility.GenericClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ProductDisplayPageAndCart extends GenericClass{
    
    private final By ADD_TO_BAG_PDP = By.xpath(".//*[@id='buy-button']");
    private final By PRODUCT_NAME = By.xpath(".//div[@class='product-details']/div/h1");
    private final By MY_BAG_SITE = By.xpath(".//*[@id='id-header-top-level-menu']/li[6]/a");
    private final By MY_BAG_LOGGED_IN = By.xpath(".//*[@id='id-header-top-level-menu']/li[5]/a");
    private final By CART_PRODUCT_NAME = By.xpath(".//*[@id='cart_products']/li/div[2]/h3");
    private final By CART_PRODUCT_NAME1 = By.xpath(".//*[@id='productRow1']/div[2]/h3/a");
    private final By CART_PRODUCT_NAME2 = By.xpath(".//*[@id='productRow2']/div[2]/h3/a");
    private final By BEGIN_CHECKOUT = By.xpath(".//*[@id='begin-checkout-button']/div/input");
    private final By CONTINUE_AS_GUEST = By.xpath(".//*[@id='content']/div[3]/a/button");
    private final By CONTINUE_AS_REGISTERED_USER = By.xpath(".//*[@id='id-checkout-auth-login']/div[2]/input");
    private final By REMOVE_ITEM_FROM_CART = By.xpath(".//*[@id='productRow1']/div[2]/div[4]/a");
    private final By ACTUAL_EMPTY_CART_TEXT = By.xpath(".//div[@class='emptyBagText']");
    private final By MORE_PRODUCTS = By.xpath(".//*[@id='product']/div[2]/div/div[2]/div[5]");
    private final By QUICK_VIEW = By.xpath(".//div[contains(@class,'open-quick-view')]");
    private final By PRODUCT_NAME_QUICK_VIEW = By.xpath(".//p[contains(@class,'productName ng-binding')]");
    private final By PRODUCT_NAME_AT_QUICK_VIEW_WINDOW = By.xpath(".//a[contains(@class,'item-name')]");
    private final By ADD_TO_BAG_QUICK_VIEW = By.xpath(".//*[@class='btn-orange-inner']");
    private final By CLOSE_QUICK_VIEW = By.xpath(".//*[@id='id-close-quick-view']");
    private final By COUNT_ITEM_QUANTITY_MY_BAG = By.xpath(".//input[@name='quantity']");
    private final By UPDATE_BUTTON_MY_BAG = By.xpath(".//input[@value='Update']");
    private final By NOTHANKS_BUTTON = By.xpath(".//input[@value='Update']");
   
    
    static String productNameAtProductDisplayPage = null;
    static String productNameAtCart = null;
    static String productNameAtPDP1= null;
    static String productNameAtPDP2= null;
    static String productNameAtCart1 = null;
    static String productNameAtCart2 = null;
    static String actualEmptyCartText = null;
    static String quickViewProductName = null;
    static String productNameAtQuickViewWindow = null;
    static Integer addToBagClickCount = null;
    static String actualBagItemCount = null;
    static String quantityToUpdate = null;
    static String updatedBagItemCount = null;
    
    public String getProductNameFromProductDisplayPage(HashMap<String, String> productDisplayName)
    {
        String product = getTextFromAnElement(PRODUCT_NAME);
        System.out.println("Product Name At PDP:" + product);
        return product;
    }
    
    public String clickQuickView(HashMap<String, String> quickView)throws InterruptedException
    {
       
        buttonClick(QUICK_VIEW);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_NAME_QUICK_VIEW));
        quickViewProductName = getTextFromAnElement(PRODUCT_NAME_QUICK_VIEW);   
        System.out.println("QuickView Product Name:" + quickViewProductName);
        return quickViewProductName;
    }
    
    public void verifyProductNameAtQuickView(HashMap<String, String> productQuickView) 
    {
		WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_NAME_AT_QUICK_VIEW_WINDOW));
        productNameAtQuickViewWindow = getTextFromAnElement(PRODUCT_NAME_AT_QUICK_VIEW_WINDOW);
        Assert.assertTrue(quickViewProductName.equalsIgnoreCase(productNameAtQuickViewWindow));
    }
    
    public void clickAddToBagAtQVWindow(HashMap<String, String> quickViewAdd)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_BAG_QUICK_VIEW));
        buttonClick(ADD_TO_BAG_QUICK_VIEW);
    }
    
    public void closeQuickView(HashMap<String, String> quickViewClose)
    {
        buttonClick(CLOSE_QUICK_VIEW);
    }
    
    public void clickAddToBagPDP(HashMap<String, String> addPDP) throws InterruptedException
    {
        addToBagClickCount = Integer.parseInt(addPDP.get("AddToBagClickCount"));
        for(int i=0; i<addToBagClickCount; i++)
        {
        	buttonClick(ADD_TO_BAG_PDP);
            Thread.sleep(4000L);
        }
    }
    
    public void clickMyBag(HashMap<String, String> myBag)
    {
           pageToLoad();       
           buttonClick(MY_BAG_SITE);   
           pageToLoad();
    
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
        productNameAtCart = getTextFromAnElement(CART_PRODUCT_NAME);
        Assert.assertTrue(productNameAtProductDisplayPage.equalsIgnoreCase(productNameAtCart));
    }
    
    public void verifyProductAddedToCartFromQuickView(HashMap<String, String> productAtCartFromQV)
    {
        pageToLoad();
        productNameAtCart = getTextFromAnElement(CART_PRODUCT_NAME);
        Assert.assertTrue(productNameAtCart.equalsIgnoreCase(productAtCartFromQV.get("ProductNameQuickView")));
    }
    
     public void verifyBothProductsAddedToCartAfterReview(HashMap<String, String> productAtCart)
    {
        pageToLoad();
        productNameAtPDP1 = productAtCart.get("ProductNameAtPDP1");
        productNameAtPDP2 = productAtCart.get("ProductNameAtPDP2");
        productNameAtCart1 = getTextFromAnElement(CART_PRODUCT_NAME1);
        productNameAtCart2 = getTextFromAnElement(CART_PRODUCT_NAME2);
         
        System.out.println("productNameAtPDP1 " + productNameAtPDP1 );
        System.out.println("productNameAtPDP2 " + productNameAtPDP2 );
        System.out.println("productNameAtCart1 " + productNameAtCart1);
        System.out.println("productNameAtCart2 " + productNameAtCart2);
         
        Assert.assertTrue(productNameAtPDP1.equalsIgnoreCase(productNameAtCart1));
        Assert.assertTrue(productNameAtPDP2.equalsIgnoreCase(productNameAtCart2));
    }
    
    public void navigateToProductPage(HashMap<String, String> productURL)
    {
        String websiteURL = productURL.get("WebsiteURL");
        String sellingProductURL = productURL.get("ProductURL");
        driver.get(websiteURL + sellingProductURL);
        pageToLoad();
    }
    
    public void beginCheckout(HashMap<String, String> checkoutClick)
    {
        pageToLoad();
        buttonClick(BEGIN_CHECKOUT);
        pageToLoad();
    }
     public void clickNoThanks(HashMap<String, String> NoThanks)
    {
       buttonClick(NOTHANKS_BUTTON);
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
        Assert.assertTrue((productRemove.get("ExpectedEmptyCartText")).equalsIgnoreCase(actualEmptyCartText));
    }
    
    public void verifyItemQuantityInMyBag(HashMap<String, String> bagItemQuantity)
    {
        pageToLoad();
        actualBagItemCount = getAttributeValue(COUNT_ITEM_QUANTITY_MY_BAG,"value");
        System.out.println("Item added " + addToBagClickCount);
        System.out.println("Items in my Bag " + actualBagItemCount);
        Assert.assertTrue(Integer.toString(addToBagClickCount).equalsIgnoreCase(actualBagItemCount));
    }
    
    public void enterQuantityCountToUpdate(HashMap<String, String> updateCount)
    {
        quantityToUpdate = updateCount.get("UpdateQuantity");
        pageToLoad();
        clearData(COUNT_ITEM_QUANTITY_MY_BAG);
        enterText(COUNT_ITEM_QUANTITY_MY_BAG,quantityToUpdate);
    }
    
    public void clickUpdateAtMyBag(HashMap<String, String> updateProductQuantity)
    {
        pageToLoad();
        buttonClick(UPDATE_BUTTON_MY_BAG);
    }
    
    public void verifyUpdatedItemQuantity(HashMap<String, String> updateBagItemQuantity)
    {
        pageToLoad();
        updatedBagItemCount = getAttributeValue(COUNT_ITEM_QUANTITY_MY_BAG,"value");
        System.out.println("Updated quantity visible " + updatedBagItemCount);
        System.out.println("Actual update quantity " + quantityToUpdate);
        Assert.assertTrue(updatedBagItemCount.equalsIgnoreCase(quantityToUpdate));
    }
}
