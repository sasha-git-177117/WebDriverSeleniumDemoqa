package framework.seleniumobjects;

import framework.base.BaseElement;
import framework.util.LoggerUtils;
import org.openqa.selenium.By;

public class Input extends BaseElement {

    public Input(By inputXPath, String name) {
        super(inputXPath,name);
    }

    public void sendText(String text) {
        LoggerUtils.debug("Ввод текста в инпут "+ name);
        getElement().sendKeys(text);
    }
}
