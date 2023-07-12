package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanySearchPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='page-branding-container']//div[@class='dev-left']//form//div[@id='tablesort_wrapper']//input[@type='text']")
    private WebElement inputName;

    @FindBy(xpath = "//table[@id='tablesort']//tbody[@role='alert']//tr//td[@class=' ']")
    private WebElement companyNameElement;

    public CompanySearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CompanySearchPage enterText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(inputName)).click();
        inputName.clear();
        inputName.sendKeys(text);
        return this;
    }

    public boolean isCompanyDisplayed(String companyName) {
        return companyNameElement.findElement(By.xpath("//a[contains(text(), '" + companyName + "')]")).isDisplayed();
    }
}
