Feature: User login module

Background: 
Given As a user I will lauch browser
    And Enter the url

@SmokeTest
  Scenario: As a valid user I will provide valid credentials for login
    When login page is displayed I will enter username and password
    And Click on login
    Then Home page should display
    And Also I will verify that Home Page title

    @Functional @RegressionTest
    Scenario: As a user I will enter invalid username and valid password home page should not display
    When login page is displayed I will enter username "admin123" and password "manager"
    And Click on login
    Then Error message should display for user
    
    @RegressionTest
    Scenario: As a user I will enter invalid username and password user should not navigate to home page
    Given As user I will launch browser "chrome"
    And Enter the url "http://localhost:8888/"
    When login page is displayed I will Enter invalid username "admin123" and password "manager123"
    And click on login
    Then Error message should display for a user "You must specify a valid username and password."
    
    
