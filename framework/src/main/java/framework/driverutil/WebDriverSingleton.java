package framework.driverutil;
import framework.util.LoggerUtils;
import org.openqa.selenium.WebDriver;


public class WebDriverSingleton {
    private static WebDriver driver = null;

    private WebDriverSingleton() {
        driver = DriverBrowserFactory.getDriver();
    }

    public static WebDriver getInstance() {
        LoggerUtils.info("Инициализируется драйвер");
        if (driver == null) {
            new WebDriverSingleton();
        }
        return driver;
    }

    public static void quit() {
        LoggerUtils.info("Завершается сеанс работы драйвера");
        driver.quit();
        driver = null;
    }

    public static void close() {
        LoggerUtils.info("Закрывается вкладка");
        driver.close();
    }

    public static void openURl() {
        LoggerUtils.info("Открывается начальная страница");
        driver.get(JsonParser.parsParamFromJson().getBaseUrl());
    }
}
