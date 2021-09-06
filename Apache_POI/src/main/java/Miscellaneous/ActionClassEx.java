               /*   Saturday   14-08-2021 */

package Miscellaneous;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClassEx {
	
	  WebDriver driver;
     // Action act;          // Action - interface
      Actions action;      // Actions - class
      
      @Test
      public void test() throws Exception
      {
    	  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
    	  driver=new ChromeDriver();
    	  driver.get("http://javabykiran.com/playground/");
    	  Thread.sleep(3000);
    	  List<WebElement> links=driver.findElements(By.xpath("//a[@class='nav-link']"));
    	  
    	  action=new Actions(driver);
    	  for (WebElement link : links) {
			action.moveToElement(link).pause(2000).build().perform();
    	     }
    	  
    	  driver.findElement(By.linkText("Drag and Drop")).click();
    	  WebElement source= driver.findElement(By.xpath("//div[text()='Home ']"));
    	  WebElement target= driver.findElement(By.xpath("//div[text()='Contact Us']"));
    	  
    	 // action.dragAndDrop(source, target).pause(3000).build().perform();
         action.clickAndHold(source).pause(2000).moveToElement(target).pause(2000).release(source).build().perform();
    	  
    	  driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    	  
      }
      

	
} //class ActionClassEx ends


/*

1)go & see the open declaration for Action interface & Actions class.
 
2) Actions action=new Actions(driver);

org.openqa.selenium.interactions.Actions  ---Actions class is from this package
constructor of Actions class need Webdriver  --- public Actions(WebDriver driver) { }  ---


hame hya par Actions ke constructor me driver pass karna padta he kyu ki,
ham Actions class ka constructor use kar rahe he , jo ki parameterized constructor he usme hame drive as a 
parameter pass karna he, go to open declaration of Actions class hame waha par dikhgea.

3)agar hame Actions class me ek se jyda 2 method perform karni ho to hame build() method use karna padta he


 */


































