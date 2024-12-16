package automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static utilities.ElemantActions.clickElement;
import static utilities.ElemantActions.getElementText;

public class Navbar {
    private WebDriver driver;

    //*home after logged
    private final By loggedInAsName = By.xpath("//a[b]");

    //*delete Account
    private final By deleteAccountLink = By.linkText("Delete Account");

    //home page locator
    private final By signupLoginButtonInHomePage = By.linkText("Signup / Login");


    public Navbar(WebDriver driver) {
        this.driver = driver;
    }

    //*Home Page after LoggedIn
    @Step("Verify that 'Logged in as username' is visible")
    public Navbar assertUserLoggedName(String fullName) {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Verify Home page title after login");
//        Assert.assertEquals(driver.findElement(loggedInAsName).getElementText(), "Logged in as " + fullName, "");
        Assert.assertEquals(getElementText(driver,loggedInAsName), "Logged in as " + fullName, "Logged in is not aligned with the Correct user");
        return this;
    }
    //*Delete Account
    @Step("Click 'Delete Account' button")
    public Navbar deleteAccount() {
        clickElement(driver,deleteAccountLink);
        return this;
    }
    @Step("Click on 'Signup / Login' button")
    public Navbar clickSignupLoginButton() {
        clickElement(driver,signupLoginButtonInHomePage);
        return this;
    }



}
