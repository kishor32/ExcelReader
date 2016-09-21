package main.java.Reader;

import main.java.DataWrapper.RunManagerWrapper;
import main.java.ExcelOperation.ExcelOperation;


public class ReadFile extends ExcelOperation {

    private RunManagerWrapper runManagerWrapper;


    public ReadFile(String filePath, String fileName) {

        super(filePath, fileName);
    }


    public RunManagerWrapper getTestParam(String sheetName) {

        runManagerWrapper = new RunManagerWrapper();

        this.setDataSheet(sheetName);

        int rowNum = this.getRowNumber();

        for (int row = 1; row <= rowNum; row++) {

                int cellNum = this.getCellNumber(this.getRow(row));

                for (int cell = 0; cell < cellNum; cell++) {

                    int cellIndex = this.getCell(row, cell).getColumnIndex();

                    switch (cellIndex) {

                        case 0:
                            runManagerWrapper.setTestCase_ID(
                                    (String) getCellValue(this.getCell(row, cell)));

                            break;

                        case 1:
                            runManagerWrapper.setDescription(
                                    (String) getCellValue(this.getCell(row,cell)));

                            break;

                        case 2: String flag=((String) getCellValue(this.getCell(row,cell)));

                            if(flag.equalsIgnoreCase("y")) {

                                runManagerWrapper.setExecute(flag);
                            }
                            break;

                        default:

                            throw new RuntimeException(ReadFile.class + " no column index found ");
                    }
                }
            }
        this.closeWorkBook();
        this.closeExcelFile();
        return runManagerWrapper;
    }
}