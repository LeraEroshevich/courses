package component;

import org.openqa.selenium.WebElement;

public class SearchInput {

    private WebElement searchInput;

    public SearchInput(WebElement searchInput) {
        this.searchInput = searchInput;
    }

    public void enterSearchTerm(String searchTerm) {
        searchInput.sendKeys(searchTerm);
    }

    public void performSearch() {
        searchInput.submit();
    }
}
