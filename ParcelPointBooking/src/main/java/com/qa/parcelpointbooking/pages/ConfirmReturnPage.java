package com.qa.parcelpointbooking.pages;

/**
 * ConfirmReturnPage is an Object for Confirm Return Page and define all 
 * Web-elements and respective actions.
 *  
 * 
 * @author Koyal
 * 
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.parcelpointbooking.base.TestBase;

public class ConfirmReturnPage extends TestBase {

	// Define Page Factory or Object Repository
	//Finding  element for orderId 
	@FindBy(xpath = "//*[@id='wrap']/div[2]/div/div/div[2]/div[2]/div/p[1]")
	WebElement orderId;
	
	//Finding  element for return reason 
	@FindBy(xpath = "//*[@id='wrap']/div[2]/div/div/div[2]/div[2]/div/p[3]")
	WebElement returnReason;
	
	//Finding  element for additional details 
	@FindBy(xpath = "//*[@id='wrap']/div[2]/div/div/div[2]/div[2]/div/p[4]")
	WebElement additionaDetails;

	// Initialize Web-elements of page factory
	public ConfirmReturnPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	// Actions on the page
	
	// Get page URL
	public String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}

	// Get Order id
	public String getOrderId() {
		String id = orderId.getText();
		return id;
	}

	// Get Return Reason
	public String getReturnReason() {
		String reason = returnReason.getText();
		return reason;
	}

	// Get Additional Details text
	public String getAdditionalDetails() {
		String detail = additionaDetails.getText();
		return detail;
	}
}
