                 /*  Sunday  13-06-2021   */

package Miscellaneous;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AlertsEx {

	static WebDriver driver;
	
	@Test
	public void test()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/Omkar%20java/SELENIUM/Offline%20Website/index.html#");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		driver.findElement(By.xpath("//button[text()='Add User']")).click();
		driver.findElement(By.id("username")).sendKeys("kiran");
		driver.findElement(By.id("mobile")).sendKeys("123456789");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("course")).sendKeys("Java");
		driver.findElement(By.id("Male")).click();
		
		WebElement statae=driver.findElement(By.tagName("select"));
		Select select=new Select(statae);
		select.selectByVisibleText("Maharashtra");
		
		driver.findElement(By.id("password")).sendKeys("12345");
		driver.findElement(By.tagName("button")).submit();
		
		System.out.println("Alert message :- "+driver.switchTo().alert().getText());    //printing alert
		
		driver.switchTo().alert().accept();
		
		//driver.switchTo().alert().dismiss();
		//driver.switchTo().alert().sendKeys("you can send message here");
		
		
  }
	
	
	@Test
	public void test1()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/Omkar%20java/SELENIUM/Offline%20Website/index.html#");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"tr_2\"]/td[8]/a/span")).click();
		
		System.out.println("Alert message :- "+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();  //for 1 st alert --Are you sure you want to delete this user
		                                     //aceept means we are clicking on 'OK'
		System.out.println("Alert message :- "+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();  // for 2nd alert -- User deleted successfully.
		
		//driver.switchTo().alert().dismiss();   //dismiss means we are clicking on 'Cancel'
		
		
	}  //hya par hame 2 alerts aa rahe he agar ham 1st wala accept karte he to 2nd wala bhi accept karna padega
	   // agar 1 st wala dismiss karnge to 2nd ka jarurat hi nahi he.
	
	
	
	
	
	
	
	
} // class AlertsEx ends
