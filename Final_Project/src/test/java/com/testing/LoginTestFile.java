package com.testing;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestFile {
    

	LoginPageFile loginPg = new LoginPageFile();
	

	@BeforeMethod
	public void beforeMethod() throws Exception {
		loginPg.openBrowser();
		
	}
	
    @AfterMethod
	public void afterMethod() throws Exception {
		loginPg.closeBrowser();
	}
    
    
    @Test 
    public void TC_Login_001() throws InterruptedException
    {   
    	Thread.sleep(1000);
    	loginPg.emailDisplayed();
    }
    
    @Test  
    public void TC_Login_002() throws Exception {
  	  loginPg.nextDisplayed();
    }
    

    @Test  
    public void TC_Login_003_to_TC_Login_007() throws  InterruptedException {
   	 loginPg.invalidEmail();
    } 
    
    
   @Test  
    public void TC_Login_008() throws  InterruptedException {
   	loginPg.validEmail();
   	}
    
   
   @Test
    public void TC_Login_009() throws  InterruptedException {
   	loginPg.emptyPassword();
   	}
   
   @Test
   public void TC_Login_010() throws  InterruptedException {
  	loginPg.wrongPassword();
   }
   

   @Test
   public void TC_Login_011() throws  InterruptedException {
  	loginPg.validCredentials();
   }
}
    
    
    

