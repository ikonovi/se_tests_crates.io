package ik.se.crates.pages;

import ik.se.crates.pages.element.PageElement;
import org.openqa.selenium.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import static ik.se.crates.pages.element.PageElement.*;

public class NavigationBar implements WebPageWait {

    private final By navigationBrowseAllCratesLinkBy = By.xpath(navigationBrowseAllCratesLink_xpath);
    private final By navigationDocsLinkBy = By.xpath(navigationDocsLink_xpath);
    private final By navigationLoginLinkBy = By.xpath(navigationLoginLink_xpath);

    private final By navigationMenuLinkBy = By.xpath(navigationMenuLink_xpath);
    private final By navigationMenuBrowseAllCratesLinkBy = By.xpath(navigationMenuBrowseAllCratesLink_xpath);
    private final By navigationMenuDocsLinkBy = By.xpath(navigationMenuDocsLink_xpath);
    private final By navigationMenuLoginLinkBy = By.xpath(navigationMenuLoginLink_xpath);

    private final By navigationSearchFieldBy = By.xpath(navigationSearchField_xpath);

    private final Logger logger = PageElement.logger;
    private final WebDriver driver;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultPage doSearch(String phrase) {
        WebElement searchBox = getToBeClickable(driver, navigationSearchFieldBy);
        searchBox.click();
        searchBox.sendKeys(phrase + Keys.ENTER);
        return new SearchResultPage(driver);
    }

    /**
     * @return text of element
     * @implNote if window is rather small, then you have to expand Menu drop-down list to get menu item text.
     */
    public String getBrowseAllCratesItemText() {
        String text;
        try {
            text = getToBeClickable(driver, navigationBrowseAllCratesLinkBy).getText();
        } catch (TimeoutException ex) {
            logger.log(Level.WARNING, "No link \"Browse All Crates\"."
                    + "\n Perhaps the window is too small. Trying to click Menu button to show items.");
            WebElement menu = getToBeClickable(driver, navigationMenuLinkBy);
            menu.click();
            text = getToBeClickable(driver, navigationMenuBrowseAllCratesLinkBy).getText();
            logger.log(Level.INFO, "Fixed: Linked is located.");
        }
        return text;
    }

    /**
     * @return text of element
     * @implNote if window is rather small, then you have to expand Menu drop-down list to get menu item text.
     */
    public String getDocsItemText() {
        String text;
        try {
            text = getToBeClickable(driver, navigationDocsLinkBy).getText();
        } catch (TimeoutException ex) {
            logger.log(Level.WARNING, "No link \"Browse All Crates\"."
                    + "\n Perhaps the window is too small. Trying to click Menu button to show items.");
            WebElement menu = getToBeClickable(driver, navigationMenuLinkBy);
            menu.click();
            text = getToBeClickable(driver, navigationMenuDocsLinkBy).getText();
            logger.log(Level.INFO, "Fixed: Linked is located.");
        }
        return text;
    }

    /**
     * @return text of element
     * @implNote if window is rather small, then you have to expand Menu drop-down list to get menu item text.
     */
    public String getLoginItemText() {
        String text;
        try {
            text = getToBeClickable(driver, navigationLoginLinkBy).getText();
        } catch (TimeoutException ex) {
            logger.log(Level.WARNING, "No link \"Browse All Crates\"."
                    + "\n Perhaps the window is too small. Trying to click Menu button to show items.");
            WebElement menu = getToBeClickable(driver, navigationMenuLinkBy);
            menu.click();
            text = getToBeClickable(driver, navigationMenuLoginLinkBy).getText();
            logger.log(Level.INFO, "Fixed: Linked is located.");
        }
        return text;
    }
}
