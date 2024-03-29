
package eCommerceLive;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.WebDriver;

public class TestClass4 {
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
	  public void testTestCase4() throws Exception {
		
		// 1. Go to http://live.techpanda.org
	    driver.get(baseUrl); 
	    
	    // 2. Click on Mobile menu
	    driver.findElement(By.linkText("MOBILE")).click();
	    Thread.sleep(1000);
	    
	    // 3. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Iphone & Sony Xperia)
	    
	    //note: store the title of the 2 mobiles for comparison for verification later when popup page comes up
	    driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[2]/ul/li[2]/a")).click();
	    String mainMobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();  // text captured - upperCase "IPHONE"
	    System.out.println("mainMobile1 = "+mainMobile1);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a")).click();   
	    String mainMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();  // text captured - upperCase "SONY XPERIA"
	    System.out.println("mainMobile2 = "+mainMobile2);
	    Thread.sleep(1000);
	    
	    // 4. Click on ‘COMPARE’ button. A pop-up window opens	   
	    driver.findElement(By.xpath("//button[@title='Compare']")).click();	    
	    Thread.sleep(1000);
	    
	    // switching to new window
	    for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    
	    // 5. Verify the pop-up window and check that the products are reflected in it
	    //    Heading "COMPARE PRODUCTS" with selected products in it.
	    String strHead = ("COMPARE PRODUCTS");
	    String compHead = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div[1]/h1")).getText();	
	    System.out.println("compHead = "+compHead);
	    String popupMobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();  // text captured is "IPHONE" in uppercase
	    String popupMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();  // text captured "SONY XPERIA" in uppercase
	    System.out.println("popupMobile1 = "+popupMobile1);
	    System.out.println("popupMobile2 = "+popupMobile2);
	    Thread.sleep(1000);
	    // to check the pop-up heading/title
	    try {	    	
	    	assertEquals(strHead, compHead);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    // to check the 2 mobiles selected are the two in the pop-up - this is tp check the IPhone
	    try {	    	
	    	assertEquals(mainMobile1, popupMobile1);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    // to check the 2 mobiles selected are the two in the pop-up - this is to check Sony X
	    try {	    	
	    	assertEquals(mainMobile2, popupMobile2);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    	    
	    // 6. Close the Pop-up Windows
	    driver.findElement(By.xpath("//button[@title='Close Window']")).click();
	    
	    // switching to new window
	    for (String handle : driver.getWindowHandles()) {
	    driver.switchTo().window(handle);
	    }	    
	  }

	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}	
}



