Feature: conatct module

  Scenario: As a user I want create a new contact
    Given I will Launch browser
    And enter the url
    And login page is dispalyed I will Enter username "admin" and password "manager"
    And click on login
    When home page is displayed click on contact
    And click on create contact
    And enter contact name conatct email and contact phone
      | lastName | email                   | phone      |
      | Nithesh  | nitheshhs123@gmailc.com | 1234567890 |
    And click on save
    Then verify contact name conatct email and conatct phone
    And close the browser
