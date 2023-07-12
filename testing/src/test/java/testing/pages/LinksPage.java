package testing.pages;

import framework.util.LoggerUtils;
import org.openqa.selenium.By;
import framework.base.BaseForm;
import framework.seleniumobjects.Link;

public class LinksPage extends BaseForm {
    private static final By CHECK_ELEMENT = By.xpath("//*[@id='linkWrapper']");
    private static final By BY_HOME_LINK = By.xpath("//*[@id='simpleLink']");
    private static final Link HOME_LINK = new Link(BY_HOME_LINK,"homeLink");

    public LinksPage() {
        super(CHECK_ELEMENT);;
    }

    public void clickHomeLink() {
        LoggerUtils.info("Нажимается ссылка "+ HOME_LINK.getName());
        HOME_LINK.click();
    }
}
