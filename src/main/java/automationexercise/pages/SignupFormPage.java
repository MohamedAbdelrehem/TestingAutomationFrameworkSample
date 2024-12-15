package automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static utilities.ElemantActions.clickElement;
import static utilities.ElemantActions.sendKeys;

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
        clickElement(driver, titleMrRadioButton);
    }


    public void enterPassword(String password) {
        sendKeys(driver, passwordField, password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        new Select(driver.findElement(daysDropdown)).selectByVisibleText(day);
        new Select(driver.findElement(monthsDropdown)).selectByVisibleText(month);
        new Select(driver.findElement(yearsDropdown)).selectByVisibleText(year);
    }
    @Step("Select checkbox 'Sign up for our newsletter!'")
    public void selectNewsletter() {
        clickElement(driver, newsletterCheckBox);
    }

    @Step("Select checkbox 'Receive special offers from our partners!'")
    public void selectSpecialOffers() {
        clickElement(driver, specialOffersCheckBox);
    }

    public void enterFirstName(String firstName) {
        sendKeys(driver, firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        sendKeys(driver, lastNameField, lastName);
    }

    public void enterCompany(String company) {
        sendKeys(driver, companyField, company);
    }

    public void enterAddress1(String address1) {
        sendKeys(driver, address1Field, address1);
    }

    public void enterAddress2(String address2) {
        sendKeys(driver, address2Field, address2);
    }

    public void selectCountry(String country) {
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
    }

    public void enterState(String state) {
        sendKeys(driver, stateField, state);
    }

    public void enterCity(String city) {
        sendKeys(driver, cityField, city);
    }

    public void enterZipCode(String zipCode) {
        sendKeys(driver, zipCodeField, zipCode);
    }

    public void enterMobileNumber(String mobileNumber) {
        sendKeys(driver, mobileNumberField, mobileNumber);
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
