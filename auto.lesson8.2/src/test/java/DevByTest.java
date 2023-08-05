import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import component.Header;
import page.AboutPage;
import page.CompanySearchPage;
import page.MainPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

@Execution(ExecutionMode.CONCURRENT)
public class DevByTest extends BaseTest {
    @ParameterizedTest
    @MethodSource("companySearchDataProvider")
    void companySearchTest(String searchText, String expectedCompany) {
        WebDriver driver = getDriver();
        CompanySearchPage companySearchPage = new MainPage(driver)
            .open(MainPage.DEV_URL)
            .getHeader()
            .clickNavBar()
            .clickCompanyItem()
            .closeAdvertisementIfPresent();

        companySearchPage.enterText(searchText);
        Assertions.assertTrue(companySearchPage.isCompanyDisplayed(expectedCompany));
        Assertions.assertTrue(companySearchPage.isEmployeeCountGreaterThanZero(expectedCompany));
        companySearchPage.closeAdvertisementIfPresent();

        boolean isAboveHasEmployees = companySearchPage.isCompanyAboveHasEmployeesGreaterThanZero(expectedCompany);
        boolean isBelowHasEmployees = companySearchPage.isCompanyBelowHasEmployeesGreaterThanZero(expectedCompany);

        Assertions.assertTrue(isAboveHasEmployees);
        Assertions.assertTrue(isBelowHasEmployees);
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
        assertTrue(aboutPage.isTitleVisible(), "Заголовок 'О проекте' не виден.");
    }
}
