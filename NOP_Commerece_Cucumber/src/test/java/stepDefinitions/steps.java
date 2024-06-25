package stepDefinitions;

import java.io.File; 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepo.addCustomerPage;
import pageObjectRepo.loginPage;
import pageObjectRepo.searchCustomerPage;
import utilities.base;
import utilities.helper;

public class steps extends base {
	
	@Before
	public void setUp() throws IOException {
		// Reading The logger
		logger = Logger.getLogger("nopCommerce");// Adding logger
		PropertyConfigurator.configure("log4j.properties");// Adding logger
		
		//Reading the config properites file
		configProp = new Properties();
		FileInputStream fis = new FileInputStream(configFilePath);
		configProp.load(fis);

	}
	
//**************************************************************************************************************************************
	  
	//Login Feature Step Definitions.............................................................
	
	@Given("User launch the browser")
	public void user_launch_the_browser() throws IOException {
		// Launching The Browser from Base Class
		logger.info("******************** Launching The Browser ********************");
		driver=initializeDriver();
		logger.info("Browser Opened Successfully");
		lp = new loginPage(driver);
		hp = new helper(driver);
	}

	@When("User opens the URL {string}")
	public void user_opens_the_url(String url) {
		driver.get(url);
		logger.info("Successfully Navigated To "+url+" url");
	}

	@And("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String emailId, String password) {
		lp.txtEmail.clear();
		logger.info("Successfully Cleared Text In Email Textfield");
		lp.txtEmail.sendKeys(emailId);
		logger.info("Successfully Entered "+emailId+" Into EmailId Textfield");
		lp.txtPassword.clear();
		logger.info("Successfully Cleared Text In Password Textfield");
		lp.txtPassword.sendKeys(password);
		logger.info("Successfully Entered "+password+" Into Password Textfield");
	}

	@And("Click on login")
	public void click_on_login() {
		lp.btnLogin.click();
		logger.info("Successfully Clicked On Login Button");
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) throws IOException, InterruptedException {
		Thread.sleep(2000);
		String neagtiveLoginValidation = configProp.getProperty("neagtiveLoginValidation");
		if (driver.getPageSource().contains(neagtiveLoginValidation)) {
			logger.info("The Web Page Dose Not Contains "+title+" But It Actually Contains "+neagtiveLoginValidation+" As Page Title");
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
			logger.info("The Web Page Contains "+title+" As Page Title");
		}
	}

	@When("User click on log out link")
	public void user_click_on_log_out_link() throws IOException, InterruptedException {
		String explicitWaitInString = configProp.getProperty("explicitWait");
		long explicitWait = Long.parseLong(explicitWaitInString);
		hp.waitTillelementToBeClickable(lp.linkLogout, explicitWait);
		logger.info("Successfully Waited "+explicitWait+" Explicit Secounds Till Element Is Clickable");
		lp.linkLogout.click();
		logger.info("Successfully Clicked On Logout On Link");
		Thread.sleep(2000);
	
	}

	@And("Close browser")
	public void close_browser() {
		driver.close();
		logger.info("******************** Browser Closed Successfully ********************");
	}
	
//**************************************************************************************************************************************
	
	//Add Customers feature step definitions..................................................................
	
