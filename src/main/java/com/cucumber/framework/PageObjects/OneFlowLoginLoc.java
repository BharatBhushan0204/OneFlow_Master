package com.cucumber.framework.PageObjects;

public interface OneFlowLoginLoc {
	
	/*
	 * #############################################################################
	 * Author: Bharat
	 * outlook login and send mail  to qbe one flow application
	 * #############################################################################
	 */

	String sigin_xpath = "//a[@aria-label='Sign in']";
	String user_xpath = "//input[@id='i0116']";
	String submit = "//input[@type='submit']";
	String pwd_xpath = "//input[@id='i0118']";
	String ibutton = "//input[@id='idSIButton9']";
	String linktext = "//span[@class='ms-ohp-svg-Icon ms-ohp-Icon ms-ohp-Icon--outlookLogo ms-ohp-Icon--outlookLogoFill ng-star-inserted']";
	
	String massage_xpath = "//span[text()='New message']" ;
	String tomail_xpath ="//div[text()='To']/following-sibling::input";
	String subject_xpath ="//input[@id='subjectLine0']";
	String mailbody_xpath ="//div[@aria-label='Message body']";
	String send_xpath= "//span[text()='Send']";
	String BLtext_xpath = "//div[@id='meInitialsButton']//following::img[1]";
	String siginout = "//a[text()='Sign out']";
		
	/*
	 * #############################################################################
	 * Author: Bharat
	 * login QBE application locators
	 * #############################################################################
	 */

	String username_Xpath = "//input[@id='txtUserID']";
	String password_Xpath = "//input[@id='txtPassword']";
	String logginbtn_Xpath = "//button[@id='sub']";
	/*
	 * #############################################################################
	 * Author: Bharat
	 * LogOut QBE application locators
	 * #############################################################################
	 */
	String logoffbutton = "(//i[@tabindex='0'])[3]";
	String logoff = "//span[text()='Log off']";  
	
	

}
