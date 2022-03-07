package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;


public class HomePage extends PageBase {

    public HomePage(AppiumDriver<AndroidElement> driver) {
        super((AndroidDriver<AndroidElement>) driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mobile Assignment']")
    public AndroidElement homePageTitle;

    @AndroidFindBy(id = "citiesList")
    public AndroidElement citiesListView;

    @AndroidFindBy(id = "search")
    public AndroidElement citySearchField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bangalore, IN']")
    public AndroidElement cityBangaloreIN;

    @AndroidFindBy(id = "app.com.mobileassignment:id/cityName")
    public List<AndroidElement> citiesList;


}
