 /*     Sunday 09-05-2021   */

package com.jbk.readExcel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel 
{
	
	public static void main(String[] args) {
		
	
 /*
    1. create file (fileInputStream--->to read)  (FileOutputStream---->to write)
    2. workbook(.xlsx XSSFWorkBook)
    3.  sheet
    4. rows
    5. cells 
 */
    try 
    {
		
    	FileInputStream fileInputStream=new FileInputStream(new File("D:\\employee.xlsx")); 
    	
    	Workbook workbook= new XSSFWorkbook(fileInputStream);
    	
    	 Sheet sheet=  workbook.getSheetAt(0);
    	 
    	
    	 Iterator<Row> rows= sheet.rowIterator();
    	 
    	while (rows.hasNext()) 
    	{
			Row row = rows.next();
		   Iterator<Cell> cells=  row.cellIterator();
			 
            while (cells.hasNext())
			{
				 Cell cell=   cells.next();
				 System.out.print(cell.getStringCellValue() + "\t");
		    }
			System.out.println();
			
		} //outer while loop ends
    	
   }  // try ends
    
    catch (Exception e) 
    {
		e.printStackTrace();
	}
 
  }// main ends
	
} // class ReadExcel ends
/*
Input file ke liye compile time error aata he isliye pahle hi hamne try/catch block likha
and hame jo code likhna he wo ham try block me likhenge

Iterator<Row> rows= sheet.rowIterator();     isse hame bahot sari rows mili
hame kya karna he kisi particular row ke pass jana he, hya to bahot sari rows he
to while loop laga ke har ek row ke pass jaynge ham

rows.hasNext()    isse kay hoga rows ke andar row present he ya nahi ye check karega, hasNext() kiya matlab 
1 st position pe jo row he uske upar ayega , matlab 0th postion pe jo row he ushe wo point out kar raha he

rows.next()     se kya mila hame , wo tino rows me se jisko wo point out kar raha he wo row hame milegi 

Row row = (Row) rows.next();     isse tino rows me se hame ek particular  row mili.iske andar bahot sare cells he
pahle sheet ke pass gaye sheet ne Sheet return kiya ,Sheet ke andat bahot sari row thi, wo saro row hamne rows ke andar rakhi
aur us rows ke andar 3 row he,to particular row ke pass jane ke liye traverse karke kisi tarha ham
us 'row' ko hya laya           Row row =  rows.next();
matlab abhi 0th position ki row ayi hogi ID,NAME,DEPT ki, to uske andar abhi 3 cells he ,iska matlab us row ke andar bhi 3cells he
iska matlab hame row se abhi cell iterate karne padege.

jo bhi row mili he usse cell iterate karenege ham abhi
row.cellIterator();       cell jab Iterate kar rahe he to kitne cell mil rahe he hame  iss example(employee.xlsx) me 
hame 1 row me 3 cells mile like (ID,NAME,DEPT)

jab ham rowIterator() kar rahe the hame Itertor of row mila ----> Iterator<Row>
cellIterator()--->  isse hame Itertor of cell  mila  --->  Iterator<Cell>
 
 ek row ke andar bahot sare cells he isliye hamne reference ka nam diya 'cells'
 Iterator<Cell> cells=  row.cellIterator();
 
 abhi hame bahot sari cells me se ek particular cell ke pass jana he
 while (cells.hasNext())----isme  cells.hasNext() -- se kya hoga us particular row ke andar cells check kiye jayenge
 to abhi 3 he matlab 0th position,1st position & 2nd position.
 pahle target karega 0th position ki cell ke liye  uske liye ham ------  cells.next(); ---- ye likhenge
   cells.next();---- ye jab karte he to 'cells' kay kar raha he return   ' Iterator<Cell> cells '
  next() ---- kya kar raha he return    ' Cell java.util.Iterator.next() '   ek particular cell single cell
  to usko ham store karenge 'Cell'  ke andar   ' Cell cell=   cells.next();'
  iska matlab hame ek cell mil gyi
  abhi uske andar data he hame wo print karna he  
  cell.getStringCellValue();     'getStringCellValue()'   ye kyu liya kyu ki cell ke andar String type ka data he
  
 System.out.println(cell.getStringCellValue()); ----- to ye print karega us cell ki andar ka data(value).
 
 if we write numbers in column of ID like 1,2,3  then we will get error of 
 ' java.lang.IllegalStateException: Cannot get a STRING value from a NUMERIC cell '
 because we had given integer value 1,2,3
 so we will change it to String like  emp1,emp2,emp3.
  
 now we want data in table format then
 isko ham ----'System.out.println(cell.getStringCellValue());' -----aise likhenge 'System.out.print(cell.getStringCellValue());'
 juse remove 'ln'. 
 ekhi line pe aana chaiye aur jaise hi row khatam hoti he wo next line pe aana chaiye.
 
 ye jo lopp he wo ekhi row ke liye he
 while (cells.hasNext())
			{
				 Cell cell=   cells.next();
				 System.out.println(cell.getStringCellValue());
			} 
 
 iske bad next hona chaiye  matlab next row new line pe aane ke liye ham while loop jaha end hota he waha pe
 System.out.println();   ye likhenge
 now we want some space between them so ham  kya karenege  "\t"(means concat karke tab) denge.
System.out.print(cell.getStringCellValue() + "\t");

*/






















 