package com.cucumber.framework.PageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cucumber.framework.GeneralHelperSel.LoggerHelper;
import com.cucumber.framework.GeneralHelperSel.SeleniumFunc;

public class CaseManagementCycleTriagerPage extends SeleniumFunc
		implements CaseManagementCycleTriagerPageLoc, CaseManagementCycleCSOPageLoc, CaseManagementCycleSMPageLoc {

	public CaseManagementCycleTriagerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private final Logger log = LoggerHelper.getLogger(CaseManagementCycleTriagerPage.class);

	CaseManagementCycleTriagerPage caseManagementCycleTriagerPage;

	public void sendCaseManagementCycleTriagerObject(CaseManagementCycleTriagerPage caseManagementCycleTriagerPage) {
		this.caseManagementCycleTriagerPage = caseManagementCycleTriagerPage;
		// System.out.println("In sendLoginObject method search page"+this.loginpage);
	}

	/*
	 * #############################################################################
	 * Author : Babu Scenario : Exception work basket Description : fetch the case
	 * information note content verification in complex WB
	 * #############################################################################
	 */

	public CaseManagementCycleTriagerPage clickonComplexWB() throws Exception {

		// click on complex work basket

		xpath_GenericMethod_Click(complex_workbasket);

		return new CaseManagementCycleTriagerPage(driver);
	}
	/*
	 * #############################################################################
	 * Author : Babu Scenario : Exception work basket Description : fetch the case
	 * information note content verification in exception WB
	 * #############################################################################
	 */

	public CaseManagementCycleTriagerPage clickonExceptionWB() throws Exception {

		driver.switchTo().defaultContent();
		// click on exception WB
		Thread.sleep(3000);
		xpath_GenericMethod_Click(Exception_workbasket);
		xpath_GenericMethod_Click(refresh);
		xpath_GenericMethod_Click(refresh);
		CaseManagementCycleTriagerPage.informationNotedisplay();

		return new CaseManagementCycleTriagerPage(driver);
	}

	/*
	 * #############################################################################
	 * Author : Babu Scenario : Case Information Note Display Description : fetch
	 * the case information note content verification
	 * #############################################################################
	 */

	public static CaseManagementCycleTriagerPage informationNotedisplay() throws Exception {

		Thread.sleep(3000);
		xpath_GenericMethod_Click(case_heading_label);
		Thread.sleep(3000);
		xpath_GenericMethod_Click(case_heading_label);
		Thread.sleep(3000);
		List<WebElement> list_of_cases = driver.findElements(By.xpath(case_list));
		int total_cases = list_of_cases.size();
		System.out.println(total_cases);
		for (int i = 0; i < total_cases; i++) {
			// HandleStaleElement(list_of_cases.get(i));
			WebDriverWait wait = new WebDriverWait(driver, 30);
/*			wait.until(ExpectedConditions.elementToBeClickable(list_of_cases.get(i)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", list_of_cases.get(i));*/
			xpath_GenericMethod_Click(First_case);
			driver.switchTo().defaultContent();

			Thread.sleep(3000);
			// get the content of the information note
			goToFrameByTag_IdByXpath(notedisplayed);
			String notedis = driver.findElement(By.xpath(notedisplayed)).getText();
			System.out.println("information note message display:" + notedis);
			String multipletypesofrequest = "The case has been routed to the complex workbasket "
					+ "+because multiple type of requests have been identified";
			String multipletypesofrequestandpolicy_quotenumber = "The case has been routed to the complex workbasket because multiple "
					+ "+type of requests and policy/quote number have been identified";
			String multiplepolicy_quotenumber = "The case has been routed to the complex "
					+ "+workbasket because multiple policy/quote number have been identified";
			String withouttypeofrequestandpolicy_quotenumber = "The case has been routed to the exception workbasket because "
					+ "+no policy/quote number nor type of request were identified.";
			String withoutpolicyquotenumber = "The case has been routed to the exception workbasket because no policy/quote number was identified.";
			if (notedis.equalsIgnoreCase(multipletypesofrequest)) {
				Assert.assertEquals(notedis, multipletypesofrequest);
				System.out.println("For those case identified with multiple types of request");
			} else if (notedis.equalsIgnoreCase(multipletypesofrequestandpolicy_quotenumber)) {
				Assert.assertEquals(notedis, multipletypesofrequestandpolicy_quotenumber);
				System.out.println("For those case identified with multiple types of request and policy/quote number");

			} else if (notedis.equalsIgnoreCase(multiplepolicy_quotenumber)) {
				Assert.assertEquals(notedis, multiplepolicy_quotenumber);
				System.out.println("For those case identified with multiple policy/quote number");

			} else if (notedis.equalsIgnoreCase(withouttypeofrequestandpolicy_quotenumber)) {
				Assert.assertEquals(notedis, withouttypeofrequestandpolicy_quotenumber);
				System.out.println("For those case identified without type of request and policy/quote number");

			} else if (notedis.equalsIgnoreCase(withoutpolicyquotenumber)) {
				Assert.assertEquals(notedis, withoutpolicyquotenumber);
				System.out.println("For those case identified without policy/quote number");

			}

			else {
				System.out.println("************information note not available************");
			}

			String SLAvalue = driver.findElement(By.xpath(SLA_Xpath)).getText();
			System.out.println("SLA value:" + SLAvalue);
			xpath_GenericMethod_Click(closebutton);
			break;

		}

		return new CaseManagementCycleTriagerPage(driver);
	}

	/*
	 * #############################################################################
	 * Author : Babu Scenario : Out-of-scope work basket Description : out-of-scope
	 * WB
	 * #############################################################################
	 */

	public CaseManagementCycleTriagerPage clickon_OutofScope_WB() throws Exception {

		driver.switchTo().defaultContent();
		// click on exception WB
		Thread.sleep(3000);
		xpath_GenericMethod_Click(outofscope_xpath);
		xpath_GenericMethod_Click(refresh);
		xpath_GenericMethod_Click(refresh);
		CaseManagementCycleTriagerPage.informationNotedisplay();

		return new CaseManagementCycleTriagerPage(driver);
	}

	/*
	 * #############################################################################
	 * Author : Babu Scenario : Get Next work Description : Get next work flow
	 * #############################################################################
	 */

	public CaseManagementCycleTriagerPage getNext_work() throws Exception {

		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		xpath_GenericMethod_Click(getnext_xpath);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		xpath_GenericMethod_Sendkeys(insured_xpath, "testdemo");
		Thread.sleep(3000);
		xpath_GenericMethod_selectFromDropdownUsingIndexbyclickingOnDropdown(typeofreq_xpath, 6);
		Thread.sleep(3000);
		xpath_GenericMethod_selectFromDropdownUsingIndexbyclickingOnDropdown(policy_Quote_xpath, 2);
		Thread.sleep(3000);
		xpath_GenericMethod_Sendkeys(Quote_xpath, "QI 1234567 PLB");
		xpath_GenericMethod_Click(submit_xpath);
		Thread.sleep(5000);
		xpath_GenericMethod_Click(getnext);
		return new CaseManagementCycleTriagerPage(driver);
	}

	/*
	 * #############################################################################
	 * Author : Babu Scenario : Get Next work Description : reassign work
	 * #############################################################################
	 */

	public CaseManagementCycleTriagerPage reassignwork() throws Exception {
		driver.switchTo().defaultContent();
		// click on exception WB
		Thread.sleep(3000);
		xpath_GenericMethod_Click(Exception_workbasket);
		xpath_GenericMethod_Click(refresh);
		xpath_GenericMethod_Click(refresh);

		Thread.sleep(3000);
		List<WebElement> list_of_cases = driver.findElements(By.xpath(case_list));
		int total_cases = list_of_cases.size();
		System.out.println(total_cases);
		for (int i = 0; i < total_cases; i++) {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(list_of_cases.get(i)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", list_of_cases.get(i));
			driver.switchTo().defaultContent();
			xpath_GenericMethod_Click(actions_xpath);
			Thread.sleep(2000);
			xpath_GenericMethod_Click(reassign_xpath);
			Thread.sleep(2000);
			xpath_GenericMethod_selectFromDropdownUsingIndexbyclickingOnDropdown(transferto_xpath, 1);
			Thread.sleep(3000);
			xpath_GenericMethod_Sendkeys(workqueue_xpath, "Complex");
			Thread.sleep(3000);
			xpath_GenericMethod_Click(Complex_xpath);
			Thread.sleep(3000);
			xpath_GenericMethod_Click(btnReassign_xpath);

			break;
		}
		return new CaseManagementCycleTriagerPage(driver);
	}

	public void OpenComplexCaseAndVerifySubject(String expectedSubject, String expectedFromAddress) throws Exception {

		driver.switchTo().defaultContent();
		// click on exception WB
		Thread.sleep(15000);
		xpath_GenericMethod_Click(complex_workbasket);
		xpath_GenericMethod_Click(refresh);
		xpath_GenericMethod_Click(refresh);
		Thread.sleep(3000);
		xpath_GenericMethod_Click_By_JavaScript(case_heading_label);
		Thread.sleep(3000);
		xpath_GenericMethod_Click_By_JavaScript(case_heading_label);
		Thread.sleep(3000);
		List<WebElement> list_of_cases = driver.findElements(By.xpath(case_list));
		int total_cases = list_of_cases.size();
		System.out.println(total_cases);
		for (int i = 0; i < total_cases; i++) {
			// driver.navigate().refresh();
			waitFor(5);
			xpath_GenericMethod_Click(First_case);

/*			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(list_of_cases.get(i)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", list_of_cases.get(i));*/
			driver.switchTo().defaultContent();
			goToFrameByTag_IdByXpath(subject_label);
			WebElement subject = driver.findElement(By.xpath(subject_label));
			WebElement fromAddress = driver.findElement(By.xpath(from_address));
			String actualSubject = subject.getText();
			System.out.println("Actual subject in side the case is : " + actualSubject);
			String actualFromAddress = fromAddress.getText();
			System.out.println("Actual from address in side the case is :" + actualFromAddress);
			if (actualSubject.equals(expectedSubject) && actualFromAddress.equals(expectedFromAddress)) {
				System.out.println("Subjcet and Address matches with expected");
				Assert.assertTrue(true);
				break;
			} else {
				xpath_GenericMethod_Click(cancel_button);
				System.out.println("Subjcet and Address not matches with expected");
				Assert.assertFalse(false);
			}

		}

	}

	public void OpenExceptionCaseAndVerifySubject(String expectedSubject, String expectedFromAddress) throws Exception {

		driver.switchTo().defaultContent();
		// click on exception WB
		Thread.sleep(15000);
		xpath_GenericMethod_Click(Exception_workbasket);
		xpath_GenericMethod_Click(refresh);
		xpath_GenericMethod_Click(refresh);
		xpath_GenericMethod_Click_By_JavaScript(case_heading_label);
		Thread.sleep(3000);
		xpath_GenericMethod_Click_By_JavaScript(case_heading_label);

		Thread.sleep(3000);
		List<WebElement> list_of_cases = driver.findElements(By.xpath(case_list));
		int total_cases = list_of_cases.size();
		System.out.println(total_cases);
		for (int i = 0; i < total_cases; i++) {
			waitFor(5);
			xpath_GenericMethod_Click(First_case);
			/*WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(list_of_cases.get(i)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", list_of_cases.get(i));*/
			driver.switchTo().defaultContent();

			goToFrameByTag_IdByXpath(subject_label);
			WebElement subject = driver.findElement(By.xpath(subject_label));
			WebElement fromAddress = driver.findElement(By.xpath(from_address));
			String actualSubject = subject.getText();
			System.out.println("Actual subject in side the case is : " + actualSubject);
			String actualFromAddress = fromAddress.getText();
			System.out.println("Actual from address in side the case is :" + actualFromAddress);
			if (actualSubject.equals(expectedSubject) && actualFromAddress.equals(expectedFromAddress)) {
				System.out.println("Subjcet and Address matches with expected");
				Assert.assertTrue(true);
				break;
			} else {
				xpath_GenericMethod_Click(cancel_button);
				System.out.println("Subjcet and Address not matches with expected");
				Assert.assertFalse(false);
			}
		}
	}

	/*
	 * #############################################################################
	 * Author : Babu Scenario : reassign work Description : reassign work-operator
	 * #############################################################################
	 */

	public CaseManagementCycleTriagerPage reassignworktooperator() throws Exception {
		driver.switchTo().defaultContent();
		// click on exception WB
		Thread.sleep(3000);
		xpath_GenericMethod_Click(complex_workbasket);
		xpath_GenericMethod_Click(refresh);
		xpath_GenericMethod_Click(refresh);

		Thread.sleep(3000);
		List<WebElement> list_of_cases = driver.findElements(By.xpath(case_list));
		int total_cases = list_of_cases.size();
		System.out.println(total_cases);
		for (int i = 0; i < total_cases; i++) {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(list_of_cases.get(i)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", list_of_cases.get(i));
			driver.switchTo().defaultContent();
			xpath_GenericMethod_Click(actions_xpath);
			Thread.sleep(2000);
			xpath_GenericMethod_Click(reassign_xpath);
			Thread.sleep(2000);
			xpath_GenericMethod_selectFromDropdownUsingIndexbyclickingOnDropdown(transferto_xpath, 2);
			Thread.sleep(3000);
			xpath_GenericMethod_Sendkeys(workqueue_xpath, "Triage user");
			Thread.sleep(3000);
			// xpath_GenericMethod_Click(Complex_xpath);
			Thread.sleep(3000);
			xpath_GenericMethod_Click(compl_xpath);
			Thread.sleep(3000);
			xpath_GenericMethod_Click(btnReassign_xpath);

			break;
		}
		return new CaseManagementCycleTriagerPage(driver);
	}

	/*
	 * #############################################################################
	 * Author : Babu Scenario : forward mail work Description : forward mail to
	 * multiple user
	 * #############################################################################
	 */

	public CaseManagementCycleTriagerPage forwardEmail() throws Exception {
		driver.switchTo().defaultContent();
		// click on exception WB
		Thread.sleep(3000);
		xpath_GenericMethod_Click(Exception_workbasket);
		xpath_GenericMethod_Click(refresh);
		xpath_GenericMethod_Click(refresh);
		
		xpath_GenericMethod_Click(case_heading_label);
		Thread.sleep(3000);
		xpath_GenericMethod_Click(case_heading_label);

		Thread.sleep(3000);

		Thread.sleep(3000);
		List<WebElement> list_of_cases = driver.findElements(By.xpath(case_list));
		int total_cases = list_of_cases.size();
		System.out.println(total_cases);
		for (int i = 0; i < total_cases; i++) {
			

			xpath_GenericMethod_Click(First_case);

/*			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(list_of_cases.get(i)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", list_of_cases.get(i));*/
			driver.switchTo().defaultContent();
			xpath_GenericMethod_Click(actions_xpath);
			Thread.sleep(2000);
			xpath_GenericMethod_Click(forwardEmail_xpath);

			Thread.sleep(2000);
			xpath_GenericMethod_Click(mail_submit);
			String text = driver.switchTo().alert().getText();
			System.out.println("fetch text:" + text);
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Assert.assertEquals("Please correct flagged fields before submitting the form!", text);

			Thread.sleep(2000);
			xpath_GenericMethod_Sendkeys(tomail_xpath, "baburao.lunavath@qbe.com;durga.subramanyam@qbe.com;");

			Thread.sleep(2000);
			xpath_GenericMethod_Click(mail_submit);
			Thread.sleep(6000);
			xpath_GenericMethod_Click(actions_xpath);
			Thread.sleep(2000);
			xpath_GenericMethod_Click(refreshaction);
			break;

		}
		return new CaseManagementCycleTriagerPage(driver);
	}

	public CaseManagementCycleTriagerPage composeNewEmail() throws Exception {
		driver.switchTo().defaultContent();
		// click on exception WB
		Thread.sleep(3000);
		xpath_GenericMethod_Click(Exception_workbasket);
		xpath_GenericMethod_Click(refresh);
		xpath_GenericMethod_Click(refresh);
		
		xpath_GenericMethod_Click(case_heading_label);
		Thread.sleep(3000);
		xpath_GenericMethod_Click(case_heading_label);
		Thread.sleep(3000);

	
		List<WebElement> list_of_cases = driver.findElements(By.xpath(case_list));
		int total_cases = list_of_cases.size();
		System.out.println(total_cases);
		for (int i = 0; i < total_cases; i++) {
			

			xpath_GenericMethod_Click(First_case);

/*			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(list_of_cases.get(i)));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", list_of_cases.get(i));*/
			driver.switchTo().defaultContent();
			xpath_GenericMethod_Click(actions_xpath);
			Thread.sleep(2000);
			xpath_GenericMethod_Click(newemail);

			Thread.sleep(2000);
			xpath_GenericMethod_Click(mail_submit);
			Thread.sleep(6000);
			xpath_GenericMethod_Click(actions_xpath);
			Thread.sleep(2000);
			xpath_GenericMethod_Click(refreshaction);

			break;

		}
		return new CaseManagementCycleTriagerPage(driver);
	}
}
