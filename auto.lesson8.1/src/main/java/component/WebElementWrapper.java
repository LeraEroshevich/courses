package component;

import org.openqa.selenium.WebElement;

public interface WebElementWrapper {
    WebElement getWrappedElement();

    void enterSearchTerm(String searchTerm);

    void performSearch();
}

