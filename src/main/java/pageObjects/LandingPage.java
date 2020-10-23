package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Sign-in Hover
	@FindBy(id = "nav-link-accountList")
	WebElement signinHover;

	// Sign-in Button
	@FindBy(className = "nav-action-inner")
	WebElement signInButton;

	// Email id
	@FindBy(id = "ap_email")
	WebElement emailidBox;

	// continue button
	@FindBy(id = "continue")
	WebElement continueButton;

	// password
	@FindBy(id = "ap_password")
	WebElement passwordBox;

	// login button
	@FindBy(id = "signInSubmit")
	WebElement loginButton;

	// verify login
	@FindBy(className = "nav-line-1")
	WebElement verifyLogin;

	// ===============================

	public WebElement signinHover() {
		return signinHover;
	}

	public WebElement signInButton() {
		return signInButton;
	}

	public WebElement emailidBox() {
		return emailidBox;
	}

	public WebElement continueButton() {
		return continueButton;
	}

	public WebElement passwordBox() {
		return passwordBox;
	}

	public WebElement loginButton() {
		return loginButton;
	}

	public WebElement verifyLogin() {
		return verifyLogin;
	}
}
