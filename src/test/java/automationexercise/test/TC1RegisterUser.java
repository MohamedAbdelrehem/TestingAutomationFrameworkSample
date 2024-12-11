package automationexercise.test;

import utilities.ScreenshotHeadway;
import automationexercise.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC1RegisterUser {

   private WebDriver driver;
    ScreenshotHeadway screenshot;

    //pages
    HomePage homePage;
    SignupLoginPage signupPage;
    SignupFormPage signupFormPage;
    ConfitmationAccountPage confitmationAccountPage;
    Navbar navbar;



    //* Setup Methods
    @BeforeClass
    private void setup() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        signupPage = new SignupLoginPage(driver);
        signupFormPage = new SignupFormPage(driver);
        confitmationAccountPage = new ConfitmationAccountPage(driver);
        navbar = new Navbar(driver);

        // Opening the website
        homePage.navigateToHomePage();
        driver.manage().window().maximize();
        // Our own class that takes the driver as an argument and makes taking screenshots easier
        screenshot = new ScreenshotHeadway(driver);
    }

    @AfterClass
    private void ending() {
        driver.quit();
    }
    @Test()
    private void RegisterUser() {


//
//        //* Test data until we start using Json for it
//        String firstName = "Mohamed", lastName = "Abdelrehem", email = "mohamedabedlrehem32@gmail.com";
//        String password = "Mohamed2001@";
//        String day = "11";
//        String month = "May";
//        String year = "2001";
//        String company = "Giza";
//        String address1 = "25 Studio Al-Ahram";
//        String address2 = "Omrania Sharkia, Giza";
//        String country = "United States";
//        String state = "Giza";
//        String city = "Giza";
//        String zipCode = "11245";
//        String mobileNumber = "01011929211";

        homePage.assertHomePage();
        navbar.clickSignupLoginButton();
        signupPage.assertLoginSignUp()
                    .signUp(firstName, lastName, email)
                    .clickSignUpButton();
        signupFormPage.assertSignUpPage()
                        .fillRegisterForm(firstName, lastName, password, day, month, year, company, address1, address2, country, state, city, zipCode, mobileNumber)
                        .clickCreateAccount();
        confitmationAccountPage.assertAccountCreated()
                                .clickContinueButton();
        navbar.assertUserLoggedName(firstName + lastName)
                .deleteAccount();
        confitmationAccountPage.clickContinueButton();
    }

}
