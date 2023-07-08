import component.Header;
import page.AboutPage;
import page.CompanySearchPage;
import page.MainPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DevByTest extends BaseTest {
    @Test
    void companySearchTest() {
        Header mainPage = new MainPage(getDriver())
            .open(MainPage.DEV_URL)
            .getHeader()
            .clickNavBar()
            .clickCompanyItem();

        CompanySearchPage companySearchPage = new CompanySearchPage(getDriver());
        companySearchPage.enterText("bit");
        // не проходит тест, не могу понять в чем дело, текст не вводится в строке, хотя путь верный и добавлен вейтер
        Assertions.assertTrue(companySearchPage.fitbitFound());
        Assertions.assertTrue(companySearchPage.isEmployeeCountGreaterThanZero());
        Assertions.assertTrue(companySearchPage.isCompanyAboveHasEmployeeCountGreaterThanZero());
        Assertions.assertTrue(companySearchPage.isCompanyBelowHasEmployeeCountGreaterThanZero());

        //тут будут описаны тесты с BIMSOLUTIONS, подскажите я правильно двигаюсь?
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
