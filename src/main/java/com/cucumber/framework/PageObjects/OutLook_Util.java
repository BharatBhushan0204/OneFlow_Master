package com.cucumber.framework.PageObjects;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.WebDriver;

import com.cucumber.framework.GeneralHelperSel.SeleniumFunc;

public class OutLook_Util extends SeleniumFunc implements OneFlowLoginLoc{
	
	public OutLook_Util(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public static void sendMail(String subject, String body)
	{
		final String username = "bharatbhushan.thanikanti@qbe.com";
        final String password = "Ammananna@04bb";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "outlook.office365.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("bharatbhushan.thanikanti@qbe.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("underwriting_test2@qbe.com"));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Mail sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

	}
	
	
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
        
        OneFlowLoginPage.LaunchQBEApp();
        //driver.quit();
        return new OneFlowLoginPage(driver);
       
        
 }

}
