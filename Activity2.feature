@Activity2
Feature: Addding candidate
  

  @tag1
  Scenario: Recruitement
    Given User Log in to HRM
    When Add candidate
    Then validate the candidate entry
    And Close browser
