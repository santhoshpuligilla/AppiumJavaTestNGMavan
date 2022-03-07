package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GoogleMapsPage extends PageBase {

    public GoogleMapsPage(AppiumDriver<AndroidElement> driver) {
        super((AndroidDriver<AndroidElement>) driver);
    }

    @AndroidFindBy(id = "app.com.mobileassignment:id/insert_point")
    public AndroidElement getInsertPoint;
}
