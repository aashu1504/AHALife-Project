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
    private final By SUCCESS_MESSAGE = By.xpath(".//*[@id='id-page-content']/div[1]/div");
    private final By BRAND_APPLICATION_LIST = By.xpath(".//*[@class='brandapplicationlistrow']");
    private final By INVITED_BRAND_ID = By.xpath(".//tr[1][@class='brandapplicationlistrow']/td[3]");
    private final By INVITED_BRAND_NAME = By.xpath(".//tr[1][@class='brandapplicationlistrow']/td[4]");
    private final By INVITED_BRAND_STATUS = By.xpath(".//tr[1][@class='brandapplicationlistrow']/td[7]");
    
    public static String expectedInvitedBrandName =null;
    public static String actualInvitedBrandID = null;
    
    public void clickInviteBrand(HashMap<String, String> inviteClick)
    {
        buttonClick(INVITE_BRAND);
    }
    
    public void enterBrandName(HashMap<String, String> brand)
    {
        expectedInvitedBrandName = brand.get("BrandName");
        enterText(BRAND_NAME,expectedInvitedBrandName);
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
    
    public void enterMinimumPricePoint(HashMap<String, String> minimumPrice)
    {
        String minimumPricePoint = minimumPrice.get("MinimumPricePoint");
        enterText(MIN_PRICE_POINT,minimumPricePoint);
    }
    
    public void enterMarginPercentage(HashMap<String, String> margin)
    {
        String marginPercentage = margin.get("MarginPercentage");
        enterText(MARGIN_PERCENTAGE,marginPercentage);
    }
    
    public void clickApproveBrand(HashMap<String, String> approveClick)
    {
        buttonClick(APPORVE_BRAND);
        pageToLoad();
    }
    
    public void verifyNavigationToBrandApplications(HashMap<String, String> brandApplications)
    {
        if(isElementExist(BRAND_APPLICATION_LIST))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }
    
    public String verifyIfInviteIsSendAndBrandIsCreated(HashMap<String, String> saveProd)
    {
        String getInviteSuccessClass = getAttributeValue(SUCCESS_MESSAGE,"class");
        if(getInviteSuccessClass.equalsIgnoreCase("alert alert-success"))
        {
            String actualInvitedBrandName = getTextFromAnElement(INVITED_BRAND_NAME);
            String actualInvitedBrandStatus = getTextFromAnElement(INVITED_BRAND_STATUS);
            if(actualInvitedBrandName.equalsIgnoreCase(expectedInvitedBrandName) && actualInvitedBrandStatus.equalsIgnoreCase("INVITED"))
            {
                actualInvitedBrandID = getTextFromAnElement(INVITED_BRAND_ID);
                Assert.assertTrue(true);
                return actualInvitedBrandID;
            }
            else
            {
                Assert.assertTrue(false);
                return null;
            }
            
        }
        else
        {
            Assert.assertTrue(false);
            return null;
        }
    }
    
    public void verifyIfInvitedBrandIsInDraft(HashMap<String, String> draftBrandCheck)
    {
        if(draftBrandCheck.get("BrandStatus").equalsIgnoreCase("DRAFT"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }    
}