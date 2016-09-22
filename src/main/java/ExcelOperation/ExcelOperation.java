package main.java.ExcelOperation;

import static main.java.util.Util.getFileSeparator;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class ExcelOperation {


    private InputStream file = null;

    private XSSFWorkbook wb;

    private XSSFSheet sheet;

    private String fiePath;

    private String fileName;


    public ExcelOperation(String filePath, String fileName) {

        this.fiePath = filePath;
        this.fileName = fileName;
        openFile();
    }

    /*
    @Function to open Excel file
     */
    private void openFile() {


        String absPath = fiePath + getFileSeparator() + fileName;

        if (!fileName.endsWith("xlsx")) {

            throw new RuntimeException(ExcelOperation.class + "-The specified file is not a modern excel file.Please update the file");
        }

        try {

            file = new FileInputStream(absPath);
            setWrokBook(file);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }
    }

    private void setWrokBook(InputStream file) {

        try {
            wb = new XSSFWorkbook(file);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }


    public void setDataSheet(String name) {

        sheet = wb.getSheet(name);
    }


    protected XSSFSheet getSheet() {

        return sheet;
    }


    protected int getRowNumber() {

        return sheet.getPhysicalNumberOfRows()-1;
    }


    protected Object getCellValue(int row, int col) {

        Cell cell=this.getCell(row,col);
        switch (cell.getCellType()) {

            case CELL_TYPE_STRING:
                return cell.getStringCellValue();
        }

        return null;
    }


    protected void closeWorkBook() {

        try {
            wb.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    protected void closeExcelFile() {

        try {

            file.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

     protected XSSFCell getCell(int row, int col) {

        return getSheet().getRow(row).getCell(col);
    }

    protected XSSFRow getRow(int rowCount){

        return getSheet().getRow(rowCount);
    }

}