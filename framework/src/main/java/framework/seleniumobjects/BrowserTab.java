package framework.seleniumobjects;

import framework.driverutil.WebDriverSingleton;
import framework.util.LoggerUtils;

import java.util.ArrayList;
import java.util.List;

public class BrowserTab {

    public void openBrowserTab(int index) {
        LoggerUtils.info("Выполняется переход на другую вклдаку");
        List<String> browserTabs = new ArrayList<>(WebDriverSingleton.getInstance().getWindowHandles());
        WebDriverSingleton.getInstance().switchTo().window(browserTabs.get(index));
    }

    public void closeBrowserTab() {
        LoggerUtils.info("Вкладка закрывается");
        WebDriverSingleton.close();
    }

    public String getURLBrowserTab() {
        LoggerUtils.info("Выполняется получение URL открытой вкладки");
        return WebDriverSingleton.getInstance().getCurrentUrl();
    }

    public void returnToBeforePage() {
        LoggerUtils.info("Выполняется возврат на начальную вкладку");
        List<String> browserTabs = new ArrayList<>(WebDriverSingleton.getInstance().getWindowHandles());
        WebDriverSingleton.getInstance().switchTo().window(browserTabs.get(0));
    }
}
