package lesson_10;

import java.util.List;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

@Epic("MTS Сайт")
@Feature("Онлайн оплата")
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
    @Description("Проверяем, что заголовок блока соответствует ожидаемому")
    @Story("Заголовок блока")
    @Severity(SeverityLevel.NORMAL)
    public void titleCheck() {
        String actual = mainPage.getBlockTitle();
        String expected = "Онлайн пополнение без комиссии";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка логотипов платёжных систем")
    @Description("Проверяем наличие 5 логотипов платёжных систем и их src")
    @Story("Логотипы")
    @Severity(SeverityLevel.MINOR)
    public void logosCheck() {
        List<WebElement> logos = mainPage.getPaymentLogos();
        Assertions.assertEquals(5, logos.size());
        logos.forEach((WebElement logo) ->
                Assertions.assertFalse(logo.getAttribute("src").isEmpty()));
    }

    @Test
    @DisplayName("Проверка кнопки [Подробнее о сервисе]")
    @Description("Проверяем, что ссылка ведёт на другую страницу")
    @Story("Навигация")
    @Severity(SeverityLevel.NORMAL)
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
    @Description("Заполняем форму, нажимаем продолжить, проверяем iframe и данные оплаты")
    @Story("Онлайн оплата")
    @Severity(SeverityLevel.CRITICAL)
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

    @Step("Проверка суммы и телефона в модальном окне")
    private void assertPaymentSummary() {
        String expectedSum = Config.SUM + ".00 BYN";
        Assertions.assertEquals(expectedSum, paymentPage.getSumTitle());
        Assertions.assertEquals("Оплатить " + expectedSum, paymentPage.getSumButton());
        Assertions.assertEquals(Config.PHONE, paymentPage.getPhoneText());
    }

    @Step("Проверка иконок")
    private void assertCardIcons() {
        List<WebElement> icons = paymentPage.getCardIcons();
        Assertions.assertFalse(icons.isEmpty());
        icons.forEach((WebElement icon) ->
                Assertions.assertFalse(icon.getAttribute("src").isEmpty()));
    }

    @Step("Проверка лейблов полей карты")
    private void assertCardLabels() {
        List.of(
                paymentPage.getCardCVCLabel(),
                paymentPage.getCardDateLabel(),
                paymentPage.getCardNameLabel(),
                paymentPage.getCardNumberLabel()
        ).forEach((String label) -> Assertions.assertFalse(label.isEmpty()));
    }

    @Test
    @DisplayName("Проверяем плейсхолдеры")
    @Description("Проверяем плейсхолдеры во всех вкладках формы")
    @Story("Плейсхолдеры")
    @Severity(SeverityLevel.NORMAL)
    public void placeholderCheck() {
        checkPlaceholders(
                PlaceholderField.CONNECTION_PHONE,
                PlaceholderField.CONNECTION_SUM,
                PlaceholderField.CONNECTION_EMAIL
        );

        mainPage.openInternetTab();
        checkPlaceholders(
                PlaceholderField.INTERNET_PHONE,
                PlaceholderField.INTERNET_SUM,
                PlaceholderField.INTERNET_EMAIL
        );

        mainPage.openInstalmentTab();
        checkPlaceholders(
                PlaceholderField.INSTALMENT_SCORE,
                PlaceholderField.INSTALMENT_SUM,
                PlaceholderField.INSTALMENT_EMAIL
        );

        mainPage.openArrearsTab();
        checkPlaceholders(
                PlaceholderField.ARREARS_SCORE,
                PlaceholderField.ARREARS_SUM,
                PlaceholderField.ARREARS_EMAIL
        );
    }

    @Step("Проверка плейсхолдеров группы полей")
    private void checkPlaceholders(PlaceholderField... fields) {
        for (PlaceholderField field : fields) {
            Assertions.assertEquals(field.placeholder, mainPage.getPlaceholder(field.locator));
        }
    }
}