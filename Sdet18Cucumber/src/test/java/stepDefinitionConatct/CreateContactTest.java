package stepDefinitionConatct;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


//ctrl+shift+o
public class CreateContactTest {
	WebDriver driver;
	String lastName;
	String email;
	String phone;
	@Given("I will Launch browser")
	public void i_will_launch_browser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Given("enter the url")
	public void enter_the_url() {
		driver.get("http://localhost:8888/");
	}
	@Given("When login page is dispalyed I will Enter username {string} and password {string}")
	public void when_login_page_is_dispalyed_i_will_enter_username_and_password(String username, String password) {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
	}
	@Given("click on login")
	public void click_on_login() {
		driver.findElement(By.id("submitButton")).click();
	}
	@When("home page is displayed click on contact")
	public void home_page_is_displayed_click_on_contact() {
		driver.findElement(By.linkText("Contacts")).click();

	}
	@When("click on create contact")
	public void click_on_create_contact() {
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	}
	@When("enter contact name conatct email and contact phone")
	public void enter_contact_name_conatct_email_and_contact_phone(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps();
		lastName=data.get(0).get("lastName");
		email=data.get(0).get("email");
		phone=data.get(0).get("phone");
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("mobile")).sendKeys(phone);
	}
	@When("click on save")
	public void click_on_save() {
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	@Then("verify contact name conatct email and conatct phone")
	public void verify_contact_name_conatct_email_and_conatct_phone() {
		String actualLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
		Assert.assertEquals(lastName, actualLastName,"Lastname is not matching");
		String actualEmail=driver.findElement(By.id("dtlview_Email")).getText();
		Assert.assertEquals(email, actualEmail);
		String actualMobile=driver.findElement(By.id("dtlview_Mobile")).getText();
		Assert.assertEquals(phone, actualMobile);
	}
	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();
	}
}

