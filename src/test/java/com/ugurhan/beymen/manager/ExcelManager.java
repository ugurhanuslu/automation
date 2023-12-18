package com.ugurhan.beymen.manager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelManager {
    public String readExcelFile(String column) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(FileSystems.getDefault().getPath("").toAbsolutePath().toString()+"/src/main/configuration/products.xlsx"));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        CellReference cellReference = new CellReference(column);
        Row row = sheet.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());
        String value = cell.getStringCellValue();
        inputStream.close();
        return value;
    }
    public void writeExcelFile(String price) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(FileSystems.getDefault().getPath("").toAbsolutePath().toString()+"/src/main/configuration/products.xlsx"));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        CellReference cellReference = new CellReference("C1");
        Row row = sheet.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());
        cell.setCellValue(price);
        inputStream.close();
        FileOutputStream out = new FileOutputStream(new File(FileSystems.getDefault().getPath("").toAbsolutePath().toString()+"/src/main/configuration/products.xlsx"));
        workbook.write(out);
        out.close();
        inputStream.close();
    }

}
