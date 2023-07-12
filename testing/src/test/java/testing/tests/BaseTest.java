package testing.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import framework.driverutil.WebDriverSingleton;

abstract public class BaseTest {

    @BeforeMethod
    public void setupClass() {
        WebDriverSingleton.getInstance();
        WebDriverSingleton.openURl();
    }

    @AfterMethod
    public void tearDown(){
        WebDriverSingleton.quit();
    }

}
