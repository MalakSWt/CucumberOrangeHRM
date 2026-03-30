Feature: Login Functionality

  Scenario Outline: Valid login
    Given user is on login page
    When user enters "<username>" and "<password>"
    Then user should be navigated to dashboard

    Examples:
      | username | password |
      | Admin    | admin123 |

  Scenario Outline: Invalid login
    Given user is on login page
    When user enters "<username>" and "<password>"
    Then error message should be displayed

    Examples:
      | username | password |
      | Malak    | wrong    |

  Scenario: Login with empty fields
    Given user is on login page
    When user clicks login without entering credentials
    Then required error message should be displayed

  Scenario: Login with only username
    Given user is on login page
    When user enters username only
    Then required error message should be displayed

  Scenario: Login with only password
    Given user is on login page
    When user enters password only
    Then required error message should be displayed