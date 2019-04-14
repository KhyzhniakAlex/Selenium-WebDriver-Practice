package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends GeneralPage {

    private By loginButtonLocator = By.xpath("//nav//a[@class='login']");

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void LoginSubmit() {
        driver.findElement(loginButtonLocator).click();
    }

    /*public LoginPage goToLogin() {
        if (driver.findElement(loginButtonLocator).isDisplayed()) {
            return LoginSubmit();
        } else {
            LogoutSubmit();
            return LoginSubmit();
        }
    }*/
}
