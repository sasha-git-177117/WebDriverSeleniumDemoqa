package framework.seleniumobjects;

import framework.base.BaseElement;
import org.openqa.selenium.By;

public class Button extends BaseElement {

    public Button(By buttonXPath, String name) {
        super(buttonXPath,name);
    }
}
