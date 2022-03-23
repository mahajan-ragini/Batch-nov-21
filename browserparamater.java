package TestNGPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class browserparamater {

	@Test
	@Parameters("browser")
	public void chromeBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium Jars\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://www.google.com");
	}else if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", "D:\\selenium Jars\\geckodriver.exe");
	    WebDriver driver = new FirefoxDriver();
	    driver.get("https://www.google.com");
		
	}
}
}