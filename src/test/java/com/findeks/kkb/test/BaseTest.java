package com.findeks.kkb.test;

import com.findeks.kkb.manager.DriverFactory;
import org.testng.annotations.*;

import java.net.MalformedURLException;


public class BaseTest extends DriverFactory {

    @Parameters("browser")
    @BeforeMethod(groups = {"hook"})
    public void before(@Optional("browser") String browser) throws MalformedURLException {
        setDriver(browser);
    }

    @AfterMethod(groups = {"hook"})
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}