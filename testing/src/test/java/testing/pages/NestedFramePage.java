package testing.pages;

import framework.util.LoggerUtils;
import org.openqa.selenium.By;
import testing.pages.enums.ButtonsFromAlertsAndFramesButton;
import framework.base.BaseForm;
import framework.seleniumobjects.*;


public class NestedFramePage extends BaseForm {
    private static final String BY_PARENT_BUTTON = "//ancestor::*[contains(@class,'group')]//*[contains(@class,'group-header')]";
    private static final By CHECK_ELEMENT = By.xpath("//*[@id='frame1Wrapper']");
    private static final By BY_NESTED_FRAME_PARENT = By.xpath("//*[@id='frame1']");
    private static final By BY_NESTED_FRAME_CHILD = By.xpath("//*[@srcdoc]");
    private static final By BY_TEXT_FROM_FRAME = By.xpath("//body");
    private static final String BLOCK_WITH_BUTTONS = ".//ancestor::*[contains(@class,'element-list')]";
    private static final String FMT_BUTTON_FROM_ALERTS_AND_FRAMES_BUTTON = "//*[contains(@class,'btn')]" +
            "//*[contains(@class,'text') and text()='%s']";
    private static final Form NESTED_FRAME_PARENT = new Form(BY_NESTED_FRAME_PARENT,"nestedFrameParent");
    private static final Form NESTED_FRAME_CHILD = new Form(BY_NESTED_FRAME_CHILD,"nestedFrameChild");

    public NestedFramePage(){
        super(CHECK_ELEMENT);;
    }

    public boolean isDisplaidFrame() {
        LoggerUtils.info("Ожидается и проверяется загрузка фрейма "+ NESTED_FRAME_PARENT.getName());
        return NESTED_FRAME_PARENT.checkAndWaitPresenceOfAllElementsLocatedBy();
    }

    public String getTextFromParent() {
        openFrame(NESTED_FRAME_PARENT);
        LoggerUtils.info("Извлекается текст фрейма "+ NESTED_FRAME_PARENT.getName());
        return NESTED_FRAME_PARENT.getTextFromFrame(BY_TEXT_FROM_FRAME);
    }

    public void openFrame(Form frame) {
        LoggerUtils.info("Выполняется переход на фрейм "+ frame.getName());
        frame.openFrame();
    }

    public String getTextFromChild() {
        openFrame(NESTED_FRAME_CHILD);
        LoggerUtils.info("Извлекается текст фрейма "+ NESTED_FRAME_CHILD.getName());
        String text = NESTED_FRAME_CHILD.getTextFromFrame(BY_TEXT_FROM_FRAME);
        closeFrame(NESTED_FRAME_CHILD);
        return text;
    }

    public void closeFrame(Form frame) {
        LoggerUtils.info("Выполняется выход из фрейма "+ frame.getName());
        frame.closeFrame();
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
