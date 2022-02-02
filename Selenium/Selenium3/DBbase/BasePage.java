package SeleniumDomaci.DBbase;

import SeleniumDomaci.DBpages.CartPage;
import SeleniumDomaci.DBpages.CategoryPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public CategoryPage categoryPage;
    public CartPage cartPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        categoryPage = new CategoryPage(driver, wdwait);
        cartPage = new CartPage(driver, wdwait);
    }

//    @AfterClass
//    public void tearDown(){
//        driver.manage().deleteAllCookies();
//        driver.close();
//        driver.quit();
//    }
}
