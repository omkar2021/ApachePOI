              /*  Saturday   12-06-2021   */

package Miscellaneous;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitEx {
	
	WebDriver driver;
	
	@Test
	public void test() {
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");	
	driver=new ChromeDriver();
	driver.get("file:///D:/Omkar%20java/SELENIUM/Offline%20Website/index.html#");

	//browser related waits -- globally declared
	
	// 1) pageLoadTimeOut wait
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);   // TimeoutException-If the timeout expires.
	
	// 2) Implicit wait
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   // NoSuchElementException
	
	//element specific wait -- declared as & when necessary (required) 
	
	// 3) Explicit wait
	WebDriverWait wait=new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img"))));
	
	// 4) Fluent wait
	  Wait w=new FluentWait(driver)
			  .withTimeout(30, TimeUnit.SECONDS)
			  .ignoring(NoSuchElementException.class)
	          .pollingEvery(3, TimeUnit.SECONDS); 
	  w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img"))));
	  
	  driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	  
	  
}
	
	

}  // class WaitEx ends

/*
1) driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
agar page load nahi hua 30 seconds me to wo TimeOutException dega, this is single line implementation
pageLoadTimeout ye page load hone ka wait kar raha he , na ki kisi WebElement ka 

2) driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
this is single line implementation, it is similar to pageLoadTimeout, just the difference is agar page 30 seconds
me load nahi hua to ye  NoSuchElementException dega
implicitlyWait har ek WebElement ke liye wait karta he automatically

both are driver level waits, pageLoadTimeout ye page ke liye kam karta he & implicitlyWait ye all WebElement ke
liye kam karta he.

3) WebDriverWait wait=new WebDriverWait(driver, 30);
WebDriverWait is class uska objcet create kiya, WebDriverWait ka constructor hame kya mangata he
 -- org.openqa.selenium.support.ui.WebDriverWait.WebDriverWait(WebDriver driver, long timeOutInSeconds) ---
 driver as 1st parameter and 2nd parameter time mangta he by default wo seconds me hi he.


WebDriverWait wait=new WebDriverWait(driver, 30);
wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email"))));

hamne hya par wait ka objcet create kiya, and bola ki alag se 30 seconds ka wait karo ,email ke webelement ke 
liye jab tak wo dikhta nahi he.

until() method me hamne condition di ,until() method ye WebDriverWait class ki he, condition ye ExpectedConditions
class se ayegi

ExpectedConditions class iss package se import hota he
-----  import org.openqa.selenium.support.ui.ExpectedConditions; --

ExpectedConditions is  Utility class ,all the methods are static here, so ham ExpectedConditions class ki 
method kaise call kar sakhte he --> className with dot operator(ExpectedConditions.call method which you want)

static method kaise call karte he ham --> className with dot operator

so ExpectedConditions class kyu use karte he , hame jis condition ka wait karna he uss condition ko provide
karne ke liye use karte he
 
 
jab hamare pass List of WebElements hoge tab ham  ExpectedConditions ki konsi method use karnge 
visibilityOfAllElements() ye wali use karnge

nested webelements means for eg got to website --> https://www.carmax.com/  --> hya par hame 'More' kar ke
option dikhega jab ham uske upper cursor(mouse) leke jate he to uske elements dikh jate he
ye hote he nested webelements.


presence & invisible me difference kya he?
for eg. ek login page hota he jab tak username & password enter nahi karte tab tak sign-in button click nahi 
ho pata, means sign-in button is waiting for some condition, which is present but not visible

kuch webelements aise hote he ki wo kisi na kisi condition ke liye ruke hue hote he 

4) jab jab ham wait use karnge to hame check karna he ki wo import kaha se ho rahe he

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import ye org.openqa.selenium.support.ui--- iss package se hi hone chaiye


5)Wait w=new FluentWait(driver)
			  .withTimeout(30, TimeUnit.SECONDS)
			  .ignoring(NoSuchElementException.class)
	          .pollingEvery(3, TimeUnit.SECONDS); 
	          
.withTimeout(30, TimeUnit.SECONDS) -- it is maximum time frame, it will wait upto 30 seconds  
     
.ignoring(NoSuchElementException.class) -- hya par ham exception ignore kar sakhte he,suppose muze pata he
ki aisa aisa exception a sakhta he so we can ignore that exception, to execute our test case smoothly
agar hame exception aata he to hamari next steps execute nahi hote to wo execution stop na ho wo ham hya par
handle kar sakhte he by ignoring that exception

ignoring nahi likha to bhi chalta he . mandatory nahi he ki likhan hi chaiye.

.pollingEvery(3, TimeUnit.SECONDS);  -- pollingEvery means frequency, total mime frame agar 30 seconds ka he
to ye polling hamne 3 seconds ka rakha 
Explicit wait me kya hota tha ki hamne 3o seconds ka time rakah tha to wo her second ko jake check karta tha 
ki wo condition fulfill ho rahi he ya nahi

aab fluent wait kya karega har 3 seconds me check karega iss condition ko
---- w.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email"))));  ---
so there will be 10 polling coz (10*3=30) so ye 10 bar hi check karega ja kar ki condition fulfill ho rahi 
he ya nahi

how frequently it should check, to hamne bola ki her 3 seconds ke bad check karo.

Wait w=new FluentWait(driver)
here Wait is an interface so we cant create object of that, so hamne uske child class ka objcet banaya

public class FluentWait<T> implements Wait<T>
public class WebDriverWait extends FluentWait<WebDriver>

so here FluentWait is class, WebDriverWait is class & Wait is interface
releation is sabse upper wait he ,wait ka child class he FluentWait & FluentWait ka child class he WebDriverWait


6) Explict wait & fluent wait dono bhi single webelement ke liye kam karte he  









 */











