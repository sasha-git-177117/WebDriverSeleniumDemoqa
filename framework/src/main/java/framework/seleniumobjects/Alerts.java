package framework.seleniumobjects;

import framework.util.LoggerUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import framework.driverutil.WaitUtil;
import framework.driverutil.WebDriverSingleton;

public class Alerts {

    public void waitingForAlertToOpen() {
        LoggerUtils.info("Ожидается открытие Alert");
        WaitUtil.getWait().until(ExpectedConditions.alertIsPresent());
    }

    public boolean isOpenAlert() {
        LoggerUtils.info("Проверяется наличие Alert");
        try {
            getAlert();
            return true;
        }
        catch (NoAlertPresentException exception) {
            return false;
        }
    }

    public Alert getAlert() {
        LoggerUtils.info("Выполняется переход на Alert");
        return WebDriverSingleton.getInstance().switchTo().alert();
    }

    public String getTextFromAlert() {
        LoggerUtils.info("Выполняется получение текста из Alert");
        return getAlert().getText();
    }

    public void pressOK() {
        LoggerUtils.info("Нажимается кнопка OK");
        getAlert().accept();
    }

    public void sendTextIntoAlert(String text) {
        LoggerUtils.info("Выполняется ввод текста в поле в Alert");
        getAlert().sendKeys(text);
    }

}
