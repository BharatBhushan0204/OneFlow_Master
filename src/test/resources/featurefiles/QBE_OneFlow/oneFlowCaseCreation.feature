Feature: Case workflow management

  #Author: Bharat Bhushan
  #Sprint 1, Sprint 2
  #Epic : 
  #Verify Case routing to Complex work basket
  #Verify Case routing to Exception work basket
  #Verify that the case is routing to specific user depends on product code scenarios are covering following no of testcase coverage, 
  #Test case coverage || Total TC's - 871 || Total automated TC's - 557
  @smoke
  Scenario Outline: Verify Case routing to Complex work basket
    Given Open the browser and navigate to particular url
    Given User send a mail to QBE with subject "<keywordinsubject>" and "<policyorquotenoinsubject>"
    When I enter valid username  "<username>" and "<password>" click on Login button
    Then Login should be successfully completed
    Then Open the case and verify the case is routed to complex work basket with "<keywordinsubject>" and "<policyorquotenoinsubject>"
    Then click on logout link and close the browser

    Examples: 
      | username | password  | keywordinsubject | policyorquotenoinsubject |
      | triager  | OF@123456 | QI 1234567 MVA   | QI 1234567 PLB           |
     # | triager  | OF@123456 | QI 1234567 PAD   | QI 1234567 PLB           |
     # | triager  | OF@123456 | QI 1234567 ISR   | QI 1234567 PLB           |
     
     
  #Author: Bharat Bhushan
  @smoke
  Scenario Outline: Verify Case routing to Exception work basket
    Given Open the browser and navigate to particular url
    Given User send a mail to QBE with subject "<keywordinsubject>" and "<policyorquotenoinsubject>"
    When I enter valid username  "<username>" and "<password>" click on Login button
    Then Login should be successfully completed
    Then Open the case and verify the case is routed to exception work basket with "<keywordinsubject>" and "<policyorquotenoinsubject>"
    Then click on logout link and close the browser

    Examples: 
      | username | password  | keywordinsubject | policyorquotenoinsubject |
      | triager  | OF@123456 | Test             | Test                     |
      
      
  #Author: baburao.lunavath@qbe.com
  #Sprint 2 and Sprint 3
  #Test case coverage || Total TC's - 23 || Total automated TC's - 23
  @smoke
  Scenario Outline: Information Note verification for complex or exception workbasket
    Given Open the browser and navigate to particular url
    When I enter valid username  "<username>" and "<password>" click on Login button
    Then Login should be successfully completed
    When verify cases routing to complex workbasket
    When click on case when user navigate to list of cases screen
    Then verify information note available at top of the page
    When verify information note for ExceptionWB cases
    Then click on logout link and close the browser

    Examples: 
      | username | password  |
      | triager  | OF@123456 |
      
      
  #Author Bharat Bhushan
  #Sprint 1 Sprint 3
  #User Story Descrc
  #Test case coverage || Total TC's - 59 || Total automated TC's - 47
  @smoke
  Scenario Outline: Verify that the CSO has ability to create a case manually
    Given Open the browser and navigate to the url
    When I enter valid username  "<username>" and "<password>" click on Login button
    Then Login should be successfully completed
    And Click on New Button
    When Click on Transaction Request button
    Then Capture request details screen is displayed
    Then Get the Case ID which is a transaction request
    And Verify the request type drop down have proper values and select "<requesttype>"
    And Verify the Policy Status drop down have expected values and select "<policyStatus>"
    And Enter Cliam ID as "<claimID>"
    And Enter Insured Name as "<insuredname>"
    And Enter Underwriter Name as "<underwritername>"
    And Verify Under writer region drop down values and select "<underwriterregion>"
    And Provide Expiration and Received date if the requirest type is as "<requesttype>"
    And Select the type as "<type>"
    And Enter valid policy or quote no as "<policyorquoteno>"
    And Click on Submit button to close the case
    Then The case resolution is displayed as "<ResolvedCompleted>"
    Then click on logout link and close the browser

    Examples: 
      | username  | password  | requesttype       | policyStatus | claimID    | insuredname | underwritername | underwriterregion | type   | policyorquoteno | ResolvedCompleted  |
      | PADUser_1 | OF@123456 | OFS Closing Check | Open         | AN 1234567 | Bharat      | Bhushan         | ACT               | Policy | AB A234567 PLB  | RESOLVED-COMPLETED |

      

  #Author Bharat
  #Sprint 1 and Sprint 2
  #This scenario is also related to routing
  @smoke
  Scenario Outline: Verify that the case is routing to specific user depends on product code
    Given Open the browser and navigate to the url
    Given Login to two user one after another and get the sum of priorities of the each user with respect to "<keywordinsubject>" and "<policyorquotenoinsubject>"
    Given User send a mail to QBE with subject "<keywordinsubject>" and "<policyorquotenoinsubject>"
    Then Login to the user which has low work load
    Then Login should be successful
    And Click on refresh button
    And Sort the list of cases with recent created case
    Then Open the case and verify that the case is created and routed to user properly and priority with "<priority>".
    Then The Request Type is autopopulated as per the expected request type "<expectedrequesttype>"
    And The Type is displayed as per the expected type "<type>"
    And The Policy or Quote number is autopopulated as it is available in the mail "<policyorquotenoinsubject>"
    Then click on logout link and close the browser

    Examples: 
      | keywordinsubject | policyorquotenoinsubject | expectedrequesttype | type   | priority |
      | closing check    | AB-A1234B9-MVA           | Closing Check       | Policy |       30 |
  #    | loss history     | Q-12345678-PAD           | Claims Experience   | Quote  |          |

 
  #Author: baburao.lunavath@qbe.com
  #Sprint 2
  #Test case coverage || Total TC's - 4 || Total automated TC's - 4
  @smoke
  Scenario Outline: GetNext work scenario varification
    Given Open the browser and navigate to particular url
    When I enter valid username  "<username>" and "<password>" click on Login button
    Then Login should be successfully completed
    When validate get nextwork flow and case should be resolved
    Then click on logout link and close the browser

    Examples: 
      | username | password  |
      | triager  | OF@123456 |



  #Author: baburao.lunavath@qbe.com
  #Sprint 2 and Sprint 3
  #Test case coverage || Total TC's - 11 || Total automated TC's - 11
  @smoke
  Scenario Outline: New mail compose scenario varification
    Given Open the browser and navigate to particular url
    When I enter valid username  "<username>" and "<password>" click on Login button
    Then Login should be successfully completed
    When validate newmailcompose send
    Then click on logout link and close the browser

    Examples: 
      | username | password  |
      | triager  | OF@123456 |

  #Sprint 2 and Sprint 3
  #Test case coverage || Total TC's - 11 || Total automated TC's - 11
  @smoke
  Scenario Outline: Forward mail scenario varification
    Given Open the browser and navigate to particular url
    When I enter valid username  "<username>" and "<password>" click on Login button
    Then Login should be successfully completed
    When validate forward mail
    Then click on logout link and close the browser

    Examples: 
      | username | password  |
      | triager  | OF@123456 |
