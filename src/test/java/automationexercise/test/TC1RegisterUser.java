package automationexercise.test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import utilities.DriverFactory;
import utilities.JsonFileManager;
import utilities.ScreenshotHeadway;
import automationexercise.pages.*;
import org.openqa.selenium.WebDriver;
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
    JsonFileManager testData;



    //* Setup Methods
    @BeforeClass
    private void setup() {

        driver = DriverFactory.initDriver("chrome", true);
        testData = new JsonFileManager("D:/Headway2024/Automation/JAVA/HeadwayAutomationDemo/src/test/TestData/UsersTestData.json");
        // Our own class that takes the driver as an argument and makes taking screenshots easier
        screenshot = new ScreenshotHeadway(driver);
    }

    @AfterClass
    private void tearDown() {
        driver.quit();
    }

    @Test()
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the user can successfully register, log in, and delete their account on the Automation Exercise website.")
    private void RegisterUser() {
        new HomePage(driver).navigateToHomePage()
                            .assertHomePage();
        new Navbar(driver).clickSignupLoginButton();
        new SignupLoginPage(driver).assertLoginSignUp()
                                 .signUp(testData.getTestData("firstName"), testData.getTestData("lastName"), testData.getTestData("email"))
                                .clickSignUpButton();
        new SignupFormPage(driver).assertSignUpPage()
                        .fillRegisterForm(testData.getTestData("firstName"), testData.getTestData("lastName"), testData.getTestData("password"), testData.getTestData("day"), testData.getTestData("month"), testData.getTestData("year"), testData.getTestData("company"), testData.getTestData("address1"), testData.getTestData("address2"), testData.getTestData("country"), testData.getTestData("state"), testData.getTestData("city"), testData.getTestData("zipCode"), testData.getTestData("mobileNumber"))
                        .clickCreateAccount();
        new ConfitmationAccountPage(driver).assertAccountCreated()
                                .clickContinueButton();
        //? is it right to recreate the Navbar and ConfitmationAccountPage again
        new Navbar(driver).assertUserLoggedName("MohamedAbdelrehem")
                .deleteAccount();
        new ConfitmationAccountPage(driver).clickContinueButton();
    }
}
