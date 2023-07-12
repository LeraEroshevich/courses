import page.HomePage;
import page.ShowPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

public class RelaxByTask1Test {

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    void checkShowTitleTest(String showType, String expectedTitle) {
        HomePage homePage = new HomePage();
        homePage.openHomePage();

        ShowPage showPage = homePage.selectShowType(showType);

        Assertions.assertTrue(showPage.isTitleVisible(expectedTitle));
    }


}
