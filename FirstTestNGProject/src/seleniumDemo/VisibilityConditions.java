package seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class VisibilityConditions {
	/**
	 * @param args  	
	 */
	
    public static void main(String[] args) {
    	// objects and variables instantiation
        WebDriver driver = new FirefoxDriver();
        String appUrl = "https://google.com";
        
        // launch the firefox browser and open the application url
        driver.get(appUrl);
        
        // maximize the browser window
        driver.manage().window().maximize();
        
        // declare and initialize the variable to store the expected title of the webpage.
        String expectedTitle = "Google";
        
        // fetch the title of the web page and save it into a string variable
        String actualTitle = driver.getTitle();
        
        // compare the expected title of the page with the actual title of the page and print the result
        if (expectedTitle.equals(actualTitle))
        {
            System.out.println("Verification Successful - The correct title is displayed on the web page.");
        }
        else
        {
            System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
        }
        
        // verify if the �Google Search� button is displayed and print the result     
        boolean submitbuttonPresence=driver.findElement(By.name("btnK")).isDisplayed();
        System.out.println(submitbuttonPresence);
        
        // enter the keyword in the �Google Search� text box by which we would want to make the request
        System.out.println("trying to enter search key");
        WebElement searchTextBox = driver.findElement(By.id("lst-ib"));
        //searchTextBox.clear();
        searchTextBox.sendKeys("Selenium");
        
        // verify that the �Search button� is displayed and enabled
        boolean searchIconPresence = driver.findElement(By.id("sblsbb")).isDisplayed();
        boolean searchIconEnabled = driver.findElement(By.id("sblsbb")).isEnabled();
        
        if (searchIconPresence==true && searchIconEnabled==true)
        {
            // click on the search button
            WebElement searchIcon = driver.findElement(By.id("sblsbb"));
            searchIcon.click();
            
            // verify results returned
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement resultReturned = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultStats")));
            System.out.println(resultReturned);
            
            // close the web browser
            driver.close();
            System.out.println("Test script executed successfully.");
            
            // terminate the program
            System.exit(0);
        }
        else
        {
            System.out.println("search box not found!");
        }        
    }
}
