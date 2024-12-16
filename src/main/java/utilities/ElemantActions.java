package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
        //! get accesable name get wird char sometimes " "
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

    @Step("Get Text from Element: {elementLocator}")
    public static String getElementText(WebDriver driver, By elementLocator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME));
        elementWaiting(driver, wait, elementLocator);
        return driver.findElement(elementLocator).getText();
    }

    @Step("Select Dropdown Option by Visible Text: {elementLocator}")
    public static void selectElementDropdownByVisibleText(WebDriver driver, By elementLocator, String visibleText) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME));
        elementWaiting(driver, wait, elementLocator);
        Select dropdown = new Select(driver.findElement(elementLocator));
        dropdown.selectByVisibleText(visibleText);
        System.out.println("Selected dropdown option: " + visibleText);
    }

    @Step("Check if Element is Displayed: {elementLocator}")
    public static boolean isElementDisplayed(WebDriver driver, By elementLocator) {
        try {
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAITING_TIME));
            wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
            return driver.findElement(elementLocator).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
    private static void elementWaiting(WebDriver driver, Wait<WebDriver> wait, By elementLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }
}