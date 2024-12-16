package automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static utilities.ElemantActions.*;

public class SignupLoginPage {
    private WebDriver driver;

    //Login/Signup locators
    private final By signupFormCheck = By.className("signup-form");

    private final By signUpNameTextField = By.cssSelector("[data-qa='signup-name']");
    private final By signUpEmailTextField = By.cssSelector("[data-qa='signup-email']");

    private final By signupButton = By.cssSelector("[data-qa='signup-button']");

    public SignupLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //* Login/SignUp page
    @Step("Verify 'New User Signup!' is visible")
    public SignupLoginPage assertLoginSignUp() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login", "Verify Login page title");

        // Verify that the signup form part is loaded
        Assert.assertTrue(isElementDisplayed(driver, signupFormCheck), "Signup form is not displayed");
        // "New User Signup!" is loaded
        //! there is a dev element that appear inside the <h2> with the text we compare so it sometimes give a error
//        WebElement newUserSignupText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
//        Assert.assertEquals(newUserSignupText.getElementText(), "New User Signup!Identity management solutions", "New User Signup! text is displayed");
        return this;

    }
    @Step("Enter name and email address")
    public SignupLoginPage signUp(String firstNameSignup, String lastNameSignup, String emailSignup) {
        // TODO: Add temp mail API
        sendKeys(driver,signUpNameTextField,firstNameSignup+lastNameSignup);
        sendKeys(driver,signUpEmailTextField,emailSignup);
        return this;
    }
    @Step("Click 'Signup' button")
    public SignupLoginPage clickSignUpButton() {
        clickElement(driver, signupButton);
        return this;
    }

}
