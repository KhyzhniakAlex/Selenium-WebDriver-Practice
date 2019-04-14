package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends GeneralPage {

    private By itemNameLocator = By.xpath("//table[@id='cart_summary']/tbody//p[@class='product-name']/a");

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void checkItemName() {
        Assert.assertEquals(driver.findElement(itemNameLocator).getText(), "Printed Dress");
    }
}
