package com.cucumber.framework.PageObjects;

import java.util.ArrayList;


import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import com.cucumber.framework.GeneralHelperSel.LoggerHelper;
import com.cucumber.framework.GeneralHelperSel.SeleniumFunc;

import com.cucumber.framework.configreader_TestBase.ObjectRepo;
import com.cucumber.framework.configreader_TestBase.TestBase;




public class OneFlowLoginPage extends SeleniumFunc implements OneFlowLoginLoc {

	private final Logger log = LoggerHelper.getLogger(OneFlowLoginPage.class);
	static OneFlowLoginPage oneFlowLoginPage;
	static SeleniumFunc seleniumFunc;
	public OneFlowLoginPage(WebDriver driver) {
		super(driver);
	}

	public void OneFlowLoginPage(OneFlowLoginPage oneFlowLoginPage) {
		this.oneFlowLoginPage = oneFlowLoginPage;
		
	}

	public void sendInformationNoteObject(OneFlowLoginPage oneFlowLoginPage) {
		this.oneFlowLoginPage = oneFlowLoginPage;

	}

	/*#############################################################################
	 * Author : Babu
	 * Scenario Outlook browser intialization
	 * #############################################################################*/
	
	public static OneFlowLoginPage LaunchOutLookApp() {
		
		//initialize the browser and load the url 

		if (ObjectRepo.reader.getRun().equalsIgnoreCase("jenkins")) {
			TestBase.getDriver().get(System.getProperty("URL"));
		} else {
			TestBase.getDriver().get(ObjectRepo.reader.getOutLookUrl());
		}
		
		oneFlowLoginPage = new OneFlowLoginPage(TestBase.getDriver());
		oneFlowLoginPage.OneFlowLoginPage(oneFlowLoginPage);
		System.out.println("******Outlook application Browser intialization successfully completed*******");

		return new OneFlowLoginPage(driver);

	}
	
	/*#############################################################################
	 * Author : Babu
	 * Scenario QBE Application browser intialization
	 * #############################################################################*/
public static OneFlowLoginPage LaunchQBEApp() {
		
		//initialize the browser and load the url 

		if (ObjectRepo.reader.getRun().equalsIgnoreCase("jenkins")) {
			TestBase.getDriver().get(System.getProperty("URL"));
		} else {
			TestBase.getDriver().get(ObjectRepo.reader.getApplicationUrl());
		}
		
		oneFlowLoginPage = new OneFlowLoginPage(TestBase.getDriver());
		oneFlowLoginPage.OneFlowLoginPage(oneFlowLoginPage);
		System.out.println("******QE Application Browser intialization successfully completed*******");

		return new OneFlowLoginPage(driver);

	}

/*#############################################################################
 * Author : Babu
 * Scenario :Outlook login 
 * #############################################################################*/
	
public static OneFlowLoginPage loginOutlook(String unamemail, String pwdmail) throws Exception {
        

        Thread.sleep(3000);
        xpath_GenericMethod_Click(sigin_xpath);
        Thread.sleep(3000);
        xpath_GenericMethod_Sendkeys(user_xpath, unamemail);
		Thread.sleep(3000);
		xpath_GenericMethod_Click(submit);
        Thread.sleep(3000);
        xpath_GenericMethod_Click(linktext);
        Thread.sleep(3000);
        
        return new OneFlowLoginPage(driver);
 }

/*#############################################################################
 * Author : Babu
 * Scenario :Outlook send mail
 * #############################################################################*/
	
	public static OneFlowLoginPage sendMail(String mailto, String mailsubject, String mailbody) throws Exception {
        
        ArrayList<String> list=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(list.get(1));
        Thread.sleep(3000);
        
        xpath_GenericMethod_Click(massage_xpath);
        Thread.sleep(3000);
        xpath_GenericMethod_Sendkeys(tomail_xpath, mailto);
        xpath_GenericMethod_Sendkeys(subject_xpath, mailsubject);
        xpath_GenericMethod_Sendkeys(mailbody_xpath, mailbody);
        captureScreen("Mail information send");
        xpath_GenericMethod_Click(send_xpath);
        Thread.sleep(2000);
        xpath_GenericMethod_Click(BLtext_xpath);
        Thread.sleep(3000);
        captureScreen("Logout outlook");
        xpath_GenericMethod_Click(siginout);
        
        //driver.quit();
        return new OneFlowLoginPage(driver);
       
        
 }
	
	/*#############################################################################
	 * Author : Babu
	 * Scenario :oneflow Login 
	 * #############################################################################*/

	public static OneFlowLoginPage applogin(String username, String password) throws Exception {
		
		//login into application with valid user name and password verify assertion
		String titleofloginpage = driver.getTitle();
		xpath_GenericMethod_Sendkeys(username_Xpath, username);
		xpath_GenericMethod_Sendkeys(password_Xpath, password);
		xpath_GenericMethod_Click(logginbtn_Xpath);
		Thread.sleep(20000);
		String titleofthehomepage = driver.getTitle();
		Assert.assertNotEquals(titleofloginpage, titleofthehomepage);

		if (titleofthehomepage.equalsIgnoreCase("Pega Case Manager Portal"))
			Assert.assertEquals("Pega Case Manager Portal", titleofthehomepage,
					"login into application successfully completed");

		else
			Assert.assertFalse(false, "login failed");

		return new OneFlowLoginPage(driver);

	}
	
	/*#############################################################################
	 * Author : Babu
	 * Scenario : oneflow Logout
	 * #############################################################################*/
	
	public static OneFlowLoginPage applogout() throws Exception {

		
		// application logout and close the browser
		driver.switchTo().defaultContent();
		xpath_GenericMethod_Click(logoffbutton);
		xpath_GenericMethod_Click(logoff);
		String title = driver.getTitle();
		Assert.assertEquals("Pega Platform", title, "logoff successful");
		System.out.println("*******====*****Logout successfully Completed********====****");
		//driver.quit();

		return new OneFlowLoginPage(driver);

	}

}
