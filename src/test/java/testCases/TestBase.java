package testCases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public static final String INVALID_CITY_WITH_RANDOM_ALPHABETS = "abdcdefgh";
    public static final String VALID_CITY_WITH_VALID_COUNTRY = "Bangalore, IN";
    public static final String INVALID_CITY_WITH_SPECIAL_CHARS = "^&**&&^&^&*&";
    public static final int CITY_POSITION = 10;

    public static AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public static void Android_Setup() throws MalformedURLException {
        File appDir = new File("src");
        File app = new File(appDir, "MobileAssignment.apk");
        DesiredCapabilities android_CAPS = new DesiredCapabilities();
        android_CAPS.setCapability(MobileCapabilityType.DEVICE_NAME, "Spull_Redmi7");
        android_CAPS.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        android_CAPS.setCapability(MobileCapabilityType.UDID, "4acb68c8");
        android_CAPS.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(url, android_CAPS);
    }

    @AfterTest
    public void androidDriverTeardown()
    {
        driver.quit();
    }

}
