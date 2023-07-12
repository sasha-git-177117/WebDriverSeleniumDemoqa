package framework.seleniumobjects;

import framework.base.BaseElement;
import org.openqa.selenium.By;

public class Link extends BaseElement {

    public Link(By linkXPath, String name) {
        super(linkXPath,name);
    }
}
