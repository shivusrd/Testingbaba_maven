package excelutility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility_automation

{
	static String path = System.getProperty("user.dir");
	public static String Getreaddata(int rowno, int column) {
		String data = "";
		try {

			FileInputStream fis = new FileInputStream(path+"\\src\\main\\resources\\Webtabledata.xlsx");
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			data = sheet.getRow(rowno).getCell(column).getStringCellValue();

		}

		catch (Exception e) {

			System.out.println("issu in Getreaddata " + e);
		}
		return data;

	}

	public static void main(String[] args) {
		
		String path = System.getProperty("user.dir");
		
		path = path+"\\src\\main\\resources\\Webtabledata.xlsx";

		for (int i = 0; i <= 29; i++)

		{
			String out = Getreaddata(i, 0);
			String out1 = Getreaddata(i, 1);
			System.out.println(out +     "      "    + out1);

		}


	}
}
