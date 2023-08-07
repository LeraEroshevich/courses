package page;

import java.time.Duration;
import java.util.List;

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
        wait.until(ExpectedConditions.elementToBeClickable(inputName));
        inputName.clear();
        inputName.sendKeys(text);
        wait.until(ExpectedConditions.textToBePresentInElementValue(inputName, text));
        return this;
    }

    public boolean isCompanyDisplayed(String companyName) {

        return companyNameElement.findElement(By.xpath("//a[contains(text(), '" + companyName + "')]")).isDisplayed();
    }

    public boolean isEmployeeCountGreaterThanZero(String companyName) {
        List<WebElement> companyRows = driver.findElements(By.xpath("//tr[@class='odd' or @class='even']"));

        for (int i = 0; i < companyRows.size(); i++) {
            WebElement companyElement = companyRows.get(i).findElement(By.xpath(".//td[@data]"));
            String companyNameText = companyElement.getText().trim();

            if (companyNameText.equals(companyName)) {
                WebElement employeesElement = companyRows.get(i).findElement(By.xpath(".//td[@class='t-left ']"));
                int employeeCount = Integer.parseInt(employeesElement.getText());
                return employeeCount > 0;
            }
        }

        return false;
    }

    public boolean isCompanyAboveHasEmployeesGreaterThanZero(String companyName) {
        List<WebElement> companyRows = driver.findElements(By.xpath("//tr[@class='odd' or @class='even']"));

        for (int i = 0; i < companyRows.size(); i++) {
            WebElement companyElement = companyRows.get(i).findElement(By.xpath(".//td[@data]"));
            String companyNameText = companyElement.getText().trim();

            if (companyNameText.equals(companyName)) {
                int companyAboveIndex = i - 1;
                if (companyAboveIndex >= 0) {
                    WebElement employeesElement = companyRows.get(companyAboveIndex).findElement(By.xpath(".//td[@class='t-left ']"));
                    int employeeCount = Integer.parseInt(employeesElement.getText());
                    return employeeCount > 0;
                }
                break;
            }
        }

        return false;
    }

    public boolean isCompanyBelowHasEmployeesGreaterThanZero(String companyName) {
        List<WebElement> companyRows = driver.findElements(By.xpath("//tr[@class='odd' or @class='even']"));

        for (int i = 0; i < companyRows.size(); i++) {
            WebElement companyElement = companyRows.get(i).findElement(By.xpath(".//td[@data]"));
            String companyNameText = companyElement.getText().trim();

            if (companyNameText.equals(companyName)) {
                int companyBelowIndex = i + 1;
                if (companyBelowIndex < companyRows.size()) {
                    WebElement employeesElement = companyRows.get(companyBelowIndex).findElement(By.xpath(".//td[@class='t-left ']"));
                    int employeeCount = Integer.parseInt(employeesElement.getText());
                    return employeeCount > 0;
                }
                break;
            }
        }

        return false;
    }

    public CompanySearchPage closeAdvertisementIfPresent() {
        By closeButtonLocator = By.xpath("//div[@aria-label='Закрыть рекламу']");
        int maxAttempts = 5;
        int intervalMs = 1000;

        for (int i = 0; i < maxAttempts; i++) {
            WebElement closeButton = findElement(closeButtonLocator);

            if (closeButton != null) {
                WebElement outerIframe = findElement(By.xpath("//iframe[@id='google_esf']"));
                if (outerIframe != null) {
                    driver.switchTo().frame(outerIframe);

                    WebElement innerIframe = findElement(By.xpath("//iframe[@id='aswift_2']"));
                    if (innerIframe != null) {
                        driver.switchTo().frame(innerIframe);

                        WebElement secondInnerIframe = findElement(By.xpath("//iframe[@title='Advertisement']"));
                        if (secondInnerIframe != null) {
                            driver.switchTo().frame(secondInnerIframe);
                        }
                    }

                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                    wait.until(ExpectedConditions.elementToBeClickable(closeButton));

                    closeButton.click();
                    driver.switchTo().defaultContent();
                    break;
                }

                try {
                    Thread.sleep(intervalMs);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return this;
    }

    private WebElement findElement(By locator) {
        try {
            return driver.findElement(locator);
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return null;
        }
    }
}
