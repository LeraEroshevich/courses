import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

public class EmployeeSAXParserTest {

    @Test
    void testLastEmployeeJobsInDifferentRooms() throws ParserConfigurationException, SAXException, IOException {
        File xmlFile = new File("/src/test/java/employee.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        EmployeeHandler handler = new EmployeeHandler();

        parser.parse(xmlFile, handler);

        List<String> companySites = handler.getCompanySites();

        int lastIndex = companySites.size() - 1;

        Assertions.assertNotEquals(companySites.get(lastIndex), companySites.get(lastIndex - 1));
    }
}
