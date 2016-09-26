package main.java.util;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
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


public final class WebDriverUtil {

    private WebDriverUtil(){

    }

    private static WebDriver driver= WebDriverFactory.getDriver().getBrowser();

    public static WebElement byFluentWait(By locator){

        Wait<WebDriver> wait=new FluentWait<>(driver)

                .pollingEvery(5, TimeUnit.SECONDS)

                .withTimeout(60, TimeUnit.SECONDS)

                .withMessage("found");

        try {

            return wait.until(webDriver->webDriver.findElement(locator));

          }catch(ElementNotFoundException e){

            e.printStackTrace();

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

            List<WebElement>elements= wait.until(webDriver->webDriver.findElements(locator));

            if(elements.size()==0){

                throw  new RuntimeException("No elements found");

            }else {

                return elements;
            }
    }

    public static void invokeApp(String url){

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    }

    public static void waitAferClick( int time){

        driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
    }


      public static class CloseDriver{

          public static void close(){

              driver.close();
          }

          public static void quit(){

              driver.quit();
          }
    }

    public static void backBrowSer(){

        driver.navigate().back();

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

    public static void forwardBrowser(){

        driver.navigate().forward();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

    public static void navigateTo(String url){

        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }


    public static  void replaceCurentUrlAndMove(String oldUrlPart, String newUrlPart){

        String url=driver.getCurrentUrl().replace(oldUrlPart,newUrlPart);

        driver.navigate().to(url);

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }

}
