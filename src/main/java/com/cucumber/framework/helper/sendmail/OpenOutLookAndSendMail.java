package com.cucumber.framework.helper.sendmail;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.framework.GeneralHelperSel.SeleniumFunc;

public class OpenOutLookAndSendMail {

	public static WebDriver outlookDriver;

	public static void SendMailThroughOut() throws Exception {
		// TODO Auto-generated method stub

		String sigin_xpath = "//a[@aria-label='Sign in']";

		String user_xpath = "//input[@id='i0116']";
		String submit = "//input[@type='submit']";
		String pwd_xpath = "//input[@id='i0118']";
		String ibutton = "//input[@id='idSIButton9']";
		String linktext = "//span[@class='ms-ohp-svg-Icon ms-ohp-Icon ms-ohp-Icon--outlookLogo ms-ohp-Icon--outlookLogoFill ng-star-inserted']";

		String massage_xpath = "//span[text()='New message']";
		String tomail_xpath = "//div[text()='To']/following-sibling::input";
		String subject_xpath = "//input[@id='subjectLine0']";
		String mailbody_xpath = "//div[@aria-label='Message body']";
		String send_xpath = "//span[text()='Send']";
		String BLtext_xpath = "//img[@alt='BT']";
		String siginout = "//a[text()='Sign out']";

		// login application locators

		String username_Xpath = "//input[@id='txtUserID']";
		String password_Xpath = "//input[@id='txtPassword']";
		String logginbtn_Xpath = "//button[@id='sub']";

		// logout application locators

		String logoffbutton = "//i[@title='Triage user']";
		String logoff = "//span[text()='Log off']";

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
		outlookDriver = new ChromeDriver();
		outlookDriver.get("https://www.office.com/");
		outlookDriver.manage().window().maximize();
		Thread.sleep(3000);

		Thread.sleep(3000);
		xpath_GenericMethod_Click(sigin_xpath);
		Thread.sleep(3000);
		xpath_GenericMethod_Sendkeys(user_xpath, "bharatbhushan.thanikanti@qbe.com");
		Thread.sleep(3000);
		xpath_GenericMethod_Click(submit);
		Thread.sleep(3000);

		// xpath_GenericMethod_Click(ibutton);
		// xpath_GenericMethod_Click(ibutton);
		xpath_GenericMethod_Click(linktext);
		Thread.sleep(3000);

		ArrayList<String> list = new ArrayList<String>(outlookDriver.getWindowHandles());
		outlookDriver.switchTo().window(list.get(1));
		Thread.sleep(3000);

		xpath_GenericMethod_Click(massage_xpath);
		Thread.sleep(3000);
		xpath_GenericMethod_Sendkeys(tomail_xpath, "Baburao.Lunavath@qbe.com");
		xpath_GenericMethod_Sendkeys(subject_xpath, "Test Mailing");
		xpath_GenericMethod_Sendkeys(mailbody_xpath, "Demo");
		xpath_GenericMethod_Click(send_xpath);
		Thread.sleep(2000);
		xpath_GenericMethod_Click(BLtext_xpath);
		Thread.sleep(3000);
		xpath_GenericMethod_Click(siginout);
		outlookDriver.quit();
	}
	
	public static String goToFrameByTag_IdByXpath(String xpath) throws InterruptedException {
		System.out.println("In GoToFrames Method Start");
		String frameNameone = null;
		List<WebElement> frames = outlookDriver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (int i = 0; i < frames.size(); i++) {
			System.out.println(frames.get(i).getAttribute("id"));
			String frameNametwo = frames.get(i).getAttribute("id");
			outlookDriver.switchTo().defaultContent();
			Thread.sleep(5000);
			outlookDriver.switchTo().frame(frameNametwo);
			try {
				if (outlookDriver.findElement(By.xpath(xpath)).isDisplayed()) {
					System.out.println("Element" + xpath + "is present in the frame :" + frameNametwo);
					frameNameone = frameNametwo;
					break;
				}
			} catch (Exception e) {
				System.out.println("Element is not present inside the frame :" + xpath);
				outlookDriver.switchTo().defaultContent();
			}
		}
		System.out.println("In GoToFrames Method End");
		return frameNameone;
	}

