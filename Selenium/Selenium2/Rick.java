package SeleniumDomaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.Keys.ENTER;

public class Rick {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");

        WebElement textbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));

        textbox.sendKeys("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        Thread.sleep(2000);
        textbox.sendKeys(ENTER);
        Thread.sleep(2000);

        WebElement play = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div.e4xoPb > div.o0igqc > div:nth-child(1) > div > div > div > div > a > div.tHQl7d > div.lSegpf.tNxQIb.ynAwRc"));

        play.click();
        Thread.sleep(1000);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";

        Assert.assertEquals(actualURL, expectedURL);
    }
}
