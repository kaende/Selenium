package SeleniumDomaci.DBpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoryPage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public List<WebElement> categories;
    public List<WebElement> items;
    public WebElement cartBtn;

    public CategoryPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public List<WebElement> getCategories() {
        return driver.findElements(By.id("itemc"));
    }

    public List<WebElement> getItems() {
        return driver.findElements(By.cssSelector(".col-lg-4.col-md-6.mb-4"));
    }

    public WebElement getCartBtn() {
        return driver.findElement(By.cssSelector(".btn.btn-success.btn-lg"));
    }

//--------------------------------------------------

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (WebElement we : getItems()) {
            sb.append("Naziv: ");
            sb.append(we.findElement(By.className("hrefch")).getText());
            sb.append("\n");
            sb.append("Opis: ");
            sb.append(we.findElement(By.id("article")).getText());
            sb.append("\n");
            sb.append("Cena: ");
            sb.append(we.findElement(By.tagName("h5")).getText());
            sb.append("\n");
        }
        return sb.toString();
    }

    public int totalPrice() {
        int sum = 0;
        for (WebElement item : getItems()) {
            sum += Integer.parseInt(item.findElement(By.tagName("h5")).getText().substring(1));
        }
        return sum;
    }

    public int totalItems() {
        return getItems().size();
    }

    public void clickCategory(int a){
        getCategories().get(a).click();
    }

    public void selectItem(int a){
        getItems().get(a).click();
    }

    public void addItem(){
        getCartBtn().click();
    }
}

