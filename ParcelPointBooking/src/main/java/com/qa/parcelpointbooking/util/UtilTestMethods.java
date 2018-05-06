package com.qa.parcelpointbooking.util;

/**
 * UtilTestMethods is class that generates unique     
 * email ID while booking a parcel.
 *  
 * 
 * @author Koyal
 * 
 *
 */

public class UtilTestMethods {
	
	public static String getUniqueEmailId()
	{
		StringBuilder uniqueEmailID = new StringBuilder("Koyal_Test_");
		uniqueEmailID.append(System.currentTimeMillis());
		uniqueEmailID.append("@gmail.com");
		return uniqueEmailID.toString();
	}
	
	

}