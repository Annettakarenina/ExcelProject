package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import util.BrowserFactory;

public class TestBrowser {
	
	WebDriver driver;
	
	@Test
	public void test() {
		driver = BrowserFactory.init();
	}

}
