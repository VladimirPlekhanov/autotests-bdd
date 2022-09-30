package atframework.steps;

import io.cucumber.java.After;
import atframework.drivermanagers.DriverManager;

public class ScenarioHooks extends DriverManager{

    /*@Before
    public void setupClass() {
        getDriver();
    }*/

    @After
    public void tearDown(){
        closeDriver();
    }
}
