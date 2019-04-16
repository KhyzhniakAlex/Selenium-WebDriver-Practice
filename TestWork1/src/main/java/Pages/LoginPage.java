package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends GeneralPage {

    @FindBy(xpath = "//form[@id='login_form']//input[@id='email']")
    private WebElement usernameLocator;
    @FindBy(xpath = "//form[@id='login_form']//input[@id='passwd']")
    private WebElement passwordLocator;
    @FindBy(xpath = "//form[@id='login_form']//button[@id='SubmitLogin']")
    private WebElement loginButtonLocator;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountPage doLogin(String username, String password) {
        typeUsername(username);
        typePassword(password);
        System.out.println("Successful login");
        return submitLogin();
    }




    private LoginPage typeUsername(String username) {
        usernameLocator.sendKeys(username);
        return this;
    }

    private LoginPage typePassword(String password) {
        passwordLocator.sendKeys(password);
        return this;
    }

    private AccountPage submitLogin() {
        loginButtonLocator.click();
        return new AccountPage(driver);
    }
}
