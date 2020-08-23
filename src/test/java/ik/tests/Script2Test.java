package ik.tests;

import ik.config.TestModels;
import ik.se.crates.pages.CratePage;
import ik.se.crates.pages.HomePage;
import ik.se.crates.pages.SearchResultPage;
import ik.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * <u>Сценарий 2:</u>
 * <pre>
 * 2.1 Открыть https://crates.io/
 * 2.2 Выполнить поиск по "derive_setters"
 * 2.3 Открыть информацию о пакете
 * 2.4 Проверить, что следующие поля представлены на странице
 * — Documentation
 * — Repository
 * — Dependent crates
 * 2.5 Проверить значения следующих элементов:
 * — Last Updated
 * — Crate Size
 * — Authors
 * </pre>
 */
public class Script2Test extends BaseTest {

    private CratePage cratePage;

    @BeforeClass
    public void doSearch() {
        HomePage homepage = new HomePage(driver);
        SearchResultPage searchResultPage = homepage.getNavigationBar().doSearch(TestModels.user.getSearchPhrase());
        searchResultPage.sortResultsByRelevance();
        cratePage = searchResultPage.clickExactMatch();
    }

    @Test
    public void testDocumentationLink() {
        Assert.assertEquals(cratePage.getDocumentationLinkText(), "Documentation");
    }

    @Test
    public void testRepositoryLink() {
        Assert.assertEquals(cratePage.getRepositoryLinkText(), "Repository");
    }

    @Test
    public void testDependentCratesLink() {
        Assert.assertEquals(cratePage.getDependentCratesLinkText(), "Dependent crates");
    }

    @Test
    public void testLastUpdatedProperty() {
        Assert.assertEquals(cratePage.getLastUpdatedValue(), "5 months ago");
    }

    @Test
    public void testCrateSizeProperty() {
        Assert.assertEquals(cratePage.getCrateSizeValue(), "6.52 kB");
    }

    @Test
    public void testAuthorsProperty() {
        Assert.assertEquals(cratePage.getAuthorsValue(), "Lymia Aluysia");
    }
}
