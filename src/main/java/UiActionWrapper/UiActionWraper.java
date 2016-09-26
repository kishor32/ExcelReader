package main.java.UiActionWrapper;


import main.java.util.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class UiActionWraper implements iAction {


    private UiActionWraper (){}

    private static UiActionWraper ui=new UiActionWraper();

    public static UiActionWraper getUI(){
        return  ui;
    }


    @Override
    public WebElement findElement(By locator) {

        return WebDriverUtil.byFluentWait(locator);
    }

    @Override
    public List<WebElement> findElements(By locator) {

        return WebDriverUtil.byFluentWaits(locator);
    }

    @Override
    public void clickOn(WebElement element) {

        element.click();
        WebDriverUtil.waitAferClick(20);

    }

    @Override
    public void sendDataTo(WebElement element, String charSequence) {

        element.sendKeys(charSequence);
    }

    @Override
    public void invokeApp(String URL) {

        WebDriverUtil.invokeApp(URL);
    }

    @Override
    public void closeBrowser() {

        WebDriverUtil.CloseDriver.close();
    }

    @Override
    public void back() {

        WebDriverUtil.backBrowSer();
    }

    @Override
    public void forward() {

        WebDriverUtil.forwardBrowser();
    }

    public void To(String url){

        WebDriverUtil.navigateTo(url);
    }

    public void replaceUrl(String oldU, String newU){

        WebDriverUtil.replaceCurentUrlAndMove(oldU,newU);


    }
}
