package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import tests.base.BaseTest;

public class SmokeTest extends BaseTest {

    @Test
    public void googleSearchTest() {

        GoogleHomePage google = new GoogleHomePage(getDriver());

        Assert.assertTrue(
                google.isPageLoaded(),
                "Google home page did not load"
        );

        google.searchFor("Selenium Automation Framework");
    }
}
