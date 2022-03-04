package excelutility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility 
{
	public static String Getreaddata(String path, int rowno, int column) {
		String data = "";
		try {

			FileInputStream fis = new FileInputStream(path);
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
		String path = "C:\\Users\\dubey\\OneDrive\\Documents\\GitHub\\18october_framework\\src\\main\\pages\\excelutility\\Webtabledata.xlsx";

		for (int i = 0; i <= 3; i++)

		{
			String out = Getreaddata(path, i, 0);
			String out1 = Getreaddata(path, i, 1);
			System.out.println(out + out1);

		}


	}


}
