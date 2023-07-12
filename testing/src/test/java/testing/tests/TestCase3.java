package testing.tests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import framework.util.LoggerUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testing.pages.MainPage;
import testing.pages.ElementsPage;
import testing.pages.WebTablesPage;
import testing.pages.enums.ButtonsFromAlertsAndFramesButton;
import testing.pages.enums.UserDataEnum;
import testing.pages.models.UserDataModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class TestCase3 extends BaseTest {
    @Test(dataProvider = "getData")
    public void testCase3(UserDataModel data) {
        LoggerUtils.info("Открывается главная страница");
        MainPage mainPage = new MainPage();
        mainPage.waitForPageToLoad();
        Assert.assertEquals(mainPage.isOpenPage(),true,
                "Не удалось открыть Главную страницу");

        LoggerUtils.info("Нажимается кнопка Elements");
        mainPage.clickElementsButton();
        ElementsPage practicElementsPage = new ElementsPage();
        practicElementsPage.waitForPageToLoad();
        LoggerUtils.info("Нажимается кнопка Web Tables страницы Elements");
        practicElementsPage.clickButton(ButtonsFromAlertsAndFramesButton.WEB_TABLES);
        WebTablesPage practicWebTablesPage = new WebTablesPage();
        practicWebTablesPage.waitForPageToLoad();
        Assert.assertEquals(practicWebTablesPage.isOpenPage(),true,
                "Страница с формой Web Tables не открылась");

        LoggerUtils.info("Нажимается кнопка Add");
        practicWebTablesPage.clickAddButton();
        Assert.assertEquals(practicWebTablesPage.isDisplaidForm(),true,
                "На странице не появилась форма Registrarion Form");

        LoggerUtils.info("Вводятся в инпуты данные пользователя из тестовых данных");
        practicWebTablesPage.sendTextInInput(UserDataEnum.FIRST_NAME, data.getFirstName());
        practicWebTablesPage.sendTextInInput(UserDataEnum.LAST_NAME, data.getLastName());
        practicWebTablesPage.sendTextInInput(UserDataEnum.AGE, Integer.toString(data.getAge()));
        practicWebTablesPage.sendTextInInput(UserDataEnum.EMAIL, data.getEmail());
        practicWebTablesPage.sendTextInInput(UserDataEnum.SALARY, Integer.toString(data.getSalary()));
        practicWebTablesPage.sendTextInInput(UserDataEnum.DEPARTMENT, data.getDepartment());
        LoggerUtils.info("Нажимается кнопка Submit");
        practicWebTablesPage.clickSubmit();
        Assert.assertEquals(practicWebTablesPage.isNotDisplaidForm(),true,
                "Форма регистрации не закрылась");
        Assert.assertEquals(practicWebTablesPage.isUserInUserTable(data),true,
                "В таблице не появились данные пользователя User №");

        int countUsersBeforDeliteUser = practicWebTablesPage.getCountUsersFromUserTable();
        LoggerUtils.info("Выполняется удаление пользователя с определенными данными");
        practicWebTablesPage.deliteUser(data);
        int countUsersAfterDeliteUser = practicWebTablesPage.getCountUsersFromUserTable();
        Assert.assertNotEquals(countUsersAfterDeliteUser,countUsersBeforDeliteUser,
                "Количество записей в таблице не изменилось");
        Assert.assertEquals(practicWebTablesPage.isUserInUserTable(data),false,
                "Пользователь User № не удалился из таблицы");

    }
    @DataProvider
    public Object[][] getData() throws FileNotFoundException {

        JsonElement jsonData = JsonParser.parseReader(new FileReader("src/test/resources/dataSet.json")).getAsJsonObject();
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        List<UserDataModel> testData = new Gson().fromJson(dataSet, new TypeToken<List<UserDataModel>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}
