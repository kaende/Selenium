package SeleniumDomaci.DBtest;

import SeleniumDomaci.DBbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestDB extends BasePage {

    @BeforeMethod
    public void setUpPage(){
        driver.navigate().to("https://www.demoblaze.com/index.html#");
        driver.manage().window().maximize();
    }

    @Test(priority = 10)
    public void printAll() throws InterruptedException {
        Thread.sleep(2000);

        for (WebElement e : categoryPage.getCategories()) {
            e.click();
            Thread.sleep(2000);
            System.out.println(e.getText());
            Thread.sleep(2000);
            System.out.print(categoryPage);
            System.out.println("Ukupno stavki iz " + e.getText() + " = " + categoryPage.totalItems());
            System.out.println("Ukupna cena svih proizvoda iz " + e.getText() + " = " + categoryPage.totalPrice() +"\n");
        }
    }

    @Test(priority = 20)
    public void addToCart() throws InterruptedException {
        int i = 0;
        int phones = 0;
        do {
            categoryPage.clickCategory(phones);
            Thread.sleep(2000);
            categoryPage.selectItem(i);
            Thread.sleep(2000);
            categoryPage.addItem();
            Thread.sleep(2000);
            cartPage.alert();
            Thread.sleep(1000);
            driver.navigate().to("https://www.demoblaze.com/index.html#");
            i++;
       }
        while (i < 3);
    }

    @Test(priority = 30)
    public void testCart() throws InterruptedException {
        cartPage.clickCart();
        Thread.sleep(2000);
        cartPage.getInCart();
        int expectedCart = 3;
        Assert.assertEquals(cartPage.getInCart().size(), expectedCart);
    }
}
