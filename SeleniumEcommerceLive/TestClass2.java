
package eCommerceLive;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.WebDriver;

public class TestClass2 {
    public String baseUrl = "http://live.techpanda.org/";
    String driverPath = "C:\\geckodriver.exe";
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
	  public void testTestCase2() throws Exception {
		
		// 1. Go to http://live.techpanda.org
	    driver.get(baseUrl); 
	    
	    // 2. Click on Mobile menu
	    driver.findElement(By.linkText("MOBILE")).click();	
	  
	    // 3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100) 	    	      
	    String XPeriaPrice = driver.findElement(By.cssSelector("#product-price-1 > span.price")).getText();
	   
	    // 4. Click on Sony Xperia mobile 	   
	    driver.findElement(By.id("product-collection-image-1")).click();
	    
	    // 5. Read the XPeria mobile price from details page
	    String detailPrice = driver.findElement(By.cssSelector("span.price")).getText();
	    	    
	    //  Product price in list and details page should be equal ($100)
	    try {
	        assertEquals(XPeriaPrice, detailPrice); 
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	  }
}
