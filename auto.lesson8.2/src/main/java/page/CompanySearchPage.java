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

    public CompanySearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='page-branding-container']//div[@class='dev-left']//form//div[@id='tablesort_wrapper']//input[@type='text']")
    private WebElement inputName;
    @FindBy(xpath = "//table[@id='tablesort']//tbody[@role='alert']//tr[@class='even']//td[@class='Fitbit']")
    private WebElement fitbitCompanyElement;
    @FindBy(xpath = "//table[@id='tablesort']//tbody[@role='alert']//tr[@class='even']//td[@data='1500']")
    private WebElement fitbitEmployeeCountElement;
    @FindBy(xpath = "//table[@id='tablesort']//tbody[@role='alert']//tr[@class='odd']//td[@data='25']")
    private WebElement companyAboveFitbitElement;
    @FindBy(xpath = "//table[@id='tablesort']//tbody[@role='alert']//tr[@class='odd']//td[@data='335']")
    private WebElement companyBelowFitbitElement;

    public CompanySearchPage enterText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputName, text));
        inputName.clear();
        inputName.sendKeys(text);
        return new CompanySearchPage(driver);
    }

    public boolean fitbitFound() {
        WebElement companyElement = driver.findElement((By) fitbitCompanyElement);
        return companyElement.isDisplayed();
    }

    public boolean isEmployeeCountGreaterThanZero() {
        WebElement employeeCountElement = driver.findElement((By) fitbitEmployeeCountElement);
        int employeeCount = Integer.parseInt(employeeCountElement.getText());
        return employeeCount > 0;
    }

    public boolean isCompanyAboveHasEmployeeCountGreaterThanZero() {
        WebElement aboveEmployeeCountElement = companyAboveFitbitElement.findElement((By) companyAboveFitbitElement);
        int aboveEmployeeCount = Integer.parseInt(aboveEmployeeCountElement.getText());
        return aboveEmployeeCount > 0;
    }

    public boolean isCompanyBelowHasEmployeeCountGreaterThanZero() {
        WebElement belowEmployeeCountElement = companyBelowFitbitElement.findElement((By) companyBelowFitbitElement);
        int belowEmployeeCount = Integer.parseInt(belowEmployeeCountElement.getText());
        return belowEmployeeCount > 0;
    }
}
