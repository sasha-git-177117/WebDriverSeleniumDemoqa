package testing.util;

import framework.base.BaseElement;
import framework.util.LoggerUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testing.pages.enums.TableEnum;
import testing.pages.models.UserDataModel;

import java.util.ArrayList;
import java.util.List;

public class TableUtil extends BaseElement {
    private String tr;
    private String td;

    public TableUtil(By tableXPath, String name, String tr, String td) {
        super(tableXPath, name);
        this.td = td;
        this.tr = tr;
    }

    public ArrayList<UserDataModel> getData() {
        LoggerUtils.debug("Выполняется получение данных с таблицы "+ name+" и распределение их в лист моделей");
        ArrayList<ArrayList<String>> elements = new ArrayList<>();

        List<WebElement> list = findElements(By.xpath(tr));
        outerloop:
        for (WebElement itVar : list)
        {
            ArrayList<String> data = new ArrayList<>();
            for (WebElement it: itVar.findElements(By.xpath(td)))
            {
                if(it.getText().equals(" "))
                    break outerloop;
                data.add(it.getText());
            }
            elements.add(data);
        }
        ArrayList<ArrayList<String>> dates = elements;
        ArrayList<UserDataModel> dataArrayList = new ArrayList<>();

        for (ArrayList<String> data: dates) {
            UserDataModel dataTable = new UserDataModel();
            dataTable.setFirstName(data.get(TableEnum.FIRST_NAME.label));
            dataTable.setLastName(data.get(TableEnum.LAST_NAME.label));
            dataTable.setEmail(data.get(TableEnum.EMAIL.label));
            dataTable.setAge(Integer.parseInt(data.get(TableEnum.AGE.label)));
            dataTable.setSalary(Integer.parseInt(data.get(TableEnum.SALARY.label)));
            dataTable.setDepartment(data.get(TableEnum.DEPARTMENT.label));
            dataArrayList.add(dataTable);
        }
        return dataArrayList;
    }
}
