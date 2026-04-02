Feature: Edit Employee

  Background:
    Given user has logged in with "Admin" and "admin123"
    And user is on "Add Employee" page
    When user enters first name "John" and last name "Doe"
    And user clicks save

  Scenario: Edit employee last name
    When user updates last name to "Smith" and click save
    Then employee name should be "John Smith"