	@Then("User Can view dashboard")
	public void user_can_view_dashboard() {
		addcust=new addCustomerPage(driver);
		hp=new helper(driver);
		String dashboardTitle = configProp.getProperty("dashboardTitle");
		Assert.assertEquals(dashboardTitle, driver.getTitle());
		logger.info("User Is Able View "+dashboardTitle+" As Dashboard Text");
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() {
	    addcust.lnkCustomerMenu().click();
	    logger.info("Successfully Clicked On Customer Menu Button");
	}

	@And("Click on customers menu item")
	public void click_on_customers_menu_item() {
	   addcust.lnkCustimerMenuItem().click();
	   logger.info("Successfully Clicked On Custimer Menu Item Button");
	}

	@And("Click on add new customer")
	public void click_on_add_new_customer() {
		String explicitWaitInString = configProp.getProperty("explicitWait");
		int explicitWait=Integer.parseInt(explicitWaitInString);
		hp.waitTillelementToBeClickable(addcust.btnAddNew(),explicitWait );
		logger.info("Successfully Waited "+explicitWait+" Explicit Secounds Till Element Is Clickable");
		addcust.btnAddNew().click();
		logger.info("Successfully Clicked On Add New Button");
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		String explicitWaitInString = configProp.getProperty("explicitWait");
		int explicitWait=Integer.parseInt(explicitWaitInString);
		String txtAddANewCustomerPage = configProp.getProperty("txtAddANewCustomerPage");
		hp.waitTillVisibilityOfElement(addcust.txtAddANewCustomerPage(), explicitWait);
		logger.info("Successfully Waited "+explicitWait+" Explicit Secounds Till Element Is Visible");
		boolean result=addcust.txtAddANewCustomerPage().getText().contains(txtAddANewCustomerPage);
		Assert.assertTrue(result);
		logger.info("User Is Able View "+txtAddANewCustomerPage+" Text");
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
	   String emailIdDomain = configProp.getProperty("emailIdDomain");
	   String password = configProp.getProperty("password");
	   String firstName = configProp.getProperty("firstName");
	   String lastName = configProp.getProperty("lastName");
	   String dateOfBirth = configProp.getProperty("dateOfBirth");
	   String companyName = configProp.getProperty("companyName");
	   String customerRoles = configProp.getProperty("customerRoles");
	   String guestsRole = configProp.getProperty("guestsRole");
	   String vendorsRole = configProp.getProperty("vendorsRole");
	   String administratorsRole = configProp.getProperty("administratorsRole");
	   String forumModeratorRole = configProp.getProperty("forumModeratorRole");
	   String managerOfVendor = configProp.getProperty("managerOfVendor");
	   String adminComment = configProp.getProperty("adminComment");
	   String email=randomString()+emailIdDomain;
	   logger.info("Successfully Genrated Random "+email+" Email");
	   addcust.txtEmail().sendKeys(email);
	   logger.info("Successfully Entered "+email+" Into Email Textfield");
	   addcust.txtPassword().sendKeys(password);
	   logger.info("Successfully Entered "+password+" Into Password Textfield");
	   addcust.txtFirstName().sendKeys(firstName);
	   logger.info("Successfully Entered "+firstName+" Into First Name Textfield");
	   addcust.txtFirstName().sendKeys(lastName);
	   logger.info("Successfully Entered "+lastName+" Into Last Name Textfield");
	   addcust.rdMale().click();
	   logger.info("Successfully Clicked On Male Redio Button");
	   addcust.txtDateOfBirth().sendKeys(dateOfBirth);
	   logger.info("Successfully Entered "+dateOfBirth+" Into Date Of Birth Textfield");
	   addcust.txtCompany().sendKeys(companyName);
	   logger.info("Successfully Entered "+companyName+" Into company Name Textfield");
	   //Registeres-default
	   //The Customer Cannot be in both 'Guest' and 'registered' customer role
	   //Add The  Customer to 'Guests' or 'registered' customer role
	   //The Customer Cannot be in both 'Vendors' and 'registered' customer role
	   //Add The  Customer to 'Vendors' or 'registered' customer role
	   if (customerRoles.equals(guestsRole)) {
		    addcust.deleteCustomerRole().click();
		    logger.info("Successfully Clicked On delete Customer Role Button");
		    addcust.textCustomerRoles().click();
		    logger.info("Successfully Clicked On Customer Roles Dropdown");
		    clickByJavaScriptExecutor(addcust.listGuests());
		    logger.info("Successfully Clicked On Guests List");
	         }
	   else if (customerRoles.equals(vendorsRole)) {
		    addcust.deleteCustomerRole().click();
		    logger.info("Successfully Clicked On delete Customer Role Button");
		    addcust.textCustomerRoles().click();
		    logger.info("Successfully Clicked On Customer Roles Dropdown");
		    clickByJavaScriptExecutor(addcust.listVendors());
		    logger.info("Successfully Clicked On Vendors List");
	         }
	   else if (customerRoles.equals(forumModeratorRole)) {
		    addcust.textCustomerRoles().click();
		    logger.info("Successfully Clicked On Customer Roles Dropdown");
		    clickByJavaScriptExecutor(addcust.listForumModerators());
		    logger.info("Successfully Clicked On Forum Moderators List");
	        }
	   else if (customerRoles.equals(administratorsRole)) {
		    addcust.textCustomerRoles().click();
		    logger.info("Successfully Clicked On Customer Roles Dropdown");
		    clickByJavaScriptExecutor(addcust.listAdministrators());
		    logger.info("Successfully Clicked On Administrators List");
	        }
	   addcust.drpmgrOfVendor().click();
	   logger.info("Successfully Clicked On Manager Of Vendor");
	   selectingByVisibleText(addcust.drpmgrOfVendor(), managerOfVendor);
	   logger.info("Successfully Selected "+managerOfVendor+" As A Visible Text For Manager Of Vendor");
	   addcust.txtAdminComment().sendKeys(adminComment);
	   logger.info("Successfully Entered "+adminComment+" Into Admin Comment Textarea");
	}

	@And("Click on save button")
	public void click_on_save_button() {
	    addcust.btnSave().click();
	    logger.info("Successfully Clicked On Save Button");
	}

	@Then("User can view confirnation message {string}")
	public void user_can_view_confirnation_message(String confirmationMessage) {
		String explicitWaitInString = configProp.getProperty("explicitWait");
		int explicitWait=Integer.parseInt(explicitWaitInString);
		hp.waitTillVisibilityOfElement(addcust.successfullyMessage(), explicitWait);
		logger.info("Successfully Waited "+explicitWait+" Explicit Secounds Till Element Is Visible");
		boolean result=addcust.successfullyMessage().getText().contains(confirmationMessage);
		Assert.assertTrue(result);
		logger.info("User Able To View "+confirmationMessage+" As Confirmation Message Text");
	}

//**************************************************************************************************************************************
	
	//Steps for Searching a Customer using emailID...................
	@And("Enter customer email")
	public void enter_customer_email() {
		searchcust=new searchCustomerPage(driver);
		hp=new helper(driver);
		String explicitWaitInString = configProp.getProperty("explicitWait");
		String searchingEmail = configProp.getProperty("searchingEmail");
		int explicitWait=Integer.parseInt(explicitWaitInString);
		hp.waitTillVisibilityOfElement(searchcust.txtEmail, explicitWait);
		logger.info("Successfully Waited "+explicitWait+" Explicit Secounds Till Element Is Visible");
		searchcust.txtEmail.clear();
		logger.info("Successfully Cleared On Email Testfield");
		searchcust.txtEmail.sendKeys(searchingEmail);
		logger.info("Successfully Entered "+searchingEmail+" Into Email Textfield");
	}

	@When("Click on search button")
	public void click_on_search_button() {
	    searchcust.btnSearch.click();
	    logger.info("Successfully Clicked On Search Testfield");
	}

	@Then("User should found email in the search table")
	public void user_should_found_email_in_the_search_table() throws InterruptedException {
		String emailColIndexInString = configProp.getProperty("emailColIndex");
		String searchingEmail = configProp.getProperty("searchingEmail");
		int emailColIndex=Integer.parseInt(emailColIndexInString);
		scrollTillElementIsvisable(searchcust.textcustomers);
		logger.info("Successfully Scroll To The Element Isvisable");
		Thread.sleep(2000);
		int rowSize=searchcust.tableRow.size();
		boolean flage=false;
	    for (int i = 1; i <= rowSize; i++) {
			String emailid=searchcust.dynamicXpathLocatorForFetchingEmailAndFirstAndLastNameText(i,emailColIndex).getText();
			if (emailid.equals(searchingEmail)) {
				flage=true;
			}
		}
	    Assert.assertTrue(flage);
	    logger.info("Searched Email Is Present In Table "+flage);
	} 
	
//**************************************************************************************************************************************
	
	//Steps for searching a customer by using Firstname And Lastname........................
	
	@When("Enter customer firstname")
	public void enter_customer_firstname() {
		searchcust=new searchCustomerPage(driver);
		hp=new helper(driver);
		String explicitWaitInString = configProp.getProperty("explicitWait");
		String searchingFirstname = configProp.getProperty("searchingFirstname");
		int explicitWait=Integer.parseInt(explicitWaitInString);
		hp.waitTillVisibilityOfElement(searchcust.txtFirstName, explicitWait);
		logger.info("Successfully Waited "+explicitWait+" Explicit Secounds Till Element Is Visible");
		searchcust.txtFirstName.clear();
		logger.info("Successfully Cleared On First Name Testfield");
		searchcust.txtFirstName.sendKeys(searchingFirstname);
		logger.info("Successfully Entered "+searchingFirstname+" Into Email Textfield");
	}

	@When("Enter customer lastname")
	public void enter_customer_lastname() {
		searchcust=new searchCustomerPage(driver);
		hp=new helper(driver);
		String searchingLastname = configProp.getProperty("searchingLastname");
		searchcust.txtLastName.clear();
		logger.info("Successfully Cleared On Last Name Testfield");
		searchcust.txtLastName.sendKeys(searchingLastname);
	}

	@Then("User should found name in the search table")
	public void user_should_found_name_in_the_search_table() throws InterruptedException {
		String firstAndLastnameColIndexInString = configProp.getProperty("firstAndLastnameColIndex");
		String searchingFirstname = configProp.getProperty("searchingFirstname");
		String searchingLastname = configProp.getProperty("searchingLastname");
		int firstAndLastnameColIndex=Integer.parseInt(firstAndLastnameColIndexInString);
		scrollTillElementIsvisable(searchcust.textcustomers);
		logger.info("Successfully Scroll To The Element Isvisable");
		Thread.sleep(2000);
		int rowSize=searchcust.tableRow.size();
		boolean flage=false;
	    for (int i = 1; i <= rowSize; i++) {
			String name=searchcust.dynamicXpathLocatorForFetchingEmailAndFirstAndLastNameText(i,firstAndLastnameColIndex).getText();
			String names[]=name.split(" ");
			if (names[0].equals(searchingFirstname)&&names[1].equals(searchingLastname)) {
				flage=true;
			}
		}
	    Assert.assertTrue(flage);
	    logger.info("Searched First And Last Name Is Present In Table "+flage);
	}

	
	
//**************************************************************************************************************************************
	 
	@After
	public void takeScraenshotOnFailureAndTearDownBrowser(Scenario scenario) throws IOException, InterruptedException {
		configProp = new Properties();
		FileInputStream fis = new FileInputStream(configFilePath);
		configProp.load(fis);
		String screenshotType = configProp.getProperty("screenshotType");
		
		//Take Scraenshot On Failure
		if (scenario.isFailed()) {
			TakesScreenshot tsc=(TakesScreenshot)driver;
			File screenshot=tsc.getScreenshotAs(OutputType.FILE);
			String screenshotName = scenario.getName();
			File file= new  File(screenShootFilePath+screenshotName+screenshotType);
			FileUtils.copyFile(screenshot, file);
			logger.info("Successfully Captured Screenshot Of The "+screenshotName +" And Strored In Screenshots Floder");
			
			//Tear Down Browser
			Thread.sleep(2000);
			driver.close();
			logger.info("******************** Browser Closed Successfully ********************");
		}
	}
}
