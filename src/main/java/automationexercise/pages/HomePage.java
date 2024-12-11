package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    private WebDriver driver;
    private String homepageURL = "https://automationexercise.com/";


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public  void navigateToHomePage() {
        driver.get(homepageURL);
    }

    //home page locator
    private final By signupLoginButtonInHomePage = By.linkText("Signup / Login");


    //*Home Page
    public HomePage assertHomePage() {

        //? how can i check on url and i already opend using the url
        Assert.assertEquals(driver.getCurrentUrl(), homepageURL);
        Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Verify that home page is visible successfully");
        // Find and interact with the Signup/Login button
        //! should be removed as it is in the bar
        Assert.assertTrue(driver.findElement(signupLoginButtonInHomePage).isDisplayed(), "Home page visibility is True");
        return this;
    }



}
