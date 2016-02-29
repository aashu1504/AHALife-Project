package AHALIFESITE;

import java.util.*;

class ProductDisplayPage{
    
    private final By ADD_TO_BAG_PDP = By.xpath(".//*[@id='buy-button']");
    
    static String productNameAtProductDisplayPage = null;
    
    public void clickAddToBagPDP(HashMap<String, String> addPDP)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_BAG_PDP));
        buttonClick(ADD_TO_BAG);
    }
    
    public void verifyNavigationToProductDisplayPage(HashMap<String, String> productName)
    {
        productNameAtProductDisplayPage = getTextFromAnElement(PRODUCT_ID);
        buttonClick(PRODUCT_ID);
    }
}