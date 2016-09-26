//package test.java;
//
//import main.java.DataWrapper.SeleniumKeywords;
//import main.java.Reader.DataTableReader;
//import static main.java.util.ReadProperties.getProperty;
//
//
//public class TestReadFile  {
//
//    public static void main(String [] args){
//
//        DataTableReader tableReader=new DataTableReader(
//
//                getProperty("datatableLocation"),getProperty("tName"));
//
//        SeleniumKeywords s=tableReader.getKeyWords("Bussiness Flow");
//
//        for(String key: s.getKeyWords()){
//
//            System.out.println(key);
//        }
//
//        /*now read some test data*/
//
//        SeleniumKeywords.SeleniumTestData s1=tableReader.getTestData("General data");
//
//        for(String data:s1.getData()){
//
//            System.out.println(data);
//
//        }
//
//    }
//}
