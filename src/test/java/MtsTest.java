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
        driver.get(Config.URL);

        mainPage = new MainPage(driver);
        paymentPage = new PaymentPage(driver);

        mainPage.acceptCookie();
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка заголовка")
    public void titleCheck() {
        String actual = mainPage.getBlockTitle();
        String expected = "Онлайн пополнение без комиссии";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка логотипов платёжных систем")
    public void logosCheck() {
        List<WebElement> logos = mainPage.getPaymentLogos();
        Assertions.assertEquals(5, logos.size());
        logos.forEach(logo -> Assertions.assertFalse(logo.getAttribute("src").isEmpty()));
    }

    @Test
    @DisplayName("Проверка кнопки [Подробнее о сервисе]")
    public void learnMoreServiceLinkCheck() {
        WebElement link = mainPage.getLearnMoreServiceLink();
        String urlBefore = driver.getCurrentUrl();

        Assertions.assertFalse(link.getAttribute("href").isEmpty());
        link.click();
        Assertions.assertNotEquals(urlBefore, driver.getCurrentUrl());
        driver.navigate().back();
    }

    @Test
    @DisplayName("Проверка кнопки [Продолжить] + Проверка модального окна")
    public void onlineTopUpCheck() {
        mainPage.fillPhone(Config.PHONE)
                .fillEmail(Config.EMAIL)
                .fillSum(Config.SUM)
                .clickContinue();

        Assertions.assertEquals("visible", paymentPage.getIframe().getCssValue("visibility"));

        paymentPage.switchToIframe();

        assertPaymentSummary();
        assertCardIcons();
        assertCardLabels();
    }

    private void assertPaymentSummary() {
        String expectedSum = Config.SUM + ".00 BYN";
        Assertions.assertEquals(expectedSum, paymentPage.getSumTitle());
        Assertions.assertEquals("Оплатить " + expectedSum, paymentPage.getSumButton());
        Assertions.assertEquals(Config.PHONE, paymentPage.getPhoneText());
    }

    private void assertCardIcons() {
        List<WebElement> icons = paymentPage.getCardIcons();
        Assertions.assertFalse(icons.isEmpty());
        icons.forEach(icon -> Assertions.assertFalse(icon.getAttribute("src").isEmpty()));
    }

    private void assertCardLabels() {
        List.of(
                paymentPage.getCardCVCLabel(),
                paymentPage.getCardDateLabel(),
                paymentPage.getCardNameLabel(),
                paymentPage.getCardNumberLabel()
        ).forEach(label -> Assertions.assertFalse(label.isEmpty()));
    }

    @Test
    @DisplayName("Проверяем плейсхолдеры")
    public void placeholderCheck() {
        checkPlaceholders(PlaceholderField.CONNECTION_PHONE,
                PlaceholderField.CONNECTION_SUM,
                PlaceholderField.CONNECTION_EMAIL);

        mainPage.openInternetTab();
        checkPlaceholders(PlaceholderField.INTERNET_PHONE,
                PlaceholderField.INTERNET_SUM,
                PlaceholderField.INTERNET_EMAIL);

        mainPage.openInstalmentTab();
        checkPlaceholders(PlaceholderField.INSTALMENT_SCORE,
                PlaceholderField.INSTALMENT_SUM,
                PlaceholderField.INSTALMENT_EMAIL);

        mainPage.openArrearsTab();
        checkPlaceholders(PlaceholderField.ARREARS_SCORE,
                PlaceholderField.ARREARS_SUM,
                PlaceholderField.ARREARS_EMAIL);
    }

    private void checkPlaceholders(PlaceholderField... fields) {
        for (PlaceholderField field : fields) {
            Assertions.assertEquals(field.placeholder, mainPage.getPlaceholder(field.locator));
        }
    }
}