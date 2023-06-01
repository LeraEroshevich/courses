Feature: Line text is SeleniumConf Chicago 2023 is a wrap! Watch the Videos

  Background: Precondition
    Given I maximize window

  Scenario: Navigate to Selenium Dev and check SeleniumConf information
    Given I navigate to url 'https://www.selenium.dev/'
    When I click to the Documentation tab
    Then I Verify That text 'SeleniumConf Chicago 2023 is a wrap! Watch the Videos' is show