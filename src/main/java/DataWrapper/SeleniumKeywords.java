package main.java.DataWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeleniumKeywords {

    private List<String > keyWords=new ArrayList<>();


    public List<String> getKeyWords() {

        if(keyWords.size()==0){

            throw new RuntimeException("Empty list of keywords");
        }
        return keyWords;
    }

    public void setKeyWords(String keyWords) {

        this.keyWords.add(keyWords);
    }


    public class SeleniumTestData{

        private List<String > data=new ArrayList<>();

        public List<String> getData() {

            if(data.size()==0){

                throw new RuntimeException("Empty list of Data");
            }

            return data;
        }

        public void setData(String data) {

            this.data.add(data);
        }


    }


}
