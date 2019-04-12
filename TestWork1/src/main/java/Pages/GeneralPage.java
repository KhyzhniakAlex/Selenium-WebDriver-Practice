package Pages;

import org.openqa.selenium.WebDriver;

public abstract class GeneralPage {

    public static WebDriver driver;

    public GeneralPage(WebDriver driver) {
        GeneralPage.driver = driver;
    }
}
