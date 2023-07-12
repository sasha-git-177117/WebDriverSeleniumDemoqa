package framework.seleniumobjects;

import framework.base.BaseElement;
import org.openqa.selenium.By;

public class Label extends BaseElement {

    public Label(By labelXPath, String name) {
        super(labelXPath,name);
    }
}
