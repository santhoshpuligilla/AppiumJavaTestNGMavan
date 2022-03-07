package testCases;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import pageObjects.GoogleMapsPage;
import pageObjects.HomePage;


public class testCasesMobileAssignment extends TestBase{

    HomePage homePage;
    GoogleMapsPage googleMapsPage;

    @Test
    public void test_01_homePage_is_displayed() {
        homePage = new HomePage(driver);
        homePage.isItemDisplayed(homePage.homePageTitle);
        homePage.isItemDisplayed(homePage.citiesListView);
        System.out.println("Home Page displayed properly");
    }

    @Test
    public void test_02_CityListInHomeViewIsScrollable() {
        homePage = new HomePage(driver);
        driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(10)" +
                                ".scrollIntoView(new UiSelector().text(\"Aast, FR\"))"));
        System.out.println("City List is Scrollable, and test Case is Passed");
    }

    @Test
    public void test_03_CitySearchWhichIsNotPartOfList() {
        homePage = new HomePage(driver);
        try {
            homePage.citySearchField.clear();
            homePage.citySearchField.sendKeys(INVALID_CITY_WITH_RANDOM_ALPHABETS);
            homePage.citiesListView.isDisplayed();
        } catch (NoSuchElementException EX) {
            System.out.println("City with random alphabets is not available");
        }
    }

    @Test
    public void test_04_SearchCityNameAlongWithCountryCode() {
        homePage = new HomePage(driver);

        homePage.citySearchField.clear();
        homePage.citySearchField.sendKeys(VALID_CITY_WITH_VALID_COUNTRY);
        homePage.cityBangaloreIN.isDisplayed();
        System.out.println("City with valid City and Country is available, and test Case is Passed");

    }

    @Test
    public void test_05_SearchCityNameByEnteringSpecialCharacters() {
        homePage = new HomePage(driver);

        try {
            homePage.citySearchField.clear();
            homePage.citySearchField.sendKeys(INVALID_CITY_WITH_SPECIAL_CHARS);
            homePage.citiesListView.isDisplayed();
        } catch (NoSuchElementException EX) {
            System.out.println("City with special characters is not available, and test Case is Passed");
        }
    }

    @Test
    public void test_06_SwitchToMapViewFromHomeView() {
        homePage = new HomePage(driver);
        googleMapsPage = new GoogleMapsPage(driver);

        homePage.citySearchField.clear();
        homePage.citiesList.get(CITY_POSITION).click();
        googleMapsPage.isItemDisplayed(googleMapsPage.getInsertPoint);
        System.out.println("Google map view is displayed, and test case is Passed");
    }
}
