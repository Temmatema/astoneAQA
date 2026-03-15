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

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookie() {
        getDriver().findElement(cookieLocator).click();
    }

    public String getBlockTitle() {
        return getDriver().findElement(headingLocator).getText().replace("\n", " ");
    }

    public List<WebElement> getPaymentLogos() {
        return getDriver().findElements(payPartnersLogos);
    }

    public WebElement getLearnMoreServiceLink() {
        return getDriver().findElement(infoLinkLocator);
    }

    public MainPage fillPhone(String phone) {
        getDriver().findElement(phoneLocator).sendKeys(phone);
        return this;
    }

    public MainPage fillSum(String sum) {
        getDriver().findElement(sumLocator).sendKeys(sum);
        return this;
    }

    public MainPage fillEmail(String email) {
        getDriver().findElement(emailLocator).sendKeys(email);
        return this;
    }

    public void clickContinue() {
        getDriver().findElement(continueBtn).click();
    }
}