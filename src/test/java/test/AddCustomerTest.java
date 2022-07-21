package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;

	ExcelReader exlReader = new ExcelReader("src\\main\\java\\testData\\LoginInfo.xlsx");
	String userName = exlReader.getCellData("LoginInfo", "Username", 2);
	String password = exlReader.getCellData("LoginInfo", "Password", 2);
	String fullName = exlReader.getCellData("AddContactInfo", "FullName", 2);
	String companyName = exlReader.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlReader.getCellData("AddContactInfo", "Email", 2);
	String phoneNumber = exlReader.getCellData("AddContactInfo", "Phone", 2);
	String address = exlReader.getCellData("AddContactInfo", "Address", 2);
	String city = exlReader.getCellData("AddContactInfo", "City", 2);
	String country = exlReader.getCellData("AddContactInfo", "Country", 2);
	String state = exlReader.getCellData("AddContactInfo", "State", 2);
	String zip = exlReader.getCellData("AddContactInfo", "Zip", 2);

	@Test
	public void userShouldBeAbleToCreateCustomer() {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage("Dashboard");
		dashboardPage.clickCustomersButton();
		dashboardPage.clickAddCustomerMenuElement();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddContactPage("Contacts");
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(companyName);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhoneNumber(phoneNumber);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.selectCountry(country);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.clickSaveButton();

		BrowserFactory.tearDown();
	}

}
