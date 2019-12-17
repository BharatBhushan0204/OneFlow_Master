package com.cucumber.framework.PageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cucumber.framework.GeneralHelperSel.LoggerHelper;
import com.cucumber.framework.GeneralHelperSel.SeleniumFunc;

public class CommonPage extends SeleniumFunc implements CaseManagementCycleCSOPageLoc, CaseManagementCycleSMPageLoc,
		CaseManagementCycleTriagerPageLoc, CommonPageLoc {
	
	private final Logger log = LoggerHelper.getLogger(CommonPage.class);

	CommonPage commonPage;


	public CommonPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void caseVerification(String xpath, String expectedSubject, String expectedFromAddress)
			throws Exception {
		driver.switchTo().defaultContent();
		// click on exception WB
		waitFor(3);
		xpath_GenericMethod_Click(xpath);
		xpath_GenericMethod_Click(refresh);
		xpath_GenericMethod_Click(refresh);
		List<WebElement> list_of_cases = driver.findElements(By.xpath(case_list));
		int total_cases = list_of_cases.size();
		System.out.println("total list of cases:" + total_cases);
		for (int i = 2; i <= total_cases + 1; i++) {
			waitFor(2);
			driver.findElement(By.xpath("(//table)[3]/tbody/tr[" + i + "]/td[3]")).click();
			waitFor(5);
			driver.switchTo().defaultContent();
			waitFor(3);
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
				waitFor(2);
				//xpath_GenericMethod_Click(closebutton);
				waitFor(2);
				break;
			} else {
				xpath_GenericMethod_Click(closebutton);
				waitFor(2);
				xpath_GenericMethod_Click(refresh);
				xpath_GenericMethod_Click(refresh);
				waitFor(5);
			}

		}

	}
	
	public static void caseAndPriorityVerification(String xpath, String expectedSubject, String expectedFromAddress, String expectedPriority)
			throws Exception {
		driver.switchTo().defaultContent();
		// click on exception WB
		waitFor(3);
		xpath_GenericMethod_Click(xpath);
		xpath_GenericMethod_Click(refresh);
		xpath_GenericMethod_Click(refresh);
		List<WebElement> list_of_cases = driver.findElements(By.xpath(case_list));
		int total_cases = list_of_cases.size();
		System.out.println("total list of cases:" + total_cases);
		for (int i = 2; i <= total_cases + 1; i++) {
			waitFor(2);
			
			String actualPriority = driver.findElement(By.xpath("(//table)[3]/tbody/tr[" + i + "]/td[2]")).getText();
			driver.findElement(By.xpath("(//table)[3]/tbody/tr[" + i + "]/td[3]")).click();
			waitFor(5);
			driver.switchTo().defaultContent();
			waitFor(3);
			goToFrameByTag_IdByXpath(subject_label);
			WebElement subject = driver.findElement(By.xpath(subject_label));
			WebElement fromAddress = driver.findElement(By.xpath(from_address));
			String actualSubject = subject.getText();
			System.out.println("Actual subject in side the case is : " + actualSubject);
			String actualFromAddress = fromAddress.getText();
			System.out.println("Actual from address in side the case is :" + actualFromAddress);
			if (actualSubject.equals(expectedSubject) && actualFromAddress.equals(expectedFromAddress) && actualPriority.equalsIgnoreCase(expectedPriority)) {
				System.out.println("Subjcet and Address matches with expected");
				Assert.assertTrue(true);
				waitFor(2);
				//xpath_GenericMethod_Click(closebutton);
				waitFor(2);
				break;
			} else {
				xpath_GenericMethod_Click(closebutton);
				waitFor(2);
				xpath_GenericMethod_Click(refresh);
				xpath_GenericMethod_Click(refresh);
				waitFor(5);
			}

		}

	}

}
