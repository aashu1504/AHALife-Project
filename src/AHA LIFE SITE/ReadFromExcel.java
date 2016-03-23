package AHALIFESITE;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ReadFromExcel extends GenericClass{
    
    static Cell GetUserName;
	 Cell GetPassword;
 
    public static void main(String[] args) throws IOException, InterruptedException{   
    	System.setProperty("webdriver.chrome.driver","C:\\Sotwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://bp.qa.ahalife.com/");
    Utility.pageToLoad(driver);
    driver.findElement(By.xpath(".//input[@id='username']")).sendKeys("hira@ahalife.com");
    driver.findElement(By.xpath(".//input[@id='password']")).sendKeys("ahalife");
    driver.findElement(By.xpath(".//input[@type='submit']")).click();
    Utility.pageToLoad(driver);
    driver.findElement(By.xpath(".//a[@class='navbar-brand']")).click();
    pageToLoad();
    ReadFromExcel objExcelFile = new ReadFromExcel();
    String filePath = System.getProperty("user.dir")+"\\src\\test\\java";
    
    String fileName = "GmailLogin.xlsx";
    String sheetName = "GmailSheet";
    
    List<DataFieldValues>	dataSheetList = new ArrayList<DataFieldValues>();
    File file =    new File(filePath+"\\"+fileName);
    FileInputStream inputStream = new FileInputStream(file);
    Workbook guru99Workbook = null;
    String fileExtensionName = fileName.substring(fileName.indexOf("."));
    if(fileExtensionName.equals(".xlsx")){
    guru99Workbook = new XSSFWorkbook(inputStream);
    }
    else if(fileExtensionName.equals(".xls")){
        guru99Workbook = new HSSFWorkbook(inputStream);
    } 
    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
    int rowCount = guru99Sheet.getLastRowNum();
    System.out.println(rowCount);
    
    for (int i = 0; i <=rowCount; i++) { 
       DataFieldValues data = new DataFieldValues();
       Row row = guru99Sheet.getRow(i);
       data.userName = row.getCell(0);
       String userName = row.getCell(0).toString();
       driver.findElement(By.xpath(".//*[@id='brandEmail']")).sendKeys(userName);
       driver.findElement(By.xpath(".//*[@id='detailsForm']/button")).click();
       Thread.sleep(2000L);
    }
    }
}