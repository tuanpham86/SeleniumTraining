package seleniumDemo;

import org.testng.annotations.Test;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
* class description
*/

public class HandlingDropDown {
	WebDriver driver;

	/**
	* Set up browser settings and open the application
	*/

	@BeforeTest
	public void setUp() {
	driver=new FirefoxDriver();
	
	// Opened the application
	driver.get("file:///F:/Work/Workspace/DemoWebAlert.html");
	driver.manage().window().maximize();
	}

	/**
	* Test to select the dropdown values
	* @throws InterruptedException
	*/

	@Test
	public void testSelectFunctionality() throws InterruptedException { 

	// Go to google
	driver.findElement(By.linkText("Google")).click();

	// navigate back to previous webpage
	driver.navigate().back();
	Thread.sleep(5000);

	// select the first operator using "select by value"
	Select selectByValue = new Select(driver.findElement(By.id("SelectID_One")));
	selectByValue.selectByValue("greenvalue");
	Thread.sleep(5000);

	// select the second dropdown using "select by visible text"
	Select selectByVisibleText = new Select (driver.findElement(By.id("SelectID_Two")));
	selectByVisibleText.selectByVisibleText("Lime");
	Thread.sleep(5000);

	// select the third dropdown using "select by index"
	Select selectByIndex = new Select(driver.findElement(By.id("SelectID_Three")));
	selectByIndex.selectByIndex(2);
	Thread.sleep(5000);       
	}

	/**
	* Tear down the setup after test completes
	*/

	@AfterTest
	public void tearDown() { 
	driver.quit();
	}
}