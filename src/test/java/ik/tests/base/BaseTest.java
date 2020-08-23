package ik.tests.base;

import com.google.inject.Inject;
import ik.config.PageElementModule;
import ik.config.TestModelModule;
import ik.config.WebDriverModule;
import ik.se.browser.Chrome;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.logging.Logger;

@Guice(modules = {WebDriverModule.class, PageElementModule.class, TestModelModule.class})
public class BaseTest {

    @Inject @Chrome
    protected WebDriver driver;

    @Inject
    protected Logger logger;

    @BeforeSuite
    public void baseSuiteSetup(ITestContext ctx) {
        logger.info("Test Suite started.");
    }

    @AfterSuite(alwaysRun = true, enabled = true)
    public void baseSuiteTearDown() {
        driver.quit();
        logger.info("Test Suite finished.");
    }
}