package main.java.DataWrapper;

import java.util.ArrayList;
import java.util.List;

public class SeleniumKeywords {

    private List<String > keyWords=new ArrayList<>();


    public List<String> getKeyWords() {

        return keyWords;
    }

    public void setKeyWords(String keyWords) {

        this.keyWords.add(keyWords);
    }


    public class SeleniumTestData{

        private List<String > data=new ArrayList<>();

        public List<String> getData() {

            return data;
        }

        public void setData(String data) {

            this.data.add(data);
        }


    }


}
