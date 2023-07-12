package framework.seleniumobjects;

import framework.base.BaseElement;
import framework.driverutil.WebDriverSingleton;
import framework.util.LoggerUtils;
import org.openqa.selenium.By;


public class Form extends BaseElement {

    public Form(By formXPath, String name) {
        super(formXPath,name);
    }

    public void openFrame() {
        LoggerUtils.debug("Ожидается открытие фрейма "+ name);
        WebDriverSingleton.getInstance().switchTo().frame(getElement());
    }

    public String getTextFromFrame(By element) {
        LoggerUtils.debug("Извлекается текст из фрейма "+ name);
        return WebDriverSingleton.getInstance().findElement(element).getText();
    }

    public void closeFrame(){
        LoggerUtils.debug("Закрывается фрейм "+ name);
        WebDriverSingleton.getInstance().switchTo().defaultContent();
    }
}


