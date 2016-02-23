package AHA LIFE BRANDS PORTAL;

import java.util.*;

class StoreFront{
    
    private final By STOREFRONT_CLICK = By.xpath(".//*[@id='storefrontHeader']/div[2]/a");
    private final By LOGO_UPLOAD = By.xpath(".//aha-filepicker[@id='model.logoUrl']/div/div[2]/div[1]/div");
	private final By CHOOSE_UPLOAD_FILE = By.xpath(".//*[@id='fileUploadInput']");
    
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
    
    public void chooseFileToUpload(HashMap<String, String> chooseFile)
    {
        enterText(CHOOSE_UPLOAD_FILE, chooseFile.get("UploadImageFile"));
    }
}