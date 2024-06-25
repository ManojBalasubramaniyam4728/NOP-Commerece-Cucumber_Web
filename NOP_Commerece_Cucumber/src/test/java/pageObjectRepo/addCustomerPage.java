package pageObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class addCustomerPage {
	
	//Globel variable
	public WebDriver driver;
	
//**************************************************************************************************************************************		
	  
	// Giving life to driver by Constracor
	public addCustomerPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
//**************************************************************************************************************************************		
	  
	// Storeing Element This Secound Way
	By lnkCustomerMenu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustimerMenuItem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By btnAddNew=By.xpath("//a[@href='/Admin/Customer/Create']");
	By txtAddANewCustomerPage=By.xpath("//h1[@class='float-left']");
	By txtEmail=By.id("Email");
	By txtPassword=By.id("Password");
	By txtFirstName=By.id("FirstName");
	By txtLastName=By.id("LastName");
	By textCustomerRoles=By.xpath("//label[text()='Customer roles']/../../..//div[@class='k-multiselect-wrap k-floatwrap']");
	By selectCustomerRole=By.xpath("//select[@id='SelectedCustomerRoleIds']");
	By deleteCustomerRole=By.xpath("//span[@aria-label='delete']");
	By listAdministrators=By.xpath("//li[text()='Administrators']");
	By listForumModerators=By.xpath("//li[text()='Forum Moderators']");
	By listGuests=By.xpath("//li[text()='Guests']");
	By listVendors=By.xpath("//li[text()='Vendors']");
	By rdMale=By.id("Gender_Male");
	By rdFemale=By.id("Gender_Female");
	By txtDateOfBirth=By.id("DateOfBirth");
	By drpmgrOfVendor=By.xpath("//select[@data-val-required='The Manager of vendor field is required.']");
	By txtCompany=By.id("Company");
	By txtAdminComment=By.id("AdminComment");
	By btnSave=By.xpath("//button[@name='save']");
	By successfullyMessage=By.xpath("//div[@class='alert alert-success alert-dismissable']");

//**************************************************************************************************************************************		
	   
	   // User Defined Method To Above Locators
	     public WebElement lnkCustomerMenu() {
	         return	driver.findElement(lnkCustomerMenu);
	        }
	     
	     public WebElement lnkCustimerMenuItem() {
	         return	driver.findElement(lnkCustimerMenuItem);
	        }
	     public WebElement btnAddNew() {
	         return	driver.findElement(btnAddNew);
	        }
	     public WebElement txtAddANewCustomerPage() {
	         return	driver.findElement(txtAddANewCustomerPage);
	        }
	     public WebElement txtEmail() {
	         return	driver.findElement(txtEmail);
	        }
	     public WebElement txtPassword() {
	         return	driver.findElement(txtPassword);
	        }
	     public WebElement txtFirstName() {
	         return	driver.findElement(txtFirstName);
	        }
	     public WebElement txtLastName() {
	         return	driver.findElement(txtLastName);
	        }
	     public WebElement textCustomerRoles() {
	         return	driver.findElement(textCustomerRoles);
	        }
	     public WebElement selectCustomerRole() {
	         return	driver.findElement(selectCustomerRole);
	        }
	     public WebElement deleteCustomerRole() {
	         return	driver.findElement(deleteCustomerRole);
	        }
	     public WebElement listAdministrators() {
	         return	driver.findElement(listAdministrators);
	        }
	     public WebElement listForumModerators() {
	         return	driver.findElement(listForumModerators);
	        }
	     public WebElement listGuests() {
	         return	driver.findElement(listGuests);
	        }
	     public WebElement listVendors() {
	         return	driver.findElement(listVendors);
	        }
	     public WebElement rdFemale() {
	         return	driver.findElement(rdFemale);
	        }
	     public WebElement rdMale() {
	         return	driver.findElement(rdMale);
	        }
	     public WebElement txtDateOfBirth() {
	         return	driver.findElement(txtDateOfBirth);
	        }
	     public WebElement txtCompany() {
	         return	driver.findElement(txtCompany);
	        }
	     public WebElement txtAdminComment() {
	         return	driver.findElement(txtAdminComment);
	        }
	     public WebElement drpmgrOfVendor() {
	         return	driver.findElement(drpmgrOfVendor);
	        }
	     public WebElement btnSave() {
	         return	driver.findElement(btnSave);
	        }
	     public WebElement successfullyMessage() {
	         return	driver.findElement(successfullyMessage);
	        }

}
