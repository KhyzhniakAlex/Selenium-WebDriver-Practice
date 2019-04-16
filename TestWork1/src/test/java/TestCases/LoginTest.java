package TestCases;

import Pages.AccountPage;
import Pages.GeneralPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static WebDriver driver;

    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        GeneralPage.driver = driver;
    }

    @Test
    public void Login() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com");

        new HomePage(driver).goToLogin();

        new LoginPage(driver).doLogin("khyzhniak@i.ua", "khyzhniak");
        Thread.sleep(1000);

        new AccountPage(driver).LogoutSubmit();
        Thread.sleep(4000);
    }

    @AfterClass
    public static void after() {
        driver.close();
    }
}
