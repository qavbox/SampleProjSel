Feature: SauceDemo login
  #install gherkin & cucumber for java plugin

  @ignore1
  Scenario: Login validation on saucedemo
    Given user is on saucedemo login page
    When enter username
    And enter password
    And click on login
    Then validate user is on product details page
    And close the browser


  @ignore2
  Scenario: Login validation on saucedemo with variable
    Given user is on saucedemo login page
    When enter username as "standard_user"
    And enter password as "secret_sauce"
    And click on login
    Then validate user is on product details page
    And close the browser

  @run
  Scenario: Login validation on saucedemo with variable
    Given user is on saucedemo login page
    When enter username & password
      |username|password|
      | standard_user | secret_sauce |
      | standard_user1 | secret_sauce1 |
    And click on login
    Then validate user is on product details page
    And close the browser
    #this will run once irrespective of no of rows of data


  @first
  Scenario Outline: Login validation on saucedemo with examples
    Given user is on saucedemo login page
    When enter username as <username>
    And enter password as <password>
    And click on login
    Then validate user is on product details page
    And close the browser
    #this scenario outline will run multiple times of the no of rows of data
    Examples:
      |username |password |
      |standard_user |secret_sauce |