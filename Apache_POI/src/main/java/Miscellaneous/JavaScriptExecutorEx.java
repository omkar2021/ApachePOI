             /*   Sunday 15-08-2021  */

package Miscellaneous;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorEx {

	static WebDriver driver;
	
	public static void main(String[] args)  throws Exception{
		
		WebElement userName,password;
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///D:/Omkar%20java/SELENIUM/Offline%20Website/index.html#");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(js.executeScript("return document.URL;"));
		
		System.out.println(driver.getTitle());
		System.out.println(js.executeScript("return document.title"));
		
		//changing title by js
		js.executeScript("document.title='updated title';");
		System.out.println(driver.getTitle());
		
		//refreshing browser by js
		js.executeScript("history.go(0);");
		
		
		//clicking element by js
		js.executeScript("arguments[0].click();",userName=driver.findElement(By.id("email")));
		//using sendKeys by js
		js.executeScript("document.getElementById('email').value='kiran@gmail.com';");
		
		// clicking element by js
		js.executeScript("arguments[0].click();", password = driver.findElement(By.id("password")));
		// using sendKeys by js
		js.executeScript("document.getElementById('password').value='123456';");
		
		//creating alert by js
		js.executeScript("alert('hello world');");
		Alert al=driver.switchTo().alert();
		System.err.println(al.getText());
		Thread.sleep(3000);
		al.accept();
		
		//navigating to other page by js
		js.executeScript("window.location='https://www.amazon.in/'");
		Thread.sleep(6000);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		WebElement  footer_logo=driver.findElement(By.xpath("//a[@href='/ref=footer_logo']"));
		js.executeScript("arguments[0].scrollIntoView(true);", footer_logo);
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		driver.navigate().forward();
	}	
	
} // class JavaScriptExecutorEx ends

/*
1) see the open declaration of  JavaScriptExecutor (public interface JavascriptExecutor)
it is an Interface and it has only 2 methods
   a) Object executeScript(String script, Object... args);
   b) Object executeAsyncScript(String script, Object... args);
   
mostly ham executeScript() method hi use karte he. executeScript() method hame kya mangta he parametres
String script --- ek to script mangta he ki hame kya operation karna he , 
Object... args--- 2nd is aur kis object par karna he wo object mangta he

to jab ham ishe script & object dete he tab wo script ko perform karta he

2) Advanced actions jo ki Actions/Robot class se bhi nahi hoti like scroll karna page ko

3) JavascriptExecutor js=(JavascriptExecutor)driver;

JavascriptExecutor is an Interface so we can not create Object of interface so ham isko type cast karte he,
WebDriver ke sath., jaise TakeScreenShot ko kiya tha 

4) js.executeScript("return document.URL;") --> isme -- "return document.URL;" -- ye jo he wo script he

Q)muze text box me value likhni he but sendKeys ka use nahi karna he to kya option he? --> 
//using sendKeys by js
js.executeScript("document.getElementById('email').value='kiran@gmail.com';");

we can enter a text into text box using  JavascriptExecutor, using script 
----- "document.getElementById('email').value='kiran@gmail.com';"  ---
 
5)
mera abhi Login k url he aab muze wo change karna he dusra lena he amazon ka enter karna he url to ham
driver.navigate().to(); likhenge ye hua WebDriver se 

yahi kam JavascriptExecutor se bhi hota he aise 
-- js.executeScript("window.location='https://www.amazon.in/'"); ---
browser ki url jo he wo ham JavascriptExecutor se bhi change kar sakhte he. 

6) js.executeScript("arguments[0].scrollIntoView(true);", footer_logo);

hya par hamne aise likha he ki jab tak footer_logo na dikhe tab tak scroll karo 
 
 */








