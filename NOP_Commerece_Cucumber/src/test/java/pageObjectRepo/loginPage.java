package pageObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	//Globel variable
	public WebDriver ldriver;

//**************************************************************************************************************************************		
	  
	// Giving life to driver by Constracor
	public loginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

//**************************************************************************************************************************************		
	  
	// Storeing Element This One Way

	// email element
	@FindBy(id = "Email")
	@CacheLookup
	public WebElement txtEmail;

	// password element
	@FindBy(id = "Password")
	@CacheLookup
	public WebElement txtPassword;

	// login element
	@FindBy(xpath = "//button[text()='Log in']")
	@CacheLookup
	public WebElement btnLogin;

	// logout element
	@FindBy(xpath = "//a[text()='Logout']/..")
	@CacheLookup
	public WebElement linkLogout;

}