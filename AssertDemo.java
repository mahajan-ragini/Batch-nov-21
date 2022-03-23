package TestNGPrograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertDemo {
	public WebDriver driver;
	
	@BeforeMethod
	public void StartingPoint()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\selenium Jars\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
	    driver = new ChromeDriver(option);
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void asserLogoTest() {
	
	
	WebElement KiteLogo = driver.findElement(By.xpath("//img[contains(@src,'kite-logo.svg')]"));
	Assert.assertTrue(KiteLogo.isDisplayed());
	System.out.println("If Logo is displayed then assertLogo Test methos result is pass");
	}
	@Test
	public void HeadingTest()
	{
	WebElement KiteHeading = driver.findElement(By.xpath("//h2[contains(text(),'Login to Kite')]"));
	String ActualHeading = KiteHeading.getText();
	String ExpectedHeading = "Login to Lite";
	Assert.assertEquals(ActualHeading, ExpectedHeading);
	System.out.println("If Both strings are equal then result is pass");
}
	@Test
	public void softHeadingTest()
	{
		WebElement KiteHeading = driver.findElement(By.xpath("//h2[contains(text(),'Login to Kite')]"));
		String ActualHeading = KiteHeading.getText();
		String ExpectedHeading = "Login to Lite";
		// call Soft Assert class
 		SoftAssert sassert = new SoftAssert();
		sassert.assertEquals(ActualHeading, ExpectedHeading);
		System.out.println("If Both strings are equal then result is pass");
		sassert.assertAll();
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}