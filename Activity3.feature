@multipleCandidate
Feature: multipleCandidate
 
  @tag1
  Scenario Outline: multipleCandidate
    Given Log in
    When Create employees with "<firstname>" and "<lastname>" and "<UserName>"
    Then verify the employee "<firstname>"
    

 Examples:
| firstname| lastname |UserName  |
| user4    | surname4 |UserName4 |
| user5    | surname5 |UserName5 |
| user6    | surname6 |UserName6 |