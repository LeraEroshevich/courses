import page.JetbrainsPage;
import page.RubyMinePage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RubyMineTest extends BaseTest{

    @Test
    void checkTextVisibilityTest() {
        RubyMinePage rubyminePage = new JetbrainsPage(getDriver())
            .open("https://www.jetbrains.com/")
            .getHeader()
            .clickDeveloperTools()
            .clickRubyMineItem();

        String titleText = rubyminePage.getTextRubyMine();
        Assertions.assertEquals(titleText, "The Most Intelligent Ruby and Rails IDE ");

    }
}
