package createworkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.record.cf.DataBarFormatting;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyExcelReader {
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static DataFormatter formatter=new DataFormatter();
	public static Object[][] ReadData() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\pdc3a-training.pdc3a\\Desktop\\Login.xlsx");
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheet("Sheet1");
		XSSFRow row=worksheet.getRow(0);
		int rowNum=worksheet.getPhysicalNumberOfRows();
		int colNum=row.getLastCellNum();
		System.out.println("Row:"+rowNum+"Col:"+colNum);
		
		Object Data[][]=new Object[rowNum-1][colNum];
		for(int i=0;i<rowNum-1;i++)
		{
			XSSFRow row1=worksheet.getRow(i+1);
			for(int j=0;j<colNum;j++)
			{
				XSSFCell cell=row.getCell(j);
				if(cell==null)
				{
					Data[i][j]="";
				}
				else
				{
					String value=formatter.formatCellValue(cell);
					Data[i][j]=value;
				}
			}
		}
		
		return Data;
		
	}

}
