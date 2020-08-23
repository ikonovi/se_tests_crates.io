package ik.se.crates.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ik.se.crates.pages.element.PageElement.homePageTitle;
import static ik.se.crates.pages.element.PageElement.waitTimeOutInSeconds;

interface WebPageWait {

    int timeout = Integer.parseInt(waitTimeOutInSeconds);

    default boolean waitTitleContains(WebDriver driver, String substring) {
        return new WebDriverWait(driver, timeout).until(
                ExpectedConditions.titleContains(substring));
    }

    default boolean waitUrlContains(WebDriver driver, String substring) {
        return new WebDriverWait(driver, timeout).until(
                ExpectedConditions.urlContains(substring));
    }

    default WebElement getToBeClickable(WebDriver driver, By by) {
        return new WebDriverWait(driver, timeout).until(
                ExpectedConditions.elementToBeClickable(by));
    }

    default WebElement getToBeVisible(WebDriver driver, By by) { // can be not enabled to click - disabled
        return new WebDriverWait(driver, timeout).until(
                ExpectedConditions.visibilityOfElementLocated(by));
    }

    default WebElement getToBePresent(WebDriver driver, By by) { // can be not visible, hence hot clickable
        return new WebDriverWait(driver, timeout).until(
                ExpectedConditions.presenceOfElementLocated(by));
    }
}
