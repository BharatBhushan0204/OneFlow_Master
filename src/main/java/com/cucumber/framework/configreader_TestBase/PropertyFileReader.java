
package com.cucumber.framework.configreader_TestBase;

import java.util.Properties;

import org.apache.log4j.Level;

import com.cucumber.framework.GeneralHelperSel.ResourceHelper;
import com.cucumber.framework.configuration.browser.BrowserType;


public class PropertyFileReader implements ConfigReader{

	private Properties prop = null;

	public PropertyFileReader() {
		prop = new Properties();
		try {
			
			prop.load(ResourceHelper.getResourcePathInputStream("/src/main/resources/configfile/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return prop.getProperty("Username");
	}

	public String getPassword() {
		return prop.getProperty("Password");
	}

	public String getApplicationUrl() {
		return prop.getProperty("AppUrl");
	}
	
	public String getOutLookUrl(){
		return prop.getProperty("OutlookUrl");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplcitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	public String getDbType() {
		return prop.getProperty("DataBase.Type");
	}

	public String getDbConnStr() {
		return prop.getProperty("DataBase.ConnectionStr");
	}

	public BrowserType getBrowser() {
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}
	
	public String getRun() {
		return prop.getProperty("Run");
	}
	
}
