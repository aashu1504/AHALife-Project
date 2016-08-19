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
    
    public void enterBrandName(HashMap<String, String> brandName)
    {
        enterText(ENTER_BRAND_TO_SEARCH,brandName.get("BrandName"));
    }
    
    public void enterBrandID(HashMap<String, String> brandID)
    {
        enterText(ENTER_BRAND_TO_SEARCH,brandID.get("BrandID"));
    }
    
    public void clickBrandSearch(HashMap<String, String> brandSearch)  
    {
        buttonClick(SEARCH_BRAND);
    }
    
    public void enterProductName(HashMap<String, String> productName)
    {
        enterText(ENTER_PRODUCTS_TO_SEARCH,productName.get("ProductName"));
    }
    
    public void enterProductID(HashMap<String, String> productID)
    {
        enterText(ENTER_PRODUCTS_TO_SEARCH,productID.get("ProductID"));
    }
    
    public void clickProductSearch(HashMap<String, String> productSearch)  
    {
        buttonClick(SEARCH_PRODUCT);
    }
}