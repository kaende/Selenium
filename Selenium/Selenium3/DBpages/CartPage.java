package SeleniumDomaci.DBpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public WebElement cart;
    public List<WebElement> inCart;

    public CartPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getCart() {
        return driver.findElement(By.id("cartur"));
    }

    public List<WebElement> getInCart() {
        return driver.findElements(By.className("success"));
    }

    //--------------------------------------

    public void alert(){
        driver.switchTo().alert().accept();
    }

    public void clickCart(){
        getCart().click();
    }
}
