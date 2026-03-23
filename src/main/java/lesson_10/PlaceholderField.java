package lesson_10;

import org.openqa.selenium.By;

public enum PlaceholderField {
    CONNECTION_PHONE ("connection-phone", "Номер телефона"),
    CONNECTION_SUM ("connection-sum", "Сумма"),
    CONNECTION_EMAIL ("connection-email", "E-mail для отправки чека"),

    INTERNET_PHONE ("internet-phone", "Номер абонента"),
    INTERNET_SUM ("internet-sum", "Сумма"),
    INTERNET_EMAIL ("internet-email", "E-mail для отправки чека"),

    INSTALMENT_SCORE ("score-instalment", "Номер счета на 44"),
    INSTALMENT_SUM ("instalment-sum", "Сумма"),
    INSTALMENT_EMAIL ("instalment-email", "E-mail для отправки чека"),

    ARREARS_SCORE ("score-arrears", "Номер счета на 2073"),
    ARREARS_SUM ("arrears-sum", "Сумма"),
    ARREARS_EMAIL ("arrears-email", "E-mail для отправки чека");

    public final By locator;
    public final String placeholder;

    PlaceholderField(String id, String placeholder) {
        this.locator = By.id(id);
        this.placeholder = placeholder;
    }
}