                  /*   Sunday 15-08-2021  */

package Miscellaneous;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SelectClassEx {
	
	WebDriver driver;
	Select select;
	
	@Test
	public void test() 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/Omkar%20java/SELENIUM/Offline%20Website/pages/examples/add_user.html");

		WebElement state = driver.findElement(By.tagName("select"));
		select = new Select(state);
		select.selectByVisibleText("Delhi");
	}	
		
		@Test
		public void test1() throws Exception
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("file:///D:/Omkar%20java/SELENIUM/Offline%20Website/pages/examples/add_user.html");
			
			WebElement state = driver.findElement(By.tagName("select"));
			select = new Select(state);
			List<WebElement> options = select.getOptions();
			for (WebElement option : options) {
				System.out.println(option.getText());    
				select.selectByVisibleText(option.getText());
				Thread.sleep(2000);
			}
		}
	
	// Select class using @DataProvider
	
	@Test(dataProvider="stateData")
	public void usingDataProvider(String stateValue)
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///D:/Omkar%20java/SELENIUM/Offline%20Website/pages/examples/add_user.html");
		
		WebElement state=driver.findElement(By.tagName("select"));
		Select select=new Select(state);
		select.selectByVisibleText(stateValue);
	}
	
	@DataProvider
	public Object[][] stateData()
	{
		return new Object[][] { 
			new Object[] { "Punjab" }, 
			new Object[] { "HP" },
			};
    }
	
	
	
	
	
} // class SelectClassEx ends

/*
1) Select is class from the package --- org.openqa.selenium.support.ui.Select ---
constructor of Select class need WebElement  --- public Select(WebElement element) --- 
constructor jo he wo parameterized he.

2) waha par <option ye jo tag he wo bhi ek WebElement hi he.
Select class ye ham wahi par use kar payenge jaha par tagName 'select' hoga 
 
3)we can use @DataProvider in select class as well, 
usingDataProvider() ye test case 2 bar run hoga kyu ki hamne 2 options provide kiye he dataprovider me,
2 browsers will open

4) agar select tag nahi hoga to ham Actions class ka moveToElement() method use kar sakhte he.
 
 */




