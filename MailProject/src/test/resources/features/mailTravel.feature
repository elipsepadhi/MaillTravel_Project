Feature: Test scenarios on MailTravel project

  Scenario Outline: <scen_out_row_num>
    Given Step from '<scen_out_row_num>' in  feature file
    Examples:
      | scen_out_row_num |
      | chrome|
      | edge|

  Scenario: validate Homepage functionality
    Given user is on Homepage
    When user click on accept all the cookies
    Then user should search for <"ind"> in search bar

  Scenario: validate booking overview page
    Given user is on booking overview page
    When user click on book online button
    Then user should see a popup message
    When user selects departure date
    Then user should not be able to see the popup message
    When   select the num of person and takes a note of the airport
    Then  calculated price for <2> adults is displayed
    And user should able to see all details and click book button

  Scenario: validate booking details page
    Given user is on booking details page
    When user views date,departure & passenger section
    Then user should able to see all details
    And  details should match with booking details page and booking overview page
    When user select accommodation details
    Then user should able click on continue button

  Scenario: fill the passenger details
    Given  user is on passenger details section
    When  user fills the  passenger details of <1,"Mrs","mail","Travel",24, 3, 1997>
    And  user fills the  passenger details of <2,"Mr","online","book",12, 5, 1996>
    When user fills the contact details of <"1234455","mail@gmail.com","Add","Add2","city","789000">
    Then user should able to click on continue button

  Scenario:validate the conformation page
    When user is on conformation page
    Then user should click on Book Now button
