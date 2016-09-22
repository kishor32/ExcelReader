package main.java.UiActionWrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public interface iAction {


     WebElement findElement(By locator);

     List<WebElement> findElements(By locator);

     void clickOn(WebElement element);

     void sendDataTo(WebElement element, String charSequence);

     void invokeApp(String URL);

}
