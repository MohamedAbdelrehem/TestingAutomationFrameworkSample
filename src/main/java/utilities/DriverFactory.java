package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
    static WebDriver driver;

    @Step("Initializing new driver (Browser Type: {browserName} ")
    public static WebDriver initDriver(String browserName, boolean maximize) {

        switch (browserName.toLowerCase()){
            case "firefox":
                System.out.println("initializing Firefox Browser");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.out.println("initializing Edge Browser");
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                System.out.println(" Chrome Browser");
                driver = new ChromeDriver();
                break;
        }
        System.out.println("on OS : " + System.getProperty("os.name") + "and the version is " + System.getProperty("os.version"));
        if (maximize) {
            driver.manage().window().maximize();
            System.out.println("window is maximized , and the window size is " + driver.manage().window().getSize());
        }
        return driver;
    }
    //Method Overloading
    public static WebDriver initDriver(String browserName) {
        return initDriver(browserName,false);
    }
    public static WebDriver initDriver() {
        return initDriver("chrome",false);
    }
}

