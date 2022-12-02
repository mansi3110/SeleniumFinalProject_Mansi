package com.testing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TrashEmailTestFile {
	TrashEmailPageFile TrashPg = new TrashEmailPageFile();

	@BeforeClass
	public void openBrowser() throws Exception {
		TrashPg.openBrowser();
		TrashPg.openURL();
	}

	@AfterClass
	public void closeBrowser() throws Exception {
		TrashPg.closeBrowser();
	}

	@Test(priority = 0)
	public void TC_TrashE_001() throws InterruptedException {
		TrashPg.emailTrash();
	}

	@Test(priority = 1)
	public void TC_TrashE_002() throws InterruptedException {
		TrashPg.emailBack();
	}
}
