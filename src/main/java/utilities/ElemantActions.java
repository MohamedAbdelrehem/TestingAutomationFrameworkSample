package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ElemantActions {
    private static int defaultWaitingTime = 10;

    @Step("Click on Element: {elementLocator}")
    public static void clickElement(WebDriver driver, By elementLocator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(defaultWaitingTime));
        elementWaiting(driver, wait, elementLocator);
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        System.out.println("Clicking on element " + driver.findElement(elementLocator).getAccessibleName());
        driver.findElement(elementLocator).click();
    }

    private static void elementWaiting(WebDriver driver, Wait<WebDriver> wait, By elementLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }
}