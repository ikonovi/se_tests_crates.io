package ik.se.crates.pages.element;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.logging.Logger;

public class PageElement {

    // WebDriver
    @Inject public static Logger logger;
    @Inject @Named("waitTimeOutInSeconds") public static String waitTimeOutInSeconds;

    // *** Navigation Bar
    // Links when window is large enough.
    @Inject @Named("navigationBrowseAllCratesLink_xpath") public static String navigationBrowseAllCratesLink_xpath;
    @Inject @Named("navigationDocsLink_xpath") public static String navigationDocsLink_xpath;
    @Inject @Named("navigationLoginLink_xpath") public static String navigationLoginLink_xpath;
    // Links when window is small and displays drop-down menu instead.
    @Inject @Named("navigationMenuLink_xpath") public static String navigationMenuLink_xpath;
    @Inject @Named("navigationMenuBrowseAllCratesLink_xpath") public static String navigationMenuBrowseAllCratesLink_xpath;
    @Inject @Named("navigationMenuDocsLink_xpath") public static String navigationMenuDocsLink_xpath;
    @Inject @Named("navigationMenuLoginLink_xpath") public static String navigationMenuLoginLink_xpath;
    // Search box
    @Inject @Named("navigationSearchField_xpath") public static String navigationSearchField_xpath;

    // *** Home page
    @Inject @Named("HomePageUrl") public static String homePageUrl;
    @Inject @Named("HomePageTitle") public static String homePageTitle;

    // *** Search Result Page
    @Inject @Named("SearchResultPageUrl") public static String searchResultPageUrl;
    @Inject @Named("SearchResultPageTitle") public static String searchResultPageTitle;
    @Inject @Named("SearchResultExactMatchHeader_xpath") public static String searchResultExactMatchHeader_xpath;
    @Inject @Named("SearchResultSortByDropdownButton_xpath") public static String searchResultSortByDropdownButton_xpath;
    @Inject @Named("SearchResultSortByDropdownRelevanceItem_xpath") public static String searchResultSortByDropdownRelevanceItem_xpath;

    // *** Crate Page
    @Inject @Named("CratePageTitle") public static String cratePageTitle;
    @Inject @Named("CratePageDocumentationLink_xpath") public static String cratePageDocumentationLink_xpath;
    @Inject @Named("CratePageRepositoryLink_xpath") public static String cratePageRepositoryLink_xpath;
    @Inject @Named("CratePageDependentCratesLink_xpath") public static String cratePageDependentCratesLink_xpath;
    @Inject @Named("CratePageLastUpdatedText_xpath") public static String cratePageLastUpdatedText_xpath;
    @Inject @Named("CratePageCrateSizeText_xpath") public static String cratePageCrateSizeText_xpath;
    @Inject @Named("CratePageAuthorsText_xpath") public static String CratePageAuthorsText_xpath;


    //@Inject @Named("") public static String;
}