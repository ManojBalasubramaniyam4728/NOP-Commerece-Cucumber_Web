package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectRepo.addCustomerPage;
import pageObjectRepo.loginPage;
import pageObjectRepo.searchCustomerPage;

public class base {
	
	//global Variables
	public static WebDriver driver;
	public loginPage lp;
	public helper hp;
	public addCustomerPage addcust;
	public searchCustomerPage searchcust;
	public static Logger logger;
	public Properties configProp;
	public static String configFilePath="config.properties";
	public static String screenShootFilePath ="screenshots/";
	
//**************************************************************************************************************************************	
	//User Defined Method To Invoking Browsers
	public WebDriver initializeDriver() throws IOException {
	configProp = new Properties();
	FileInputStream fis = new FileInputStream(configFilePath);
	configProp.load(fis);
	String browserName = configProp.getProperty("browser");
	String implicitWaitInString = configProp.getProperty("implicitWait");
	int implicitWait = Integer.parseInt(implicitWaitInString);

	if (browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
	}

	else if (browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
	}

	else if (browserName.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
	   }
	
	return driver;
	}
	
//**************************************************************************************************************************************
	//create for generating random string
	public static String randomString() {
		String genratedString=RandomStringUtils.randomAlphabetic(5);
		return genratedString;
	}
	
//**************************************************************************************************************************************
    //User Defined Method For Selecting And Deseleting Elements In Diffrent Forms
 public void selectingByIndex(WebElement element, Integer number) {
    	Select select=new Select(element);
    	select.selectByIndex(number);
    }
    
    public void selectingByVisibleText(WebElement element, String text) {
    	Select select=new Select(element);
    	select.selectByVisibleText(text);
    }
    
    public void selectingByValue(WebElement element, String Value) {
    	Select select=new Select(element);
    	select.selectByValue(Value);
    }
    
    public void deSelectingByIndex(WebElement element, Integer number) {
    	Select select=new Select(element);
    	select.deselectByIndex(number);
    }
    
    public void deSelectingByVisibleText(WebElement element, String text) {
    	Select select=new Select(element);
    	select.deselectByVisibleText(text);
    }
    
    public void deSelectingByValue(WebElement element, String Value) {
    	Select select=new Select(element);
    	select.deselectByValue(Value);
    }
    
    public void deSelectingAll(WebElement element) {
    	Select select=new Select(element);
    	select.deselectAll();
    }
    
 //**************************************************************************************************************************************
    //User Defined Method For Click By Java Script Executor
    public static void clickByJavaScriptExecutor(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
 	                  }
    
 //**************************************************************************************************************************************
    //User Defined Method For Scroll By JavascriptExecutor
    public static void scrollTillElementIsvisable(WebElement element) {
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("arguments[0].scrollIntoView(true);", element);
    }   
	
	

}

