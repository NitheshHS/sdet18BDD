package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginToApp {
	WebDriver driver;
	@Given("As user I will launch browser {string}")
	public void as_user_i_will_launch_browser(String browser) {
	    if(browser.equals("chrome")) {
	    	WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
	    }else if(browser.equals("firefox")) {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    }
	    else {
	    	System.out.println("Provide valid browser name");
	    }
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Given("Enter the url {string}")
	public void enter_the_url(String url) {
	    driver.get(url);
	}
	@When("login page is displayed I will Enter invalid username {string} and password {string}")
	public void login_page_is_displayed_i_will_enter_invalid_username_and_password(String username, String password) {
		driver.findElement(By.name("user_name")).sendKeys(username);
		  driver.findElement(By.name("user_password")).sendKeys(password);
	}
	@When("click on login")
	public void click_on_login() {
		driver.findElement(By.id("submitButton")).click();
	}
	@Then("Error message should display for a user {string}")
	public void error_message_should_display_for_a_user(String expectedErrorMsg) {
		String actualErrorMessage= driver.findElement(By.xpath("//div[@class='errorMessage']")).getText();
		Assert.assertEquals(expectedErrorMsg, actualErrorMessage, "comapring error message");
	}
}
