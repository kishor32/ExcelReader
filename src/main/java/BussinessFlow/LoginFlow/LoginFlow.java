package main.java.BussinessFlow.LoginFlow;

import main.java.UiActionWrapper.UiActionWraper;
import org.openqa.selenium.WebElement;
import static main.java.ObjectRepository.LoginOR.LoginOR.*;


public class LoginFlow {


    private UiActionWraper uiaction=UiActionWraper.getUI();


    public void LogIn(String usrname, String password){

        uiaction.clickOn(uiaction.findElement(LOGINLINK));

        WebElement uName=uiaction.findElement(USERNAME);

        uiaction.sendDataTo(uName,usrname);

        WebElement psd=uiaction.findElement(PASSWORD);

        uiaction.sendDataTo(psd,password);

        uiaction.clickOn(uiaction.findElement(BUTTON));

    }
}
