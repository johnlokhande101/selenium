package createworkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteWorkBook {
  @Test
  public void f() throws IOException {
	  
	  File src=new File("C:\\Users\\pdc3a-training.pdc3a\\Desktop\\Sheet1.xlsx");
	  FileInputStream fis=new FileInputStream(src);
	  XSSFWorkbook wb=new XSSFWorkbook(fis);
	  XSSFSheet sheet1=wb.getSheetAt(0);
	  
	  int row=sheet1.getLastRowNum();
	  System.out.println("Total number of rows: "+row);
	  
	  
	  for(int i=0;i<=row;i++)
	  {
		  String data=sheet1.getRow(i).getCell(0).getStringCellValue();
		  System.out.println("Test data is :"+data);
		  
		  String data1=sheet1.getRow(i).getCell(1).getStringCellValue();
		  System.out.println("Test data is :"+data1);
		  
		  
	}
	  
	  
	  sheet1.getRow(0).createCell(2);//.setCellValue("Username");
	  sheet1.getRow(1).createCell(2);//.setCellValue("Password");
	  //sheet1.getRow(2).createCell(2).setCellValue("Result");
	  
	  FileOutputStream fout=new FileOutputStream(new File("C:\\Users\\pdc3a-training.pdc3a\\Desktop\\Sheet2.xlsx"));
	  wb.write(fout);
	  fout.close();
	  
	  
  }
}
