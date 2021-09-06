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
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;



public class UsersPageTC {
	Workbook workbook=null;
	WebDriver driver;
	
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
		Sheet sheet=workbook.getSheet("column");
		int rows=sheet.getRows();
		int columns=sheet.getColumns();
		System.out.println("rows- " +rows+ " columns- " +columns);
		
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
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///D:/Omkar%20java/SELENIUM/Offline%20Website/pages/examples/users.html");
		
		ArrayList<String> actualList=new ArrayList<String>();
		List<WebElement> rows=driver.findElements(By.xpath("//tr"));   //getting all 5 rows //all elements of 5 rows ayenge
		WebElement col;
		for(WebElement row:rows) 
		{
			if(rows.indexOf(row)==0)
				 col=row.findElement(By.xpath("//th[1]"));
			else
				col=row.findElement(By.tagName("td"));
			
			actualList.add(col.getText());
		}
				
		Assert.assertEquals(actualList, verifyUsersColumnTable());
		
		
	}
	
	
	
	

} // class UsersPageTC ends
