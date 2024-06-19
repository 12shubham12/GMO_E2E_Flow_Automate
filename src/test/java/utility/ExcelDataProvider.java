package utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelDataProvider {

    XSSFWorkbook wb;

    public ExcelDataProvider(){
        File scr = new File("./TestData/Inputdata.xlsx");
        try{
            FileInputStream fis = new FileInputStream(scr);
            wb = new XSSFWorkbook(fis);
        }
        catch(Exception e){
            System.out.println("Unable to read Excel file"+e.getMessage());
        }

    }
    //method to read data from excel
    public int getQuantity(String sheetName, int row, int column){
        return (int) wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }

    public String getStringVal(String sheetName, int row, int column){
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    public int getNumericVal(String sheetName, int row, int column){
        return (int) wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }

    public long getLongVal(String sheetName, int row, int column){
        return (long) wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }

}