	public static String goToFrameByTag_IdByName(String name) throws InterruptedException {
		System.out.println("In GoToFrames Method Start");
		String frameNameone = null;
		List<WebElement> frames = outlookDriver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (int i = 0; i < frames.size(); i++) {
			System.out.println(frames.get(i).getAttribute("id"));
			String frameNametwo = frames.get(i).getAttribute("id");
			outlookDriver.switchTo().defaultContent();
			Thread.sleep(5000);
			outlookDriver.switchTo().frame(frameNametwo);
			try {
				if (outlookDriver.findElement(By.name(name)).isDisplayed()) {
					System.out.println("Element" + name + "is present in the frame :" + frameNametwo);
					frameNameone = frameNametwo;
					break;
				}
			} catch (Exception e) {
				System.out.println("Element is not present inside the frame :" + name);
				outlookDriver.switchTo().defaultContent();
			}
		}
		System.out.println("In GoToFrames Method End");
		return frameNameone;
	}

	public static String goToFrameByTag_IdById(String id) throws InterruptedException {
		System.out.println("In GoToFrames Method Start");
		String frameNameone = null;
		List<WebElement> frames = outlookDriver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (int i = 0; i < frames.size(); i++) {
			System.out.println(frames.get(i).getAttribute("id"));
			String frameNametwo = frames.get(i).getAttribute("id");
			outlookDriver.switchTo().defaultContent();
			Thread.sleep(5000);
			outlookDriver.switchTo().frame(frameNametwo);
			try {
				if (outlookDriver.findElement(By.id(id)).isDisplayed()) {
					System.out.println("Element" + id + "is present in the frame :" + frameNametwo);
					frameNameone = frameNametwo;
					break;
				}
			} catch (Exception e) {
				System.out.println("Element is not present inside the frame :" + id);
				outlookDriver.switchTo().defaultContent();
			}
		}
		System.out.println("In GoToFrames Method End");
		return frameNameone;
	}

	public static String goToFrameByTag_NameByXpath(String xpath) throws InterruptedException {
		System.out.println("In GoToFrames Method Start");
		String frameNameone = null;
		List<WebElement> frames = outlookDriver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (int i = 0; i < frames.size(); i++) {
			System.out.println(frames.get(i).getAttribute("name"));
			String frameNametwo = frames.get(i).getAttribute("name");
			outlookDriver.switchTo().defaultContent();
			Thread.sleep(5000);
			outlookDriver.switchTo().frame(frameNametwo);
			try {
				if (outlookDriver.findElement(By.xpath(xpath)).isDisplayed()) {
					System.out.println("Element" + xpath + "is present in the frame: " + frameNametwo);
					frameNameone = frameNametwo;
					break;
				}
			} catch (Exception e) {
				System.out.println("Element is not present inside the frame: " + xpath);
				outlookDriver.switchTo().defaultContent();
			}
		}
		System.out.println("In GoToFrames Method End");
		return frameNameone;
	}

	public static String goToFrameByTag_NameByName(String name) throws InterruptedException {
		System.out.println("In GoToFrames Method Start");
		String frameNameone = null;
		List<WebElement> frames = outlookDriver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (int i = 0; i < frames.size(); i++) {
			System.out.println(frames.get(i).getAttribute("name"));
			String frameNametwo = frames.get(i).getAttribute("name");
			outlookDriver.switchTo().defaultContent();
			Thread.sleep(5000);
			outlookDriver.switchTo().frame(frameNametwo);
			try {
				if (outlookDriver.findElement(By.name(name)).isDisplayed()) {
					System.out.println("Element" + name + "is present in the frame: " + frameNametwo);
					frameNameone = frameNametwo;
					break;
				}
			} catch (Exception e) {
				System.out.println("Element is not present inside the frame: " + name);
				outlookDriver.switchTo().defaultContent();
			}
		}
		System.out.println("In GoToFrames Method End");
		return frameNameone;
	}

