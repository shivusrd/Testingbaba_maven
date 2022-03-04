package excelutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

public static void main(String[] args) throws IOException {
String path = "C:\\Users\\sd47860\\eclipse-workspace\\18october_Framework\\src\\main\\pages\\excelutility\\WriteExcel.xlsx";
FileInputStream fis = new FileInputStream(path);
Workbook workbook = new XSSFWorkbook(fis);
Sheet sheet = workbook.getSheetAt(0);
int lastRow = sheet.getLastRowNum();
for(int i=1; i<=lastRow; i++){
Row row = sheet.getRow(i);
Cell cell = row.createCell(0);
cell.setCellValue("32");
}
FileOutputStream fos = new FileOutputStream(path);
workbook.write(fos);
fos.close();
}
}