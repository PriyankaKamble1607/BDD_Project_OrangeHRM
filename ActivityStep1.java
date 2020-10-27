package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ActivityStep1 
{
    WebDriver driver;
	
    WebDriverWait wait;
	
    
	
    @Given("^User Logged in to HRM$")
	
    public void userIsOnGooglePage() throws Throwable {
	
        //Create a new instance of the Firefox driver
	
        driver = new FirefoxDriver();
	
        wait = new WebDriverWait(driver, 40);
		
        //Open the browser
	
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
	
    }
    @When("^On recruitement Page$")
    public void recruitementPage() 
    {
    	driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
    	driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
    	driver.findElement(By.id("btnAdd")).click();
    	
    	Select JobTitle = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
    	JobTitle.selectByVisibleText("Automation Test Engineer");
    	//driver.findElement(By.xpath("//li[1]/select/option[3]")).click();
    	driver.findElement(By.id("addJobVacancy_name")).sendKeys("Tester2");
    	driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("Demo User");
    	driver.findElement(By.id("btnSave")).click();
    	driver.findElement(By.id("btnBack")).click();
    	  	 
    	
    } 
    @Then("^validate the entry$")
    public void validate()
    {
    	Select vacancy = new Select(driver.findElement(By.id("vacancySearch_jobVacancy")));
    	vacancy.selectByVisibleText("Tester2");	
    	driver.findElement(By.id("btnSrch")).click();
    	String vac=driver.findElement(By.xpath("//table/tbody/tr/td[2]/a")).getText();
    	assertEquals("Tester2", vac);
    }
    @And("^close browser$")
    public void close()
    {
    	driver.quit();
    }
    
}
