package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends GeneralPage{

    private By menuLocator = By.xpath("//div[@id='block_top_menu']/ul/li[2]");
    private By itemLocator = By.xpath("//div[@id='block_top_menu']/ul/li[2]/ul/li[1]/a");
    private By logoutButtonLocator = By.xpath("//nav//a[@class='logout']");

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private AccountPage moveToMenu() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(menuLocator)).perform();
        return this;
    }

    private ItemPage goToItem() {
        driver.findElement(itemLocator).click();
        return new ItemPage(driver);
    }



    public ItemPage chooseItem() {
        moveToMenu();
        return goToItem();
    }



    public LoginPage LogoutSubmit() {
        driver.findElement(logoutButtonLocator).click();
        System.out.println("Successful logout");
        return new LoginPage(driver);
    }
}
