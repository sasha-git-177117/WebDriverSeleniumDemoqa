package testing.pages;

import framework.seleniumobjects.Form;
import framework.util.LoggerUtils;
import org.openqa.selenium.By;
import framework.base.BaseForm;


public class FramePage extends BaseForm {
    private static final By CHECK_ELEMENT = By.xpath("//*[@id='framesWrapper']");
    private static final By BY_MAIN_FRAME = By.xpath("//*[@id='framesWrapper']");
    private static final By BY_FRAME_FIRST = By.xpath("//*[@id='frame1']");
    private static final By BY_FRAME_SECOND = By.xpath("//*[@id='frame2']");
    private static final By BY_TEXT_FROM_FRAME = By.xpath("//*[@id='sampleHeading']");
    private static final Form MAIN_FRAME = new Form(BY_MAIN_FRAME,"mainFrame");
    private static final Form FRAME_FIRST = new Form(BY_FRAME_FIRST,"frameFirst");
    private static final Form FRAME_SECOND = new Form(BY_FRAME_SECOND,"frameSecond");

    public FramePage() {
        super(CHECK_ELEMENT);;
    }

    public boolean isDisplaidFrame() {
        LoggerUtils.info("Проверяется существование фрейма "+ MAIN_FRAME.getName());
        return MAIN_FRAME.checkAndWaitPresenceOfAllElementsLocatedBy();
    }

    public void openFrame(Form frame) {
        LoggerUtils.info("Выполняется переход на "+frame.getName());
        frame.openFrame();
    }

    public void closeFrame(Form frame) {
        LoggerUtils.info("Выполняется выход с "+frame.getName());
        frame.closeFrame();
    }

    public String getTextFromFrameFirst() {
        openFrame(FRAME_FIRST);
        LoggerUtils.info("Извлекается текст из "+ FRAME_FIRST.getName());
        String text = FRAME_FIRST.getTextFromFrame(BY_TEXT_FROM_FRAME);
        closeFrame(FRAME_FIRST);
        return text;
    }

    public String getTextFromFrameSecond() {
        openFrame(FRAME_SECOND);
        LoggerUtils.info("Извлекается текст из "+ FRAME_SECOND.getName());
        String text = FRAME_SECOND.getTextFromFrame(BY_TEXT_FROM_FRAME);
        closeFrame(FRAME_SECOND);
        return text;
    }
}
