package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GeneralPage {

    private By loginButtonLocator = By.xpath("//nav//a[@class='login']");

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage LoginSubmit() {
        driver.findElement(loginButtonLocator).click();
        return new LoginPage(driver);
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
