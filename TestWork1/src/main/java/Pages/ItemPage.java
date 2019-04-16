package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends GeneralPage{

    @FindBy(xpath = "//div[@id='center_column']/ul/li/div")
    private WebElement itemBlockLocator;
    @FindBy(xpath = "//div[@id='center_column']/ul/li//a[@title='Add to cart']")
    private WebElement addToCartButtonLocator;
    @FindBy(xpath = "//div[@id='layer_cart']//a[@title='Proceed to checkout']")
    private WebElement goToCartButtonLocator;

    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CartPage addItemToCart() {
        moveToItemBlock();
        return addToCartAndGoToCast();
    }




    private ItemPage moveToItemBlock() {
        Actions action = new Actions(driver);
        action.moveToElement(itemBlockLocator).perform();
        return this;
    }

    private CartPage addToCartAndGoToCast() {
        addToCartButtonLocator.click();
        WebDriverWait waiter = new WebDriverWait(driver, 10);
        waiter.until(ExpectedConditions.visibilityOf(goToCartButtonLocator));
        goToCartButtonLocator.click();
        return new CartPage(driver);
    }
}
