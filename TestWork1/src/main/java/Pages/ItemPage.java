package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends GeneralPage{

    private By itemBlockLocator = By.xpath("//div[@id='center_column']/ul/li/div");
    private By addToCartButtonLocator = By.xpath("//div[@id='center_column']/ul/li//a[@title='Add to cart']");
    private By goToCartButtonLocator = By.xpath("//div[@id='layer_cart']//a[@title='Proceed to checkout']");

    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private ItemPage moveToItemBlock() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(itemBlockLocator)).perform();
        return this;
    }

    private CartPage addToCartAndGoToCast() {
        driver.findElement(addToCartButtonLocator).click();
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(goToCartButtonLocator)));
        driver.findElement(goToCartButtonLocator).click();
        return new CartPage(driver);
    }

    public CartPage addItemToCart() {
        moveToItemBlock();
        return addToCartAndGoToCast();
    }
}
