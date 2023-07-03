package component;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SearchInput implements WebElementWrapper {
    private final WebElement element;

    public SearchInput(WebElement element) {
        this.element = element;
    }

    @Override
    public void enterSearchTerm(String searchTerm) {
        element.sendKeys(searchTerm);
    }

    @Override
    public void performSearch() {
        element.sendKeys(Keys.ENTER);
    }

    @Override
    public WebElement getWrappedElement() {
        return element;
    }
}
