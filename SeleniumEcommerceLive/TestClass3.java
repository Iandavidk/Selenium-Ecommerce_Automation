
package eCommerceLive;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.WebDriver;

public class TestClass3 {
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
	  public void testTestCase3() throws Exception {
		
		// 1. Go to http://live.techpanda.org
	    driver.get(baseUrl); 
	    
	    // 2. Click on Mobile menu
	    driver.findElement(By.linkText("MOBILE")).click();
	    	  
	    // 3. In the list of all mobile , click on ‘ADD TO CART’ for Sony Xperia mobile
	    driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/button")).click();	
	    
	    // 4. Change ‘QTY’ value to 1000 and click ‘UPDATE’ button. 
	    //    Expected "The requested quantity for "Sony Xperia" is not available." error message is displayed. 
	    
	    driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).clear();	    
	    driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).sendKeys("1000");	
	    driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/button")).click();
	   	    
	    // 5. Verify the error message
	    String reqQty = driver.findElement(By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[2]/p")).getText();	    
	    String msgQty = ("* The requested quantity for \"Sony Xperia\" is not available.");
	    try {	    	
	    	assertEquals(reqQty, msgQty);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    
	    // 6. Click on ‘EMPTY CART’ link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
	    
	    driver.findElement(By.xpath(".//*[@id='empty_cart_button']")).click();
	    	    
	    // 7. Verify cart is empty
	    String noItemsStg = ("You have no items in your shopping cart.");
	    String noItemsMsg = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/div[2]/p[1]")).getText();
	    System.out.println("You have no items msg = " + noItemsMsg);
	    
	    try {	    	
   	assertEquals(noItemsStg, noItemsMsg);
	    } catch (Exception e) {
	    	e.printStackTrace();	    	
	    }	
	      	   
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}	
}
