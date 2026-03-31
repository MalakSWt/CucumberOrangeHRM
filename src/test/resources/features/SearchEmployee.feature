Feature: Search Employee

  Background:
    Given user has logged in with "Admin" and "admin123"

  Scenario: Search employee by name
    When user navigates to PIM page
    And user searches for employee "John"
    Then employee "John" should appear in search results