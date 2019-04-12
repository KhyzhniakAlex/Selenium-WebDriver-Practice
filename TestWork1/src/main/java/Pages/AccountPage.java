package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends GeneralPage{

    private WebDriverWait waiter;

    private By menuLocator = By.xpath("//div[@id='block_top_menu']/ul/li[2]");
    private By itemLocator = By.xpath("//div[@id='block_top_menu']/ul/li[2]/ul/li[1]/a");

    public AccountPage(WebDriver driver) {
        super(driver);
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
}
