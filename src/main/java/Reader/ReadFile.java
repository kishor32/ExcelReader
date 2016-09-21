package main.java.Reader;

import main.java.DataWrapper.RunManagerWrapper;
import main.java.ExcelOperation.ExcelOperation;
import static main.java.Reader.ColumnMap.RunManager.DESCRIPTION;
import static main.java.Reader.ColumnMap.RunManager.EXECUTE;
import static main.java.Reader.ColumnMap.RunManager.TC_ID;


public class ReadFile extends ExcelOperation implements ColumnMap {

    private RunManagerWrapper runManagerWrapper;


    public ReadFile(String filePath, String fileName) {

        super(filePath, fileName);
    }


    public RunManagerWrapper getTestParam(String sheetName) {

        runManagerWrapper = new RunManagerWrapper();

        this.setDataSheet(sheetName);

        int rowNum = this.getRowNumber();

        for (int row = 1; row <= rowNum; row++) {

            String flag=(String)this.getCellValue(row,EXECUTE);

             if(flag.equalsIgnoreCase("yes")){

                 runManagerWrapper.setTestCase_ID((String)this.getCellValue(row,TC_ID));

                 runManagerWrapper.setDescription((String)this.getCellValue(row,DESCRIPTION));
             }
        }

        this.closeWorkBook();
        this.closeExcelFile();
        return runManagerWrapper;
    }
}