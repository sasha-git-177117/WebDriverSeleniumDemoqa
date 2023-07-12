package testing.tests;

import framework.util.LoggerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import testing.pages.*;
import testing.pages.enums.ButtonsFromAlertsAndFramesButton;
import testing.util.BrowserTabUtil;


public class TestCase4 extends BaseTest {

    @Test
    public void testCase4() {
        LoggerUtils.info("Открывается главная страница");
        MainPage mainPage = new MainPage();
        mainPage.waitForPageToLoad();
        Assert.assertEquals(mainPage.isOpenPage(),true,
                "Не удалось открыть Главную страницу");

        LoggerUtils.info("Нажимается кнопка Alerts, Frame & Windows");
        mainPage.clickAlertsButton();
        AlertWindowsPage practicAlertWindows = new AlertWindowsPage();
        practicAlertWindows.waitForPageToLoad();
        LoggerUtils.info("Нажимается кнопка Browser windows");
        practicAlertWindows.clickButton(ButtonsFromAlertsAndFramesButton.BROWSER_WINDOWS);
        BrowserWindowPage practicBrowserWindowPage = new BrowserWindowPage();
        practicBrowserWindowPage.waitForPageToLoad();
        Assert.assertNotEquals(practicBrowserWindowPage.isOpenPage(),0,
                "Страница с формой Browser Windows не открылась");

        LoggerUtils.info("Нажимается кнопка New tab");
        practicBrowserWindowPage.clickNewTab();
        BrowserTabUtil browserWindowUtil = new BrowserTabUtil();
        browserWindowUtil.openBrowserTab(1);
        SamplePage samplePage = new SamplePage();
        samplePage.waitForPageToLoad();
        Assert.assertEquals(browserWindowUtil.getPartURLPage(),"/sample","Новая вкладка /sample не открылась");
        Assert.assertEquals(samplePage.isOpenPage(),true,"Страница sample page не открылась");

        LoggerUtils.info("Закрывается открытая ранее вкладка");
        browserWindowUtil.closeBrowserTab();
        browserWindowUtil.returnToBeforePage();
        practicBrowserWindowPage.waitForPageToLoad();
        Assert.assertEquals(practicBrowserWindowPage.isOpenPage(),true,
                "Страница с формой Browser Windows не открылась");

        LoggerUtils.info("Нажимается кнопка Links");
        practicBrowserWindowPage.clickButton(ButtonsFromAlertsAndFramesButton.LINKS);
        LinksPage practicLinksPage = new LinksPage();
        practicLinksPage.waitForPageToLoad();
        Assert.assertEquals(practicLinksPage.isOpenPage(),true,"Страница с формой Links не открылась");

        LoggerUtils.info("Нажимается ссылка Home");
        practicLinksPage.clickHomeLink();
        browserWindowUtil.openBrowserTab(1);
        mainPage.waitForPageToLoad();
        Assert.assertEquals(mainPage.isOpenPage(),true,"Новая вкладка с главной страницей не открылась");

        LoggerUtils.info("Выполняется возврат на прошлую вкладку");
        browserWindowUtil.returnToBeforePage();
        practicLinksPage.waitForPageToLoad();
        Assert.assertEquals(practicLinksPage.isOpenPage(),true, "Страница с формой Links не открылась");

    }
}
