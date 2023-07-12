package framework.base;

import framework.util.LoggerUtils;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import framework.driverutil.WaitUtil;
import framework.driverutil.WebDriverSingleton;

@AllArgsConstructor
abstract public class BaseForm {
    protected By locator;

    public void waitForPageToLoad() {
        LoggerUtils.info("Ожидание открытия страницы");
        WaitUtil.getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.locator));
    }

    public boolean isOpenPage() {
        LoggerUtils.info("Проверка открытия страницы");
        return !WebDriverSingleton.getInstance().findElements(locator).isEmpty();
    }
}
