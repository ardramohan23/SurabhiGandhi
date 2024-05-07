package utilitypkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static int getRowCount(String x1, String sheet) throws Exception {
		
		try {
			FileInputStream fi=new FileInputStream(x1);
			XSSFWorkbook wb=new XSSFWorkbook(fi);
			XSSFSheet sh=wb.getSheet(sheet);
			return sh.getLastRowNum();
		} catch (FileNotFoundException e) {
			
			return 0;
		}
		
		
	}
	
	public static String getCellValue(String x1,String sheet, int r,int c) throws Exception {
		
		try {
			FileInputStream fi=new FileInputStream(x1);
			XSSFWorkbook wb=new XSSFWorkbook(fi);
			XSSFCell cell=wb.getSheet(sheet).getRow(r).getCell(c);
			if(cell.getCellType()==CellType.STRING) {
				return cell.getStringCellValue();
			}
			else {
				return cell.getRawValue();
			}
			
		} catch (FileNotFoundException e) {
			
			return "";
		}
		
		
		
	}

}
