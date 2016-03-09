package seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DemoTestNG {
	public WebDriver driver = new FirefoxDriver();
	String appUrl = "https://accounts.google.com";

	@Test
	public void gmailLogin() {

	// launch the firefox browser and open the application url
	driver.get("https://gmail.com");

	// maximize the browser window
	driver.manage().window().maximize();
	              
	// declare and initialize the variable to store the expected title of the web page.
	String expectedTitle = "Gmail";

	// fetch the title of the web page and save it into a string variable
	String actualTitle = driver.getTitle();
	Assert.assertEquals(expectedTitle,actualTitle);

	// enter a valid user name in the email text box
	WebElement username = driver.findElement(By.id("Email"));
	username.clear();
	username.sendKeys("TestSelenium");

    //click Next button
    WebElement nextButton = driver.findElement(By.id("next"));
    nextButton.click();
    
    //add explicit wait
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
    
	// enter a valid password in the password text box
	// WebElement password = driver.findElement(By.id("Passwd"));
	password.clear();
	password.sendKeys("password123");

	// click on the Sign in button
	WebElement SignInButton = driver.findElement(By.id("signIn"));
	SignInButton.click();

	// close the web browser
	driver.close();
	}
}