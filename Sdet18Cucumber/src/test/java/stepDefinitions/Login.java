package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Login {
	WebDriver driver;
	@Given("As a user I will lauch browser")
	public void as_a_user_i_will_lauch_browser() {
		WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("Enter the url")
	public void enter_the_url() {
	    driver.get("http://localhost:8888/");
	}

	@When("login page is displayed I will enter username and password")
	public void login_page_is_displayed_i_will_enter_username_and_password() {
	  driver.findElement(By.name("user_name")).sendKeys("admin");
	  driver.findElement(By.name("user_password")).sendKeys("manager");
	}

	@When("Click on login")
	public void click_on_login() {
	 driver.findElement(By.id("submitButton")).click();
	}

	@Then("Home page should display")
	public void home_page_should_display() {
	   System.out.println(driver.getTitle());
	}

	@Then("Also I will verify that Home Page title")
	public void also_i_will_verify_that_home_page_title() {
	   Assert.assertEquals("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM", driver.getTitle(),
			   "Comapring the title page");
	   driver.close();
	}
	
	@When("login page is displayed I will enter username {string} and password {string}")
	public void login_page_is_displayed_i_will_enter_username_and_password(String username, String password) {
		driver.findElement(By.name("user_name")).sendKeys(username);
		  driver.findElement(By.name("user_password")).sendKeys(password);
	}
	@Then("Error message should display for user")
	public void error_message_should_display_for_user() {
	   String actualErrorMessage= driver.findElement(By.xpath("//div[@class='errorMessage']")).getText();
	   Assert.assertEquals(actualErrorMessage, "You must specify a valid username and password.", "Validating the error message");
	}

}