	public static String goToFrameByTag_NameById(String id) throws InterruptedException {
		System.out.println("In GoToFrames Method Start");
		String frameNameone = null;
		List<WebElement> frames = outlookDriver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (int i = 0; i < frames.size(); i++) {
			System.out.println(frames.get(i).getAttribute("name"));
			String frameNametwo = frames.get(i).getAttribute("name");
			outlookDriver.switchTo().defaultContent();
			Thread.sleep(5000);
			outlookDriver.switchTo().frame(frameNametwo);
			try {
				if (outlookDriver.findElement(By.id(id)).isDisplayed()) {
					System.out.println("Element" + id + "is present in the frame: " + frameNametwo);
					frameNameone = frameNametwo;
					break;
				}
			} catch (Exception e) {
				System.out.println("Element is not present inside the frame: " + id);
				outlookDriver.switchTo().defaultContent();
			}
		}
		System.out.println("In GoToFrames Method End");
		return frameNameone;
	}

	// Generic method for click on links,radio buttons,check boxes,drop down and
	// text boxes using xpath
	public static void xpath_GenericMethod_Click(String xpath) throws Exception {

		try {
			
			String frames=goToFrameByTag_NameByXpath(xpath);
			System.out.println("using getattribute name");
			if(frames==null) {
			goToFrameByTag_IdByXpath(xpath);
			System.out.println("using getattribute Id");	
			}
		} catch (Exception e) {
			e.getMessage();
		}
		WebElement ele = outlookDriver.findElement(By.xpath(xpath));
		waitForElement(ele, 3);
		ele.click();
		waitFor(2);
		outlookDriver.switchTo().defaultContent();
	}

	// Generic method for click on links,radio buttons,check boxes,drop down and
	// text boxes using id
	public static void id_GenericMethod_Click(String id) throws Exception {

		try {
			goToFrameByTag_NameById(id);
			System.out.println("using getattribute name");
		} catch (Exception e) {
			goToFrameByTag_IdById(id);
			System.out.println("using getattribute Id");
		}
		WebElement ele = outlookDriver.findElement(By.id(id));
		waitForElement(ele, 3);
		ele.click();
		waitFor(2);
	}

	// Generic method for click on links,radio buttons,check boxes,drop down and
	// text boxes using name
	public static void name_GenericMethod_Click(String name) throws Exception {

		try {
			goToFrameByTag_NameByName(name);
			System.out.println("using getattribute name");
		} catch (Exception e) {
			goToFrameByTag_IdByName(name);
			System.out.println("using getattribute Id");
		}
		WebElement ele = outlookDriver.findElement(By.name(name));
		waitForElement(ele, 3);
		ele.click();
		waitFor(2);
	}

	// Generic method for clear on text boxes and textarea using xpath
	public static void xpath_GenericMethod_Clear(String xpath) throws Exception {

		try {
			goToFrameByTag_NameByXpath(xpath);
			System.out.println("using getattribute name");
		} catch (Exception e) {
			goToFrameByTag_IdByXpath(xpath);
			System.out.println("using getattribute Id");
		}
		WebElement ele = outlookDriver.findElement(By.xpath(xpath));
		waitForElement(ele, 3);
		ele.clear();
		waitFor(2);
	}

	// Generic method for clear on text boxes and textarea using id
	public static void id_GenericMethod_Clear(String id) throws Exception {

		try {
			goToFrameByTag_NameById(id);
			System.out.println("using getattribute name");
		} catch (Exception e) {
			goToFrameByTag_IdById(id);
			System.out.println("using getattribute Id");
		}
		WebElement ele = outlookDriver.findElement(By.id(id));
		waitForElement(ele, 3);
		ele.clear();
		waitFor(2);
	}

	// Generic method for clear on text boxes and textarea using name
	public static void name_GenericMethod_Clear(String name) throws Exception {

		try {
			goToFrameByTag_NameByName(name);
			System.out.println("using getattribute name");
		} catch (Exception e) {
			goToFrameByTag_IdByName(name);
			System.out.println("using getattribute Id");
		}
		WebElement ele = outlookDriver.findElement(By.name(name));
		waitForElement(ele, 3);
		ele.clear();
		waitFor(2);
	}

