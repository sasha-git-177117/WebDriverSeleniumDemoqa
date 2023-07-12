package testing.pages;

import framework.util.LoggerUtils;
import org.openqa.selenium.By;
import testing.pages.enums.ButtonsFromAlertsAndFramesButton;
import framework.base.BaseForm;
import framework.seleniumobjects.Button;


public class ElementsPage extends BaseForm {
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'playgound-body')]");
    private static final String BY_PARENT_BUTTON = "//ancestor::*[contains(@class,'group')]//*[contains(@class,'group-header')]";
    private static final String BLOCK_WITH_BUTTONS = ".//ancestor::*[contains(@class,'element-list')]";
    private static final String FMT_BUTTON_FROM_ALERTS_AND_FRAMES_BUTTON = "//*[contains(@class,'btn')]" +
            "//*[contains(@class,'text') and text()='%s']";

    public ElementsPage() {
        super(CHECK_ELEMENT);;
    }

    public void clickPredok(ButtonsFromAlertsAndFramesButton element) {
        Button parentButton = new Button(By.xpath(String.format(FMT_BUTTON_FROM_ALERTS_AND_FRAMES_BUTTON, element.label) +
                BY_PARENT_BUTTON),"parentButton "+ element);
        LoggerUtils.info("Нажимается кнопка "+ parentButton.getName());
        parentButton.click();
    }

    public void clickButton(ButtonsFromAlertsAndFramesButton element) {
        Button buttonFromAlertsAndFramesButton = new Button(By.xpath(String.format(FMT_BUTTON_FROM_ALERTS_AND_FRAMES_BUTTON,
                element.label)),
                element.toString());

        if(!isDispayed(element)) {
            clickPredok(element);
        }

        LoggerUtils.info("Ожидается видимость элемента "+ buttonFromAlertsAndFramesButton.getName());
        buttonFromAlertsAndFramesButton.waitVisibilityOf();
        LoggerUtils.info("Нажимается элемент "+ buttonFromAlertsAndFramesButton.getName());
        buttonFromAlertsAndFramesButton.click();
    }

    public boolean isDispayed(ButtonsFromAlertsAndFramesButton element) {
        Button buttonFromAlertsAndFramesButton = new Button(By.xpath(String.format(FMT_BUTTON_FROM_ALERTS_AND_FRAMES_BUTTON,
                element.label)),
                element.toString());

        LoggerUtils.info("Производится поиск атрибута, определяющего видимость элемента "+
                buttonFromAlertsAndFramesButton.getName());

        return buttonFromAlertsAndFramesButton.findElement(By.xpath(BLOCK_WITH_BUTTONS)).getAttribute("class").contains("show");
    }
}
