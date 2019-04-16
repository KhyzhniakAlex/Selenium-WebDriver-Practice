package TestCases;

import Pages.AccountPage;
import Pages.GeneralPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OpenItemTest {

    private static WebDriver driver;

    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        GeneralPage.driver = driver;
    }

    @Test
    public void moveToChosenCategoryAndOpenItsPage() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com");

        new HomePage(driver).goToLogin();

        new LoginPage(driver).doLogin("khyzhniak@i.ua", "khyzhniak");
        Thread.sleep(3000);

        new AccountPage(driver).chooseItem();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(), "Casual Dresses - My Store");
    }

    @AfterClass
    public static void after() {
        driver.close();
    }
}