	// Generic method for sendkeys on text boxes and textarea using xpath
	public static void xpath_GenericMethod_Sendkeys(String xpath, String testdata) throws Exception {

		try {
			String frames=goToFrameByTag_NameByXpath(xpath);
			System.out.println("using getattribute name");
			if(frames==null) {
			goToFrameByTag_IdByXpath(xpath);
			System.out.println("using getattribute Id");	
			}
		} catch (Exception e) {
			e.getMessage();
		}
		WebElement ele = outlookDriver.findElement(By.xpath(xpath));
		waitForElement(ele, 3);
		ele.sendKeys(testdata);
		waitFor(2);
		outlookDriver.switchTo().defaultContent();
	}

	// Generic method for sendkeys on text boxes and textarea using id
	public static void id_GenericMethod_Sendkeys(String id, String testdata) throws Exception {

		try {
			goToFrameByTag_NameById(id);
			System.out.println("using getattribute name");
		} catch (Exception e) {
			goToFrameByTag_IdById(id);
			System.out.println("using getattribute Id");
		}
		WebElement ele = outlookDriver.findElement(By.id(id));
		waitForElement(ele, 3);
		ele.sendKeys(testdata);
		waitFor(2);
	}

	// Generic method for sendkeys on text boxes and textarea using name
	public static void name_GenericMethod_Sendkeys(String name, String testdata) throws Exception {

		try {
			goToFrameByTag_NameByName(name);
			System.out.println("using getattribute name");
		} catch (Exception e) {
			goToFrameByTag_IdByName(name);
			System.out.println("using getattribute Id");
		}
		WebElement ele = outlookDriver.findElement(By.name(name));
		waitForElement(ele, 3);
		ele.sendKeys(testdata);
		waitFor(2);
	}

	public static void waitForElement(WebElement element, int timeunitForsec) {
		WebDriverWait wait = new WebDriverWait(outlookDriver, timeunitForsec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitFor(int millisec) {
		try {
			Thread.sleep(millisec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void xpath_SelectFromDropdownUsingVisibleText(String expath, String valuetoselect) {
		Select s = new Select(outlookDriver.findElement(By.xpath(expath)));
		s.selectByVisibleText(valuetoselect);
	}

	public static void name_SelectFromDropdownUsingVisibleText(String name, String valuetoselect) {
		Select s = new Select(outlookDriver.findElement(By.name(name)));
		s.selectByVisibleText(valuetoselect);
	}

	public static void id_SelectFromDropdownUsingVisibleText(String id, String valuetoselect) {
		Select s = new Select(outlookDriver.findElement(By.id(id)));
		s.selectByVisibleText(valuetoselect);
	}

	public static void xpath_SelectFromDropdownUsingIndex(String expath, int indexvalue) {
		Select s = new Select(outlookDriver.findElement(By.xpath(expath)));
		s.selectByIndex(indexvalue);
	}

	public static void name_SelectFromDropdownUsingIndex(String name, int indexvalue) {
		Select s = new Select(outlookDriver.findElement(By.name(name)));
		s.selectByIndex(indexvalue);
	}

	public static void id_SelectFromDropdownUsingIndex(String id, int indexvalue) {
		Select s = new Select(outlookDriver.findElement(By.id(id)));
		s.selectByIndex(indexvalue);
	}

	public static void xpath_SelectFromDropdownUsingValue(String expath, String value) {
		Select s = new Select(outlookDriver.findElement(By.xpath(expath)));
		s.selectByValue(value);
	}

	public static void name_SelectFromDropdownUsingValue(String name, String value) {
		Select s = new Select(outlookDriver.findElement(By.name(name)));
		s.selectByValue(value);
	}

	public static void id_SelectFromDropdownUsingValue(String id, String value) {
		Select s = new Select(outlookDriver.findElement(By.id(id)));
		s.selectByValue(value);
	}
}
