Feature: Organization module

@End2End
  Scenario Outline: As a user I want to create multiple organization and save and verify
    Given As a user I will launch browser
    And I will enter url
    And login page is displayed I will enter username "admin"  and password "manager"
    And Click on login
    And In home page click on organization
    When organization page is displayed click on create organization
    And In organization page enter organization name "<Oraganization>" and organization email "<Email>"
    Then click on save
    And Verify that organization name "<Oraganization>" and email should be "<Email>"

    Examples: 
      | Oraganization | Email               |
      | Google123     | www.goo@gmail.com   |
      | Microsoft123  | www.micro@gmail.com |
