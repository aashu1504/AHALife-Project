package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class StoreFront extends GenericClass{
    
    private final By STOREFRONT_CLICK = By.xpath(".//*[@id='storefrontHeader']/div[2]/a");
    private final By LOGO_UPLOAD = By.xpath(".//aha-filepicker[@id='model.logoUrl']/div/div[2]/div[1]/div");
	private final By CHOOSE_UPLOAD_FILE = By.xpath(".//*[@id='fileUploadInput']");
    private final By SAVE_UPLOAD_CHANGES = By.xpath(".//button[@class='aha-btn']");
    
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
    
    public void chooseFileToUpload(HashMap<String, String> chooseFile) throws InterruptedException
    {
        enterText(CHOOSE_UPLOAD_FILE,userName.get("BrandUserName"));
        Thread.sleep(6000L);
    }
    
    public void saveChangesClick(HashMap<String, String> chooseFile)
    {
        buttonClick(SAVE_UPLOAD_CHANGES);
    }
    
}