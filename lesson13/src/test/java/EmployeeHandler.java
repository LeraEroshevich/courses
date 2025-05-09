import java.util.ArrayList;
import java.util.List;


import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class EmployeeHandler extends DefaultHandler {

    private List<String> companySites;

    public EmployeeHandler() {
        companySites = new ArrayList<>();
    }

    public List<String> getCompanySites() {
        return companySites;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("employee")){
            String companySite = attributes.getValue("companySite");
            companySites.add(companySite);
        }
    }
}
