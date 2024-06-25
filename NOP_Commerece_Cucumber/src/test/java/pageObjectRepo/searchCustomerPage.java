package pageObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class searchCustomerPage {
	//Globel variable
		public WebDriver driver;
		
//**************************************************************************************************************************************		
		  
		// Giving life to driver by Constracor
		public searchCustomerPage(WebDriver rdriver) {
			driver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
//**************************************************************************************************************************************		
      //// Storeing Element This third Way
		
	  @FindBy(how =How.ID,using = "SearchEmail")
      @CacheLookup
      public WebElement txtEmail;
      
      @FindBy(how =How.ID,using = "SearchFirstName")
      @CacheLookup
      public WebElement txtFirstName;
      
      @FindBy(how =How.ID,using = "SearchLastName")
      @CacheLookup
      public WebElement txtLastName;
      
      @FindBy(how =How.ID,using = "SearchMonthOfBirth")
      @CacheLookup
      public WebElement drpDOBMonth;
      
      @FindBy(how =How.ID,using = "SearchDayOfBirth")
      @CacheLookup
      public WebElement drpDayOfDOB;
      
      @FindBy(how =How.ID,using = "SearchCompany")
      @CacheLookup
      public WebElement txtCompany;
      
      @FindBy(how =How.XPATH,using = "//div[@class='k-multiselect-wrap k-floatwrap']")
      @CacheLookup
      public WebElement txtCustomerrole;
      
      @FindBy(how =How.XPATH,using = "//li[text()='Administrators']")
      @CacheLookup
      public WebElement lstItemAdministrators;
      
      @FindBy(how =How.XPATH,using = "//li[text()='Forum Moderators']")
      @CacheLookup
      public WebElement lstItemForumModerators;
      
      @FindBy(how =How.XPATH,using = "//li[text()='Guests']")
      @CacheLookup
      public WebElement lstItemGuests;
      
      @FindBy(how =How.XPATH,using = "//li[text()='Vendors']")
      @CacheLookup
      public WebElement lstItemVendors;
      
      @FindBy(how =How.XPATH,using = "//li[text()='Registered']")
      @CacheLookup
      public WebElement lstItemRegistered;
      
      @FindBy(how =How.ID,using = "search-customers")
      @CacheLookup
      public WebElement btnSearch;
      
      @FindBy(how =How.XPATH,using = "//table[@id='customers-grid']")
      @CacheLookup
      public WebElement table;
      
      @FindBy(how =How.XPATH,using = "//table[@id='customers-grid']/tbody/tr")
      @CacheLookup
      public List<WebElement> tableRow;
      
      @FindBy(how =How.XPATH,using = "//table[@id='customers-grid']/tbody/tr/td")
      @CacheLookup
      public List<WebElement> tableColumns; 
      
      @FindBy(how =How.XPATH,using = "//a[text()='customers']")
      @CacheLookup
      public WebElement textcustomers; 
      
      public WebElement dynamicXpathLocatorForFetchingEmailAndFirstAndLastNameText(int loopNumbers,int columan) {
		return driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+loopNumbers+"]/td["+columan+"]"));
	}
}
