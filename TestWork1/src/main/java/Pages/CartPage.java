package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class CartPage extends GeneralPage {

    private By itemNameLocator = By.xpath("//table[@id='cart_summary']/tbody//p[@class='product-name']/a");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void checkItemName() {
        Assert.assertEquals(driver.findElement(itemNameLocator).getText(), "Printed Dress");
    }
}
