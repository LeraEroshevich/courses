
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.xml.sax.SAXException;

public class ParserXML {

    private WebDriver driver;
    private static ChromeOptions options;
    private static List<String> companySites;

    @BeforeAll
    static void downloadDriver(){
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeAll
    static void setupCompanySites() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        EmployeeHandler handler = new EmployeeHandler();

        parser.parse(new File(base + "/src/test/java/employee.xml"), handler);

        companySites = handler.getCompanySites();
    }

    @BeforeEach
    void startBrowser(){
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void closeDriver(){
        driver.close();
    }

    private static String base = System.getProperty("user.dir");

    @Test
    void parserXMLFile() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        EmployeeHandler handler = new EmployeeHandler();

        parser.parse(new File(base + "/src/test/java/employee.xml"), handler);

        List<String> companySites = handler.getCompanySites();
        for (String companySite : companySites) {
            driver.get(companySite);

            String currentUrl = driver.getCurrentUrl();
            Assertions.assertEquals(companySite, currentUrl);
        }
    }

    @Test
    void testInstanceOfCompanyEpam() {
        EpamPage epamPage = new EpamPage(driver);

        String url = companySites.get(0);
        EpamPage returnedPage = epamPage.open(url);

        Assertions.assertTrue(returnedPage instanceof EpamPage);
    }

    @Test
    void testInstanceOfCompanyItransition() {
        ItransitionPage itransitionPage = new ItransitionPage(driver);

        String url = companySites.get(1);
        ItransitionPage returnedPage = itransitionPage.open(url);

        Assertions.assertTrue(returnedPage instanceof ItransitionPage);
    }

    @Test
    void testInstanceOfCompanyWargaming() {
        WargamingPage wargamingPage = new WargamingPage(driver);

        String url = companySites.get(2);
        WargamingPage returnedPage = wargamingPage.open(url);

        Assertions.assertTrue(returnedPage instanceof WargamingPage);
    }
}
