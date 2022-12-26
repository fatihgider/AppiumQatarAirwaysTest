package methods;

import com.thoughtworks.gauge.Step;
import driver.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import pages.FlightsPage;

import java.time.Duration;

public class Methods{
    AppiumDriver appiumDriver;
    FluentWait<AppiumDriver> wait;
    static Logger log = Logger.getLogger(FlightsPage.class.getName());

    public Methods(){
        appiumDriver = BaseTest.appiumDriver;
        wait = new FluentWait<>(appiumDriver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
    }

    @Step("<x> saniye bekle")
    public void waitForSecods(int x) throws InterruptedException {
        Thread.sleep(1000*x);
    }

    public MobileElement findElement(By by){
        return (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by){
        findElement(by).click();
    }

    public void sendKeys(By by, String text){
        findElement(by).sendKeys(text);
    }

    public void SwipeUp(){
        final int PRESS_TIME = 200;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = appiumDriver.manage().window().getSize();
        pointOptionStart = PointOption.point(300,  1270);
        pointOptionEnd = PointOption.point(300, 810);
        new TouchAction(appiumDriver)
                .press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
    }
    public boolean isElementVisibles(By by){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            log.info("Sayfa Yüklendi");
            System.out.println("Page Load Success");
            return true;
        }catch (Exception e){
            log.info("Sayfa Yüklenemedi"+e.getMessage());
            System.out.println("Page Load Failed"+e.getMessage());
            return false;
        }
    }
}
