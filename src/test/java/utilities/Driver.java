package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    // private Constructor
    private Driver() {
    }


// method to give instance

    public static WebDriver getDriver(){
        if (driver == null) {
            switch (Config.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();

                    // Additional Chrome Options (optional):
//                    ChromeOptions options = new ChromeOptions();
//                    options.addArguments("--disable-popup-blocking");
//                    options.addArguments("test-type");
//                    options.addArguments("allow-running-insecure-content");
//                    options.addArguments("disable-extensions");
//                    options.addArguments("--ignore-certificate-errors");
//                    options.addArguments("test-type=browser");
//                    options.addArguments("disable-infobars");

                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
