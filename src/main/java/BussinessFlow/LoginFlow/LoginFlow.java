package main.java.BussinessFlow.LoginFlow;

import main.java.UiActionWrapper.UiActionWraper;
import org.openqa.selenium.WebElement;
import static main.java.ObjectRepository.LoginOR.LoginOR.*;
import static main.java.util.ReadProperties.getProperty;

public class LoginFlow {


    private UiActionWraper uiaction=UiActionWraper.getUI();


    private void invokeApp(){

        uiaction.invokeApp(getProperty("AppURL"));
    }

    public void LogIn(String usrname, String password){

        invokeApp();

        uiaction.clickOn(uiaction.findElement(LOGINLINK));

        WebElement uName=uiaction.findElement(USERNAME);

        uiaction.sendDataTo(uName,usrname);

        WebElement psd=uiaction.findElement(PASSWORD);

        uiaction.sendDataTo(psd,password);

        uiaction.clickOn(uiaction.findElement(BUTTON));

    }

}
