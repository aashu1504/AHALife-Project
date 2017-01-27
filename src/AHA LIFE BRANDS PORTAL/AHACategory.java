package AHALIFEBRANDSPORTAL;

import java.util.*;
import Utility.GenericClass;
import org.openqa.selenium.By;
import org.testng.Assert;

class AHACategory extends GenericClass{
    private final By CATEGORY_PAGE_HEADER_TWO = By.xpath(".//*[@id='crudListTable']/table/thead/tr/th[2]/a");
    private final By CATEGORY_DATA_LIST = By.xpath(".//*[@id='crudListTable']/table/tbody/tr");
    private final By CATEGORY_SEARCH_ITEM = By.xpath(".//*[@id='crudList']/form/div/div[1]/div/div[1]/input");  
    private final By ACTUAL_CATEGORY_NAME = By.xpath(".//*[@id='crudListTable']/table/tbody/tr/td[2]/a");
    private final By CATEGORY_ID = By.xpath(".//*[@id='crudListTable']/table/tbody/tr/td[1]/a");
    private final By SAVE_CONTINUE_BUTTON = By.xpath(".//input[@value='SAVE & CONTINUE EDITING']");
    private final By CATEGORY_NAME_CATEGORY_PAGE = By.xpath(".//*[@id='object_CATEGORY_NAME']");
    private final By CATEGORY_SAVE_MESSAGE = By.xpath(".//*[@id='id-page-content']/div[1]/div");
    
    static String expectedCategoryName = null;
    static String actualCategoryName = null;
    static String actualCategoryNameAtCategoryPage = null;
    static String actualCategoryId = null;
    static String actualCategorySaveMessage = null;
    static String expectedCategorySaveMessage = null;
    
    public void verifyNavigationToListOfAHACategories(HashMap<String, String> ahaCategoriesList)   //verify if list of aha categories are visible
    {
       if(getTextFromAnElement(CATEGORY_PAGE_HEADER_TWO).equalsIgnoreCase("Category Name")) 
       {
        if(isElementExist(CATEGORY_DATA_LIST))
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
    
    public void enterCategoryToSearch(HashMap<String, String> categoryName)
    {
        expectedCategoryName = categoryName.get("CategoryName");
        enterText(CATEGORY_SEARCH_ITEM,expectedCategoryName);
    }
    
    public void verifySearchedCategory(HashMap<String, String> searchCategory) 
    {
        actualCategoryId = getTextFromAnElement(CATEGORY_ID);
        actualCategoryName = getTextFromAnElement(ACTUAL_CATEGORY_NAME);
        Assert.assertTrue(actualCategoryName.equalsIgnoreCase(expectedCategoryName));
    }
    
    public void clickCategoryName(HashMap<String, String> categoryNameClick)
    {
        buttonClick(ACTUAL_CATEGORY_NAME);
        pageToLoad();
    }
    
    public void clickSaveAndContinueCategoryPage(HashMap<String, String> saveClick)
    {
        buttonClick(SAVE_CONTINUE_BUTTON);
        pageToLoad();
    }
    
    public void verifyNavigationToCategoryPage(HashMap<String, String> CategoryPageNavigation) 
    {
        actualCategoryNameAtCategoryPage = getAttributeValue(CATEGORY_NAME_CATEGORY_PAGE,"value");
        Assert.assertTrue(actualCategoryNameAtCategoryPage.equalsIgnoreCase(expectedCategoryName));
    }
    
    public void verifySuccessfullySavedCategoryPage(HashMap<String, String> categoryPageSave) 
    {
        actualCategorySaveMessage = getTextFromAnElement(CATEGORY_SAVE_MESSAGE);
        expectedCategorySaveMessage = "Category " + actualCategoryId + " [" + actualCategoryName + "] " + "has been saved";
        System.out.println(actualCategorySaveMessage);
        System.out.println(expectedCategorySaveMessage);
        Assert.assertTrue(actualCategorySaveMessage.equalsIgnoreCase(expectedCategorySaveMessage));
    }    
    
}