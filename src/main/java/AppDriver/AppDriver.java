package main.java.AppDriver;


import main.java.Browser.Browser;
import main.java.DataWrapper.SeleniumKeywords;
import main.java.DriverFactory.WebDriverFactory;
import main.java.Reader.DataTableReader;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


import static main.java.util.ReadProperties.getProperty;

public class AppDriver {

    private  static   Class<?> testCase ;

    private DataTableReader tableReader = new DataTableReader(

            getProperty("datatableLocation"), getProperty("tName")

    );


    private List <String> loadKeyWords() {

        SeleniumKeywords keywords = tableReader.setKeyWords("Bussiness Flow");

        return keywords.getKeyWords();

    }


    private Set<String> getAllTestClass() throws

            ClassNotFoundException, IllegalAccessException, InstantiationException {

        Set<String> testClass = new LinkedHashSet<>();

        final String CLASS_FILE_EXTENSION = ".class";

        String className = null;

        File packageDirectories = new File(getProperty("PackageDir"));

        File[] directory = packageDirectories.listFiles();

        if(directory.length==0){

            throw new RuntimeException("No file inside directory");
        }

        for (int i = 0; i < directory.length; i++) {

            File packageFile = directory[i];

            String fileName = packageFile.getName();

            if (fileName.endsWith(CLASS_FILE_EXTENSION)) {

                className = fileName.substring(0, fileName.length()

                        - CLASS_FILE_EXTENSION.length());

                testClass.add(className);
            }

        }

        return testClass;
    }


    public static void main(String[]args) throws Exception{


        AppDriver a=new AppDriver();

        List<String> keys=a.loadKeyWords();

        WebDriverFactory.getDriver().setBrowser(Browser.getBrowser());

                a.getAllTestClass().forEach(s -> {

                    try{

                        System.out.println(s);


                        testCase = Class.forName("test.java" + "." + s);

                        Object Obj = testCase.newInstance();

                        Method[] methods = Obj.getClass().getMethods();

                    for (String key : keys) {

                        for (Method m : methods) {

                            if (key.equalsIgnoreCase(m.getName())) {

                                m.invoke(Obj);
                            }
                        }
                    }
                }catch ( Exception e) {

                       throw new RuntimeException("Exception Occurred->"+e.getMessage());

                    }} ); }}


