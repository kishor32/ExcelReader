package main.java.util;

import main.java.DriverFactory.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.OutputType;
import static java.util.UUID.randomUUID;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebDriverUtil {

    private static WebDriver driver= WebDriverFactory.getDriver().getBrowser();

    public static WebElement byFluentWait(By locator){

        Wait<WebDriver> wait=new FluentWait<>(driver)

                .pollingEvery(5, TimeUnit.SECONDS)

                .withTimeout(60, TimeUnit.SECONDS);
        try {

            return wait.until(webDriver->webDriver.findElement(locator));

          }catch(NoSuchElementException e){

        }
        return null;
    }


    public static void clickByInteraction(WebElement element){

             new Actions(driver)
                .moveToElement(element)
                .click()
                .build()
                .perform();
    }


    public static String takeScreenShot(Class c, String name){

        String path=new String("D://ExcelReaderWriter//Screenshots//"+c+randomUUID()+".jpeg");

        File srcFile= new EventFiringWebDriver(driver).getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(srcFile, new File(path));

        }catch (IOException e){
            e.printStackTrace();
        }

        return path;
    }

    public static List<WebElement> byFluentWaits(By locator){

        Wait<WebDriver> wait=new FluentWait<>(driver)

                .pollingEvery(5, TimeUnit.SECONDS)

                .withTimeout(60, TimeUnit.SECONDS);
        try {

            return wait.until(webDriver->webDriver.findElements(locator));

         }catch(NoSuchElementException e){

        }
        return null;

    }

    public static void invokeApp(String url){

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    }

}
