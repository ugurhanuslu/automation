package com.ugurhan.beymen.manager;
import com.ugurhan.beymen.config.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.time.Duration;


public class DriverFactory {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    static ConfigFileReader configFileReader = new ConfigFileReader();
    public final Logger logger = LogManager.getLogger(this.getClass());

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(String testBrowser) throws MalformedURLException {
        switch (testBrowser) {

            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-notifications");
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                break;
            }
            default: {
                WebDriverManager.chromedriver().driverVersion("120").setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
        }
        driver.manage().deleteAllCookies();
        driver.navigate().to(configFileReader.getBaseUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicityWait()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configFileReader.getPageLoadTimeout()));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configFileReader.getWebDriverWait()));
    }
}
