package testing.util;

import framework.seleniumobjects.Alerts;

public class AlertUtil {
    Alerts alerts = new Alerts();

    public String getTextFromAlert() {
        return alerts.getTextFromAlert();
    }

    public void clickAlertOk() {
        alerts.pressOK();
    }

    public boolean isOpenAlert() {
        return alerts.isOpenAlert();
    }

    public void enterTextIntoAlert(String text) {
        alerts.sendTextIntoAlert(text);
    }

    public void waitingForAlertToOpen() {
        alerts.waitingForAlertToOpen();
    }
}
