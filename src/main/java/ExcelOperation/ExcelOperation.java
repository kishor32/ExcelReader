package main.java.ExcelOperation;

import static main.java.util.Util.getFileSeparator;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;

import main.java.util.Util;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;


public class ExcelOperation {


    private InputStream file=null;

    private HSSFWorkbook wb;

    private HSSFSheet sheet;

    private HSSFCell cell;

    private HSSFRow row;

    private String fiePath;

    private String fileName;

    private String dataSheetName;

    private ConcurrentHashMap<String , String> dataMap;


    public ExcelOperation(String filePath, String fileName) {

        this.fiePath = filePath;
        this.fileName = fileName;
        openFile();
    }

    /*
    @Function to open Excel file
     */
    private void openFile(){


        String absPath=fiePath+getFileSeparator()+fileName+".xlsx";

        try {

            file=new FileInputStream(absPath);
            setWrokBook(file);

        }catch(FileNotFoundException e){

          e.printStackTrace();

        }finally {

            try {

                file.close();

            }catch (IOException e){

                e.printStackTrace();
            }
        }
    }

    private void setWrokBook(InputStream file) {

        try {
            wb = new HSSFWorkbook(file);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public HSSFWorkbook getWorkbook(){

        return wb;
    }

    public void setDataSheetName(String name){

        this.dataSheetName=name;
    }

    private String getDataSheetName(){

        return dataSheetName;
    }

    private void setSheet(){

        sheet=wb.getSheet(getDataSheetName());
    }


    public int getRowNumber(){

       return sheet.getLastRowNum();

    }


    private String getValue() {

    }

}