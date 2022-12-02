package com.testing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadUnreadTestFile {
	ReadUnreadEmailPageFile RUemail = new ReadUnreadEmailPageFile();

	@BeforeClass
	public void openBrowser() throws Exception {
		RUemail.openBrowser();
		RUemail.openURL();
	}

	@AfterClass
	public void closeBrowser() throws Exception {
		RUemail.closeBrowser();
	}

	@Test(priority = 0)
	public void RU_Check_001() throws InterruptedException {
		RUemail.ReadToUnread();
	}

	@Test(priority = 1)
	public void RU_Check_002() throws InterruptedException {
		RUemail.UnreadToRead();
	}

}
