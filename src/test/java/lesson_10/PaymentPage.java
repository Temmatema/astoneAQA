package lesson_10;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage extends BasePage {

    private final By sumTitleLocator = By.xpath("//div[@class='pay-description__cost']/span");
    private final By sumButtonLocator = By.xpath("//div[@class='card-page__card']/button/span");
    private final By phoneTextLocator = By.xpath("//div[@class='pay-description__text']/span");
    private final By cardNumberLabel = By.xpath("//input[@formcontrolname='creditCard']/following-sibling::label");
    private final By cardDateLabel = By.xpath("//input[@formcontrolname='expirationDate']/following-sibling::label");
    private final By cardCVCLabel = By.xpath("//input[@formcontrolname='cvc']/following-sibling::label");
    private final By cardNameLabel = By.xpath("//input[@formcontrolname='holder']/following-sibling::label");
    private final By cardIconsLocator = By.xpath("//div[contains(@class, 'cards-brands')]/img");
    private final By iframeLocator = By.className("payment-widget-iframe");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void switchToIframe() {
        getDriver().switchTo().frame(waitForElement(iframeLocator));
    }

    public WebElement getIframe() {
        return waitForElement(iframeLocator);
    }

    public String getSumTitle() {
        return getText(sumTitleLocator);
    }

    public String getSumButton() {
        return getText(sumButtonLocator);
    }

    public String getPhoneText() {
        String text = getText(phoneTextLocator);
        return text.replaceAll(".*375", "");
    }

    public String getCardNumberLabel() {
        return getText(cardNumberLabel);
    }

    public String getCardDateLabel() {
        return getText(cardDateLabel);
    }

    public String getCardCVCLabel() {
        return getText(cardCVCLabel);
    }

    public String getCardNameLabel() {
        return getText(cardNameLabel);
    }

    public List<WebElement> getCardIcons() {
        waitForElement(cardIconsLocator);
        return getDriver().findElements(cardIconsLocator);
    }
}