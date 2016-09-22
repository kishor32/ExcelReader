package main.java.Reader;

import main.java.DataWrapper.SeleniumKeywords;
import main.java.ExcelOperation.ExcelOperation;
import main.java.DataWrapper.RunManagerWrapper;
import static main.java.util.ReadProperties.getProperty;


public class DataTableReader extends ExcelOperation implements ColumnMap {


    private SeleniumKeywords seleniumkeywords;

    private SeleniumKeywords.SeleniumTestData testData=null;


    public DataTableReader(String filePath, String fileName) {

        super(filePath, fileName);
    }


    public SeleniumKeywords getKeyWords(String sheetName){

        ReadFile file=new ReadFile(getProperty("fileLocation"),getProperty("filename"));

        RunManagerWrapper r=file.getTestParam("Full Suite");

        seleniumkeywords=new SeleniumKeywords();

        this.setDataSheet(sheetName);

        int nRow=this.getRowNumber();

        for(int row=1; row<=nRow; row++){

            String tetsCase=(String)this.getCellValue(row, Sprint1_LogIn.TC_ID);

            if(r.getTestCase_ID().contains(tetsCase)){

                int lastCellNum=this.getRow(row).getPhysicalNumberOfCells();

                for(int cell=1;cell<lastCellNum;cell++){

                    seleniumkeywords.setKeyWords((String)this.getCellValue(row,cell));
                }
            }
        }

        return seleniumkeywords;
    }


    public SeleniumKeywords.SeleniumTestData getTestData(String sheetName){

        seleniumkeywords=new SeleniumKeywords();

        testData=seleniumkeywords.new SeleniumTestData();

        this.setDataSheet(sheetName);

        int nRow=this.getRowNumber();

        for(int row=1; row<=nRow; row++){

                int lastCellNum=this.getRow(row).getLastCellNum();

                for(int cell=1;cell<lastCellNum;cell++){

                    testData.setData((String)this.getCellValue(row,cell));
                }
        }

        return testData;
    }

}
