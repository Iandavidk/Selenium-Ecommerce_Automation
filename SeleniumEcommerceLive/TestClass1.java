//********************************************************************************************
//*                                                                                          *
//*    Guru99 eCommerce Live Project                                                         *
//*    Day 1 - TestCase 1                                                                    *
//*    Author: Ian Kihara Wangui                                                              *                                                                                      *

//********************************************************************************************
/*  

Test Steps
Step 1. Goto http://live.techpanda.org/
Step 2. Verify Title of the page
Step 3. Click on ‘MOBILE’ menu
Step 4. Verify Title of the page
Step 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’
Step 6. Verify all products are sorted by name
*/

package eCommerceLive;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass1 {
    public String baseUrl = "http://live.techpanda.org/";
    String driverPath = "C:\\geckodriver.exe";
    public int scc = 0;
    public WebDriver driver ; 
     
     @BeforeTest
  // Step 1 Goto http://live.techpanda.org/
      public void launchBrowser() {
          System.out.println("launching firefox browser"); 
          System.setProperty("webdriver.gecko.driver", driverPath);
          driver = new FirefoxDriver();
          driver.get(baseUrl);
      }
     
     @Test
   //Step 2. Verify Title of the page
     public void verifyHomepageTitle() throws IOException {
         String expectedTitle = "THIS IS DEMO SITE FOR   ";
         String actualTitle = driver.findElement(By.cssSelector("h2")).getText();;
         Assert.assertEquals(actualTitle, expectedTitle);
         
   // Step 3. Click on ‘MOBILE’ menu
 	    driver.findElement(By.linkText("MOBILE")).click();	
 	    
   // Step 4. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’		
 	    new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");
 	    
   // Step 5. Verify all products are sorted by name
 		// this will take a screen shot of the manager's page after a successful login
 	    scc = (scc+1);
 		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 		String png = ("C:\\Users\\HP\\Documents\\Guru99 eCommerce Live Project\\Day01_TestCase1\\Mobile Products are sorted" + scc + ".png");
 		FileUtils.copyFile(scrFile, new File(png));
    }
     
     @AfterTest
     public void terminateBrowser(){
         driver.close();
     }
        
}
