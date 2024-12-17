package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverFactory {
    static WebDriver driver;

    @Step("Initializing new driver (Browser Type: {browserName} ")
    public static WebDriver initDriver(String browserName, String maximize, String headless) {
        switch (browserName.toLowerCase()){
            case "firefox":
                System.out.println("initializing Firefox Browser");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if(Boolean.parseBoolean(headless)){
                    firefoxOptions.addArguments("--headless=new");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                System.out.println("initializing Edge Browser");
                EdgeOptions edgeOptions = new EdgeOptions();
                if(Boolean.parseBoolean(headless)){
                    edgeOptions.addArguments("--headless=new");
                }
                driver = new EdgeDriver(edgeOptions);
                break;
            case "true":
            default:
                System.out.println("initializing Chrome Browser");
                ChromeOptions chromeOptions = new ChromeOptions();
                if(Boolean.parseBoolean(headless)){
                    chromeOptions.addArguments("--headless=new");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
        }
        System.out.println("on OS : " + System.getProperty("os.name") + "and the version is " + System.getProperty("os.version"));
        if (Boolean.parseBoolean(maximize)) {
            driver.manage().window().maximize();
            System.out.println("window is maximized , and the window size is " + driver.manage().window().getSize());
        }
        return driver;
    }
//    //Method Overloading
//    public static WebDriver initDriver(String browserName) {
//        return initDriver(browserName,false,false);
//    }
//    public static WebDriver initDriver() {
//        return initDriver("chrome",false,false);
//    }
}

