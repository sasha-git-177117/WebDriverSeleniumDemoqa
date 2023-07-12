package testing.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testing.pages.AlertWindowsPage;
import testing.pages.MainPage;
import testing.pages.AlertPage;
import testing.pages.enums.AlertButtonsEnum;
import testing.pages.enums.ButtonsFromAlertsAndFramesButton;
import testing.util.AlertUtil;
import framework.util.LoggerUtils;
import testing.util.StringUtil;


public class TestCase1 extends BaseTest {

    @Test
    public void testCase1() {
        LoggerUtils.info("Открывается главная страница");
        MainPage mainPage = new MainPage();
        mainPage.waitForPageToLoad();
        Assert.assertEquals(mainPage.isOpenPage(),true,
                "Не удалось открыть Главную страницу");

        LoggerUtils.info("Нажимается кнопка Alerts, Frame & Windows");
        mainPage.clickAlertsButton();
        AlertWindowsPage practicAlertWindows = new AlertWindowsPage();
        practicAlertWindows.waitForPageToLoad();
        LoggerUtils.info("Нажимается кнопка Alerts");
        practicAlertWindows.clickButton(ButtonsFromAlertsAndFramesButton.ALERTS);

        AlertPage practicePage = new AlertPage();
        practicePage.waitForPageToLoad();
        Assert.assertEquals(practicePage.isOpenPage(),true,
                "Не удалось открыть страницу Alerts");
        Assert.assertEquals(practicePage.isDisplaidForm(),true,
                "Форма Alert не найдена");
        LoggerUtils.info("Нажимается кнопка рядом с лейблом Click Button to see alert");
        practicePage.clickAlertButton(AlertButtonsEnum.TO_SEE_ALERT);

        AlertUtil alertUtil = new AlertUtil();
        alertUtil.waitingForAlertToOpen();
        Assert.assertEquals(alertUtil.isOpenAlert(),true, "Alert не открылся");
        Assert.assertEquals(alertUtil.getTextFromAlert(),"You clicked a button",
                "Текст с Alert не совпал с ожидаемым");

        LoggerUtils.info("Нажимается кнопка Ok на Alert");
        alertUtil.clickAlertOk();
        Assert.assertNotEquals(alertUtil.isOpenAlert(),true, "Alert не закрылся");

        LoggerUtils.info("Нажимается кнопка рядом с лейблом On button click, confirm box will appear");
        practicePage.clickAlertButton(AlertButtonsEnum.CONFIRM);
        alertUtil.waitingForAlertToOpen();
        Assert.assertEquals(alertUtil.isOpenAlert(),true, "Alert не открылся");
        Assert.assertEquals(alertUtil.getTextFromAlert(),"Do you confirm action?",
                "Текст с Alert не совпал с ожидаемым");

        LoggerUtils.info("Нажимается кнопка Ok на Alert");
        alertUtil.clickAlertOk();
        Assert.assertNotEquals(alertUtil.isOpenAlert(),true, "Alert не закрылся");
        Assert.assertEquals(practicePage.getAllTextFromLabelNearButton(AlertButtonsEnum.CONFIRM),"You selected Ok",
                "Рядом с кнопкой не появилась надпись или надпись не соответствует ожидаемой");

        LoggerUtils.info("Нажимается кнопка рядом с лейблом On button click, prompt box will appear");
        practicePage.clickAlertButton(AlertButtonsEnum.PROMPT);
        alertUtil.waitingForAlertToOpen();
        Assert.assertEquals(alertUtil.isOpenAlert(),true,"Alert не открылся");
        Assert.assertEquals(alertUtil.getTextFromAlert(),"Please enter your name",
                "Текст в Alert не совпадает с ожидаемым");

        String generedText = StringUtil.getGeneratorText();
        LoggerUtils.info("Вводится сгенерированный текст в поле Alert");
        alertUtil.enterTextIntoAlert(generedText);
        LoggerUtils.info("Нажимается кнопка Ok в Alert");
        alertUtil.clickAlertOk();
        Assert.assertNotEquals(alertUtil.isOpenAlert(),true,"Alert не закрылся");
        Assert.assertEquals(practicePage.getEnterTextFromLabelNearButton(AlertButtonsEnum.PROMPT),generedText,
                "Появившийся текст не соответствует введенному в Alert");
    }
}
