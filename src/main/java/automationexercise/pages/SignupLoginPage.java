package automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
    public SignupLoginPage assertLoginSignUp() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login", "Verify Login page title");

        // Verify that the signup form part is loaded
        Assert.assertTrue(driver.findElement(signupFormCheck).isDisplayed(), "Signup form is displayed");

        // "New User Signup!" is loaded
        //! there is a dev element that appear inside the <h2> with the text we compare so it sometimes give a error
//        WebElement newUserSignupText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
//        Assert.assertEquals(newUserSignupText.getText(), "New User Signup!Identity management solutions", "New User Signup! text is displayed");
        return this;

    }

    public SignupLoginPage signUp(String firstNameSignup, String lastNameSignup, String emailSignup) {
        WebElement nameTextField = driver.findElement(signUpNameTextField);
        WebElement emailTextField = driver.findElement(signUpEmailTextField);

        nameTextField.sendKeys(firstNameSignup + lastNameSignup);
        // TODO: Add temp mail API
        emailTextField.sendKeys(emailSignup);
        return this;
    }

    public SignupLoginPage clickSignUpButton() {
        driver.findElement(signupButton).click();
        return this;
    }

}
