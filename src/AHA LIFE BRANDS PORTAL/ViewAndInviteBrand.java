package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

class ViewAndInviteBrand extends GenericClass{
    
    private final By INVITE_BRAND = By.xpath(".//a[@data-type='INVITED']");
    private final By BRAND_NAME = By.xpath(".//*[@id='legal_name']");
    private final By BRAND_WEBSITE_URL = By.xpath(".//*[@id='website_url']");
    private final By BRAND_EMAIL = By.xpath(".//*[@id='contact_email']");
    private final By MIN_PRICE_POINT = By.xpath(".//*[@id='price_point']");
    private final By MARGIN_PERCENTAGE = By.xpath(".//*[@id='margin_percentage']");
    private final By APPORVE_BRAND = By.xpath(".//input[@value='APPROVE']");
    
    public void clickInviteBrand(HashMap<String, String> inviteClick)
    {
        buttonClick(INVITE_BRAND);
    }
    
    public void enterBrandName(HashMap<String, String> brand)
    {
        String brandName = brand.get("BrandName");
        enterText(BRAND_NAME,brandName);
    }
    
    public void enterWebsiteURL(HashMap<String, String> url)
    {
        String websiteUrl = url.get("WebsiteURL");
        enterText(BRAND_WEBSITE_URL,websiteUrl);
    }
    
    public void enterBrandEmail(HashMap<String, String> email)
    {
        String brandEmail = email.get("BrandEmail");
        enterText(BRAND_EMAIL,brandEmail);
    }
    
    public void enterMinPricePoint(HashMap<String, String> minPrice)
    {
        String minPricePoint = minPrice.get("MinPricePoint");
        enterText(MIN_PRICE_POINT,minPricePoint);
    }
    
    public void enterMarginPercentage(HashMap<String, String> margin)
    {
        String marginPercentage = margin.get("MarginPercentage");
        enterText(MARGIN_PERCENTAGE,marginPercentage);
    }
    
    public void clickApproveBrand(HashMap<String, String> approveClick)
    {
        buttonClick(APPORVE_BRAND);
    }
}