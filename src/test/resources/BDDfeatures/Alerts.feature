Feature: Validate Alerts 

@Regression
  Scenario: validate Confirm Box Alert
    Given User is on Alerts Page
    Then I validate the title
    When user click on alert with OK and cancel
    And click the button to display a confirm box
    Then Validate Alert PopUp Appears
    And validate Text Of Confirm Box Alert
    When user perform click on OK button of confirm box alert
    Then Validate You pressed OK is displayed
           
