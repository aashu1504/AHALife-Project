package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class PromotionsAndDynamicModules extends GenericClass{
    
    private final By DYNAMIC_MODULE_HEADER = By.xpath(".//div[@data-ng-controller='dynamicModuleController']/div/h1");
    private final By DYNAMIC_MODULES = By.xpath(".//div[@data-ng-repeat='module in dynamicModules']");
    private final By SAVE_DYNAMIC_MODULE = By.xpath("//button[contains(.,'Save')]");
    private final By DYNAMIC_MODULE_SAVE_SUCCESS = By.xpath(".//div[@data-ng-controller='dynamicModuleController']/div[2]/div[2]/p");
    private final By VIEW_ALL_PROMOTIONS = By.xpath(".//*[@id='viewPromotionHref']");
    private final By PROMO_HEADER = By.xpath(".//*[@id='viewPromotions']/div[1]/h2");
    private final By PROMO_LIST = By.xpath(".//*[@id='viewPromotions']/table/tbody/tr");
    private final By CREATE_PROMOTION = By.xpath(".//*[@id='createPromotionHref']");
    private final By ENTER_PROMO_NAME = By.xpath(".//*[@id='promotion.name']");
    private final By START_DATE = By.xpath(".//*[@id='startdate']");
    private final By END_DATE = By.xpath(".//*[@id='enddate']");
    private final By EXTENSION_DATE = By.xpath(".//*[@id='extensionexpirydate']");
    private final By PROMO_TARGET_URL = By.xpath(".//*[@id='promotion.targetUrl']");
    private final By SCHEDULE_PROMO = By.xpath(".//*[@id='createPromotions']/div[3]/form/button");
    private final By PROMO_IMAGE_UPLOAD = By.xpath(".//*[@name='promotion.promoImage']/div/div[2]/div/div");
    private final By CHOOSE_UPLOAD_FILE = By.xpath(".//*[@id='fileUploadInput']");
    private final By EXPECTED_OFFER_NAME = By.xpath(".//*[@id='viewPromotions']/table/tbody/tr/td[1]");
    private final By SEARCH_PROMO = By.xpath("//input[@placeholder='Search']");
    
    static String expectedDynamicHeaderText = null;
    static String actualDynamicHeaderText = null;
    static String actualSaveModuleText = null;
    static String expectedSaveModuleText = null;
    static String enterPromoName = null;
    static String expectedPromoName = null;
    
    public void verifyNavigationToManageDynamics(HashMap<String, String> manageDynamic)
    {
        expectedDynamicHeaderText = manageDynamic.get("ManageDynamicHeaderText");
        actualDynamicHeaderText = getTextFromAnElement(DYNAMIC_MODULE_HEADER);
        if(expectedDynamicHeaderText.equalsIgnoreCase(actualDynamicHeaderText))
        {
           if(isElementExist(DYNAMIC_MODULES))    
           {
               Assert.assertTrue(true);
           }
            else
            {
                Assert.assertTrue(false);
            }
        }
        else
        {
            Assert.assertTrue(false);
        }
    }
    
    public void clickOnSaveDynamicModule(HashMap<String, String> saveModules)
    {
	    buttonClick(SAVE_DYNAMIC_MODULE);
    }
    
    public void clickOnViewAllPromotions(HashMap<String, String> viewAllPromotions)
    {
	    buttonClick(VIEW_ALL_PROMOTIONS);
        pageToLoad();
    }
    
    public void verifyIfModulesAreSaved(HashMap<String, String> saveModule)
    {   
        actualSaveModuleText = getTextFromAnElement(DYNAMIC_MODULE_SAVE_SUCCESS);
        expectedSaveModuleText = saveModule.get("ExpectedSaveModuleText");
        Assert.assertTrue(actualSaveModuleText.equalsIgnoreCase(expectedSaveModuleText));
    }
    
    public void verifyNavigationToViewAllPromotions(HashMap<String, String> viewPromoNavigation)   //verify if list of promos are visible
    {
       if(getTextFromAnElement(PROMO_HEADER).equalsIgnoreCase(viewPromoNavigation.get("PromoPageHeaderText"))) 
       {
        if(isElementExist(PROMO_LIST))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
       }
        else
        {
            Assert.assertTrue(false);
        }
    }
    
   public void clickOnCreateNewPromotion(HashMap<String, String> createPromotion)
    {
	    buttonClick(CREATE_PROMOTION);
        pageToLoad();
    }
    
    public void enterNewPromoName(HashMap<String, String> promoName)
    {
        enterPromoName = promoName.get("EnterNewPromoName");
        enterText(ENTER_PROMO_NAME,enterPromoName);
    }
    
    public void enterStartDate(HashMap<String, String> startDate)
    {
        enterText(START_DATE,startDate.get("StartDate"));
    }
    
    public void enterEndDate(HashMap<String, String> endDate)
    {
        enterText(END_DATE,endDate.get("EndDate"));
    }
    
    public void enterExtensionDate(HashMap<String, String> extensionDate)
    {
        enterText(EXTENSION_DATE,extensionDate.get("ExtensionDate"));
    }
    
    public void enterTargetURL(HashMap<String, String> targetURL)
    {
        enterText(PROMO_TARGET_URL,targetURL.get("TargetUrl"));
    }
    
    public void schedulePromo(HashMap<String, String> schedulePromo)
    {
	    buttonClick(SCHEDULE_PROMO);
        pageToLoad();
    }
    
    public void clickUploadPromoImage(HashMap<String, String> promoImage)
    {
		buttonClick(PROMO_IMAGE_UPLOAD);
        pageToLoad();
        driver.switchTo().frame("filepicker_dialog");
    }
    
    public void PromoImageFileToUpload(HashMap<String, String> chooseFile) throws InterruptedException
    {
        enterText(CHOOSE_UPLOAD_FILE,"C:\\Users\\ashishu\\Desktop\\Testing_Images\\Flower.png");
        Thread.sleep(8000L);
        driver.switchTo().defaultContent();
    }
    
    public void enterPromoToSearch(HashMap<String, String> searchPromo)
    {
        enterText(SEARCH_PROMO,enterPromoName);
    }
    
    public void verifyIfPromotionIsCreated(HashMap<String, String> createdOffer)
    {   
        expectedPromoName = getTextFromAnElement(EXPECTED_OFFER_NAME);
        Assert.assertTrue(expectedPromoName.equalsIgnoreCase(enterPromoName));
    }
}