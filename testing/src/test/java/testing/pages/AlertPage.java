package testing.pages;

import framework.util.LoggerUtils;
import org.openqa.selenium.By;
import testing.pages.enums.AlertButtonsEnum;
import framework.base.BaseForm;
import framework.seleniumobjects.Button;
import framework.seleniumobjects.Form;
import framework.seleniumobjects.Label;


public class AlertPage extends BaseForm {
    private static final By CHECK_ELEMENT = By.xpath("//*[@id='javascriptAlertsWrapper']");
    private static final By BY_ALERTS_FORM = By.xpath("//*[@id='javascriptAlertsWrapper']");
    private static final String LABEL_NEAR_BUTTON = "//parent::*//preceding-sibling::*//*[contains(@id,'Result')]";
    private static final Form ALERTS_FORM = new Form(BY_ALERTS_FORM,"alertsForm");
    private static final String FMT_CHILD_BUTTON = "//*[@id='%s']";

    public AlertPage(){
        super(CHECK_ELEMENT);;
    }

    public boolean isDisplaidForm() {
        LoggerUtils.info("Проверяется существование елемента "+ ALERTS_FORM.getName());
        return ALERTS_FORM.checkAndWaitPresenceOfAllElementsLocatedBy();
    }

    public void clickAlertButton(AlertButtonsEnum element) {
        Button alertButton = new Button(By.xpath(String.format(FMT_CHILD_BUTTON, element.label)),element.toString());
        LoggerUtils.info("Нажимается кнопка "+ alertButton.getName());
        alertButton.click();
    }

    public String getAllTextFromLabelNearButton(AlertButtonsEnum element) {
        Label textNearAlertButton = new Label(By.xpath(String.format(FMT_CHILD_BUTTON, element.label)+ LABEL_NEAR_BUTTON),"labelNearButton " + element);
        LoggerUtils.info("Извлекается текст из элемента "+ textNearAlertButton.getName());
        return textNearAlertButton.getText();
    }

    public String getEnterTextFromLabelNearButton(AlertButtonsEnum element) {
        Label enterTextNearAlertButton = new Label(By.xpath(String.format(FMT_CHILD_BUTTON, element.label)+ LABEL_NEAR_BUTTON),"labelNearButton " + element);
        LoggerUtils.info("Извлекается текст сгенерированный Alert-ом из элемента "+ enterTextNearAlertButton.getName());
        return enterTextNearAlertButton.getText().split(" ")[enterTextNearAlertButton.getText().split(" ").length-1];
    }
}
