package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h2[text()=' Contacts ']") WebElement ADD_CONTACT_HEADER;

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement FULL_NAME_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") WebElement COMPANY_DROPDOWN_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]") WebElement EMAIL_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")	WebElement PHONE_NUMBER_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]") WebElement ADDRESS_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]") WebElement CITY_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]") WebElement STATE_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]") WebElement ZIP_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"rform\"]/div[1]/div[1]/div[9]/div/span/span[1]/span")	WebElement COUNTRY_DROPDOWN_ELEMENT;

	@FindBy(how=How.XPATH, using="//*[@id=\"submit\"]") WebElement SAVE_BUTTON_ELEMENT;

	public void insertFullName(String fullName) {
		int genNum=generateRandomNumber(999);
		FULL_NAME_ELEMENT.sendKeys(fullName+genNum);
	}
	
	public void validateAddContactPage(String addContactHeader) {
		Assert.assertEquals(ADD_CONTACT_HEADER.getText(), addContactHeader, "Add Contact page is not available");
	}

	public void selectCompany(String company) {	
		selectFromDropdown(COMPANY_DROPDOWN_ELEMENT, company);
	}
	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNumber(9999)+email);
	}
	public void insertPhoneNumber(String phoneNumber) {
		PHONE_NUMBER_ELEMENT.sendKeys(phoneNumber);//sendKeys() takes String "numbers"		
	}
	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(generateRandomNumber(999)+address);
	}
	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}
	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}
	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}
	public void selectCountry(String country) {
		selectFromDropdown(COUNTRY_DROPDOWN_ELEMENT, country);
	}
	public void clickSaveButton() {
		SAVE_BUTTON_ELEMENT.click();
	}

}
