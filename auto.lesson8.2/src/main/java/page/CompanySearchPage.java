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
        int maxAttempts = 5;
        int intervalMs = 1000;

        for (int i = 0; i < maxAttempts; i++) {
            boolean result = Boolean.parseBoolean(driver.findElement(By.xpath("//body")).getAttribute("aria-hidden"));
            if (result) {
                By iFrameLocator = By.xpath("//iframe[contains(@src, 'https://googleads.g.doubleclick.net/pagead/html/')]");
                List<WebElement> iFrames = driver.findElements(iFrameLocator);
                for (WebElement iFrame : iFrames) {
                    if (iFrame.getAriaRole().equals("Iframe")) {
                        driver.switchTo().frame(iFrame);
                        WebElement subIframe = driver.findElement(By.xpath("//iframe[@title='Advertisement']"));
                        driver.switchTo().frame(subIframe);
                        driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
                        driver.switchTo().defaultContent();
                    }
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

}
