package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class StoreFront extends GenericClass{
    
    private final By STOREFRONT_CLICK = By.xpath(".//*[@id='storefrontHeader']/div[2]/a");
    private final By LOGO_UPLOAD = By.xpath(".//aha-filepicker[@id='model.logoUrl']/div/div[2]/div[1]/div");
	private final By CHOOSE_UPLOAD_FILE = By.xpath(".//*[@id='fileUploadInput']");
    private final By SAVE_UPLOAD_CHANGES = By.xpath("html/body/div[5]/div/div/div[3]/div/div[2]/button");
    
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
        enterText(CHOOSE_UPLOAD_FILE,"D:\\FileUpload\\Desert.jpg");
        Thread.sleep(8000L);
    }
    
    public void saveChangesClick(HashMap<String, String> chooseFile)
    {
        driver.switchTo().defaultContent();
        buttonClick(SAVE_UPLOAD_CHANGES);
    }
    
}