package main.java.DataWrapper;

import java.util.List;

public class SeleniumKeywords {

    private String testCase;

    private List<String > keyWords;

    private List<String>  Data;


    public String getTestCase() {
        return testCase;
    }

    public void setTestCase(String testCase) {
        this.testCase = testCase;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords.add(keyWords);
    }

    public List<String> getData() {
        return Data;
    }

    public void setData(String data) {
        Data.add(data) ;
    }
}
