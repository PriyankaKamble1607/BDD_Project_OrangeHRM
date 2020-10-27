package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ActivityStep3
{

	WebDriver driver;
	WebDriverWait wait;
	
    
	
    @Given("^Log in$")	
    public void userLogin() throws Throwable
    {
	    driver = new FirefoxDriver();
	    wait = new WebDriverWait(driver,50);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
        //Open the browser
	
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        
	  }
    
    @When("^Create employees with \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void multiple(String Fname,String Lname, String Uname) 
    {
    	 driver.findElement(By.id("menu_pim_viewPimModule")).click();
    	 driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
    	 driver.findElement(By.id("btnAdd")).click();
    	 driver.findElement(By.id("firstName")).sendKeys(Fname);
    	 driver.findElement(By.id("lastName")).sendKeys(Lname);
    
    	 driver.findElement(By.id("chkLogin")).click();
    	 driver.findElement(By.id("user_name")).sendKeys(Uname);
    	 
    	 driver.findElement(By.id("btnSave")).click();
    	 
    }
    @Then("^verify the employee \"(.*)\"$")
    public void verifyempl(String Fname)
    {
    	driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
    	driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(Fname);
    	driver.findElement(By.id("searchBtn")).click();
        WebElement actual=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+Fname+"')]")));
        String act=actual.getText();
    	assertEquals(Fname, act);
    	System.out.println("Pass");
    	
    }

}
