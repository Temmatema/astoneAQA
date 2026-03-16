import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    private final By cookieLocator = By.id("cookie-agree");
    private final By payPartnersLogos = By.xpath("//div[@class='pay__partners']//img");
    private final By phoneLocator = By.id("connection-phone");
    private final By sumLocator = By.id("connection-sum");
    private final By emailLocator = By.id("connection-email");
    private final By continueBtn = By.xpath("//form[@id='pay-connection']/button");
    private final By headingLocator = By.xpath("//h2[contains(normalize-space(), 'Онлайн пополнение без комиссии')]");
    private final By infoLinkLocator = By.xpath("//a[text()='Подробнее о сервисе']");
    private final By internetTabLocator = By.xpath("//ul[@class='select__list']//p[text()='Домашний интернет']");
    private final By instalmentTabLocator = By.xpath("//ul[@class='select__list']//p[text()='Рассрочка']");
    private final By arrearsTabLocator = By.xpath("//ul[@class='select__list']//p[text()='Задолженность']");
    private final By selectButtonLocator = By.className("select__header");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookie() {
        click(cookieLocator);
    }

    public String getBlockTitle() {
        return getText(headingLocator).replace("\n", " ");
    }

    public List<WebElement> getPaymentLogos() {
        waitForElement(payPartnersLogos);
        return getDriver().findElements(payPartnersLogos);
    }

    public WebElement getLearnMoreServiceLink() {
        return waitForElement(infoLinkLocator);
    }

    public MainPage fillPhone(String phone) {
        setInputText(phoneLocator, phone);
        return this;
    }

    public MainPage fillSum(String sum) {
        setInputText(sumLocator, sum);
        return this;
    }

    public MainPage fillEmail(String email) {
        setInputText(emailLocator, email);
        return this;
    }

    public void clickContinue() {
        click(continueBtn);
    }

    public String getPlaceholder(By locator) {
        return getAttribute(locator, "placeholder");
    }

    public void openInternetTab() {
        selectTab();
        click(internetTabLocator);
    }

    public void openArrearsTab() {
        selectTab();
        click(arrearsTabLocator);
    }

    public void openInstalmentTab() {
        selectTab();
        click(instalmentTabLocator);
    }

    public void selectTab() {
        click(selectButtonLocator);
    }
}