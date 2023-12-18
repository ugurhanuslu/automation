package com.ugurhan.beymen.test;
import com.ugurhan.beymen.manager.DriverFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import java.net.MalformedURLException;


public class BaseTest extends DriverFactory {
    private static final Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeAll
    public static void before() throws MalformedURLException {
        PropertyConfigurator.configure("log4j.properties");
        setDriver("chrome");
        logger.info("Browser has been started");
    }

    @AfterAll()
    public static void after() {
        if (driver != null) {
            driver.quit();
            logger.info("Driver has been closed");
        }
    }
}