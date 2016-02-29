package AHALIFESITE;

import java.util.*;

class ProductDisplayPage{
    
    private final By ADD_TO_BAG_PDP = By.xpath(".//*[@id='buy-button']");
    
    public void clickAddToBagPDP(HashMap<String, String> quickViewAdd)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_BAG));
        buttonClick(ADD_TO_BAG);
    }
}