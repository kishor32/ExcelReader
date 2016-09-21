package main.java.Reader;

import main.java.DataWrapper.SeleniumKeywords;
import main.java.ExcelOperation.ExcelOperation;
import main.java.DataWrapper.RunManagerWrapper;

public class DataTableReader extends ExcelOperation implements ColumnMap {

    private SeleniumKeywords seleniumkeywords;

    private RunManagerWrapper runManagerWrapper=new RunManagerWrapper();

    public DataTableReader(String filePath, String fileName) {
        super(filePath, fileName);
    }


    public SeleniumKeywords getKeyWords(){

        seleniumkeywords=new SeleniumKeywords();
        boolean flag=false;

        int nRow=this.getRowNumber();

        for(int row=1; row<=nRow; row++){

            String tetsCase=(String)this.getCellValue(row, Sprint1_LogIn.TC_ID);

            if(runManagerWrapper.getTestCase_ID().contains(tetsCase)){

                flag=true;
            }

            if (flag){

                for(int keywords=1; keywords<)
            }


        }

        return seleniumkeywords;
    }

}
