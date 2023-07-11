import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomParser {

    @Test
    void testLastEmployeeJob() throws ParserConfigurationException {
        File xmlFile = new File("/src/test/java/employee.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);

            Element root = document.getDocumentElement();
            NodeList officeList = root.getElementsByTagName("office");

            Element lastOffice = (Element) officeList.item(officeList.getLength() - 1);
            NodeList employeeList = lastOffice.getElementsByTagName("employee");

            Element lastEmployee = (Element) employeeList.item(employeeList.getLength() - 1);
            String job = lastEmployee.getAttribute("job");

            Assertions.assertEquals("Senior", job);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
