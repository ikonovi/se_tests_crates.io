package ik.tests;

import ik.se.crates.pages.HomePage;
import ik.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * <u>Сценарий 1:</u>
 * <pre>
 * 1.1 Открыть https://crates.io/
 * 1.2 Проверить, что Navigation Bar содержит следующие элементы:
 * — Browse All Crates
 * — Docs
 * — Log in with GitHub
 * </pre>
 */
public class Script1Test extends BaseTest {

    private HomePage homepage;

    @BeforeClass
    public void beforeClass() {
        homepage = new HomePage(driver);
    }

    @BeforeTest
    public void setUpHomepage() {
        driver.navigate().refresh();
    }

    @Test
    public void testNavigationBarBrowseAllCratesItemPresent() {
        Assert.assertEquals(homepage.getNavigationBar().getBrowseAllCratesItemText(), "Browse All Crates");
    }

    @Test
    public void testNavigationBarDocsItemPresent() {
        Assert.assertEquals(homepage.getNavigationBar().getDocsItemText(), "Docs");
    }

    @Test
    public void testNavigationBarLoginItemPresent() {
        Assert.assertEquals(homepage.getNavigationBar().getLoginItemText(), "Log in with GitHub");
    }
}
