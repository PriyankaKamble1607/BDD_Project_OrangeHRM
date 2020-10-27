package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActivityStep4 
{
	WebDriver driver;
	WebDriverWait wait;
	
    
	
    @Given("^Logged in$")	
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
    
    @When("^Added multiple recruitement$")
    public void Page(DataTable table) throws Throwable 
    {
    	for (int i=0;i<=2;i++)
    	{
    	driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();    	
    	driver.findElement(By.id("btnAdd")).click();
    	List <List<String>> jobTitle= table.asLists();
    	System.out.println(jobTitle);
    	Select JobTitle = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
    	JobTitle.selectByVisibleText(jobTitle.get(i).get(0));
    	//driver.findElement(By.xpath("//li[1]/select/option[3]")).click();
    	driver.findElement(By.id("addJobVacancy_name")).sendKeys(jobTitle.get(i).get(1));
    	driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(jobTitle.get(i).get(2));
    	driver.findElement(By.id("btnSave")).click();
    	driver.findElement(By.id("btnBack")).click();
    	}
    	
    }
    @Then("^validate the recruitement$")
    public void valid(DataTable table) throws Throwable
    {
    	
    	List <List<String>> jobTitle= table.asLists();
    	System.out.println(jobTitle);
    	for(int i=0;i<=2;i++)
    	{
    	//driver.findElement(By.id("vacancySearch_jobVacancy")).clear();	
    	Select vacancy = new Select(driver.findElement(By.id("vacancySearch_jobVacancy")));
    	vacancy.selectByVisibleText(jobTitle.get(i).get(0));	
    	driver.findElement(By.id("btnSrch")).click();
    	Thread.sleep(3000);
    	String vac=driver.findElement(By.xpath("//a[contains(text(),'"+ jobTitle.get(i).get(0)+"')]")).getText();
    	assertEquals(jobTitle.get(i).get(0), vac);
    	}
    }
}

