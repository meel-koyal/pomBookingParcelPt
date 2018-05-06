package com.qa.parcelpointbooking.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.parcelpointbooking.base.TestBase;
import com.qa.parcelpointbooking.pages.ReturnDetailsPage;
import com.qa.parcelpointbooking.pages.SerachAndSelectLocationPage;
import com.qa.parcelpointbooking.util.UIMessages;

public class UIErrorMessageTest extends TestBase {
	private SerachAndSelectLocationPage _serachAndSelectLocation;
	private ReturnDetailsPage _returnDetails;

	// Launch browser
	@BeforeTest
	public void beginForErrorMessageTest() {
		System.out.println("Start Test - Inside Function : beginForErrorMessageTest");
		launchBrowser();
		System.out.println("driver in beginForErrorMessageTest" + this.driver.toString());
		_serachAndSelectLocation = new SerachAndSelectLocationPage(this.driver);
		System.out.println("Completed Function : beginForErrorMessageTest");
	}

	// Validate error message when no store is selected
	@Test(priority = 0)
	public void validateStoreNotSelectedErrorMessage() {
		System.out.println("0. Inside Function : validateStoreNotSelected");
		_serachAndSelectLocation.checkClickOnNextButtonForNavigatingToDetailsPageWithErrors(false);
		String currentURL = _serachAndSelectLocation.getPageURL();
		Assert.assertEquals(currentURL, UIMessages.HOME_PAGE_NO_STORE_SEELCTED_ERROR_URL);
		Assert.assertEquals(_serachAndSelectLocation.getStoreNotSelectedErrorMessage(), UIMessages.NO_STORE_SELECTION);
		System.out.println("Completed Function : validateStoreNotSelected");
	}

	// Validate error message when terms check box is not selected, since by default
	// box is checked so need to un-check it first.
	@Test(priority = 1)
	public void validateTermsCheckBoxNotSelectedErrorMessage() {
		_serachAndSelectLocation.serachLocation();
		_serachAndSelectLocation.selectParcelPointStore();
		System.out.println("1. Inside Function : validateTermsCheckBoxNotSelected");
		_serachAndSelectLocation.uncheckTermsCheckBox();
		_serachAndSelectLocation.checkClickOnNextButtonForNavigatingToDetailsPageWithErrors(true);
		String currentURL = _serachAndSelectLocation.getPageURL();
		Assert.assertEquals(currentURL, UIMessages.HOME_PAGE_NO_CHECKBOX_SELECTED_ERROR_URL);
		Assert.assertEquals(_serachAndSelectLocation.getTermsCheckBoxNotSelectedErrorMessage(),
				UIMessages.TERMS_CHECKBOX_NOT_SELECTED);
		System.out.println("Completed Function : validateTermsCheckBoxNotSelected");

	}

	// Validate error message when no information is provided

	@Test(priority = 2)
	public void verifyErrorMessagesOnReturnDetailsPage() {
		_returnDetails = _serachAndSelectLocation.navigateToReturnDetailsPage();
		System.out.println("2. Inside Function : verifyErrorMessagesOnReturnDetailsPage  ");
		_returnDetails.naviagteToReturnConfirmPage();
		String currentURL = _returnDetails.getPageURL();
		Assert.assertEquals(currentURL, UIMessages.RETURN_DETAILS_PAGE_ERROR_URL);
		Assert.assertEquals(_returnDetails.getNoOrderIDErrorMessage(), UIMessages.INVALID_ORDER_NUM);
		System.out.println("No order error message: " + _returnDetails.getNoOrderIDErrorMessage());
		Assert.assertEquals(_returnDetails.getNoReturnReasonSelectedErrorMessage(), UIMessages.NO_REASON_SELECTED);
		System.out.println("No return reason message: " + _returnDetails.getNoReturnReasonSelectedErrorMessage());
		Assert.assertEquals(_returnDetails.getNoCustomerNameErrorMessage(), UIMessages.EMPTY_NAME);
		System.out.println("No customer namer message: " + _returnDetails.getNoCustomerNameErrorMessage());
		Assert.assertEquals(_returnDetails.getNoCustomerEmailErrorMessage(), UIMessages.EMPTY_EMAIL_ADDRESS);
		System.out.println("No ecustomer email message: " + _returnDetails.getNoCustomerEmailErrorMessage());
		Assert.assertEquals(_returnDetails.getNoCustomerMobileNumErrorMessage(), UIMessages.EMPTY_PHONE_NUM);
		System.out.println("No order error message: " + _returnDetails.getNoCustomerMobileNumErrorMessage());
		System.out.println("Completed Function : verifyErrorMessagesOnReturnDetailsPage ");
	}

	// Validate error message when invalid mobile number is provided
	@Test(priority = 3)
	public void verifyInvalidCustomerMobileNumErrorMessage() {
		System.out.println("3. Inside Function : verifyInvalidCustomerMobileNum");
		_returnDetails.setInputOrderID();
		_returnDetails.setReturnDetails();
		_returnDetails.setCustomerName();
		_returnDetails.setCustomerEmail();
		_returnDetails.setCustomerMobileNumInvalidFormat();
		_returnDetails.naviagteToReturnConfirmPage();
		String currentURL = _returnDetails.getPageURL();
		Assert.assertEquals(currentURL, UIMessages.RETURN_DETAILS_PAGE_ERROR_URL);
		Assert.assertEquals(_returnDetails.getInvalidMobileNumErrorMessage(), UIMessages.CHECK_PHONE_NUM_FORMAT);
		System.out.println("Invalid Mobile Num error message: " + _returnDetails.getInvalidMobileNumErrorMessage());
		System.out.println("Completed Function : verifyInvalidCustomerMobileNum");
	}

	// close browser
	@AfterTest
	public void closeBrowserAfterVerifyingErrorMessages() {
		System.out.println("End Test - Inside Function : closeBrowserAfterVerifyingErrorMessages");
		driver.quit();
		System.out.println("Completed Function : closeBrowserAfterVerifyingErrorMessages");
	}
}
