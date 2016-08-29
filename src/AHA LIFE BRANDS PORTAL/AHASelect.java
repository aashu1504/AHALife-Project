package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class AHASelect extends GenericClass{
    
    private final By TOPIC_PAGE_HEADER_TWO = By.xpath(".//*[@id='crudListTable']/table/thead/tr/th[2]/a");
    private final By TOPIC_DATA_LIST = By.xpath(".//*[@id='crudListTable']/table/tbody/tr");
    private final By ACTUAL_TOPIC_NAME = By.xpath(".//*[@id='crudListTable']/table/tbody/tr/td[2]/a");
    private final By TOPIC_SEARCH_INPUT = By.xpath(".//*[@id='crudList']/form/div/div[1]/div/div[1]/input");
    private final By TOPIC_NAME_TOPIC_PAGE = By.xpath(".//*[@id='object_CATEGORY_NAME']");
    
    static String expectedTopicName = null;
    static String actualTopicName = null;
    static String actualTopicNameAtTopicPage = null;
    
    public void verifyNavigationToListOfAHASelects(HashMap<String, String> ahaSelectList)   //verify if list of aha select are visible
    {
       if(getTextFromAnElement(TOPIC_PAGE_HEADER_TWO).equalsIgnoreCase("Category Name")) 
       {
        if(isElementExist(TOPIC_DATA_LIST))
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
    
    public void enterTopicToSearch(HashMap<String, String> topicName)
    {
        expectedTopicName = topicName.get("TopicName");
        enterText(TOPIC_SEARCH_INPUT,expectedTopicName);
    }
    
     public void verifySearchedTopic(HashMap<String, String> searchTopic) 
    {
        actualTopicName = getTextFromAnElement(ACTUAL_TOPIC_NAME);
        Assert.assertTrue(actualTopicName.equalsIgnoreCase(expectedTopicName));
    }
    
    public void clickTopicName(HashMap<String, String> topicNameClick)
    {
        buttonClick(ACTUAL_TOPIC_NAME);
        pageToLoad();
    }
    
    public void verifyNavigationToTopicPage(HashMap<String, String> topicPageNavigation) 
    {
        actualTopicNameAtTopicPage = getAttributeValue(TOPIC_NAME_TOPIC_PAGE,"value");
        Assert.assertTrue(actualTopicNameAtTopicPage.equalsIgnoreCase(expectedTopicName));
    }
}