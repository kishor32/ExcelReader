package main.java.DataWrapper;

import java.util.ArrayList;
import java.util.List;

public class RunManagerWrapper {

    private  List <String>  TestCase_ID=new ArrayList();

    private  List <String>  Description=new ArrayList();

    private  List <String>   Execute=new ArrayList();


    public List<String>  getTestCase_ID() {

        return TestCase_ID;
    }

    public void setTestCase_ID(String testCase_ID) {

        getTestCase_ID().add(testCase_ID);
    }

    public List <String>  getDescription() {

        return Description;
    }

    public void setDescription(String description) {

        Description.add(description);
    }

    public List<String>  getExecute() {

        return Execute;
    }

    public void setExecute(String execute) {

        Execute.add(execute);
    }
}
