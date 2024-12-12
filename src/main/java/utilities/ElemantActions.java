package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ElemantActions {
    private static WebDriver driver;
    private static Wait<WebDriver> wait;
    private static int defultWaitingTime = 10;

    public static void click(By elementLocator) {
        elementWaiting(elementLocator);
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        System.out.println("Clicking on element " + driver.findElement(elementLocator).getAccessibleName());
        driver.findElement(elementLocator).click();
    }
    private static void elementWaiting(By elementLocator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(defultWaitingTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }
}
