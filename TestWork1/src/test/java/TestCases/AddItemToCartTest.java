package TestCases;

import Pages.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AddItemToCartTest {

    private static WebDriver driver;

    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        GeneralPage.driver = driver;
    }

    @Test
    public void AddToCartAndCheckCart() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com");

        new HomePage(driver).LoginSubmit();

        new LoginPage(driver).doLogin("khyzhniak@i.ua", "khyzhniak");

        new AccountPage(driver).chooseItem();
        Assert.assertEquals(driver.getTitle(), "Casual Dresses - My Store");

        new ItemPage(driver).addItemToCart();

        new CartPage(driver).checkItemName();
        Thread.sleep(3000);
    }

    @AfterClass
    public static void after() {
        driver.close();
    }
}
