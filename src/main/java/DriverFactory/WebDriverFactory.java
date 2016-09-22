package main.java.DriverFactory;

public class WebDriverFactory {

    private static WebDriverFactory webDriverFactory= null;

    private WebDriverFactory(){

        /*Singleton*/
    }

    public static WebDriverFactory getDriver(){
        if(webDriverFactory == null){
            webDriverFactory=new WebDriverFactory();
        }
        return webDriverFactory;
    }


}
