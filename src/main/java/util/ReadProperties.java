package main.java.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

    private static  Properties properties;

    public static String getProperty(String key){

        loadFile();
        return properties.getProperty(key);

    }

    private static void loadFile(){

        try {

            InputStream file=new FileInputStream("D://ExcelReaderWriter//src//main//resources//excel.properties");

            properties=new Properties();

            properties.load(file);

        }catch (IOException fileNotFound){

            System.out.println(fileNotFound.getMessage());
        }

    }
}
