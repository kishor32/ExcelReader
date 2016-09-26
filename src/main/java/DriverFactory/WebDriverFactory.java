package main.java.DriverFactory;

import main.java.Browser.Browser;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static main.java.util.ReadProperties.getProperty;
import java.io.File;

public class WebDriverFactory {

    private static WebDriverFactory webDriverFactory= null;

    private WebDriver driver=null;

    private WebDriverFactory(){

        /*Singleton*/
    }

    public static WebDriverFactory getDriver(){

        if(webDriverFactory == null){
            webDriverFactory=new WebDriverFactory();
        }
        return webDriverFactory;
    }

    public void setBrowser(Browser browser){

        if(browser.getBrowserName()==null){

            throw new NullPointerException(" browser name is null ");
        }

        switch (browser.getBrowserName().toLowerCase()){

            case "chrome" : loadSysProperty("chrome"); driver=new ChromeDriver(this.chromeOption()); break;

            default:
                throw new RuntimeException("No suitable Driver found. Please restart the execution");

        }
    }

    public WebDriver getBrowser(){

        return driver;
    }


    private void loadSysProperty(String browser){

        switch (browser.toLowerCase()){

            case "chrome" :

                File chrome=new File(getProperty("chromeDriver"));
                System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());

                break;
        }

    }

    private ChromeOptions chromeOption (){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        return options;
    }

}
