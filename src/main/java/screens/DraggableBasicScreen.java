package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraggableBasicScreen extends BaseScreen{
    public DraggableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/drag_handle']")
    List<MobileElement> list;

    public DraggableBasicScreen dragDown() {
        MobileElement element = list.get(0);
        Rectangle rect = element.getRect();
        int xFrom = rect.getX() + rect.getWidth() / 2;// получаем середину ширины элемента по оси Х
        int yFrom = rect.getY() + rect.getHeight() / 2;//получаем середину высоты элемента по оси У,так мы получаем центр элемента

        int xTo = xFrom;
        int yTo = yFrom + rect.getHeight();

        TouchAction<?> touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(xFrom, yFrom))
                .moveTo(PointOption.point(xTo, yTo))
                .release()
                .perform();//задаем точку в которой  зажимаем элемент и двигаем его до определенной точки
        return this;
    }

    public DraggableBasicScreen dragDown(int index) {
        MobileElement element = list.get(index);
        Rectangle rect = element.getRect();
        int xFrom = rect.getX() + rect.getWidth() / 2;// получаем середину ширины элемента по оси Х
        int yFrom = rect.getY() + rect.getHeight() / 2;//получаем середину высоты элемента по оси У,так мы получаем центр элемента

        int xTo = xFrom;
        int yTo = yFrom + rect.getHeight();

        TouchAction<?> touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(xFrom, yFrom))
                .moveTo(PointOption.point(xTo, yTo))
                .release()
                .perform();//задаем точку в которой  зажимаем элемент и двигаем его до определенной точки
        return this;
    }


        public DraggableBasicScreen dragUp(int index) {
            MobileElement element = list.get(index);
            Rectangle rect = element.getRect();
            int xFrom =  rect.getX() + rect.getWidth()/2;// получаем середину ширины элемента по оси Х
            int yFrom = rect.getY() + rect.getHeight()/2;//получаем середину высоты элемента по оси У,так мы получаем центр элемента

            int xTo = xFrom;
            int yTo = yFrom - rect.getHeight();

            TouchAction<?>touchAction = new TouchAction(driver);
            touchAction.longPress(PointOption.point(xFrom, yFrom))
                    .moveTo(PointOption.point(xTo, yTo))
                    .release()
                    .perform();//задаем точку в которой  зажимаем элемент и двигаем его до определенной точки
            return this;
    }
}
