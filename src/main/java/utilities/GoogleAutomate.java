//package HeadwayPack;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//
//import java.time.Duration;
//
//// Main class for automating the test case
//public class GoogleAutomate {
//    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        //our own class that take the driver as argument and then make taking screenshot just one line
//        ScreenshotHeadway screenshot = new ScreenshotHeadway(driver);
//
//
//        //setting up the browser
//        driver.manage().window().maximize();
//
//        //?-----------------------------------Home Page-----------------------------------?//
//        //opening the website
//        driver.navigate().to("https://automationexercise.com/");
//
//        //* take screenshot 📷 and add date to it
//        screenshot.captureScreenshot("HomePageVerify.png");
//
//        // Find and interact with the Signup/Login button
//        WebElement signupLoginButton = driver.findElement(By.linkText("Signup / Login"));
//        System.out.println("Home page visibility is: " + signupLoginButton.isDisplayed());
//        signupLoginButton.click();
//
//        //?-----------------------------------Login Page-----------------------------------?//
//
//        // Verify that the signup form part is loaded
//        WebElement signupForm = driver.findElement(By.className("signup-form"));
//        System.out.println("Signup form visibility is: " + signupForm.isDisplayed());
//
//        // "New User Signup!" is loaded
//        WebElement newUserSignupText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
//        System.out.println("The text \"New User Signup!\" visibility is: " + newUserSignupText.isDisplayed());
//
//        //* take screenshot 📷 and add date to it
//        screenshot.captureScreenshot("LoginPageVerify.png");
//
//
//        WebElement nameTextField = driver.findElement(By.cssSelector("[data-qa='signup-name']"));
//        WebElement emailTextField = driver.findElement(By.cssSelector("[data-qa='signup-email']"));
//
//        nameTextField.sendKeys("MohamedAbdelrehem");
//        //TODO: add temp mail API
//        emailTextField.sendKeys("mohamedabdelrehem32@gmail.com");
//
//        WebElement signupButton = driver.findElement(By.cssSelector("[data-qa='signup-button']"));
//        signupButton.click();
//
//        //?-----------------------------------Signup Page-----------------------------------?//
//        WebElement enterAccountInfoTitle = driver.findElement(By.xpath("(//b)[1]"));
//        System.out.println("Enter account info title visibility is: " + enterAccountInfoTitle.isDisplayed());
//
//        //* take screenshot 📷 and add date to it
//        screenshot.captureScreenshot("SignupPageVerify.png");
//
//
//        WebElement titleMr = driver.findElement(By.id("id_gender1"));
//        titleMr.click();
//
//        WebElement passwordTextField = driver.findElement(By.id("password"));
//        passwordTextField.sendKeys("Mohamed2001@");
//
//
//        Select daysDropdown = new Select(driver.findElement(By.id("days")));
//        Select monthsDropdown = new Select(driver.findElement(By.id("months")));
//        Select yearsDropdown = new Select(driver.findElement(By.id("years")));
//
//        daysDropdown.selectByVisibleText("11");
//        monthsDropdown.selectByVisibleText("May");
//        yearsDropdown.selectByVisibleText("2001");
//
//
//        WebElement newsletterCheckBox = driver.findElement(By.id("newsletter"));
//        newsletterCheckBox.click();
//
//        WebElement specialOffersCheckBox = driver.findElement(By.id("optin"));
//        specialOffersCheckBox.click();
//
//        //ADDRESS INFORMATION
//        WebElement firstNameTextField = driver.findElement(By.id("first_name"));
//        firstNameTextField.sendKeys("Mohamed");
//        WebElement lastNameTextField = driver.findElement(By.id("last_name"));
//        lastNameTextField.sendKeys("Abdelrehem");
//        WebElement companyTextField = driver.findElement(By.id("company"));
//        companyTextField.sendKeys("Giza");
//        WebElement address1TextField = driver.findElement(By.id("address1"));
//        address1TextField.sendKeys("25 Studio Al-Ahram");
//        WebElement address2TextField = driver.findElement(By.id("address2"));
//        address2TextField.sendKeys("Omrania Sharkia, Giza");
//        Select countryDropdown = new Select(driver.findElement(By.id("country")));
//        countryDropdown.selectByVisibleText("United States");
//        WebElement stateTextField = driver.findElement(By.id("state"));
//        stateTextField.sendKeys("Giza");
//        WebElement cityTextField = driver.findElement(By.id("city"));
//        cityTextField.sendKeys("Giza");
//        WebElement zipCodeTextField = driver.findElement(By.id("zipcode"));
//        zipCodeTextField.sendKeys("11245");
//        WebElement mobileNumberTextField = driver.findElement(By.id("mobile_number"));
//        mobileNumberTextField.sendKeys("01011929211");
//
//        WebElement createAccountButton = driver.findElement(By.cssSelector("[data-qa='create-account']"));
//        createAccountButton.click();
//
//        //?-----------------------------------Account Created Page-----------------------------------?//
//        WebElement accountCreatedTitle = driver.findElement(By.xpath("(//b)[1]"));
//        System.out.println("\"Account Created!\" title visibility is: " + accountCreatedTitle.isDisplayed());
//
//        //* take screenshot 📷 and add date to it
//        screenshot.captureScreenshot("AccounCreatedVerify.png");
//
//
//        WebElement continueButton = driver.findElement(By.cssSelector("[data-qa='continue-button']"));
//        continueButton.click();
//
//        //?-----------------------------------Home page check Page-----------------------------------?//
//        //? selecting using 2
//        WebElement loggedInAsName = driver.findElement(By.xpath("//a[b]"));
//        //!error to stop are there alternative
//        continueButton.click();
//
//        System.out.println("name is " + loggedInAsName.getText());
//
//
//        //! delete account
//        WebElement deleteAccountLink = driver.findElement(By.linkText("Delete Account"));
//        deleteAccountLink.click();
//
//
//        //* take screenshot 📷 and add date to it
//        screenshot.captureScreenshot("homepageloggedinVerify.png");
//
//        //?-----------------------------------Home page check Page-----------------------------------?//
//        screenshot.captureScreenshot("accountDeletedVerify.png");
//        WebElement continueButtonDel = driver.findElement(By.cssSelector("[data-qa='continue-button']"));
//        continueButtonDel.click();
//
//
//        driver.quit();
//    }
//}
