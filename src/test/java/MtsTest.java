import java.util.List;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MtsTest {

    private WebDriver driver;
    private MainPage mainPage;
    private PaymentPage paymentPage;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://mts.by");

        mainPage = new MainPage(driver);
        paymentPage = new PaymentPage(driver);

        mainPage.acceptCookie();
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    @Test
    public void titleCheck() {
        String actual = mainPage.getBlockTitle();
        String expected = "Онлайн пополнение без комиссии";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void logosCheck() {
        List<WebElement> logos = mainPage.getPaymentLogos();
        Assertions.assertEquals(5, logos.size());
        logos.forEach(logo -> Assertions.assertFalse(logo.getAttribute("src").isEmpty()));
    }

    @Test
    public void learnMoreServiceLinkCheck() {
        WebElement link = mainPage.getLearnMoreServiceLink();
        String urlBefore = driver.getCurrentUrl();

        Assertions.assertFalse(link.getAttribute("href").isEmpty());
        link.click();
        Assertions.assertNotEquals(urlBefore, driver.getCurrentUrl());
        driver.navigate().back();
    }

    @Test
    public void onlineTopUpCheck() {
        mainPage
            .fillPhone(Config.PHONE)
            .fillEmail(Config.EMAIL)
            .fillSum(Config.SUM)
            .clickContinue();

        WebElement iframe = paymentPage.getIframe();
        Assertions.assertEquals("visible", iframe.getCssValue("visibility"));

        paymentPage.switchToIframe();

        Assertions.assertEquals(Config.SUM + ".00 BYN", paymentPage.getSumTitle());
        Assertions.assertEquals("Оплатить " + Config.SUM + ".00 BYN", paymentPage.getSumButton());
        Assertions.assertEquals(Config.PHONE, paymentPage.getPhoneText());

        List<WebElement> icons = paymentPage.getCardIcons();
        Assertions.assertFalse(icons.isEmpty());

        for (WebElement icon : icons) {
            Assertions.assertFalse(icon.getAttribute("src").isEmpty());
        }

        List.of(
                paymentPage.getCardCVCLabel(),
                paymentPage.getCardDateLabel(),
                paymentPage.getCardNameLabel(),
                paymentPage.getCardNumberLabel()
        ).forEach(label -> Assertions.assertFalse(label.isEmpty()));
    }
}