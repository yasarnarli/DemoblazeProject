Feature:Login Test- The user should be able to login with valid credentials

  Background:Go to home page login
    Given The user is on the login page

  @loginWithoutParameters
  Scenario: Positive Scenario 1 - user should be able to login
    When The user enters valid credentials
    Then Verify "Welcome yusufn" message


  @loginWithParameters
  Scenario: Positive Scenario 2 - user should be able to login
    When The user enters "yusufn" and "test1234" and click login button
    Then Verify "Welcome yusufn" message


  @loginWithScenarioOutline
    Scenario Outline: Positive Scenario 3 - user should be able to login
    When The user enters "<username>" and "<password>" and click login button
    Then Verify "<welcomeUser>" message
      Examples:

    |username|password|welcomeUser|
    |yusufn|test1234|Welcome yusufn|


  @loginWithDataTableAndScenarioOutline
  Scenario Outline: Positive Scenario 4 - user should be able to login
    When The user enters valid username and password
    |username|<user>|
    |password|<password>|
    Then Verify "<welcomeUser>" message

    Examples:
    |user|password|welcomeUser|
    |yusufn|test1234|Welcome yusufn|



