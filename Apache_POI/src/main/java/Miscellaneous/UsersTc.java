            /*  Sunday  13-06-2021   */

package Miscellaneous;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/*
 *  TASKS:-
 *  1) print all the male users
 *  2)print the users from maharsahtra
 *  3)check the mobile is valis or not
 *  4)verify each user has entered gender correctly
 *  5)verify that user having email id with @gmail
 *  
 */

public class UsersTc {
	
	WebDriver driver;
	Workbook workbook;
	
	@BeforeSuite
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///D:/Omkar%20java/SELENIUM/Offline%20Website/index.html#");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		
	}
		
	@Test
	public ArrayList<String> verifyUsersColumnTable() 
	{
		ArrayList<String> expectedList=new ArrayList<String>();  
		
		try
		{
		FileInputStream fis=new FileInputStream("Test.xls");
		 workbook=Workbook.getWorkbook(fis);
		}
		catch (Exception e) {
			
		}
		Sheet sheet=workbook.getSheet("username");
		int rows=sheet.getRows();
		int columns=sheet.getColumns();
		System.out.println("rows- " +rows+ " columns- " +columns);
		System.out.println("Expected Data is:- ");
		for (int i = 0; i < rows; i++) 
		{
			for (int j = 0; j < columns; j++) 
			{
				Cell cell = sheet.getCell(j, i);
				String data = cell.getContents();
				System.out.println(data);
				expectedList.add(data);
			}	
		}
		return expectedList;	
		
	} // verifyUsersColumnTable() ends
	
	
	@Test
	public void test()
	{
		ArrayList<String> actaulData=new ArrayList<String>();
		List<WebElement> rows=driver.findElements(By.xpath("//tr"));    //will get all 5 rows
		WebElement userName;
		System.out.println("Actual Data is:-");
		for(int i=0;i<rows.size();i++) 
		{
			int row=i+1;        //list zero se start hoti he but row 1 se start hota he so hamne 1 add kiya
			if(i==0)
				userName=driver.findElement(By.xpath("//tr["+row+"]//th[2]"));
			else
				userName=driver.findElement(By.xpath("//tr["+row+"]//td[2]"));
			
			actaulData.add(userName.getText());
			//System.out.println(userName.getText());
			
		}
		
		System.out.println(actaulData);
		Assert.assertEquals(actaulData, verifyUsersColumnTable());
	}
		
	
	
	

} // class UsersTc ends

