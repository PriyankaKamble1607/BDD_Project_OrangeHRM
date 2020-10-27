package stepDefinitions;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActivityStep2
{

	WebDriver driver;
	WebDriverWait wait;
	
    
	
    @Given("^User Log in to HRM$")	
    public void user() throws Throwable
    {
	  //Create a new instance of the Firefox driver
	
        driver = new FirefoxDriver();
	
        wait = new WebDriverWait(driver, 40);
		
        //Open the browser
	
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
	
    }
    
    @When("^Add candidate$")
    public void recruitementPage() 
    {
    	driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
    	driver.findElement(By.id("btnAdd")).click();
    	driver.findElement(By.id("addCandidate_firstName")).sendKeys("Veerash");
    	driver.findElement(By.id("addCandidate_lastName")).sendKeys("Kam");
    	driver.findElement(By.id("addCandidate_email")).sendKeys("veera@gmail.com");
    	WebElement upload =driver.findElement(By.id("addCandidate_resume"));
    	upload.sendKeys("C:\\Users\\PriyankaKamble\\Desktop\\resume.txt"); 
    	driver.findElement(By.id("btnSave")).click();
    	driver.findElement(By.id("btnBack")).click();
    	
    }
    @Then("^validate the candidate entry$")
    public void verifyCandidate()
    {
    	driver.findElement(By.id("candidateSearch_candidateName")).sendKeys("Veerash Kam");
    	driver.findElement(By.id("btnSrch")).click();
    	String candidate=driver.findElement(By.xpath("//a[contains(text(),'Veerash  Kam')]")).getText();
    	assertEquals("Veerash Kam", candidate);
    }
	
    @And("^Close browser$")
    public void close()
    {
    	driver.quit();
    }
}
