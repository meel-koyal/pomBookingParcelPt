package com.qa.parcelpointbooking.util;

/**
 * UIMessages is an Interface  that defines all possible error messages  
 * while navigating during parcel booking and all static information that need to be verified
 * 
 * @author Koyal
 * 
 *
 */

public interface UIMessages {
	//List all the UI error messages
	public static String HOME_PAGE_URL = "https://staging.parcelpoint.com.au/adidas/return/method";
	public static String HOME_PAGE_NO_STORE_SEELCTED_ERROR_URL = "https://staging.parcelpoint.com.au/adidas/return/method?hasErrors=true&orderId=&coverageId=0";
	public static String HOME_PAGE_NO_CHECKBOX_SELECTED_ERROR_URL= "https://staging.parcelpoint.com.au/adidas/return/method?hasErrors=true&orderId=";
	public static String RETURN_DETAILS_PAGE_URL = "https://staging.parcelpoint.com.au/adidas/return?orderId=&returnAuthType=FREE";
	public static String RETURN_DETAILS_PAGE_ERROR_URL="https://staging.parcelpoint.com.au/adidas/return?orderId=";
	public static String RETURN_COMPLETE_PAGE_URL= "https://staging.parcelpoint.com.au/adidas/6ZZZ-ZZZP3PLW/return/complete";
	public static String NO_STORE_SELECTION = "Please select a store on the map";
	public static String TERMS_CHECKBOX_NOT_SELECTED = "Please agree to the ParcelPoint Terms of Service";
	public static String INVALID_ORDER_NUM = "Invalid order number";
	public static String NO_REASON_SELECTED = "Return reason required";
	public static String EMPTY_NAME = "Please specify your name";
	public static String EMPTY_EMAIL_ADDRESS = "Please specify your email address";
	public static String EMPTY_PHONE_NUM = "Please specify your phone number";
	public static String CHECK_EXISTING_EMAIL = "This email is already in use. Please login above."; 
	public static String CHECK_PHONE_NUM_FORMAT = "Invalid phone number";
	public static String PARCEL_RETURN_REASON = "Returns Reason: Faulty (12)";
	public static String PARCEL_RETURN_ADDITIONAL_DETAILS = "Additional Details: None";
	public static String PARCEL_RETURN_ORDER_NUM = "AAU0123467";
}
