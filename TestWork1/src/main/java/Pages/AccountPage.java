package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends GeneralPage{

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]")
    private WebElement menuLocator;
    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]/ul/li[1]/a")
    private WebElement itemLocator;
    @FindBy(xpath = "//nav//a[@class='logout']")
    private WebElement logoutButtonLocator;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ItemPage chooseItem() {
        moveToMenu();
        return goToItem();
    }

    public LoginPage LogoutSubmit() {
        logoutButtonLocator.click();
        System.out.println("Successful logout");
        return new LoginPage(driver);
    }





    private AccountPage moveToMenu() {
        Actions action = new Actions(driver);
        action.moveToElement(menuLocator).perform();
        return this;
    }

    private ItemPage goToItem() {
        itemLocator.click();
        return new ItemPage(driver);
    }
}
