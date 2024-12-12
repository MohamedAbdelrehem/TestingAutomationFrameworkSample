package automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static utilities.ElemantActions.clickElement;

public class SignupFormPage {
    private WebDriver driver;

    public SignupFormPage(WebDriver driver) {
        this.driver = driver;
    }

    //Signup locators
    private final By signUpEnterAccountInfoTitle = By.xpath("(//b)[1]");
    // Locators
    private final By titleMrRadioButton = By.id("id_gender1");
    private final By passwordField = By.id("password");
    private final By daysDropdown = By.id("days");
    private final By monthsDropdown = By.id("months");
    private final By yearsDropdown = By.id("years");
    private final By newsletterCheckBox = By.id("newsletter");
    private final By specialOffersCheckBox = By.id("optin");
    private final By firstNameField = By.id("first_name");
    private final By lastNameField = By.id("last_name");
    private final By companyField = By.id("company");
    private final By address1Field = By.id("address1");
    private final By address2Field = By.id("address2");
    private final By countryDropdown = By.id("country");
    private final By stateField = By.id("state");
    private final By cityField = By.id("city");
    private final By zipCodeField = By.id("zipcode");
    private final By mobileNumberField = By.id("mobile_number");
    private final By createAccountButton = By.cssSelector("[data-qa='create-account']");

    //* SignUp page
    @Step("Verify that 'ENTER ACCOUNT INFORMATION' is visible")
    public SignupFormPage assertSignUpPage() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup", "Verify Signup page title");

        Assert.assertEquals(driver.findElement(signUpEnterAccountInfoTitle).getText(), "ENTER ACCOUNT INFORMATION", "\"Enter Account Information\" title is displayed");
        return this;
    }

    public void selectTitleMr() {
        driver.findElement(titleMrRadioButton).click();
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        new Select(driver.findElement(daysDropdown)).selectByVisibleText(day);
        new Select(driver.findElement(monthsDropdown)).selectByVisibleText(month);
        new Select(driver.findElement(yearsDropdown)).selectByVisibleText(year);
    }
    @Step("Select checkbox 'Sign up for our newsletter!'")
    public void selectNewsletter() {
        driver.findElement(newsletterCheckBox).click();
    }

    @Step("Select checkbox 'Receive special offers from our partners!'")
    public void selectSpecialOffers() {
        driver.findElement(specialOffersCheckBox).click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterCompany(String company) {
        driver.findElement(companyField).sendKeys(company);
    }

    public void enterAddress1(String address1) {
        driver.findElement(address1Field).sendKeys(address1);
    }

    public void enterAddress2(String address2) {
        driver.findElement(address2Field).sendKeys(address2);
    }

    public void selectCountry(String country) {
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
    }

    public void enterState(String state) {
        driver.findElement(stateField).sendKeys(state);
    }

    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void enterZipCode(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void enterMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }
    @Step("Click 'Create Account button'")
    public void clickCreateAccount() {
        clickElement(driver, createAccountButton);
    }
    @Step("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public SignupFormPage fillRegisterForm(String firstName, String lastName, String password, String day, String month, String year, String company, String address1, String address2, String country, String state, String city, String zipCode, String mobileNumber) {
        selectTitleMr();
        enterPassword(password);
        selectDateOfBirth(day, month, year);
        selectNewsletter();
        selectSpecialOffers();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterCompany(company);
        enterAddress1(address1);
        enterAddress2(address2);
        selectCountry(country);
        enterState(state);
        enterCity(city);
        enterZipCode(zipCode);
        enterMobileNumber(mobileNumber);
        return this;
    }
}
