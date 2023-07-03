import page.JetbrainsPage;
import page.PyCharmPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class PyCharmTest extends BaseTest{

    @Test
    void checkTextVideoTitleTest() {
        PyCharmPage pyCharmPage = new JetbrainsPage(getDriver())
            .open("https://www.jetbrains.com/")
            .getHeader()
            .clickDeveloperTools()
            .clickPyCharmPage()
            .clickBtnTakeVideo();

        String titleText = pyCharmPage.getTextVideoTitle();
        Assertions.assertEquals(titleText, "WebStorm Overview 2021");
        // Видео недосупно
    }

    @Test
    void checkBtnDownload() {
        PyCharmPage pyCharmPage = new JetbrainsPage(getDriver())
            .open("https://www.jetbrains.com/")
            .getHeader()
            .clickDeveloperTools()
            .clickPyCharmPage();

        WebElement downloadButton = pyCharmPage.getDownloadButton();
        boolean isDownloadButtonEnabled = downloadButton.isEnabled();
        Assertions.assertTrue(isDownloadButtonEnabled, "Download button is disabled.");
    }
}
