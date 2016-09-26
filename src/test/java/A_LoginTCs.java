package test.java;

import main.java.BussinessFlow.LoginFlow.LoginFlow;
import main.java.DataWrapper.SeleniumKeywords;
import main.java.DataWrapper.iColumnMap;
import main.java.DriverFactory.WebDriverFactory;
import main.java.Reader.DataTableReader;
import main.java.URL.iURL;
import main.java.UiActionWrapper.UiActionWraper;
import main.java.util.Util;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static main.java.util.ReadProperties.getProperty;


public class A_LoginTCs implements iColumnMap.LoginData, iURL {

    private  SeleniumKeywords.SeleniumTestData td;
    private LoginFlow loginFlow;
    private WebDriver driver= WebDriverFactory.getDriver().getBrowser();


    @BeforeClass
    public void initialize(){

        DataTableReader tableReader=new
                DataTableReader(getProperty("datatableLocation"),getProperty("tName"));

        td=tableReader.getTestData("Login_General data");

        loginFlow=new LoginFlow();
    }


    @Test
    public void LogIn(){

        loginFlow.LogIn(td.getData().get(USERNAME), td.getData().get(PASSWORD));

        if(Util.HTTPResponse.is200(driver.getCurrentUrl()) &&
                driver.getCurrentUrl().equals(ADMIN_PAGE_URL)){

        }
    }

    @Test

    public void close(){

        UiActionWraper.getUI().closeBrowser();
    }

}
