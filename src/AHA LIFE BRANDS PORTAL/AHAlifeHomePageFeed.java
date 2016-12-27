package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

class AHAlifeHomePageFeed extends GenericClass{
    
    private final By VIDEO_FEED_SOURCE = By.xpath(".//div[@rel='videoFeed']");
    private final By VIDEO_FEED_DESTINATION = By.xpath(".//*[@id='feedForm']/div");
    private final By VIDEO_MODULE_CREATE = By.xpath(".//*[@id='searchVideoModal']/a");
    private final By VIDEO_MODULE_NAME = By.xpath(".//*[@id='videoModuleName']");
    private final By VIDEO_UPLOAD_IMAGE = By.xpath(".//aha-filepicker[@urls='Module.ImageUrls']/div/div[2]/div/div");
    private final By VIDEO_URL = By.xpath(".//*[@id='videoModuleUrl']");
    private final By VIDEO_SAVE_MODULE = By.xpath(".//*[@id='videoModuleForm']/button");
    private final By VIDEO_MODULE_SEARCH_TEXT_BOX = By.xpath(".//*[@id='searchVideoModal']/div[2]/div/input[1]");
    private final By VIDEO_MODULE_ADD_FROM_SEARCH = By.xpath(".//*[@id='searchVideoModal']/div[2]/button");
    
    private final By SHOW_EVEN_SAVED_FEED_DASHBOARD = By.xpath(".//*[@id='moduleEven']/div/div");
    private final By SHOW_ODD_SAVED_FEED_DASHBOARD = By.xpath(".//*[@id='moduleOdd']/div/div");
    private final By PUBLISH_FEED_CLICK = By.xpath(".//*[@id='feedForm']/input");
    private final By MANAGE_AHALIFE_FEEDS = By.xpath(".//a[@href='/admin/manage-published-feeds#?siteCategory=ahalife']");
    private final By PUBLISHED_FEEDS_DATA = By.xpath(".//tr[@class='ng-scope']/td[3]");
    
    static String videoModuleName = null;
    static String videoLinkUrl = null;
    static String videoImageFileToUpload = "C:\\Users\\ashishu\\Desktop\\Testing_Images\\Flower.png";
    static List<String> ahaLifeFeedsList = null;
    
    public void dragVideoModuleForVideoFeedCreation(HashMap<String, String> dragVideo) throws InterruptedException
    {
        dragAndDrop(VIDEO_FEED_SOURCE,VIDEO_FEED_DESTINATION);
        Thread.sleep(4000L);
    }
    
    public void clickCreateVideoModule(HashMap<String, String> createVideoModule)
    {
        buttonClick(VIDEO_MODULE_CREATE);
    }
    
    public void enterVideoModuleName(HashMap<String, String> videoName)
    {
        videoModuleName = videoName.get("VideoModuleName");
        enterText(VIDEO_MODULE_NAME,videoModuleName);
    }
    
    public void clickUploadImageForVideoModule(HashMap<String, String> clickUpload)
    {
        clickUploadImage(VIDEO_UPLOAD_IMAGE);
    }
    
    public void uploadImageForVideoModule(HashMap<String, String> uploadVideoImage) throws InterruptedException
    { 
        directProductImageUpload(videoImageFileToUpload);
    }
    
    public void enterVideoUrl(HashMap<String, String> videoUrl)
    {
        videoLinkUrl = videoUrl.get("VideoURL");
        enterText(VIDEO_URL,videoLinkUrl);
    }
    
    public void saveVideoModule(HashMap<String, String> saveVideoModule) throws InterruptedException
    {
        buttonClick(VIDEO_SAVE_MODULE);
        Thread.sleep(4000L);
    }
    
    public void publishFeeds(HashMap<String, String> feedsPublish)
    {
        buttonClick(PUBLISH_FEED_CLICK);
        pageToLoad();
    }  
    
    public void clickToSeeAhaLifePublishedFeeds(HashMap<String, String> manageAHAFeeds) throws InterruptedException
    {
        Thread.sleep(5000L);
        buttonClick(MANAGE_AHALIFE_FEEDS);
        pageToLoad();
    }
    
    public void verifyIfCreatedVideoFeedExist(HashMap<String, String> videoFeedExist) throws InterruptedException
    {
        Thread.sleep(5000L);
        if(isElementExist(PUBLISHED_FEEDS_DATA))
        {
            List<WebElement> feedList = listOfWebElements(PUBLISHED_FEEDS_DATA);
            ahaLifeFeedsList = new ArrayList<String>();
            for (int i = 0;i<feedList.size();i++)
                 {
                    ahaLifeFeedsList.add(feedList.get(i).getText());
                 }
            if(ahaLifeFeedsList.contains(videoModuleName))
            {
                System.out.println(videoModuleName);
            }
            else
            {
                System.out.println("Created Feed is either not created or does not exist in Page 1");
                Assert.assertTrue(false);
            }
        }
        else
        {
            System.out.println("No AHA Life feeds exist");
            Assert.assertTrue(false);
        }
    }
    
    
    public void enterVideoModuleNameForSearch(HashMap<String, String> videoNameForSearch) throws InterruptedException
    {
        enterText(VIDEO_MODULE_SEARCH_TEXT_BOX,videoModuleName);
        Thread.sleep(4000L);
        pressKey(VIDEO_MODULE_SEARCH_TEXT_BOX,Keys.ENTER);
    }
    
    public void addSearchedVideoModule(HashMap<String, String> addSearchedVideoModule) throws InterruptedException
    {
        buttonClick(VIDEO_MODULE_ADD_FROM_SEARCH);
        Thread.sleep(3000L);
    }
    
    public void verifyIfSavedModuleIsShownOnDashboard(HashMap<String, String> savedModuleDashboard)
    {
        if(isElementExist(SHOW_ODD_SAVED_FEED_DASHBOARD) || (isElementExist(SHOW_EVEN_SAVED_FEED_DASHBOARD)))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}