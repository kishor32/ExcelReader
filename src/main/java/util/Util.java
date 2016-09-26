package main.java.util;

import java.net.HttpURLConnection;
import java.net.URL;

public class Util {

    public static String getFileSeparator()
    {

        return System.getProperty("file.separator");
    }

    public static class HTTPResponse{

        private static int nStatus;

        private static int getnStatus(String uRL){

            setStatus(uRL);
            return nStatus;
        }

        private static void setStatus(String uRL){

            try{

                URL url=new URL(uRL);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                nStatus=connection.getResponseCode();

            }catch(Exception e){

                e.printStackTrace();
            }
        }

        public static boolean is200(String url){

            if(getnStatus(url)==200){

                return true;
            }
           return false;
        }

    }
}
