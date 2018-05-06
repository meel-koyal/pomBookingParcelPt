package com.qa.parcelpointbooking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.parcelpointbooking.base.TestBase;
import com.qa.parcelpointbooking.util.UIMessages;

public class SerachAndSelectLocationPage extends TestBase {

	private String _storeNamePreSelection;
	private String _streetAddressPreSelection;

	private String _storeNamePostSelection;
	private String _streetAddressPostSelection;
	private WebDriverWait wait;

	// Define Page Factory or Object Repository

	// Finding Search input box
	@FindBy(id = "ppSearchInput")
	WebElement searchLocationBox;

	// Finding Search icon
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;

	// Finding error message element without store selection
	@FindBy(className = "red-element")
	WebElement noStoreSelected;

	// Finding error message element without terms check-box selection
	@FindBy(className = "red-element")
	WebElement noTermsCheckBoxSelected;

	// Finding Select store button of the first element in search list
	@FindBy(xpath = "//li[1]/div[1]")
	WebElement storeName;
	@FindBy(xpath = "//li[1]/div[3]")
	WebElement streeAddress;
	@FindBy(xpath = "//li[1]/div[6]")
	WebElement selectButton;

	// Find elements for selected store
	@FindBy(xpath = "//div[@class='header-store-selected']/div")
	WebElement selectedStoreName;

	// Find elements for selected store street address
	@FindBy(xpath = "//div[@class='header-store-selected']/div[2]")
	WebElement selectedStreeName;

	// Finding check box form terms and conditions
	@FindBy(id = "delivery-terms-and-conditions-5")
	WebElement checkBoxTerms;

	// Switch to location widget frame
	@FindBy(id = "ppIframeWidget-parcelpoint-stores-widget")
	WebElement locationWidget;

	// Finding Next button to navigate to confirm return page
	@FindBy(id = "parcelPointSubmitButton")
	WebElement nextButton;

	// Initialize Web-elements of page factory
	public SerachAndSelectLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	// Actions on the page
	// Get page title
	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	// send search text
	public void serachLocation() {
		// Switch to location widget frame
		driver.switchTo().frame(driver.findElement(By.id("ppIframeWidget-parcelpoint-stores-widget")));
		wait.until(ExpectedConditions.visibilityOf(selectButton));

		// Search for store location in Artarmon
		searchLocationBox.sendKeys("Artarmon");
		Actions builder = new Actions(driver);
		builder.moveToElement(searchButton).click().perform();
		// wait.until(ExpectedConditions.visibilityOf(selectButton));

	}

	// Set Selected Store Name
	private void setStoreNamePreSelection(String strInpStoreName) {
		this._storeNamePreSelection = strInpStoreName;
	}

	// Set Selected Street Address
	private void setStreetAddressPreSelection(String strInpStreetAddress) {
		this._streetAddressPreSelection = strInpStreetAddress;
	}

	// Get store name pre selection
	public String getStoreNamePreSelection() {
		return this._storeNamePreSelection;
	}

	// Get street address pre selection
	public String getStreetAddressPreSelection() {
		return this._streetAddressPreSelection;
	}

	// Select required store
	public void selectParcelPointStore() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String storeNamePreSelection = storeName.getText();
		String streetAddressPreSelection = streeAddress.getText();
		setStoreNamePreSelection(storeNamePreSelection);
		setStreetAddressPreSelection(streetAddressPreSelection);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		selectButton.click();
		setStoreNamePostSelection(selectedStoreName.getText());
		setStreetAddressPostSelection(selectedStreeName.getText());
	}

	// Set Selected Store Name
	private void setStoreNamePostSelection(String strInpStoreNameSelected) {
		this._storeNamePostSelection = strInpStoreNameSelected;
	}

	// Set Selected Street Address
	private void setStreetAddressPostSelection(String strInpStreetAddressSelected) {
		this._streetAddressPostSelection = strInpStreetAddressSelected;
	}

	// Get store name post selection
	public String getStoreNamePostSelection() {
		return this._storeNamePostSelection;
	}

	// Get street address post selection
	public String getStreeAddressPostSelection() {
		return this._streetAddressPostSelection;
	}

	// Get error message for no store selected
	public String getStoreNotSelectedErrorMessage() {
		String storeErrorMessage = noStoreSelected.getText();
		return storeErrorMessage;
	}

	// Get error message for no terms check box selected
	public String getTermsCheckBoxNotSelectedErrorMessage() {
		String termsCheckboxErrorMessage = noTermsCheckBoxSelected.getText();
		return termsCheckboxErrorMessage;
	}

	// Un-check terms check box
	public void uncheckTermsCheckBox() {
		if (getTermsCheckBoxSelect()) {
			checkBoxTerms.click();
		}
	}

	// Check terms check box
	public void checkTermsCheckBox() {
		if (!getTermsCheckBoxSelect()) {
			checkBoxTerms.click();
		}
	}

	// To find if terms check box is selected
	public boolean getTermsCheckBoxSelect() {
		// Switch back to main page from frame
		driver.switchTo().defaultContent();
		boolean checkBoxSelected = checkBoxTerms.isSelected();
		return checkBoxSelected;
	}

	// Click on "Next" button for expected errors on page
	public void checkClickOnNextButtonForNavigatingToDetailsPageWithErrors(boolean afterStoreSelection) {
		if (afterStoreSelection) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locationWidget));
			System.out.println("Inside checkClickOnNextButtonWithErrors : " + selectedStoreName.getText());
			wait.until(ExpectedConditions.textToBePresentInElement(selectedStoreName, getStoreNamePostSelection()));
			driver.switchTo().defaultContent();
		}
		nextButton.click();
	}

	public ReturnDetailsPage navigateToReturnDetailsPage() {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locationWidget));

		wait.until(ExpectedConditions.textToBePresentInElement(selectedStoreName, getStoreNamePostSelection()));
		driver.switchTo().defaultContent();

		nextButton.click();

		ExpectedCondition e = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return ((d.getCurrentUrl() != UIMessages.HOME_PAGE_NO_CHECKBOX_SELECTED_ERROR_URL)
						|| (d.getCurrentUrl() != UIMessages.HOME_PAGE_NO_STORE_SEELCTED_ERROR_URL)
						|| (d.getCurrentUrl() != UIMessages.HOME_PAGE_URL));
			};
		};
		wait.until(e);

		return new ReturnDetailsPage(driver);

	}

}
