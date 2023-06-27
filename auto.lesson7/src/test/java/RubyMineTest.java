import component.Header;
import page.JetbrainsPage;

import org.junit.jupiter.api.Test;

public class RubyMineTest extends BaseTest{

    @Test
    void checkTextVisibilityTest() {
        Header jetbrainsPage = new JetbrainsPage(getDriver())
            .open("https://www.jetbrains.com/")
            .getHeader()
            .clickDeveloperTools()
            .clickRubyMineItem()
            .getText


    }
}
