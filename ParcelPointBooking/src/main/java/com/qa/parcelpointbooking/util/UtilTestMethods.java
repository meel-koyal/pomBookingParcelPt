package com.qa.parcelpointbooking.util;

public class UtilTestMethods {
	
	public static String getUniqueEmailId()
	{
		StringBuilder uniqueEmailID = new StringBuilder("Test_");
		uniqueEmailID.append(System.currentTimeMillis());
		uniqueEmailID.append("@gmail.com");
		return uniqueEmailID.toString();
	}
	
	

}