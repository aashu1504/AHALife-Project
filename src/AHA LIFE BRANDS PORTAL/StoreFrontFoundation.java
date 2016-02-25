package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class StoreFrontFoundation extends GenericClass{
    
    private final By STOREFRONT_CLICK = By.xpath(".//*[@id='storefrontHeader']/div[2]/a");
    private final By LOGO_UPLOAD = By.xpath(".//aha-filepicker[@id='model.logoUrl']/div/div[2]/div[1]/div");
	private final By CHOOSE_UPLOAD_FILE = By.xpath(".//*[@id='fileUploadInput']");
    private final By SAVE_UPLOAD_CHANGES = By.xpath(".//div[@class='modal-footer ng-scope']/div/div[2]/button");
    private final By STOREFRONT_IMAGERY_UPLOAD = By.xpath(".//aha-filepicker[@id='model.imageUrls']/div/div[2]/div[1]/div");
    private final By PAGE_LABEL_ACTUAL = By.xpath(".//*[@id='pageLabel']");
    
    private final By STOREFRONT_NAME = By.xpath(".//*[@id='pageLabel']");
    private final By STOREFRONT_URL = By.xpath(".//*[@id='pageLabel']");
    private final By BRAND_STORY = By.xpath(".//*[@id='pageLabel']");
    private final By BRAND_TAGLINE = By.xpath(".//*[@id='pageLabel']");
    
    static String expectedStoreFrontText = null;
    static String actualStoreFrontText = null;
    
    //<!--------------------------------------------BRAND STOREFRONT FOUNDATION START-----------------------------------------------------------------!>
    
    public void verifyStoreFrontNavigation(HashMap<String, String> storeFrontNavigation)  
    {
        expectedStoreFrontText = storeFrontNavigation.get("StoreFrontText");
        System.out.println("Expected is : " + expectedStoreFrontText);
        actualStoreFrontText = getTextFromAnElement(PAGE_LABEL_ACTUAL);
        System.out.println("Actual is : " + actualStoreFrontText);
        Assert.assertTrue(expectedStoreFrontText.equalsIgnoreCase(actualStoreFrontText));
    }
       
    public void enterStoreFrontName(HashMap<String, String> storefrontName)              //----> Your Brand Name
    {
        enterText(STOREFRONT_NAME,storefrontName.get("StorefrontName"));
    }
    
    public void enterStoreFrontURL(HashMap<String, String> storefrontURL)                 //----> Your StoreFront/Brand URL
    {
        enterText(STOREFRONT_URL,storefrontURL.get("StoreFrontURL"));
    }
    
    public void enterBrandStory(HashMap<String, String> brandStory)                       //-----> Story about your brand, how it was made
    { 
        enterText(BRAND_STORY,brandStory.get("BrandStory"));              
    }
    
    public void enterBrandTagLine(HashMap<String, String> brandTagLine)                       //-----> Story about your brand, how it was made
    { 
        enterText(BRAND_TAGLINE,brandTagLine.get("BrandTagLine"));              
    }
      
    public void storeFrontClick(HashMap<String, String> storeFront)
    {
        pageToLoad();
		buttonClick(STOREFRONT_CLICK);
    }
    
    public void logoUploadClick(HashMap<String, String> logoUpload)
    {
        pageToLoad();
		buttonClick(LOGO_UPLOAD);
        pageToLoad();
        driver.switchTo().frame("filepicker_dialog");
    }
    
    public void logoImageFileToUpload(HashMap<String, String> chooseFile) throws InterruptedException
    {
        enterText(CHOOSE_UPLOAD_FILE,"D:\\FileUpload\\Desert.jpg");
        Thread.sleep(8000L);
    }
    
    public void saveChangesClick(HashMap<String, String> chooseFile) throws InterruptedException
    {
        driver.switchTo().defaultContent();
        Thread.sleep(4000L);
        buttonClick(SAVE_UPLOAD_CHANGES);
    }
    
    public void storeFrontUploadClick(HashMap<String, String> logoUpload) throws InterruptedException
    {
        Thread.sleep(4000L);
		buttonClick(STOREFRONT_IMAGERY_UPLOAD);
        pageToLoad();
        driver.switchTo().frame("filepicker_dialog");
    }
    
    public void storeFrontImageFileUpload(HashMap<String, String> chooseFile) throws InterruptedException
    {
        enterText(CHOOSE_UPLOAD_FILE,"D:\\FileUpload\\Koala.jpg");
        Thread.sleep(8000L);
    }
    
     //<!--------------------------------------------BRAND STOREFRONT FOUNDATION END-----------------------------------------------------------------!>
}