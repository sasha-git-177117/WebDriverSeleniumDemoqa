package framework.base;

import lombok.AllArgsConstructor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import framework.driverutil.WaitUtil;
import framework.driverutil.WebDriverSingleton;
import framework.util.LoggerUtils;

import java.util.List;

@AllArgsConstructor
public abstract class BaseElement{
    protected By elementXPath;
    protected String name;

    public String getName() {
        return name;
    }

    public WebElement getElement() {
        LoggerUtils.debug("Выполняется поиск и возврат элемента " + name);
        return WebDriverSingleton.getInstance().findElement(elementXPath);
    }

    public WebElement findElement(By element) {
        LoggerUtils.debug("Выполняется поиск и возврат элемента от элемента " + name);
        return getElement().findElement(element);
    }

    public List<WebElement> findElements(By element) {
        LoggerUtils.debug("Выполняется поиск и возврат элементов от элемента " + name);
        return getElement().findElements(element);
    }

    public List<WebElement> getElements()  {
        LoggerUtils.debug("Выполняется поиск и возврат элементов " + name);
        return WebDriverSingleton.getInstance().findElements(elementXPath);
    }

    public void click()  {
        LoggerUtils.debug("Нажимается кнопка " + name);
        getElement().click();
    }

    public String getText() {
        LoggerUtils.debug("Извлекается текст с элемента " + name);
        return getElement().getText();
    }

    public boolean checkAndWaitNotPresenceOfAllElementsLocatedBy() {
        LoggerUtils.debug("Ожидается и проверяется отсутствие на странице элемента " + name);
        return WaitUtil.getWait().until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(elementXPath)));
    }

    public boolean checkAndWaitPresenceOfAllElementsLocatedBy() {
        LoggerUtils.debug("Ожидается и проверяется существование на странице элемента " + name);
        return !WaitUtil.getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementXPath)).isEmpty();
    }

    public void waitVisibilityOf() {
        LoggerUtils.debug("Ожидается видимость на странице элемента " + name);
         WaitUtil.getWait().until(ExpectedConditions.visibilityOf(getElement()));
    }

}
