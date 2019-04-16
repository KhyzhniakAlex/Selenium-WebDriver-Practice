package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends GeneralPage {

    @FindBy(xpath = "//table[@id='cart_summary']/tbody//p[@class='product-name']/a")
    private WebElement itemNameLocator;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void checkItemName() {
        Assert.assertEquals(itemNameLocator.getText(), "Printed Dress");
    }
}
