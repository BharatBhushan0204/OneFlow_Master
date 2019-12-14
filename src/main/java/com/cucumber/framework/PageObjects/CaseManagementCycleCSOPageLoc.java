package com.cucumber.framework.PageObjects;

public interface CaseManagementCycleCSOPageLoc {

	/*
	 * #############################################################################
	 * Author : Bharat
	 * Locators of Dashboard(case list screen)
	 * #############################################################################
	 */

	String users_list = "//span[@title=' Click to view assignments in the worklist']";
	String refresh_button = "//button[@title='Refresh List']";
	String case_heading_label = "//div[text()='Case']";
	String case_list1 = "//a[@alt='Click here to open the object']";
	String cancel_button = "//i[@class='icons pi pi-circle-close']";
	String priority_list = "//td[@headers='a2']";
	String Firstuser = "(//span[@title=' Click to view assignments in the worklist'])[1]";
	String Seconduser = "(//span[@title=' Click to view assignments in the worklist'])[2]";
	String FirstCase = "(//a[@data-test-id='201410081557130000198739'])[1]";
	String Plus_icon = "(//span[@class='menu-item-icon-imageclass pi pi-plus'])[1]";
	String New_button = "(//span[@class='menu-item-icon-imageclass pi pi-plus'])[1]";
	String TransactionRequest_button = "//li[@title='Transaction Request']";
	
	/*
	 * #############################################################################
	 * Author: Bharat
	 * Locators of Case details
	 * #############################################################################
	 */
	
	String subject_label = "//div[text()='Subject:']//following::span[1]";
	String from_address = "//div[text()='From:']//following::span[2]";
	String request_type_dropdown = "//select[@id='5042139e']";
	String type_dropdown = "//select[@id='a9b7b0e3']";
	String policy_textbox = "//input[@id='89f1d6bf']";
	String quote_textbox = "//input[@id='fc9b59e6']";
	String CaptureRequestDetails_label = "//span[text()='Capture Request Details']";
	String PolicyStatus_dropdown = "//select[@id='6461acf7']";
	String ClaimId_textbox = "//input[@id='d5793cdc']";
	String InsuredName_textbox = "//input[@id='d8e7ef4d']";
	String UnderWriterName_textbox = "//input[@id='2307fa7a']";
	String UnderWriterRegion_dropdown = "//select[@id='9c605124']";
	String Submit_button = "//button[text()='Submit']";
	String TransactionRequest_id = "//span[@class='workarea_header_id']";
	String CaseResolution_label = "(//span[@class='badge_text'])[2]";
	String ExpirationDate_datafield = "//span[@name='$PpyWorkPage$pRequestDetails$pExpirationDate']";
	String ReceivedDate_datefield = "//span[@name='$PpyWorkPage$pRequestDetails$pReceivedDate']";
	String CurrentDate = "//td[@class='calcell today selected']";
	String Actions_dropdown = "//button[@title='Actions']";
	String CreateRFI_button = "//span[text()='Create RFI']";
	String ReasonCodes_list = "//span[@class='ms-primary-option']";
	/*
	 * #############################################################################
	 * Author: Bharat
	 * Locators of Login and Logout
	 * #############################################################################
	 */

	String username_textfiled = "//input[@id='txtUserID']";
	String password_textfield = "//input[@id='txtPassword']";
	String login_btn = "//span[@class='loginButtonText']";
	String verify_msg = "//a[text()='OneFlow']";
	String logoffbutton = "(//i[@tabindex='0'])[3]";
	String logoff = "//span[text()='Log off']";
	String verify_msg_xpath = "//a[text()='OneFlow']";
}
