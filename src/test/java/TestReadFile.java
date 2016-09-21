package test.java;

import main.java.Reader.ReadFile;
import static main.java.util.ReadProperties.getProperty;


public class TestReadFile  {

    public static void main(String [] args){

        ReadFile file=new ReadFile(getProperty("fileLocation"),getProperty("filename"));

        System.out.println(file.getTestParam("Full suite").getTestCase_ID());

    }
}
