package hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;




public class Hook {
	//@before Exceute in acending order 
	@Before(value = "@SmokeTest")
	public void setUpForSmokeTest() {
		System.out.println("Inside setUpForSmokeTest");
	}
	@Before(value="@RegressionTest")
	public void setUpForRegressionTest() {
		System.out.println("Inside setUpForRegressionTest");
	}
	
	
	@Before
	public void setUp() {
		System.out.println("Inside @Before method");
	}
	//@After execute in descending order
	@After
	public void teardown(Scenario sceanrio) {
		if(sceanrio.isFailed()) {
			//write code for screenshot
		}
		System.out.println("Inside @After method");
	}
	
	@After(value="@SmokeTest") 
	public void tearDownForSmokeTest() {
		System.out.println(" inside tearDownForSmokeTest");
	}
	
	@After(value="@RegressionTest")
	public void tearDownForRegressionTest() {
		System.out.println(" inside tearDownForRegressionTest");
	}

}
