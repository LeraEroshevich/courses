package lesson.step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumStepDefinition {
    @Given("I maximize window")
    public void maximizeWindow() {
    BaseStep.driver.manage().window().maximize();
}
    By confTextLocator = By.xpath("//header//a[@href='https://www.youtube.com/playlist?list=PLRdSclUtJDYXDEsWI0vwBmJxW17NgsaAk']//parent::h4");
    By confLinkLocator = By.xpath("//header//a[@href='https://www.youtube.com/playlist?list=PLRdSclUtJDYXDEsWI0vwBmJxW17NgsaAk']");

    @Given("I navigate to url {string}")
    public void navigateTo(String url){
        BaseStep.driver.get(url);
    }



    @When("I click to the Documentation tab")
    public void clickToTheDocumentationTab() {
        BaseStep.driver.findElement(By.xpath("//header//a[@href='/documentation']")).click();
    }

    @Then("I Verify That text {string} is show")
    public void verifyThatTextSeleniumConfChicagoIsAWrapWatchTheVideosIsShow(String text) {
        WebElement confText = BaseStep.driver.findElement(confTextLocator);

        Assertions.assertEquals(text, confText.getText());
    }
}
