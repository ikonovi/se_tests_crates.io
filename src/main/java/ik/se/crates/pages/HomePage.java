package ik.se.crates.pages;

import ik.se.crates.pages.element.PageElement;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

import static ik.se.crates.pages.element.PageElement.homePageTitle;
import static ik.se.crates.pages.element.PageElement.homePageUrl;

public class HomePage implements WebPageWait {

    private NavigationBar navigationBar;

    private final Logger logger = PageElement.logger;
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.navigationBar = new NavigationBar(driver);
        this.driver.get(homePageUrl);
        logger.info("Navigate to URL=" + homePageUrl);
        logger.info("Check page title = " + homePageTitle);
        waitTitleContains(driver, homePageTitle);
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }
}
