package test.java.LoginTest;

import main.java.BussinessFlow.LoginFlow.LoginFlow;
import main.java.DataWrapper.SeleniumKeywords;
import main.java.DataWrapper.iColumnMap;
import main.java.Reader.DataTableReader;
import main.java.util.WebDriverUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static main.java.util.ReadProperties.getProperty;


public class LoginTCs implements iColumnMap.LoginData {

    private  SeleniumKeywords.SeleniumTestData td;
    private LoginFlow loginFlow;


    @BeforeClass
    public void initialize(){

        DataTableReader tableReader=new
                DataTableReader(getProperty("datatableLocation"),getProperty("tName"));

        td=tableReader.getTestData("General data");

        loginFlow=new LoginFlow();
    }


    @Test
    public void LogIn(){

        String username=td.getData().get(USERNAME);

        String Password=td.getData().get(PASSWORD);

        loginFlow.LogIn(username ,Password);
    }


    @Test
     public void takeScreenShot(){

        WebDriverUtil.takeScreenShot(LoginTCs.class, "HomePage");
    }

    @Test(priority = 1)
    public void generateReport(){


    }

    @Test (priority = 2)


    public void logOut(){


    }

}
