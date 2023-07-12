package framework.driverutil;

import framework.util.LoggerUtils;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

    public static WebDriverWait getWait() {
        LoggerUtils.info("Настроилось ожидание (добавлено время для явного ожидания)");
        return new WebDriverWait(WebDriverSingleton.getInstance(),JsonParser.parsParamFromJson().getExplicitWait());
    }
}
