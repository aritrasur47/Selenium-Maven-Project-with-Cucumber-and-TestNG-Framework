package stepImplementations;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import resources.Base;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@RunWith(Cucumber.class)
public class stepImplementations extends Base {

	LandingPage homePage;

	@Given("^Intialize the browser with Driver$")
	public void intialize_the_browser_with_Driver() throws Throwable {
		driver = initializeDriver();
		homePage = new LandingPage(driver);
	}

	@Given("^Navigate to \"([^\"]*)\" website$")
	public void navigate_to_website(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Given("^Click on to SignIn button in the home page$")
	public void click_on_to_signin_button_in_the_home_page() throws Throwable {
		Actions action = new Actions(driver);
		WebElement mouseHover = homePage.signinHover();
		action.moveToElement(mouseHover).build().perform();
		homePage.signInButton().click();
	}
	
	@When("^User enters email (.+)$")
	public void user_enters_email_username(String email) throws Throwable {
		homePage.emailidBox().sendKeys(email);
	}
	
	@When("^User clicks on continue button$")
	public void user_clicks_on_continue_button() throws Throwable {
		homePage.continueButton().click();
	}

	@And("^User enters password (.+)$")
	public void user_enters_password(String password) throws Throwable {
		homePage.passwordBox().sendKeys(password);
	}

	@And("^User click on login button$")
	public void user_click_on_login_button() throws Throwable {
		homePage.loginButton().click();
	}

	@Then("^Verify that the user is successfully logged in$")
	public void verify_that_the_user_is_successfully_logged_in() throws Throwable {
		Assert.assertTrue(homePage.verifyLogin().isDisplayed());
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
