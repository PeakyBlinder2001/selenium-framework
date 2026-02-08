package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class GoogleHomePage {

    private WebDriver driver;
    private WaitUtils wait;

    // Locators
    private By searchBox = By.name("q");

    // Constructor
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }



    public boolean isPageLoaded() {
        return wait.waitForTitleContains("Google");
    }

    public void searchFor(String text) {
        wait.waitForElementVisible(searchBox).sendKeys(text);
    }
}
