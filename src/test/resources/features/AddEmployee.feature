Feature: Add Employee Functionality

  Background:
    Given user has logged in with "Admin" and "admin123"

  Scenario: Add a new employee with valid data
    Given user is on "Add Employee" page
    When user enters first name "John" and last name "Doe"
    And user clicks save
    Then employee "John Doe" should be listed in the employee table

  Scenario: Add employee with empty first name
    Given user is on "Add Employee" page
    When user enters last name "Doe" only
    And user clicks save
    Then error message should be displayed for first name

  Scenario: Add employee with empty last name
    Given user is on "Add Employee" page
    When user enters first name "John" only
    And user clicks save
    Then error message should be displayed for last name


  Scenario Outline: Add multiple employees
    Given user is on "Add Employee" page
    When user enters first name "<firstName>" and last name "<lastName>"
    And user clicks save
    Then employee "<firstName> <lastName>" should be listed in the employee table

    Examples:
      | firstName | lastName |
      | Alice     | Smith    |
      | Bob       | Brown    |