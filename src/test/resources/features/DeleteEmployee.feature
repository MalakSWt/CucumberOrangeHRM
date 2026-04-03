Feature: Delete Employee

  Background:
    Given user has logged in with "Admin" and "admin123"
    And user navigates to PIM page
    When user searches for employee ID "0515"

  Scenario: Delete existing employee
    When user deletes the employee
    Then employee should be deleted successfully