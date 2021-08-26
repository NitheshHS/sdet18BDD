package stepDefinitionOrg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {
	WebDriver driver;
	@Given("As a user I will launch browser")
	public void as_a_user_i_will_launch_browser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Given("I will enter url")
	public void i_will_enter_url() {
		driver.get("http://localhost:8888/");
	}
	@Given("login page is displayed I will enter username {string}  and password {string}")
	public void login_page_is_displayed_i_will_enter_username_and_password(String string, String string2) {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		  driver.findElement(By.name("user_password")).sendKeys("manager");
	}
	@Given("In home page click on organization")
	public void in_home_page_click_on_organization() {
		driver.findElement(By.linkText("Organizations")).click();
	}
	@When("organization page is displayed click on create organization")
	public void organization_page_is_displayed_click_on_create_organization() {
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	}
	@When("In organization page enter organization name {string} and organization email {string}")
	public void in_organization_page_enter_organization_name_and_organization_email(String orgName, String email) {
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.id("email1")).sendKeys(email);
	}
	@Then("click on save")
	public void click_on_save() {
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	@Then("Verify that organization name {string} and email should be {string}")
	public void verify_that_organization_name_and_email_should_be(String orgName, String email) {
	   String orgNameInInfo=driver.findElement(By.id("dtlview_Organization Name")).getText();
	   String emailInInfo=driver.findElement(By.id("dtlview_Email")).getText();
	   Assert.assertEquals(orgNameInInfo, orgName,"Oraganization name is not matching");
	   Assert.assertEquals(emailInInfo, email,"email is not matching");
	   driver.close();
	}
	@Given("Click on login")
	public void click_on_login() {
		 driver.findElement(By.id("submitButton")).click();
	}
}
