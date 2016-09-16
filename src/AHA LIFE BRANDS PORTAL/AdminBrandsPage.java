package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class AdminBrandsPage extends GenericClass{
    
    private final By ENTER_PORTAL_AS_BRAND = By.xpath(".//*[@id='id-model-view']/div[3]/div[4]/a");
    private final By STOREFRONT_NAME_ADMIN_PAGE = By.xpath(".//*[@id='object_STOREFRONT_NAME']");
    private final By BRAND_LEGAL_NAME = By.xpath(".//*[@id='object_LEGAL_NAME']");
      
    static String actualBrandNameAdminPage = null;
    static String brandNameAccountsTab = null;
    static String brandLegalNameAtAdminPage = null;
    static String actualStorefrontNameAdminPage = null;
    
    public void clickEnterPortalAsBrand(HashMap<String, String> enterBrandClick)
    {
        buttonClick(ENTER_PORTAL_AS_BRAND);
        pageToLoad();
    }  
    
    public void getStorefrontName(HashMap<String, String> storefrontName)
    {
        actualStorefrontNameAdminPage = getAttributeValue(STOREFRONT_NAME_ADMIN_PAGE,"value");
        pageToLoad();
    } 
    
    public void getBrandLegalName(HashMap<String, String> brandLegalName)
    {
        brandLegalNameAtAdminPage = getAttributeValue(BRAND_LEGAL_NAME,"value");
        pageToLoad();
    } 
    
    public void verifyAdminEnteringAsBrand(HashMap<String, String> adminAsBrand) 
    {
        brandNameAccountsTab = adminAsBrand.get("BrandNameAccountsTab");
        Assert.assertTrue(brandLegalNameAtAdminPage.equalsIgnoreCase(brandNameAccountsTab));
    }
}