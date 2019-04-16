package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GeneralPage {

    @FindBy(xpath = "//nav//a[@class='login']")
    private WebElement loginButtonLocator;
    @FindBy(xpath = "//nav//a[@class='logout']")
    private WebElement logoutButtonLocator;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private LoginPage LoginSubmit() {
        loginButtonLocator.click();
        return new LoginPage(driver);
    }

    private HomePage LogoutSubmit() {
        logoutButtonLocator.click();
        System.out.println("Successful logout");
        return new HomePage(driver);
    }

    public void goToLogin() {
        try {
            if (loginButtonLocator.isEnabled())
                LogoutSubmit();
        } catch(NoSuchElementException e) {
            System.out.println("You are not signed in");
        } finally {
            LoginSubmit();
        }
    }
}
