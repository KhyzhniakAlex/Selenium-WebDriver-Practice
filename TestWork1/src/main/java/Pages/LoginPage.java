package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends GeneralPage {

    private By usernameLocator = By.xpath("//form[@id='login_form']//input[@id='email']");
    private By passwordLocator = By.xpath("//form[@id='login_form']//input[@id='passwd']");
    private By loginButtonLocator = By.xpath("//form[@id='login_form']//button[@id='SubmitLogin']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private LoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    private LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    private AccountPage submitLogin() {
        driver.findElement(loginButtonLocator).click();
        return new AccountPage(driver);
    }

    public AccountPage doLogin(String username, String password) {
        typeUsername(username);
        typePassword(password);
        System.out.println("Successful login");
        //submitLogin();
        return submitLogin();
    }
}
