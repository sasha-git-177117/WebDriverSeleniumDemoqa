package testing.pages;

import org.openqa.selenium.By;
import framework.base.BaseForm;
import framework.seleniumobjects.Button;
import framework.util.LoggerUtils;

public class MainPage extends BaseForm{
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'home-content')]");
    private static final By BY_BUTTON_ALERTS = By.xpath("//*[contains(text(),'Alerts') and contains(text(),'Frame')]//ancestor::*[contains(@class,'top-card')]");
    private static final By BY_BUTTON_ELEMENTS = By.xpath("//*[contains(text(),'Elements')]//ancestor::*[contains(@class,'top-card')]");
    private static final Button BUTTON_ALERTS = new Button(BY_BUTTON_ALERTS,"buttonAlerts");
    private static final Button BUTTON_ELEMENTS = new Button(BY_BUTTON_ELEMENTS,"buttonElements");

    public MainPage() {
        super(CHECK_ELEMENT);
    }

    public void clickAlertsButton() {
        LoggerUtils.info("Нажимается элемент "+ BUTTON_ALERTS.getName());
        BUTTON_ALERTS.click();
    }

    public void clickElementsButton() {
        LoggerUtils.info("Нажимается элемент "+ BUTTON_ELEMENTS.getName());
        BUTTON_ELEMENTS.click();
    }
}
