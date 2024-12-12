package automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ConfitmationAccountPage {
    private WebDriver driver;

    public ConfitmationAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    //* SignU
    public final By accountCreatedTitle = By.xpath("(//b)[1]");
    //*pass Signup
    public final By continueButton = By.cssSelector("[data-qa='continue-button']");

    //*Account Created Page
    @Step("Verify that 'ACCOUNT CREATED!' is visible")
    public ConfitmationAccountPage assertAccountCreated() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Account Created", "Verify Account Created page title");

        Assert.assertEquals(driver.findElement(accountCreatedTitle).getText(), "ACCOUNT CREATED!", "Account Created! message not align with the title displayed");
        return this;
    }

    //*multiple usage method
    @Step("Click 'Continue' button")
    public ConfitmationAccountPage clickContinueButton() {
        driver.findElement(continueButton).click();
        return this;
    }

}
