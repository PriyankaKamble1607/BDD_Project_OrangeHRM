@multiplevacancy
Feature: Creating multile vacancies
  
  @tag1
  Scenario: Creating multiple vacancy
    Given Logged in
    When Added multiple recruitement
       |Android Developer|Developer1.1|user4 surname4|
       |Automation Test Engineer|Tester1.1|user5 surname5|
       |DevOps Engineer|Engineer1.1|user6 surname6|
    Then validate the recruitement
    |Developer1.1|
    |Tester1.1|
    |Engineer1.1|
    

  