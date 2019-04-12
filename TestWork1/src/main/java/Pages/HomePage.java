package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends GeneralPage {

    private By loginButtonLocator = By.xpath("//nav//a[@class='login']");
    private By logoutButtonLocator = By.xpath("//nav//a[@class='logout']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void LoginSubmit() {
        driver.findElement(loginButtonLocator).click();
    }

    public void LogoutSubmit() {
        driver.findElement(logoutButtonLocator).click();
        System.out.println("Successful logout");
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
