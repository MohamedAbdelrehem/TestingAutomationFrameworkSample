package automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static utilities.ElemantActions.isElementDisplayed;
//import io.qameta.allure.Severity;

public class HomePage {
    private WebDriver driver;
    private String homepageURL = "https://automationexercise.com/";


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Navigate to url 'http://automationexercise.com'\n")
    public  HomePage navigateToHomePage() {
        driver.get(homepageURL);
        return this;
    }

    //home page locator
    private final By signupLoginButtonInHomePage = By.linkText("Signup / Login");


    //*Home Page
    @Step("Verify that home page is visible successfully")
    public HomePage assertHomePage() {

        //? how can I check on url and i already opend using the url
        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
        Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Verify that home page is visible successfully");
        // Find and interact with the Signup/Login button
        //! should be removed as it is in the bar
        Assert.assertTrue(isElementDisplayed(driver,signupLoginButtonInHomePage), "Home page visibility is True");
        return this;
    }



}
