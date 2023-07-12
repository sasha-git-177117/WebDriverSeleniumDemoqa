package framework.driverutil;

import framework.util.LoggerUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverBrowserFactory {
    private static WebDriver driver = null;

    public static WebDriver getDriver () {
        WebDriverManager.getInstance().setup();

        switch (DriverBrowserEnum.valueOf(JsonParser.parsParamFromJson().getBrowser().toUpperCase())) {
            case CHROME:
                LoggerUtils.info("Натроился браузер Chrome");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--lang="+JsonParser.parsParamFromJson().getLanguage());
                chromeOptions.setHeadless(JsonParser.parsParamFromJson().getHeadless());
                driver = new ChromeDriver(chromeOptions);
                break;

            case FIREFOX:
                LoggerUtils.info("Натроился браузер FireFox");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(JsonParser.parsParamFromJson().getHeadless());
                firefoxOptions.addArguments("--lang="+JsonParser.parsParamFromJson().getLanguage());
                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                LoggerUtils.info("Натроился браузер по умолчанию Chrome");
                ChromeOptions defaultOptions = new ChromeOptions();
                defaultOptions.addArguments("--lang="+JsonParser.parsParamFromJson().getLanguage());
                defaultOptions.setHeadless(JsonParser.parsParamFromJson().getHeadless());
                driver = new ChromeDriver(defaultOptions);
                break;
        }
        return driver;
    }
}
