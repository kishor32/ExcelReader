package test.java;

import main.java.BussinessFlow.HomePage.HomePageFlow;
import main.java.DataWrapper.SeleniumKeywords;
import main.java.DataWrapper.iColumnMap;
import main.java.DriverFactory.WebDriverFactory;
import main.java.Reader.DataTableReader;
import main.java.URL.iURL;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static main.java.DataWrapper.iColumnMap.adminPage.SEARCH_TERM;
import static main.java.util.ReadProperties.getProperty;

public class B_HomePageTC implements iColumnMap.LoginData, iURL {

    private  SeleniumKeywords.SeleniumTestData td;
    private HomePageFlow homePageFlow;
    private WebDriver driver= WebDriverFactory.getDriver().getBrowser();

    @BeforeClass

     public void initialize(){

        DataTableReader tableReader=new DataTableReader(

                getProperty("datatableLocation"), getProperty("tName")
        );

        td=tableReader.getTestData("Admin_GeneralData");

        homePageFlow=new HomePageFlow();

    }


    @Test
    public void searchByName(){

        homePageFlow.searchByName(td.getData().get(SEARCH_TERM));
    }


    @Test

    public void clickOnMerchant(){

        homePageFlow.clickOnMerchant();
    }

    @Test

    public void clickOnAllMerchantLink(){

         homePageFlow.clickOnAllMerchantLink();
    }

    @Test
    public  void takeScreenShot(){

    }

}
