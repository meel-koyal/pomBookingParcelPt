package com.qa.parcelpointbooking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qa.parcelpointbooking.base.TestBase;
import com.qa.parcelpointbooking.util.UtilTestMethods;

public class ReturnDetailsPage extends TestBase {
	
	

	// Define Page Factory or Object Repository

	// Finding Order ID input box
	@FindBy(id = "order-number-returns")
	WebElement orderIdBox;

	// Finding error message element without order id
	@FindBy(xpath = "//*[@id='returnsForm']/div[2]//div[1]/div[2]/ul/li[1]/label")
	WebElement noOrderID;

	// Finding Return Reason drop down
	@FindBy(id = "retailerReturnsReasonsId")
	WebElement returnReason;

	// Finding error message element without return reason selection
	@FindBy(xpath = "//*[@id='returnsForm']/div[2]//div[2]/div[2]/ul/li[1]/label")
	WebElement noReturnReasonSelected;

	// Finding Additional Details input box
	@FindBy(id = "retailerAdditionalDetails")
	WebElement detailsBox;

	// Finding Name input box
	@FindBy(id = "delivery-name-createAccount")
	WebElement nameInputBox;

	// Finding error message element without customer name
	@FindBy(xpath = "//*[@id='returnsForm']/div[4]/div/div[3]/div[1]/span/ul/li/label")
	WebElement noCustomerName;

	// Finding Email input box
	@FindBy(id = "delivery-email-createAccount")
	WebElement emailInputBox;

	// Finding error message element without customer email
	@FindBy(xpath = "//*[@id='returnsForm']/div[4]/div/div[3]/div[2]/span/ul/li/label")
	WebElement noCustomerEmail;

	// Finding Mobile input box
	@FindBy(id = "delivery-mobile-createAccount")
	WebElement mobileCustomerNumber;

	// Finding error message element without return reason selection
	@FindBy(xpath = "//*[@id='returnsForm']/div[4]/div/div[3]/div[3]/span/ul/li/label")
	WebElement noCustomerMobileNum;

	// Finding error message element without return reason selection
	@FindBy(xpath = "//*[@id='returnsForm']/div[4]/div/div[3]/div[3]/span/ul/li/label")
	WebElement mobileNumFormat;

	// Finding Next button
	@FindBy(id = "submitReturnsForm")
	WebElement nextButton;

	// Initialize Web-elements of page factory
	public ReturnDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Actions on the page
	
	// Get current page URL
	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	// Input order number
	public void setInputOrderID() {
		// String order = driver.get(prop.getProperty("orderid"));
		orderIdBox.sendKeys("AAU0123467");
	}

	// Remove order number
	public void clearInputOrderID() {
		// String order = driver.get(prop.getProperty("orderid"));
		orderIdBox.clear();
		;
	}

	// Select return reason
	public void setReturnReason() {
		
		Select reasonSelect = new Select(returnReason);
		reasonSelect.selectByVisibleText("Faulty (12)");
	}

	// Remove return reason
	public void clearReturnReason() {
		Select reasonSelect = new Select(returnReason);
		reasonSelect.deselectAll();
	}

	// Input return details
	public void setReturnDetails() {
		detailsBox.sendKeys("None");
	}

	// Remove return details
	public void clearReturnDetails() {
		detailsBox.clear();
	}

	// Input customer name
	public void setCustomerName() {
		nameInputBox.sendKeys("John Doe");
	}

	// Remove customer name
		public void clearCustomerName() {
			nameInputBox.clear();
		}
	
	// Input customer EMail
	public void setCustomerEmail() {
		emailInputBox.sendKeys(UtilTestMethods.getUniqueEmailId());
	}
	
	// Remove customer EMail
	public void clearCustomerEmail() {
		emailInputBox.clear();
	}

	// Input customer mobile number
	public void setCustomerMobileNum() {
		mobileCustomerNumber.sendKeys("0469789789");
	}
	
	// Remove customer mobile number
		public void clearCustomerMobileNum() {
			mobileCustomerNumber.sendKeys("0123456789");
		}
		
		// Input incorrect customer mobile number
		public void setCustomerMobileNumInvalidFormat() {
			mobileCustomerNumber.sendKeys("0123456789");
		}
		
	// Get error message when no order is provided
	public String getNoOrderIDErrorMessage() {
		String noOrderIDErrMsg = noOrderID.getText();
		return noOrderIDErrMsg;
	}

	// Get error message when no return reason is selected
	public String getNoReturnReasonSelectedErrorMessage() {
		String noReturnReasonSelectedErrMsg = noReturnReasonSelected.getText();
		return noReturnReasonSelectedErrMsg;
	}

	// Get error message when no customer name is provided
	public String getNoCustomerNameErrorMessage() {
		String noCustomerNameErrMsg = noCustomerName.getText();
		return noCustomerNameErrMsg;
	}

	// Get error message when no customer email is provided
	public String getNoCustomerEmailErrorMessage() {
		String noNoCustomerEmailErrMsg = noCustomerEmail.getText();
		return noNoCustomerEmailErrMsg;
	}

	// Get error message when no customer phone number is of incorrect format
	public String getNoCustomerMobileNumErrorMessage() {
		String noCustomerMobileNumErrMsg = noCustomerMobileNum.getText();
		return noCustomerMobileNumErrMsg;
	}

	// Get error message when no customer phone number is of incorrect format
	public String getInvalidMobileNumErrorMessage() {
		String invalidMobileNumErrMsg = mobileNumFormat.getText();
		return invalidMobileNumErrMsg;
	}

	// Navigate to confirm return parcel screen	
		public ConfirmReturnPage naviagteToReturnConfirmPage() {
			nextButton.click();
			return new ConfirmReturnPage(driver);
	
		}
}
