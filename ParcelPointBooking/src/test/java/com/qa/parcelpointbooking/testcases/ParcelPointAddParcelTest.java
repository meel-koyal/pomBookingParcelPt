package com.qa.parcelpointbooking.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.parcelpointbooking.base.TestBase;
import com.qa.parcelpointbooking.pages.ConfirmReturnPage;
import com.qa.parcelpointbooking.pages.ReturnDetailsPage;
import com.qa.parcelpointbooking.pages.SerachAndSelectLocationPage;
import com.qa.parcelpointbooking.util.UIMessages;
import com.qa.parcelpointbooking.util.UtilTest;

public class ParcelPointAddParcelTest extends TestBase {
	private SerachAndSelectLocationPage _serachAndSelectLocation;
	private ReturnDetailsPage _returnDetails;
	private ConfirmReturnPage _confirmReturn;

	// Constructor
	public ParcelPointAddParcelTest() {
		super();
	}

	// Launch Browser
	@BeforeClass
	public void beginAddingParcel() {
		System.out.println("Start Test - Inside Function : beginAddingParcel");
		launchBrowser();
		System.out.println("driver" + this.driver.toString());
		_serachAndSelectLocation = new SerachAndSelectLocationPage(this.driver);
		System.out.println("Completed Function : beginAddingParcel");
	}

	// Validate page url
	@Test(priority = 10)
	public void validateHomePageURL() {
		System.out.println("10. Inside Function : validateHomePageURL");
		String currentURL = _serachAndSelectLocation.getPageURL();
		Assert.assertEquals(currentURL, UIMessages.HOME_PAGE_URL);
		System.out.println("Completed Function : validateHomePageURL");

	}

	// Validate name and street of selected store
	@Test(priority = 11)
	public void verifySelectedStoreName() {
		System.out.println("11. Inside Function : verifySelectedStoreName");
		_serachAndSelectLocation.serachLocation();
		_serachAndSelectLocation.selectParcelPointStore();
		System.out.println("PRESELECT :    " + _serachAndSelectLocation.getStoreNamePreSelection());
		Assert.assertEquals(_serachAndSelectLocation.getStoreNamePreSelection(),
				_serachAndSelectLocation.getStoreNamePostSelection());
		Assert.assertEquals(_serachAndSelectLocation.getStreetAddressPreSelection(),
				_serachAndSelectLocation.getStreeAddressPostSelection());
		System.out.println("Completed Function : verifySelectedStoreName");

	}

	// Validate navigation to return details page after marking terms check-box is
	// selected
	@Test(priority = 12)
	public void verifyReturnDetailsPageURL() {
		System.out.println("12. Inside Function : verifyReturnDetailsPageURL");
		_serachAndSelectLocation.checkTermsCheckBox();
		_returnDetails = _serachAndSelectLocation.navigateToReturnDetailsPage();
		String currentURL = _serachAndSelectLocation.getPageURL();
		Assert.assertEquals(currentURL, UIMessages.RETURN_DETAILS_PAGE_URL);
		System.out.println("Completed Function : verifyReturnDetailsPageURL");

	}

	// Validate return details url after navigating to it
	@Test(priority = 13)
	public void validateReturnDetailsPageURLAfterNavigation() {
		System.out.println("13. Inside Function : validateReturnDetailsPageURLAfterNavigation");
		String currentURL = _returnDetails.getPageURL();
		Assert.assertEquals(currentURL, UIMessages.RETURN_DETAILS_PAGE_URL);
		System.out.println("Completed Function : validateReturnDetailsPageURLAfterNavigation");
	}

	// Validate navigation to return confirm page after providing details
	@Test(priority = 14)
	public void verifyNavigationToReturnConfirmPage() {
		System.out.println("14. Inside Function : verifyNavigationToReturnConfirmPage");
		_returnDetails.setInputOrderID();
		_returnDetails.setReturnDetails();
		_returnDetails.setReturnReason();
		_returnDetails.setCustomerName();
		_returnDetails.setCustomerEmail();
		_returnDetails.setCustomerMobileNum();
		_confirmReturn = _returnDetails.naviagteToReturnConfirmPage();
		String currentURL = _returnDetails.getPageURL();
		boolean orderCompleteCond = currentURL.toUpperCase().endsWith("RETURN/COMPLETE");
		Assert.assertTrue(orderCompleteCond);
		System.out.println("Completed Function : verifyNavigationToReturnConfirmPage");
	}

	// Validate page url
	@Test(priority = 15)
	public void validateReturnConfirmPageURL() {
		System.out.println("15. Inside Function : validateReturnConfirmPageURL");
		String currentURL = _confirmReturn.getCurrentPageURL();
		boolean orderCompleteCond = currentURL.toUpperCase().endsWith("RETURN/COMPLETE");
		Assert.assertTrue(orderCompleteCond);
		System.out.println("Completed Function : validateReturnConfirmPageURL");
	}

	// validate order number
	@Test(priority = 16)
	public void verifyOrderID() {
		System.out.println("16. Inside Function : verifyOrderID");
		String orderID = _confirmReturn.getOrderId();
		boolean orderCompleteCond = orderID.toUpperCase().contains(UtilTest.PARCEL_RETURN_ORDER_NUM);
		Assert.assertTrue(orderCompleteCond);
		System.out.println("Completed Function : verifyOrderID");
	}

	// validate return reason
	@Test(priority = 17)
	public void verifyReturnReason() {
		System.out.println("17. Inside Function : verifyReturnReason");
		Assert.assertEquals(_confirmReturn.getReturnReason(), UtilTest.PARCEL_RETURN_REASON);
		System.out.println("Completed Function : verifyReturnReason");
	}

	// validate additional details
	@Test(priority = 18)
	public void verifyAdditionalDetails() {
		System.out.println("18. Inside Function : verifyAdditionalDetails");
		Assert.assertEquals(_confirmReturn.getAdditionalDetails(), UtilTest.PARCEL_RETURN_ADDITIONAL_DETAILS);
		System.out.println("Completed Function : verifyAdditionalDetails");
	}

	// close browser
	@AfterClass
	public void closeBrowserAfterAddingParcel() {
		System.out.println("End Test - Inside Function : closeBrowserAfterAddingParcel");
		driver.quit();
		System.out.println("Completed Function : closeBrowserAfterAddingParcel");
	}

}
