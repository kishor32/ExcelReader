package main.java.BussinessFlow.HomePage;

import main.java.ObjectRepository.HomepageOR.HomepageOR;
import main.java.URL.iURL;
import main.java.UiActionWrapper.UiActionWraper;
import main.java.util.Util;
import org.openqa.selenium.WebElement;


public class HomePageFlow {

    private UiActionWraper uiaction=UiActionWraper.getUI();


    public void searchByName(String searchItem){

        WebElement searchByNameLabel=uiaction.findElement(HomepageOR.SEARCH_BY_NAME);

        uiaction.clickOn(searchByNameLabel);

        WebElement textBox=uiaction.findElement(HomepageOR.SEARCH_TEXTBOX);

        uiaction.sendDataTo(textBox, searchItem);

    }


    public void clickOnMerchant(){

        WebElement  merchantElement=uiaction.findElement(HomepageOR.CLICK_ON_MERCENT);
        
        if(merchantElement!=null){

            uiaction.clickOn(merchantElement);
        }

        if(Util.HTTPResponse.is200(iURL.HOME_PAGE_URL_MERCENT)){

            /* @Todo code loging reporting */
            System.out.println("We are on merchant page");
        }
    }


}
