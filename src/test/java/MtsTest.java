import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MtsTest {
    static WebDriver driver;
    
    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://mts.by");

        //принимаем куки
        WebElement cookieBtn = driver.findElement(By.id("cookie-agree"));
        cookieBtn.click();   
    }

    @AfterAll
    static void quit() {
        driver.quit();
    }

    @Test
    void test1() {
        WebElement heading = driver.findElement(By.xpath("//h2[contains(normalize-space(), 'Онлайн пополнение без комиссии')]"));
    
        String actualText = heading.getText().replace("\n", " ");
        String expectedText = "Онлайн пополнение без комиссии";

        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    void test2() {
        List<WebElement> imgs = driver.findElements(By.xpath("//div[@class='pay__partners']//img"));
        
        Assertions.assertEquals(5, imgs.size());

        //проверяем, что заполнен src, а не просто пустые теги img
        for(WebElement img : imgs) {
            String src = img.getAttribute("src");
            Assertions.assertFalse(src.isEmpty());
        }
    }

    @Test
    void test3() {
        WebElement link = driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']"));

        Assertions.assertFalse(link.getAttribute("href").isEmpty());

        String url = driver.getCurrentUrl();
        link.click();
        Assertions.assertNotEquals(url, driver.getCurrentUrl());
    }

    @Test
    void test4() {
        
    }
}