package com.cucumber.framework.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.cucumber.framework.GeneralHelperSel.LoggerHelper;
import com.cucumber.framework.GeneralHelperSel.SeleniumFunc;

public class CaseManagementCycleCSOPage extends SeleniumFunc
		implements CaseManagementCycleCSOPageLoc, CaseManagementCycleSMPageLoc, CaseManagementCycleTriagerPageLoc {

	CaseManagementCycleCSOPage caseManagementCycleCSOPage;

	public String[] expectedRequestTypses = { "Please Select...", "Adhoc", "AON", "Bind Cover/Bound Successful",
			"Builders Warranty", "Cancellation Calculation (ie. No closing yet)", "Cancellation Closing/Processing",
			"Certificate of Currency", "Claims Experience", "Closing Check", "Endorsement", "e-referral",
			"Follow Up Closing", "Follow up declaration", "Issue Schedule & certificate of Insurance (PAD Only)",
			"Issue Schedule (PI schedule created - all others via c.change)", "L3 RATER",
			"Lapse (all items in Pending Acceptance after 30 days unless excl by UW via a note QUW)", "Marine",
			"Motor Trade/Motor Composite", "NB Issue Terms", "OFS Closing Check", "Other", "Outbound Call",
			"Pending Acceptance", "Pending Closing", "Preparation for Policy Schedule", "Prepare rating/work up",
			"QR CTP", "Quote Registration", "Receive Closing", "Renew", "Renewals (5th week from expiry)",
			"Request Declaration", "Risk Work Up", "Rnwl Issue Terms B - Email", "Rnwl Issue Terms B - WISE",
			"Smart Salary", "Survey Recommendation", "Survey report", "Survey Request/Registration",
			"Suspended Policies", "Voice Inbound", "Voice Outbound", "Workers Comp", "Workload Allocation" };
	public String[] expectedPolicyStatuses = { "Please Select...", "Open", "Pending Acceptance", "Pending Closing", "Open Closing Received",
			"Open-Processing", "Pending RFI", "Resolved-InForce", "Open Referral", "Lapse",
			"Cancelled", "Transferred" };
	public String[] exepctedUnderWriterRegions = { "Please Select...", "ACT", "NSW", "NT", "QLD", "SA", "TAS", "VIC",
			"WA" };
	public String[] expectedTypes = { "Please Select...", "Policy", "Quote" };
	
	public String[] expectedReasonCodes = {"Account number", "Authority Code","Authority code required", "Broker Contact Details", "Clarification on instructions", "COC information", "Completed by UW", "Created survey WO", "Duplicate/Existing survey report/request found", "Excess", "Forwarded emails from broker", "If policy to be lapsed", "Insured name", "L3 actioned with DTP", "L3 actioned with recommendation", "L3 RATER", "Late Triage", "Mismatch information - Closing Check", "Missing documents", "Mistriage", "National scheme", "No broker contact", "No existing instructions", "Other", "Out of scope", "Per DTP", "Policy number", "Reassigned per DTP", "Rego No", "Reviewed eRef for Voice outbound", "State of Risk", "Sublimits", "Sum Insured", "Survey completion date", "Vehicle Rate", "Vehicles Details", "Voice Outbound"};

	public int i;

	private final Logger log = LoggerHelper.getLogger(CaseManagementCycleCSOPage.class);

	public CaseManagementCycleCSOPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void sendCaseManagementCycleCSOObject(CaseManagementCycleCSOPage caseManagementCycleCSOPage) {
		this.caseManagementCycleCSOPage = caseManagementCycleCSOPage;
		// System.out.println("In sendLoginObject method search page"+this.loginpage);
	}

	/*
	 * #############################################################################
	 * Author: Bharat Method to Add the priority
	 * #############################################################################
	 */
	public static int sum(List<Integer> list1) {
		int sum = 0;
		for (int k : list1) {
			sum += k;
		}
		return sum;
	}

	/*
	 * #############################################################################
	 * Author: Bharat Method to store the list of priorities into a Array list and
	 * perform Sum and return
	 * #############################################################################
	 */
	public int GetSumOfPriority() throws Exception {

		xpath_GenericMethod_Click(refresh_button);
		xpath_GenericMethod_Click(refresh_button);
		Thread.sleep(3000);
		List<WebElement> listOfPriorities = driver.findElements(By.xpath(priority_list));
		List<Integer> list = new ArrayList<Integer>(listOfPriorities.size());

		for (int i = 0; i < listOfPriorities.size(); i++) {
			System.out.println("Count of priorities " + listOfPriorities.size());
			Thread.sleep(2000);
			// listOfPriorities.get(i).click();
			String actualPriority = listOfPriorities.get(i).getText();
			System.out.println("Text of P" + actualPriority);
			int casePriority = Integer.parseInt(actualPriority);
			list.add(casePriority);

		}
		System.out.println(list);
		int sumOfPriorities = sum(list);
		System.out.println(sumOfPriorities);
		return sumOfPriorities;

	}

	/*
	 * #############################################################################
	 * Author: Bharat Utility Method to Login with a user and get the sum of
	 * priorities
	 * #############################################################################
	 */

	public int LoginAndGetSumOfUserOne(String firstUsername, String firstPasswword) throws Exception {

		OneFlowLoginPage.applogin(firstUsername, firstPasswword);
		int userOnePrioritySum = GetSumOfPriority();
		OneFlowLoginPage.applogout();
		Thread.sleep(5000);
		return userOnePrioritySum;
	}

	public int LoginAndGetSumOfUserTwo(String secondUsername, String secondPassword) throws Exception {

		OneFlowLoginPage.applogin(secondUsername, secondPassword);
		int userTwoPrioritySum = GetSumOfPriority();
		OneFlowLoginPage.applogout();
		return userTwoPrioritySum;
	}

	public void Login(String userName, String password) throws Exception {

		Thread.sleep(5000);
		OneFlowLoginPage.applogin(userName, password);

	}

	public String LoginToUserAndGetTheSum(String productCode, String sub) throws Exception {
		if (productCode.equalsIgnoreCase("ISR") || productCode.equalsIgnoreCase("ISC")
				|| productCode.equalsIgnoreCase("ASL") || productCode.equalsIgnoreCase("DOL")
				|| productCode.equalsIgnoreCase("MNL") || productCode.equalsIgnoreCase("SLI")
				|| productCode.equalsIgnoreCase("SLE") || productCode.equalsIgnoreCase("GEN")
				|| productCode.equalsIgnoreCase("JLB") || productCode.equalsIgnoreCase("MBD")
				|| productCode.equalsIgnoreCase("SUP") || productCode.equalsIgnoreCase("SDO")
				|| productCode.equalsIgnoreCase("FIP") || productCode.equalsIgnoreCase("FIC")
				|| productCode.equalsIgnoreCase("FGS")) {
			int sum1 = LoginAndGetSumOfUserOne("ISRUser_1", "OF@123456");
			int sum2 = LoginAndGetSumOfUserTwo("ISRUser_2", "OF@123456");

			if (sum1 < sum2) {
				return "ISRUser_1";
			} else {
				return "ISRUser_2";
			}
			// System.out.print("User logged into ISR work group");

		} else if (productCode.equalsIgnoreCase("PAD")) {
			int sum1 = LoginAndGetSumOfUserOne("PADUser_1", "OF@123456");
			System.out.println(sum1);
			int sum2 = LoginAndGetSumOfUserTwo("PADUser_2", "OF@123456");
			System.out.println(sum2);
	
			if (sum1 < sum2) {
				return "PADUser_1";
			} else {
				
				return "PADUser_2";
			}
			// System.out.print("User logged into PAD work group");

		} else if (productCode.equalsIgnoreCase("MVA")) {
			int sum1 = LoginAndGetSumOfUserOne("MVAUser1", "OF@123456");
			System.out.println(sum1);
			int sum2 = LoginAndGetSumOfUserTwo("MVAUser2", "OF@123456");
			System.out.println(sum2);

			if (sum1 < sum2) {
				
				return "MVAUser1";
			} else {
				
				return "MVAUser2";
			}
			// System.out.print("User logged into MVA work group");

		} else if (productCode.equalsIgnoreCase("PLB") || productCode.equalsIgnoreCase("CAN")
				|| productCode.equalsIgnoreCase("CRR") || productCode.equalsIgnoreCase("CMH")
				|| productCode.equalsIgnoreCase("MLL") || productCode.equalsIgnoreCase("UMB")
				|| productCode.equalsIgnoreCase("EXL") || productCode.equalsIgnoreCase("MPI")
				|| productCode.equalsIgnoreCase("CAR") || productCode.equalsIgnoreCase("PRL")
				|| productCode.equalsIgnoreCase("LFL")) {
			int sum1 = LoginAndGetSumOfUserOne("PLBUser1", "OF@123456");
			int sum2 = LoginAndGetSumOfUserTwo("PLBUser2", "OF@123456");
			
			if (sum1 < sum2) {
	
				return "PLBUser1";

			} else {
			
				return "PLBUser1";
			}

		} else {
			OutLook_Util.sendMail(sub, "Test");
			driver.findElement(By.xpath("//input[@id='txtUserID']")).sendKeys("triager");
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("OF@123456");
			driver.findElement(By.xpath("//span[@class='loginButtonText']")).click();
			System.out.print("User logged into Triager work group");
			return "triager";

		}

	}

	public void ClickOnRefresh(int n) {
		for (int i = 0; i < n; i++) {

			driver.findElement(By.xpath("//button[@title='Refresh List']")).click();

		}
	}

	public void SortTheListWithRecentCreatedCases() throws InterruptedException {
		Thread.sleep(3000);
		WebElement sortField = driver.findElement(By.xpath(case_heading_label));
		driver.findElement(By.xpath(case_heading_label)).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		// js.executeScript("arguments[0].click();", sortField);
		driver.findElement(By.xpath(case_heading_label)).click();

	}

	public void VerifyTheCaseRoutingAndPriority(String expectedSubject, String expectedFromAddress, String priority) throws Exception {
		CommonPage.caseAndPriorityVerification(refresh_button, expectedSubject, expectedFromAddress, priority);
	}

	public void VerifyRequestType(String expectedrequesttype) throws Exception {

		String actualRequestType = getDefaultValueFromDD(request_type_dropdown);
		Assert.assertEquals(actualRequestType, expectedrequesttype);

	}

	public String VerifyType(String expectedtype) throws InterruptedException {
		String actualType = getDefaultValueFromDD(type_dropdown);
		Assert.assertEquals(actualType, expectedtype);
		return actualType;

	}

	public void VerifyPolicyOrQuoteNumber(String type, String expectedpolicyorquoteNo) throws Exception {

		if (type.equals("Policy")) {

			goToFrameByTag_IdByXpath(policy_textbox);
			WebElement policytextbox = driver.findElement(By.xpath(policy_textbox));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", policytextbox);
			Thread.sleep(3000);
			String actualpolicynumber = policytextbox.getAttribute("value");
			System.out.println(actualpolicynumber);

			String policyno = expectedpolicyorquoteNo;
			String expectedpolicyNoAfterTrim = policyno.replaceAll("\\W", "");

			System.out.println("actual policy no " + actualpolicynumber);
			System.out.println("policy no before trim " + policyno);
			System.out.println("Expected policy no after trim " + expectedpolicyNoAfterTrim);

			Assert.assertEquals(actualpolicynumber, expectedpolicyNoAfterTrim);
			System.out.println("Policy No is verified");
		} else {

			goToFrameByTag_IdByXpath(quote_textbox);
			WebElement quotetextbox = driver.findElement(By.xpath(quote_textbox));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", quotetextbox);
			Thread.sleep(3000);
			String actualquotenumber = quotetextbox.getAttribute("value");
			System.out.println(actualquotenumber);

			String quoteno = expectedpolicyorquoteNo;
			String expectedquoteNoAfterTrim = quoteno.replaceAll("\\W", "");

			System.out.println("actual quote no " + actualquotenumber);
			System.out.println("quote no before trim " + quoteno);
			System.out.println("Expected quote no after trim " + expectedquoteNoAfterTrim);

			Assert.assertEquals(actualquotenumber, expectedquoteNoAfterTrim);
			System.out.println("Quote No is verified");
		}

	}

	/*
	 * ________________________________________________________________________________________
	 * 
	 * Methods for AbilityToDefineCasePrioritization_GWMS-118.feature
	 * __________________________________________________________________________________________
	 */

	public void CloseTheCase() throws Exception {

		xpath_GenericMethod_Click(cancel_button);
	}

	public void VerifyPriority(int expectedPriority) throws InterruptedException {

		Thread.sleep(5000);
		
		List<WebElement> listOfPriorities = driver.findElements(By.xpath(priority_list));

		String actualPriority = listOfPriorities.get(i).getText();
		System.out.println("Text of P" + actualPriority);
		int casePriority = Integer.parseInt(actualPriority);

		if (casePriority == expectedPriority) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	/*
	 * ________________________________________________________________________________________
	 *
	 * Methods related to AbilityToCreateManualCase_GWMS-153 feaure
	 * _________________________________________________________________________________________
	 */

	public void ClickOnNewButton() throws Exception {

		WebElement target = driver.findElement(By.xpath(New_button));
		Actions actions = new Actions(driver);
		actions.moveToElement(target).build();
		xpath_GenericMethod_Click(New_button);
		waitFor(8);
	}

	public void ClickOnTransactionRequest() throws Exception {

		xpath_GenericMethod_Click(TransactionRequest_button);
	}

	public void verifyCaptureTransactionDetailsScreen() {

		waitFor(5);
		WebElement CaptureRequestDetails = driver.findElement(By.xpath(CaptureRequestDetails_label));
		if (CaptureRequestDetails.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public String GetCaseID() {

		String actualcaseId = driver.findElement(By.xpath(TransactionRequest_id)).getText();
		int lenght = actualcaseId.length();
		String caseId = actualcaseId.substring(1, lenght - 1);
		System.out.println(caseId);
		return caseId;

	}

	public void VerifyRequestTypeDropDownValues() throws InterruptedException {

		Thread.sleep(6000);
		Select sel = new Select(driver.findElement(By.xpath(request_type_dropdown)));
		List<WebElement> options = sel.getOptions();
		int countOfTypes = options.size();
		System.out.println(countOfTypes);
		System.out.println(expectedRequestTypses.length);

		if (countOfTypes == expectedRequestTypses.length) {

			System.out.println("No of options are equal");

			for (int i = 0; i < countOfTypes; i++) {

				if (options.get(i).getText().equals(expectedRequestTypses[i])) {

					System.out.println(options.get(i).getText());
					Assert.assertTrue(true);

				} else {
					System.out.println(options.get(i).getText());
					Assert.assertTrue(false);
				}
			}

		}

	}

	public void selectRequestTypeFromDropDown(String requestType) {

		selectFromDropdownUsingVisibleText(request_type_dropdown, requestType);
	}

	public void VerifyPolicyStatusDropDownValues() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();

		Select sel2 = new Select(driver.findElement(By.xpath(PolicyStatus_dropdown)));
		List<WebElement> option = sel2.getOptions();
		int countOfPolicyStatuses = option.size();
		System.out.println(countOfPolicyStatuses);
		System.out.println(expectedPolicyStatuses.length);

		if (countOfPolicyStatuses == expectedPolicyStatuses.length) {

			System.out.println("No of options are equal");

			for (int j = 0; j < countOfPolicyStatuses; j++) {

				if (option.get(j).getText().equals(expectedPolicyStatuses[j])) {
					System.out.println(option.get(j).getText());
					Assert.assertTrue(true);

				} else {
					System.out.println(option.get(j).getText());
					Assert.assertTrue(false);
				}
			}

		}

	}

	public void selectPolicyStatusFromDropDown(String policystatus) {

		selectFromDropdownUsingVisibleText(PolicyStatus_dropdown, policystatus);
	}

	public void ProvideClaimID(String claimid) throws Exception {

		xpath_GenericMethod_Sendkeys(ClaimId_textbox, claimid);
	}

	public void ProvideInsuredName(String insuredname) throws Exception {

		xpath_GenericMethod_Sendkeys(InsuredName_textbox, insuredname);

	}

	public void ProvideUnderWriterName(String underwritername) throws Exception {

		xpath_GenericMethod_Sendkeys(UnderWriterName_textbox, underwritername);
	}

	public void VerifyUnderWriterRegionDropDownValues() {

		Select sel = new Select(driver.findElement(By.xpath(UnderWriterRegion_dropdown)));
		List<WebElement> options = sel.getOptions();
		int countOfRegions = options.size();
		System.out.println(countOfRegions);
		System.out.println(exepctedUnderWriterRegions.length);

		if (countOfRegions == exepctedUnderWriterRegions.length) {

			System.out.println("No of options are equal");

			for (int i = 0; i < countOfRegions; i++) {

				if (options.get(i).getText().equals(exepctedUnderWriterRegions[i])) {

					System.out.println(options.get(i).getText());
					Assert.assertTrue(true);

				} else {
					System.out.println(options.get(i).getText());
					Assert.assertTrue(false);
				}
			}

		}

	}

	public void selectUnderWriterRegionFromDropDown(String region) {

		selectFromDropdownUsingVisibleText(UnderWriterRegion_dropdown, region);
	}

	public void VerifyTypeDropDownValues() {

		Select sel = new Select(driver.findElement(By.xpath(type_dropdown)));
		List<WebElement> options = sel.getOptions();
		int countOfTypes = options.size();
		System.out.println(countOfTypes);
		System.out.println(expectedTypes.length);

		if (countOfTypes == expectedTypes.length) {

			System.out.println("No of options are equal");

			for (int i = 0; i < countOfTypes; i++) {

				if (options.get(i).getText().equals(expectedTypes[i])) {

					System.out.println(options.get(i).getText());
					Assert.assertTrue(true);

				} else {
					System.out.println(options.get(i).getText());
					Assert.assertTrue(false);
				}
			}

		}

	}

	public void selectTypeFromDropDown(String type) {

		selectFromDropdownUsingVisibleText(type_dropdown, type);
		waitFor(8);
	}

	public void ProvidePolicyOrQuoteNumber(String type, String policyorquoteno) throws Exception {

		if (type.equals("Policy")) {

			xpath_GenericMethod_Sendkeys(policy_textbox, policyorquoteno);

		} else {
			xpath_GenericMethod_Sendkeys(quote_textbox, policyorquoteno);

		}

	}

	public void SubmitManaulCreatedCase() {

		for (int i = 0; i < 3; i++) {

			WebElement submit = driver.findElement(By.xpath(Submit_button));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", submit);
			waitFor(15);
		}
	}

	public void VerifyResolutionCompletedState(String expectedResolution) {

		String actualResolution = driver.findElement(By.xpath(CaseResolution_label)).getText();
		Assert.assertEquals(actualResolution, expectedResolution);
	}

	public void ProvideDate(String locator) throws Exception {

		driver.findElement(By.xpath(locator)).click();
		xpath_GenericMethod_Click(CurrentDate);

	}

	public void ProvideExpirationReceivedDates(String requestType) throws Exception {
		if (requestType.equalsIgnoreCase("Rnwl Issue Terms B – Email")
				|| requestType.equalsIgnoreCase("Rnwl Issue Terms B – WISE")
				|| requestType.equalsIgnoreCase("Pending Acceptance") || requestType.equalsIgnoreCase("Renewals")
				|| requestType.equalsIgnoreCase("Follow up declaration")
				|| requestType.equalsIgnoreCase("Request declaration")) {
			driver.findElement(By.xpath(ExpirationDate_datafield)).click();
			xpath_GenericMethod_Click(CurrentDate);

			driver.findElement(By.xpath(ReceivedDate_datefield)).click();
			xpath_GenericMethod_Click(CurrentDate);
		} else {

			System.out.println("Expiration and Received Data fields");
		}
	}

	public void ValidateMandatoryFields() throws Exception {
		
		xpath_GenericMethod_Click(Submit_button);
		String mandatoryNote = driver.switchTo().alert().getText();
		if (mandatoryNote.equalsIgnoreCase("Please correct flagged fields before submitting the form!")) {
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
		}
		else {
			driver.switchTo().alert().accept();
			Assert.assertTrue(false);
			
		}
	}
	
	/*---------------------------------------------------------------------------------------------------------------
	 * Methods for Ability to have an RFI functionality_GWMS-145.feature
	 * _____________________________________________________________________________________________________________
	 */

	public void ClickOnActionDropDown() throws Exception {
		
		xpath_GenericMethod_Click(Actions_dropdown);
		
	}
	
	public void SelectCreateRFI() throws Exception {
		
		xpath_GenericMethod_Click(CreateRFI_button);;
	}
	
	public void VerifyReasonCodesDropDownValues() {
		
		List<WebElement> reasoncodes = driver.findElements(By.xpath(ReasonCodes_list));
		System.out.println("actual"+  reasoncodes.size());
		if(reasoncodes.size() == expectedReasonCodes.length) {
			
		}
	}
	
	
}
