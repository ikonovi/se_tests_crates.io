package ik.se.crates.pages;

import ik.se.crates.pages.element.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

import static ik.se.crates.pages.element.PageElement.*;

public class CratePage implements WebPageWait {

    private final By cratePageDocumentationLinkBy = By.xpath(cratePageDocumentationLink_xpath);
    private final By cratePageRepositoryLinkBy = By.xpath(cratePageRepositoryLink_xpath);
    private final By cratePageDependentCratesLinkBy = By.xpath(cratePageDependentCratesLink_xpath);
    private final By cratePageLastUpdatedTextBy = By.xpath(cratePageLastUpdatedText_xpath);
    private final By cratePageCrateSizeTextBy = By.xpath(cratePageCrateSizeText_xpath);
    private final By cratePageAuthorsTextBy = By.xpath(CratePageAuthorsText_xpath);

    private NavigationBar navigationBar;
    private final Logger logger = PageElement.logger;
    private final WebDriver driver;

    public CratePage(WebDriver driver) {
        this.driver = driver;
        this.navigationBar = new NavigationBar(driver);
        logger.info("URL is " + driver.getCurrentUrl());
        waitTitleContains(driver, cratePageTitle);
    }

    public String getLastUpdatedValue() {
        WebElement element = getToBeClickable(driver, cratePageLastUpdatedTextBy);
        return element.getText();
    }

    public String getCrateSizeValue() {
        WebElement element = getToBeClickable(driver, cratePageCrateSizeTextBy);
        return element.getText();
    }

    public String getAuthorsValue() {
        WebElement element = getToBeClickable(driver, cratePageAuthorsTextBy);
        return element.getText();
    }

    public String getDependentCratesLinkText() {
        WebElement element = getToBeClickable(driver, cratePageDependentCratesLinkBy);
        return element.getText();
    }

    public String getRepositoryLinkText() {
        WebElement element = getToBeClickable(driver, cratePageRepositoryLinkBy);
        return element.getText();
    }

    public String getDocumentationLinkText() {
        WebElement element = getToBeClickable(driver, cratePageDocumentationLinkBy);
        return element.getText();
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }
}
