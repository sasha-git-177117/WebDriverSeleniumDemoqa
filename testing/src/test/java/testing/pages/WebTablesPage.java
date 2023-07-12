package testing.pages;

import framework.util.LoggerUtils;
import org.openqa.selenium.By;
import testing.pages.enums.UserDataEnum;
import testing.pages.models.UserDataModel;
import framework.base.BaseForm;
import framework.seleniumobjects.Button;
import framework.seleniumobjects.Form;
import framework.seleniumobjects.Input;
import testing.util.TableUtil;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class WebTablesPage extends BaseForm {
    private static final By CHECK_ELEMENT = By.xpath("//*[contains(@class,'web-tables-wrapper')]");
    private static final By BY_ADD_BUTTON = By.xpath("//*[@id='addNewRecordButton']");
    private static final By BY_MAIN_FORM = By.xpath("//*[@id='registration-form-modal']");
    private static final By BY_SUBMIT_BUTTON = By.xpath("//*[@id='submit']");
    private static final By BY_USERS_TABLE = By.xpath("//*[contains(@class,'rt-table')]");
    private static final By BY_DELITE_BUTTON = By.xpath("//*[contains(@id,'delete-record')]");
    private static final String TR_FROM_USER_TABLE = "//*[contains(@class,'rt-tr-group')]//*[contains(@class,'tr')]";
    private static final String TD_FROM_USER_TABLE = "./descendant::*[contains(@class,'td')]";
    private static final Button ADD_BUTTON = new Button(BY_ADD_BUTTON,"addButton");
    private static final Button SUBMIT_BUTTON = new Button(BY_SUBMIT_BUTTON,"submitButton");
    private static final Button DELITE_BUTTON = new Button(BY_DELITE_BUTTON,"deliteButton");
    private static final String FMT_USER_DATA_FIELD = "//*[@id='%s']";
    private static final Form MAIN_FORM = new Form(BY_MAIN_FORM,"mainForm");
    private static final TableUtil USERS_TABLE =
            new TableUtil(BY_USERS_TABLE,"usersTable", TR_FROM_USER_TABLE, TD_FROM_USER_TABLE);

    public WebTablesPage(){
        super(CHECK_ELEMENT);;
    }

    public void clickAddButton() {
        LoggerUtils.info("Нажимается кнопка "+ ADD_BUTTON.getName());
        ADD_BUTTON.click();
    }

    public void sendTextInInput(UserDataEnum element, String text) {
        Input userDataField = new Input(By.xpath(String.format(FMT_USER_DATA_FIELD, element.label)),element.toString());
        LoggerUtils.info("Вводится текст в инпут "+ userDataField.getName());
        userDataField.sendText(text);
    }

    public boolean isDisplaidForm() {
        LoggerUtils.info("Ожидается и проверяется наличие на странице формы "+ MAIN_FORM.getName());
        return MAIN_FORM.checkAndWaitPresenceOfAllElementsLocatedBy();
    }

    public boolean isNotDisplaidForm() {
        LoggerUtils.info("Ожидается и проверяется отсутствие на странице формы "+ MAIN_FORM.getName());
        return MAIN_FORM.checkAndWaitNotPresenceOfAllElementsLocatedBy();
    }

    public void clickSubmit() {
        LoggerUtils.info("Нажимается кнопка "+ SUBMIT_BUTTON.getName());
        SUBMIT_BUTTON.click();
    }

    public ArrayList<UserDataModel> parseDataFromTableToUserModels() {
        LoggerUtils.info("Выполняется получение данных с таблицы "+ USERS_TABLE.getName());
        return USERS_TABLE.getData();
    }

    public int getFirstFindIndexUserFromTable(UserDataModel userData) {
        ArrayList<UserDataModel> userDataArrayList = parseDataFromTableToUserModels();
        LoggerUtils.info("Выполняется поиск индекса пользователя в списке пользователей "+ USERS_TABLE.getName());
            return IntStream.range(0, userDataArrayList.size())
                    .filter(i -> userData.equals(userDataArrayList.get(i)))
                    .findFirst()
                    .orElse(-1);
    }

    public boolean isUserInUserTable(UserDataModel userData) {
        LoggerUtils.info("Выполняется проверка существования пользователя в списке пользователей "+ USERS_TABLE.getName());
        return getFirstFindIndexUserFromTable(userData) > -1;
    }

    public void deliteUser(UserDataModel userData) {
        int index = getFirstFindIndexUserFromTable(userData);
        LoggerUtils.info("Нажимается кнопка" + DELITE_BUTTON.getName() +
                " и выполняется удаление пользователя в списке пользователей "+ USERS_TABLE.getName());
        DELITE_BUTTON.getElements().get(index).click();
    }

    public int getCountUsersFromUserTable() {
        LoggerUtils.info("Выполняется подсчет количества записей в таблице "+ USERS_TABLE.getName());
        return parseDataFromTableToUserModels().size();
    }
}
