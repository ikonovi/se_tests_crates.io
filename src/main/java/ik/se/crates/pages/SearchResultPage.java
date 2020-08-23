package ik.se.crates.pages;

import ik.se.crates.pages.element.PageElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

import static ik.se.crates.pages.element.PageElement.*;

public class SearchResultPage implements WebPageWait {

    private final By searchResultExactMatchHeaderBy = By.xpath(searchResultExactMatchHeader_xpath);
    private final By searchResultSortByDropdownButtonBy = By.xpath(searchResultSortByDropdownButton_xpath);
    private final By searchResultSortByDropdownRelevanceItemBy = By.xpath(searchResultSortByDropdownRelevanceItem_xpath);

    private NavigationBar navigationBar;

    private final Logger logger = PageElement.logger;
    private final WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        navigationBar = new NavigationBar(driver);
        logger.info("URL is " + driver.getCurrentUrl());
        waitTitleContains(driver, searchResultPageTitle);
    }

    public CratePage clickExactMatch() {
        WebElement exactMatchHeader = getToBeClickable(driver, searchResultExactMatchHeaderBy);
        exactMatchHeader.click();
        return new CratePage(driver);
    }

    public void sortResultsByRelevance() {
        WebElement sortByButton = getToBeClickable(driver, searchResultSortByDropdownButtonBy);
        sortByButton.click();
        WebElement sortRelevanceItem = getToBeClickable(driver, searchResultSortByDropdownRelevanceItemBy);
        sortRelevanceItem.click();
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }
}
