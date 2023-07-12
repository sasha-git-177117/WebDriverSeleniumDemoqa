package testing.tests;

import framework.util.LoggerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import testing.pages.AlertWindowsPage;
import testing.pages.enums.ButtonsFromAlertsAndFramesButton;
import testing.pages.MainPage;
import testing.pages.FramePage;
import testing.pages.NestedFramePage;


public class TestCase2 extends BaseTest {
    @Test
    public void testCase2() {
        LoggerUtils.info("Открывается главная страница");
        MainPage mainPage = new MainPage();
        mainPage.waitForPageToLoad();
        Assert.assertEquals(mainPage.isOpenPage(),true,
                "Не удалось открыть Главную страницу");

        LoggerUtils.info("Нажимается кнопка Alerts, Frame & Windows");
        mainPage.clickAlertsButton();
        AlertWindowsPage practicAlertWindows = new AlertWindowsPage();
        practicAlertWindows.waitForPageToLoad();
        LoggerUtils.info("Нажимается кнопка Nested Frames");
        practicAlertWindows.clickButton(ButtonsFromAlertsAndFramesButton.NESTED_FRAMES);
        NestedFramePage practicIFramePage = new NestedFramePage();
        practicIFramePage.waitForPageToLoad();
        Assert.assertEquals(practicIFramePage.isOpenPage(),true,
                "Страница с формой Nested Frames не открылась");
        Assert.assertEquals(practicIFramePage.isDisplaidFrame(),true,
                "Форма Nested Frames не была найдена");
        Assert.assertEquals(practicIFramePage.getTextFromParent(),"Parent frame",
                "На форме отсутсвует ожидаемая надпись");
        Assert.assertEquals(practicIFramePage.getTextFromChild(),"Child Iframe",
                "На форме отсутсвует ожидаемая надпись");

        LoggerUtils.info("Нажимается кнопка Frames");
        practicIFramePage.clickButton(ButtonsFromAlertsAndFramesButton.FRAMES);
        FramePage practicFramePage = new FramePage();
        practicFramePage.waitForPageToLoad();
        Assert.assertEquals(practicFramePage.isOpenPage(),true,
                "Страница с формой Frames не открылась");
        Assert.assertEquals(practicFramePage.isDisplaidFrame(),true, "Форма Frames не найдена");
        Assert.assertEquals(practicFramePage.getTextFromFrameFirst(),practicFramePage.getTextFromFrameSecond(),
                "Надпись из верхнего фрейма не соответствует надписи из нижнего");
    }
}
