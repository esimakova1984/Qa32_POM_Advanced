package tests;

import config.AppiumConfiguration;
import org.testng.annotations.Test;
import screens.DragScreen;

public class DragTest extends AppiumConfiguration {

    @Test
    public void dragDown(){
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragDown(5);
    }

    @Test
    public void dragUp(){
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragUp(7);
    }
}
