package screens;

import config.AppiumConfiguration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SwipeadleBasicScreen extends BaseScreen {

    public SwipeadleBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container']")
    List<MobileElement> list;


    public SwipeadleBasicScreen swipeFromLeftToRight(int index) {
        MobileElement element = list.get(index);
        Rectangle rect = element.getRect();
        int xFrom = rect.getX();
        int yFrom = rect.getY() + rect.getHeight()/2;

        int xTo = xFrom + rect.getWidth();
        int yTo = yFrom;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom, yFrom))
                .moveTo(PointOption.point(xTo, yTo))
                .release()
                .perform();

        return this;
    }

    public SwipeadleBasicScreen swipeFromRightToLeft(int index) {
        MobileElement element = list.get(index);
        Rectangle rect = element.getRect();
        int xFrom = rect.getX() + rect.getWidth();
        int yFrom = rect.getY() + rect.getHeight()/2;

        int xTo = xFrom - rect.getWidth();
        int yTo = yFrom;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom, yFrom))
                .moveTo(PointOption.point(xTo, yTo))
                .release()
                .perform();

        return this;
    }
}
