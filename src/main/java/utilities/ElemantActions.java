package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ElemantActions {
    private static final int DEFAULT_WAITING_TIME  = 10;

    @Step("Click on Element: {elementLocator}")
    public static void clickElement(WebDriver driver, By elementLocator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME ));
        elementWaiting(driver, wait, elementLocator);
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        System.out.println("Clicking on element " + driver.findElement(elementLocator).getAccessibleName());
        driver.findElement(elementLocator).click();
    }

    @Step("Send keys to Element: {elementLocator}")
    public static void sendKeys(WebDriver driver, By elementLocator, String text) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME ));
        elementWaiting(driver, wait, elementLocator);
        WebElement element = driver.findElement(elementLocator);
        element.clear();
        element.sendKeys(text);
        System.out.println("Sending keys to element: " + text);
    }

    private static void elementWaiting(WebDriver driver, Wait<WebDriver> wait, By elementLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }
}