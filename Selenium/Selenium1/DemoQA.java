package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DemoQA {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/profile");

        Cookie ck1 = new Cookie("userID", "3982a9ab-f950-4883-aaf1-34a233d2198d");
        driver.manage().addCookie(ck1);

        Cookie ck2 = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6InN0ZWZhbjEyMyIsInBhc3N3b3JkIjoiUXdlcnR5MTIzISIsImlhdCI6MTY0MjMzNDIyOH0.3DkUa0HFXlXNKr2r_-1LKmvyM49nKINlHM_JhMZI7fo");
        driver.manage().addCookie(ck2);

        Cookie ck3 = new Cookie("userName", "stefan123");
        driver.manage().addCookie(ck3);

        Cookie ck4 = new Cookie("expires", "2022-01-23T11%3A57%3A08.682Z");
        driver.manage().addCookie(ck4);

        WebElement btn = driver.findElement(By.xpath("//*[@id=\"notLoggin-label\"]/a[1]"));
        btn.click();
        Thread.sleep(1000);

        WebElement logOut = driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        logOut.click();
        Thread.sleep(2000);

        WebElement loggedOuttxt = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]"));

        String actualURL = "https://demoqa.com/login";
        String expectedURL = "https://demoqa.com/login";
        String pageTitle = "Login";

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(loggedOuttxt.getText(), pageTitle);
    }
}
