package com.testing;

public interface LoginDataFile {

	Xls_Reader data = new Xls_Reader("D:\\Selenium Java class\\final_Project_Doc\\userData.xlsx");
	 public String userEmail = data.getCellData("UserData", 0, 7);
	 public String emptyPassword = data.getCellData("UserData", 1, 8);
	 public String userPassword = data.getCellData("UserData", 1, 9);
	
}