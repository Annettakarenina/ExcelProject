package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	WebDriver driver;
	
	ExcelReader exlReader = new ExcelReader("src\\main\\java\\testData\\LoginInfo.xlsx");
	String userName = exlReader.getCellData("LoginInfo", "Username", 2);
	String password = exlReader.getCellData("LoginInfo", "Password", 2);

	
	@Test
	public void validUserShouldBeAbleLogin() {
		
		driver=BrowserFactory.init();
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		//=============================envoking constructor of LoginPage^^ with driver
		
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);;
		loginPage.clickSigninButton();
		
		DashboardPage dashboardPage= PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage("Dashboard");
		
		BrowserFactory.tearDown();
		
	}
}
