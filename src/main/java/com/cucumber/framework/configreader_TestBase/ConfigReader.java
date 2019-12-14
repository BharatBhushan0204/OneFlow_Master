package com.cucumber.framework.configreader_TestBase;

import com.cucumber.framework.configuration.browser.BrowserType;

public interface ConfigReader {
	public String getUserName();
	public String getPassword();
	public String getApplicationUrl();
	public String getOutLookUrl();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public BrowserType getBrowser();
	public String getRun();
	
}
