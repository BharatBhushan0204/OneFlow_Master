package com.cucumber.framework.stepDef;




import org.apache.log4j.Logger;

import com.cucumber.framework.GeneralHelperSel.LoggerHelper;
import com.cucumber.framework.PageObjects.CaseManagementCycleTriagerPage;
import com.cucumber.framework.PageObjects.OneFlowLoginPage;
import com.cucumber.framework.configreader_TestBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CaseManagementCycleTriagerTest {

	private final Logger log = LoggerHelper.getLogger(CaseManagementCycleTriagerTest.class);
	
	public String subject;

	CaseManagementCycleTriagerPage caseManagementCycleTriagerPage;
	OneFlowLoginPage oneFlowLoginPage;
	
	

	/*#############################################################################
	 * Author : Babu
	 * Scenario outlook & browser lunch
	 * #############################################################################*/
	
	@Given("^Open the browser and navigate to particular url$")
	public void open_the_browser_and_navigate_to_particular_url() throws Throwable {
		
		
		/*OneFlowLoginPage.LaunchOutLookApp()();
		OneFlowLoginPage.loginOutlook("baburao.lunavath@qbe.com", "ManBabu@123");
		OneFlowLoginPage.sendMail("durga.subramanyam@qbe.com", "testdemomail", "testdemomail");*/
		OneFlowLoginPage.LaunchQBEApp();
	}
	
	/*#############################################################################
	 * Author : Babu
	 * Scenario application login
	 * #############################################################################*/

	@When("^I enter valid username  \"([^\"]*)\" and \"([^\"]*)\" click on Login button$")
	public void i_enter_valid_username_and_click_on_Login_button(String usernamefield, String passwordfield)
			throws Throwable {
		
		Thread.sleep(3000);
		OneFlowLoginPage.applogin(usernamefield, passwordfield);
		
	}
	
	/*#############################################################################
	 * Author : Babu
	 * Scenario login application
	 * #############################################################################*/

	@Then("^Login should be successfully completed$")
	public void login_should_be_successfully_completed() throws Throwable {
		System.out.println("Login succussfully completed");
		Thread.sleep(15000);
		

		
	}
	
	/*#############################################################################
	 * Author : Babu
	 * Scenario Complex WB
	 * #############################################################################*/

	@When("^verify cases routing to complex workbasket$")
	public void verify_cases_routing_to_complex_workbasket() throws Throwable {
		caseManagementCycleTriagerPage = new CaseManagementCycleTriagerPage(TestBase.getDriver());
		caseManagementCycleTriagerPage.sendCaseManagementCycleTriagerObject(caseManagementCycleTriagerPage);
		caseManagementCycleTriagerPage.clickonComplexWB();
	}
	
	/*#############################################################################
	 * Author : Babu
	 * Scenario case information screen
	 * #############################################################################*/

	@When("^click on case when user navigate to list of cases screen$")
	public void click_on_case_when_user_navigate_to_list_of_cases_screen() throws Throwable {
		CaseManagementCycleTriagerPage.informationNotedisplay();
	}
	
	/*#############################################################################
	 * Author : Babu
	 * Scenario information note 
	 * #############################################################################*/

	@Then("^verify information note available at top of the page$")
	public void verify_information_note_available_at_top_of_the_page() throws Throwable {
		System.out.println("verify information note text for complex work basket");

	}
	
	/*#############################################################################
	 * Author : Babu
	 * Scenario Exception WB
	 * #############################################################################*/

	@When("^verify information note for ExceptionWB cases$")
	public void verify_information_note_for_ExceptionWB_cases() throws Throwable {
		caseManagementCycleTriagerPage.clickonExceptionWB();
		
	}
	
	/*#############################################################################
	 * Author : Babu
	 * Scenario logout application
	 * #############################################################################*/
	
	@Then("^click on logout link and close the browser$")
	public void click_on_logout_link_and_close_the_browser() throws Throwable {
		OneFlowLoginPage.applogout();
	    
	}
	
	/*#############################################################################
	 * Author : Babu
	 * Scenario get Nextwork
	 * #############################################################################*/
	
	@When("^validate get nextwork flow and case should be resolved$")
	public void validate_get_nextwork_flow_and_case_should_be_resolved() throws Throwable {
		caseManagementCycleTriagerPage = new CaseManagementCycleTriagerPage(TestBase.getDriver());
		caseManagementCycleTriagerPage.sendCaseManagementCycleTriagerObject(caseManagementCycleTriagerPage);
		caseManagementCycleTriagerPage.getNext_work();
	}
	
	/*#############################################################################
	 * Author : Babu
	 * Scenario Reassign work triager to cso or workbasket 
	 * #############################################################################*/
	
	@When("validate Reassign to Workbasket or worklist or operator")
	public void validate_Reassign_to_Workbasket_or_worklist_or_operator() throws Exception {
		caseManagementCycleTriagerPage = new CaseManagementCycleTriagerPage(TestBase.getDriver());
		caseManagementCycleTriagerPage.sendCaseManagementCycleTriagerObject(caseManagementCycleTriagerPage);
		caseManagementCycleTriagerPage.reassignwork();
	    
	}

	
	@Then("Open the case and verify the case is routed to complex work basket with {string} and {string}")
	public void open_the_case_and_verify_the_case_is_routed_to_complex_work_basket_with_and(String keywordinsubject, String policyorquotenoinsubject) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		subject = keywordinsubject + " " + policyorquotenoinsubject;
		caseManagementCycleTriagerPage = new CaseManagementCycleTriagerPage(TestBase.getDriver());
		caseManagementCycleTriagerPage.sendCaseManagementCycleTriagerObject(caseManagementCycleTriagerPage);
		caseManagementCycleTriagerPage.OpenComplexCaseAndVerifySubject(subject, "bharatbhushan.thanikanti@qbe.com");
	}
	

	@Then("Open the case and verify the case is routed to exception work basket with {string} and {string}")
	public void open_the_case_and_verify_the_case_is_routed_to_exception_work_basket_with_and(String keywordinsubject, String policyorquotenoinsubject) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		subject = keywordinsubject + " " + policyorquotenoinsubject;
		caseManagementCycleTriagerPage = new CaseManagementCycleTriagerPage(TestBase.getDriver());
		caseManagementCycleTriagerPage.sendCaseManagementCycleTriagerObject(caseManagementCycleTriagerPage);
		caseManagementCycleTriagerPage.OpenExceptionCaseAndVerifySubject(subject, "bharatbhushan.thanikanti@qbe.com");
	}
	
	@When("validate newmailcompose send")
    public void validate_newmailcompose_send() throws Exception {
        // Write code here that turns the phrase above into concrete actions
		caseManagementCycleTriagerPage = new CaseManagementCycleTriagerPage(TestBase.getDriver());
		caseManagementCycleTriagerPage.sendCaseManagementCycleTriagerObject(caseManagementCycleTriagerPage);
		caseManagementCycleTriagerPage.composeNewEmail();
    }
   
    @When("validate forward mail")
    public void validate_forward_mail() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    	caseManagementCycleTriagerPage = new CaseManagementCycleTriagerPage(TestBase.getDriver());
    	caseManagementCycleTriagerPage.sendCaseManagementCycleTriagerObject(caseManagementCycleTriagerPage);
    	caseManagementCycleTriagerPage.forwardEmail();
    }
   
    @When("validate Reassign to  operator")
    public void validate_Reassign_to_operator() throws Exception {
        // Write code here that turns the phrase above into concrete actions
    	caseManagementCycleTriagerPage = new CaseManagementCycleTriagerPage(TestBase.getDriver());
    	caseManagementCycleTriagerPage.sendCaseManagementCycleTriagerObject(caseManagementCycleTriagerPage);
    	caseManagementCycleTriagerPage.reassignworktooperator();
    }


}
