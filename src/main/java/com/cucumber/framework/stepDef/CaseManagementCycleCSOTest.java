package com.cucumber.framework.stepDef;

import org.apache.log4j.Logger;

import com.cucumber.framework.GeneralHelperSel.LoggerHelper;
import com.cucumber.framework.GeneralHelperSel.SeleniumFunc;
import com.cucumber.framework.PageObjects.CaseManagementCycleCSOPage;
import com.cucumber.framework.PageObjects.OneFlowLoginPage;
import com.cucumber.framework.PageObjects.OutLook_Util;
import com.cucumber.framework.configreader_TestBase.TestBase;
import com.cucumber.framework.helper.sendmail.OpenOutLookAndSendMail;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CaseManagementCycleCSOTest {
	
	public static String subject;
	public static String numbertype;
	public static String Username;
	public static String actualtype;
	
	private final Logger log = LoggerHelper.getLogger(CaseManagementCycleCSOTest.class);
	CaseManagementCycleCSOPage caseManagementCycleCSOPage;
	OneFlowLoginPage oneFlowLoginPage;
	
	@Given("Open the browser and navigate to the url")
	public void open_the_browser_and_navigate_to_the_url() {
	    // Write code here that turns the phrase above into concrete actions
		OneFlowLoginPage.LaunchQBEApp();

	}

	@Given("Login to two user one after another and get the sum of priorities of the each user with respect to {string} and {string}")
	public void login_to_two_user_one_after_another_and_get_the_sum_of_priorities_of_the_each_user_with_respect_to_and(
			String keywordinsubject, String policyorquotenoinsubject) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage = new CaseManagementCycleCSOPage(TestBase.getDriver());
		caseManagementCycleCSOPage.sendCaseManagementCycleCSOObject(caseManagementCycleCSOPage);
		subject = keywordinsubject + " " + policyorquotenoinsubject;
		String productCodeFromSubject = subject.substring(subject.length() - 3);
		Username = caseManagementCycleCSOPage.LoginToUserAndGetTheSum(productCodeFromSubject, subject);

	}

	@Given("User send a mail to QBE with subject {string} and {string}")
	public void user_send_a_mail_to_QBE_with_subject_and(String keywordinsubject, String policyorquotenoinsubject) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		//OpenOutLookAndSendMail.SendMailThroughOut();
		subject = keywordinsubject + " " + policyorquotenoinsubject;
		OneFlowLoginPage.LaunchOutLookApp();
		OutLook_Util.loginOutlook("bharatbhushan.thanikanti@qbe.com", "Anjivenki@04bb");
		OutLook_Util.sendMail("underwriting_test2@qbe.com", subject, "testdemomail");
		System.out.println("mail sent");
			 
	}

	@Then("Login to the user which has low work load")
	public void login_to_the_user_which_has_low_work_load() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.Login(Username, "OF@123456");
		System.out.println("Low work loadUser logged into application");
		
	}
	
	@Then("Login should be successful")
	public void login_should_be_successful() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Login successfull");
	}

	@Then("Click on refresh button")
	public void click_on_refresh_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(50000);
		caseManagementCycleCSOPage.ClickOnRefresh(4);

	}

	@Then("Sort the list of cases with recent created case")
	public void sort_the_list_of_cases_with_recent_created_case() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		SeleniumFunc.waitFor(1);
		caseManagementCycleCSOPage.SortTheListWithRecentCreatedCases();
	}
	
	@Then("Open the case and verify that the case is created and routed to user properly and priority with {string}.")
	public void open_the_case_and_verify_that_the_case_is_created_and_routed_to_user_properly_and_priority_with(String priority) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage = new CaseManagementCycleCSOPage(TestBase.getDriver());
		caseManagementCycleCSOPage.sendCaseManagementCycleCSOObject(caseManagementCycleCSOPage);
		caseManagementCycleCSOPage.VerifyTheCaseRoutingAndPriority(subject, "bharatbhushan.thanikanti@qbe.com", priority);

	}

	@Then("The Request Type is autopopulated as per the expected request type {string}")
	public void the_Request_Type_is_autopopulated_as_per_the_expected_request_type(String expectedrequesttype) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.VerifyRequestType(expectedrequesttype);
	}

	@Then("The Type is displayed as per the expected type {string}")
	public void the_Type_is_displayed_as_per_the_expected_type(String type) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		numbertype = caseManagementCycleCSOPage.VerifyType(type);
	}

	@Then("The Policy or Quote number is autopopulated as it is available in the mail {string}")
	public void the_Policy_or_Quote_number_is_autopopulated_as_it_is_available_in_the_mail(String policyorquotenoinsubject) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.VerifyPolicyOrQuoteNumber(numbertype, policyorquotenoinsubject);
	}
	
	/*---------------------------------------------------------------------------------------------------------------
	 * Step Defination for AbilityToDefineCasePrioritization_GWMS-118.feature
	 * 
	 __________________________________________________________________________________________________________________*/
	
	@Then("Close the case")
	public void close_the_case() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage = new CaseManagementCycleCSOPage(TestBase.getDriver());
		caseManagementCycleCSOPage.sendCaseManagementCycleCSOObject(caseManagementCycleCSOPage);
		caseManagementCycleCSOPage.CloseTheCase();
	}

	@Then("Verify that the priority is defined as expected {string} for the given combination")
	public void verify_that_the_priority_is_defined_as_expected_for_the_given_combination(String priority) throws InterruptedException {
		int priorityNumber = Integer.parseInt(priority);
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage = new CaseManagementCycleCSOPage(TestBase.getDriver());
		caseManagementCycleCSOPage.sendCaseManagementCycleCSOObject(caseManagementCycleCSOPage);
		caseManagementCycleCSOPage.VerifyPriority(priorityNumber);
	}
	
	/* --------------------------------------------------------------------------------------------------------------------------------	
	 *  Step defination for AbilityToCreateManualCase_GWMS-153.feature
	 * _______________________________________________________________________________________________________________
	 * */
	
	@Then("Click on New Button")
	public void click_on_New_Button() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage = new CaseManagementCycleCSOPage(TestBase.getDriver());
		caseManagementCycleCSOPage.sendCaseManagementCycleCSOObject(caseManagementCycleCSOPage);
		caseManagementCycleCSOPage.ClickOnNewButton();

	}

	@When("Click on Transaction Request button")
	public void click_on_Transaction_Request_button() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.ClickOnTransactionRequest();
	}

	@Then("Capture request details screen is displayed")
	public void capture_request_details_screen_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.verifyCaptureTransactionDetailsScreen();
	}

	@Then("Get the Case ID which is a transaction request")
	public void get_the_Case_ID_which_is_a_transaction_request() {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.GetCaseID();
	}

	@Then("Verify the request type drop down have proper values and select {string}")
	public void verify_the_request_type_drop_down_have_proper_values_and_select(String requesttype) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.VerifyRequestTypeDropDownValues();
		caseManagementCycleCSOPage.selectRequestTypeFromDropDown(requesttype);
	}

	@Then("Verify the Policy Status drop down have expected values and select {string}")
	public void verify_the_Policy_Status_drop_down_have_expected_values_and_select(String policyStatus) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.VerifyPolicyStatusDropDownValues();
		caseManagementCycleCSOPage.selectPolicyStatusFromDropDown(policyStatus);
	}

	@Then("Enter Cliam ID as {string}")
	public void enter_Cliam_ID_as(String claimID) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.ProvideClaimID(claimID);
	}

	@Then("Enter Insured Name as {string}")
	public void enter_Insured_Name_as(String insuredname) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.ProvideInsuredName(insuredname);
	}

	@Then("Enter Underwriter Name as {string}")
	public void enter_Underwriter_Name_as(String underwritername) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.ProvideUnderWriterName(underwritername);
	}

	@Then("Verify Under writer region drop down values and select {string}")
	public void verify_Under_writer_region_drop_down_values_and_select(String underwriterregion) {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.VerifyUnderWriterRegionDropDownValues();
		caseManagementCycleCSOPage.selectUnderWriterRegionFromDropDown(underwriterregion);
	}
	
	@Then("Provide Expiration and Received date if the requirest type is as {string}")
	public void provide_Expiration_and_Received_date_if_the_requirest_type_is_as(String requesttype) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.ProvideExpirationReceivedDates(requesttype);
	}

	@Then("Select the type as {string}")
	public void select_the_type_as(String type) {
	    // Write code here that turns the phrase above into concrete actions
		actualtype = type;
		caseManagementCycleCSOPage.VerifyTypeDropDownValues();
		caseManagementCycleCSOPage.selectTypeFromDropDown(type);
		
	}

	@Then("Enter valid policy or quote no as {string}")
	public void enter_valid_policy_or_quote_no_as(String policyorquoteno) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.ProvidePolicyOrQuoteNumber(actualtype, policyorquoteno);
	}

	@Then("Click on Submit button to close the case")
	public void click_on_Submit_button_to_close_the_case() {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.SubmitManaulCreatedCase();
	}

	@Then("The case resolution is displayed as {string}")
	public void the_case_resolution_is_displayed_as(String ResolvedCompleted) {
	    // Write code here that turns the phrase above into concrete actions
		caseManagementCycleCSOPage.VerifyResolutionCompletedState(ResolvedCompleted);
	}
	
	/*____________________________________________________________________________________________________
	 * 
	 * Test methods for case field mandatory validation
	 *_____________________________________________________________________________________________________*/
	

}
