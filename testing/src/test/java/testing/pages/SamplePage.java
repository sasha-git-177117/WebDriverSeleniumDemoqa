package testing.pages;

import org.openqa.selenium.By;
import framework.base.BaseForm;

public class SamplePage extends BaseForm {
    private static final By CHECK_ELEMENT = By.xpath("//*[@id='sampleHeading']");

    public SamplePage() {
        super(CHECK_ELEMENT);;
    }
}
