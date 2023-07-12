import java.util.stream.Stream;

import component.Header;
import page.AboutPage;
import page.CompanySearchPage;
import page.MainPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

public class DevByTest extends BaseTest {
    @ParameterizedTest
    @MethodSource("companySearchDataProvider")
    void companySearchTest(String searchText, String expectedCompany) {
        WebDriver driver = getDriver();

        CompanySearchPage mainPage = new MainPage(driver)
            .open(MainPage.DEV_URL)
            .getHeader()
            .clickNavBar()
            .clickCompanyItem();

        CompanySearchPage companySearchPage = new CompanySearchPage(driver);
        companySearchPage.enterText(searchText);
        Assertions.assertTrue(companySearchPage.isCompanyDisplayed(expectedCompany));

    }

    private static Stream<Arguments> companySearchDataProvider() {
        return Stream.of(
            Arguments.of("bit", "Fitbit"),
            Arguments.of("solution", "BIMSOLUTIONS")
        );
    }

    @Test
    void visibilityAboutCompanyTest() {
        Header mainPage = new MainPage(getDriver())
            .open(MainPage.DEV_URL)
            .getHeader()
            .clickNavBar()
            .clickAboutItem();
        AboutPage aboutPage = new AboutPage(getDriver());
        Assertions.assertTrue(aboutPage.isTitleVisible(), "Заголовок 'О проекте' не виден.");
    }
}
